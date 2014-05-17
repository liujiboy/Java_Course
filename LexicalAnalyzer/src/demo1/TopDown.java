package demo1;

import java.io.IOException;
import java.util.List;
/**
 * 识别的文法如下：
 * S::=<句子>;S
 * S::=空串
 * <句子>::=<类型> identifier A
 * A::=空串
 * A::==数字
 * <类型>::=int
 * <类型>::=double
 * 
 * @author 刘骥
 *
 */
public class TopDown {
	// Token串
	private List<Token> tokens;
	// 符号表
	private SymbolTable symbolTable;
	private int index = 0;

	public TopDown(List<Token> tokens, SymbolTable symbolTable) {
		super();
		this.tokens = tokens;
		this.tokens.add(new Token("#", null));
		this.symbolTable = symbolTable;
	}

	public void parse() {
		S();

	}

	private void S() {
		Token token = tokens.get(index++);
		if (token.getWord().equals("int")||token.getWord().equals("double")) {
			index--;
			句子();
			token = tokens.get(index++);
			if (token.getWord().equals(";")) {

			} else {
				throw new RuntimeException("读取的不是;");
			}
			S();
		} else if (token.getWord().equals("#")) {
			System.out.println("语法正确！");
		} else {
			throw new RuntimeException("读取的不是int或者#");
		}
	}
	private void 句子() {
		Token token = tokens.get(index++);
		if (token.getWord().equals("int")||token.getWord().equals("double")) {
			index--;
			SymbolType type=类型();
			token = tokens.get(index++);
			if (token.getType() == TokenType.identifier) {
				Symbol symbol=this.symbolTable.get(token.getWord());
				symbol.setType(type);
			} else {
				throw new RuntimeException("读取的不是标示符");
			}
			String digit=A();
			Symbol symbol=this.symbolTable.get(token.getWord());
			symbol.setValue(digit);
		}
	}

	private String A() {
		Token token = tokens.get(index++);
		if (token.getWord().equals("=")) {

			token = tokens.get(index++);
			if (token.getType() == TokenType.digit) {
				return token.getWord();
			} else {
				throw new RuntimeException("读取的不是数字");
			}
		} else if (token.getWord().equals(";")) {
			index--;
		} else {
			throw new RuntimeException("读取的不是=或者;");
		}
		return null;
	}

	private SymbolType 类型() {
		Token token = tokens.get(index++);
		if (token.getWord().equals("int")) {
			return SymbolType.Integer;
		} else if(token.getWord().equals("double")){
			return SymbolType.Double;
		}
		else{
			throw new RuntimeException("读取的不是int,double");
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Lex lex = new Lex("input3.txt");
		TopDown topDown = new TopDown(lex.getTokens(), lex.getSymbolTable());
		topDown.parse();
		System.out.println("输出符号表");
		for(Symbol symbol:topDown.symbolTable.values())
			System.out.println(symbol);
	}

}
