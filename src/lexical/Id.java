package lexical;

/**
 * 表示Id词法标记
 * 
 * @author jianyong.jiang
 * */
public class Id extends Token {

	private String name;
	
	public Id(String id) {
		super(TagEnum.ID);
		
		this.name = id;
	}
	
	public String getName(){
		return this.name;
	}
}
