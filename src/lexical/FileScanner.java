package lexical;

import java.io.*;

/**
 * 表示文件扫描器，按顺序读取文件中每一个字符, 返回-1表示文件结束
 * 
 */
public class FileScanner implements Closeable {

	private char curCh;
	private char oldCh;
	private int lineNum = 0;
	private int charAtLine = 0;
	private String curLine = "";

	private BufferedReader bufReader;

	public FileScanner(String filePath) throws IOException {
		if (filePath == null) {
			throw new IllegalArgumentException("filePath");
		}
		bufReader = new BufferedReader(new FileReader(filePath));
	}

	public int getNextChar() throws IOException {
		if (charAtLine >= curLine.length()) {
			this.readNewLine();
		}
		
		//skip empty line
		while (curLine != null && curLine.trim().isEmpty()) {
			this.readNewLine();
		}

		// end of file
		if (curLine == null) {
			return -1;
		}

		oldCh = curCh;
		curCh = curLine.charAt(charAtLine);
		charAtLine++;

		return curCh;
	}

	public int getLineNum() {
		return this.lineNum;
	}
	
	public int getOldChar(){
		return this.oldCh;
	}

	private void readNewLine() throws IOException {
		curLine = bufReader.readLine();
		charAtLine = 0;
		lineNum++;
	}

	public static void main(String[] args) throws IOException {
		try (FileScanner scan = new FileScanner("D:\\project\\cit-x86\\compiler\\lexial.c")) {
			int ch;
			while ((ch = scan.getNextChar()) != -1) {
				System.out.print((char) ch);
			}
		}
	}

	@Override
	public void close() throws IOException {
		if (bufReader != null) {
			bufReader.close();
		}
	}

}
