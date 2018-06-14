package lexical;

import java.io.*;
import java.util.function.*;

/**
 * 表示词法分析器
 * 
 * @author jack
 */
public class Lexer implements Closeable {

	private FileScanner fileScanner;
	private int ch;

	public Lexer(String filePath) throws IOException {
		this.fileScanner = new FileScanner(filePath);
		this.ch = ' ';
	}

	/**
	 * 获取下一个Token, Token分为标识符，关键字， 数字，字符串， 字符， 界符， 特殊符号 标识符关键字以 下划线_和字母开头，
	 * 后续非字母，数字，下划线结束 数字 二进制，八进制， 十进制，十六进制 以0开头 字符串 "内容" 字符 'char' 界符 与运算符号匹配 特殊
	 * Err和End
	 * 
	 */
	public Token getNextToken() {
		StringBuilder content = new StringBuilder();
		Token t = null;
		
		while (ch != -1) {
			// 忽略空白字符
			while (Character.isWhitespace(ch)) {
				this.scan();
			}

			if (Character.isLetterOrDigit(ch) || ch == '_') {
				// 标识符，关键字
				content.setLength(0);
				do {
					content.append(ch);
					scan();
				} while (Character.isLetterOrDigit(ch) || ch == '_');
				String id = content.toString();
				TagEnum tag = KeywordMaps.getTag(id);
				if (tag == TagEnum.ID) {
					t = new Id(id);
				} else {
					t = new Token(tag);
				}
			}
			else if (ch == '"'){
				//字符串
				content.setLength(0);
				while(!scan('"')){
					if (ch == '\\'){ //转义
						scan();
						if (ch == 'n'){
							content.append(ch);
						}else if (ch == '\\'){
							content.append('\\');
						}else if (ch == 't'){
							content.append('\t');
						}else if (ch == '"'){
							content.append('"');
						}else if (ch == '0'){
							content.append('\0');
						}else if (ch == '\n'){
							
						}else if (ch == -1){
							//LEXERROR(STR_NO_R_QUTION);
							t=new Token(TagEnum.ERR);
							break;
						}
						
					}
				}
			}
		}

		return t;
	}

	private boolean scan(char need) {
		this.ch = this.fileScanner.getNextChar();
		if (this.ch != need) {
			return false;
		} else {
			return this.scan();
		}
	}

	private boolean scan() {
		ch = this.fileScanner.getNextChar();
		return true;
	}

	@Override
	public void close() throws IOException {
		if (this.fileScanner != null) {
			this.fileScanner.close();
		}
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {

	}
}
