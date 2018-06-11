package lexical;

/**
 * 表示数字记号
 * 
 * @author jianyong.jiang
 * */
public class Number extends Token {
	private int val;
	
	public Number(int val) {
		super(TagEnum.NUM);
		this.val = val;
	}
	
	public int value(){
		return this.val;
	}
}
