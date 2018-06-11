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
}
