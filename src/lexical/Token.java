package lexical;

/**
 * 表示一个词法标记
 * 
 * @author jianyong.jiang
 * */
public class Token {
	private TagEnum tag;
	
	public Token(TagEnum tag){
		this.tag = tag;
	}
	
	public TagEnum tag(){
		return this.tag;
	}
	
	public boolean isErr(){
		return this.tag == TagEnum.ERR;
	}
	
	public final static Token End = new Token(TagEnum.END);
	public final static Token Err = new Token(TagEnum.ERR);
}
