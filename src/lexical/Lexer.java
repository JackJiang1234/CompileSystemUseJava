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
	 * 获取下一个Token
	 */
	public Token getNextToken() {
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	@Override
	public void close() throws IOException {
		if (this.fileScanner != null){
			this.fileScanner.close();
		}
	}

}
