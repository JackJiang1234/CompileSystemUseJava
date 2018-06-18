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
	private StringBuilder content;

	public Lexer(String filePath) throws IOException {
		this.fileScanner = new FileScanner(filePath);
		this.ch = ' ';
		this.content = new StringBuilder();
	}

	/**
	 * 获取下一个Token, Token分为标识符，关键字， 数字，字符串， 字符， 界符， 特殊符号 标识符关键字以 下划线_和字母开头，
	 * 后续非字母，数字，下划线结束 数字 二进制，八进制， 十进制，十六进制 以0开头 字符串 "内容" 字符 'char' 界符 与运算符号匹配 特殊
	 * Err和End
	 * 
	 */
	public Token getNextToken() {
		Token t = null;

		while (ch != -1) {
			// 忽略空白字符
			while (Character.isWhitespace(ch)) {
				this.scan();
			}

			if (isIdOrKeyword()) {
				t = recognizeIdOrKeyword();
			} else if (isStr()) {
				t = recognizeStr();
			} else if (isNumber()) {
				t = recognizeNumber();
			} else if (isChar()){
				t = recognizeChar();
			} else {
				t = recognizeOperator();
			}
			
			if (t.isErr()){
				//忽略错误词法记号
				continue;
			}else{
				return t;
			}
		}
		
		return Token.End;
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

	/**
	 * 是否标识行，关键字 ，以字母或下划线开始
	 */
	private boolean isIdOrKeyword() {
		return Character.isLetter(ch) || ch == '_';
	}

	/**
	 * 标识符，关键字识别， 非字母，数字或下划线结束
	 */
	private Token recognizeIdOrKeyword() {
		content.setLength(0);
		do {
			content.append(ch);
			scan();
		} while (Character.isLetterOrDigit(ch) || ch == '_');
		String id = content.toString();
		TagEnum tag = KeywordMaps.getTag(id);
		if (tag == TagEnum.ID) {
			return new Id(id);
		} else {
			return new Token(tag);
		}
	}

	/**
	 * 是否字符串 以双引号"开始
	 */
	private boolean isStr() {
		return ch == '"';
	}

	/**
	 * 识别字符串 支持\\, \n, \t, \", \0转义，中间可以是任何其它符， 遇到双引号"结束
	 */
	private Token recognizeStr() {
		Token t = null;
		content.setLength(0);
		while (!scan('"')) {
			if (ch == '\\') { // 转义处理
				scan();
				if (ch == 'n') {
					content.append(ch);
				} else if (ch == '\\') {
					content.append('\\');
				} else if (ch == 't') {
					content.append('\t');
				} else if (ch == '"') {
					content.append('"');
				} else if (ch == '0') {
					content.append('\0');
				} else if (ch == '\n') {

				} else if (ch == -1) {
					// LEXERROR(STR_NO_R_QUTION);
					t = Token.Err;
					break;
				} else {
					content.append(ch);
				}
			} else if (ch == -1) {
				// LEXERROR(STR_NO_R_QUTION);
				t = Token.Err;
				break;
			} else {
				content.append(ch);
			}
		}
		if (t == null) {
			t = new Str(content.toString());
		}
		return t;
	}

	/**
	 * 是否数字 0-9开头
	 */
	private boolean isNumber() {
		return Character.isDigit(ch);
	}

	/**
	 * 十进制      非0开始的数字
	 * 十六进制  0x开始
	 * 二进制      0b
	 * 八进制      0开头0-7之间的数字
	 * */
	private Token recognizeNumber() {
		int val = 0;
		if (ch != '0'){//10进制
			do {
				val = val * 10 + (ch - '0');
			}while(Character.isDigit(ch));
		}else {
			scan();
			if (ch == 'x'){
				
			}else if (ch == 'b'){
				
			}else if (ch > '0' && ch <= '7'){
				
			}
		}
		return null;
	}
	
	/**
	 * 是否字符  以单引号'开始
	 * */
	private boolean isChar(){
		return ch == '\''; 
	}

	/**
	 * 识别字符
	 */
	private Token recognizeChar() {
		return null;
	}
	
	/**
	 * 识别运算符
	 * */
	private Token recognizeOperator(){
		return null;
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
