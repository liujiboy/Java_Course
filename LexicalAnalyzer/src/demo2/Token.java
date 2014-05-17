package demo2;
/**
 * Token
 * @author 刘骥
 *
 */
public class Token {
	private String word;
	private TokenType type;
	public Token(String word, TokenType type) {
		super();
		this.word = word;
		this.type = type;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public TokenType getType() {
		return type;
	}
	public void setType(TokenType type) {
		this.type = type;
	}
	public String toString()
	{
		return "("+word+","+type+")";
	}
}
