package lexical;

import java.io.*;

/**
 * 表示词法分析器
 * 
 * @author jack
 */
public class Lexer {

	public Lexer(String filePath) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String buff = null;
			while ((buff = br.readLine()) != null) {
				System.out.println(buff);
			}
		}
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

}
