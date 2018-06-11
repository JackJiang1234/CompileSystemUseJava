package lexical;

/**
 * 表示字符串记号
 * 
 * @author jianyong.jiang
 * */
public class Str extends Token{
	private String str;
	
	public Str(String s) {
		super(TagEnum.STRING);
		this.str = s;
	}

	public String getStr(){
		return this.str;
	}
}
