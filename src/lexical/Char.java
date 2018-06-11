package lexical;

/**
 *表示字符记号
 * 
 * @author jianyong.jiang
 * */
public class Char extends Token{
	private char ch;
	
	public Char(char ch){
		super(TagEnum.CHAR);
		this.ch = ch;
	}
	
	public char getChar(){
		return this.ch;
	}
}
