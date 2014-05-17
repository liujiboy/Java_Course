package demo2;
/**
 * 符号
 * @author 刘骥
 *
 */
public class Symbol {
	private String word;
	private SymbolType type;
	private String value;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Symbol(String word, SymbolType type, String value) {
		super();
		this.word = word;
		this.type = type;
		this.value = value;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public SymbolType getType() {
		return type;
	}
	public void setType(SymbolType type) {
		this.type = type;
	}
	public String toString()
	{
		return "("+word+","+type+","+value+")";
	}
}
