package lexical;

import java.io.*;

/**
 * 表示词法分析器
 * 
 * @author jack
 */
public class Lexer implements Closeable{
	
	private FileScanner fileScanner; 
	
	public Lexer(String filePath) throws IOException {
		this.fileScanner = new FileScanner(filePath);
	}

	/**
	 * 获取下一个Token, Token分为标识符，关键字， 数字，字符串， 字符， 界符， 特殊符号
	 * 标识符关键字以 下划线_和字母开头， 后续非字母，数字，下划线结束
	 * 数字  二进制，八进制， 十进制，十六进制  以0开头
	 * 字符串   "内容"
	 * 字符       'char'
	 * 界符     与运算符号匹配
	 * 特殊     Err和End
	 */
	public Token getNextToken() {
		
		return null;
	}

	@Override
	public void close() throws IOException {
		if (this.fileScanner != null){
			this.fileScanner.close();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
}
