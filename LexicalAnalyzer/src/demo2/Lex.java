package demo2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 此版本将++运算符号识别为一个Token
 * @author liuji
 *
 */
public class Lex {
	//分隔符、运算符和关键字符号
	private static final char SEPARATORS[] = { '{', '}', ';' };
	//此处减少了“+”
	private static final char OPERATORS[] = { '=', '-', '*', '/', '(',
			')', '!', '<', '>', '^' ,'%'};
	private static final String keywords[] = { "int", "while","if","else" };
	static {
		//对符号进行排序，以便于后面应用折半查找
		Arrays.sort(SEPARATORS);
		Arrays.sort(OPERATORS);
		Arrays.sort(keywords);
	}
	//自动机的初始状态
	private String state="开始";
	//Token串
	private List<Token> tokens = new ArrayList<Token>();
	//符号表
	private SymbolTable symbolTable = new SymbolTable();
	//源文件
	private SourceCode sc;
	public Lex(String fileName) throws IOException{
		sc=new SourceCode(fileName);
		//记录识别的单词
		StringBuffer word=new StringBuffer();
		//while循环是一个有穷状态自动机
		while(sc.hasChar())
		{
			char ch=sc.nextChar();
			if(state.equals("开始")&&Character.isLetter(ch))
			{
				state="识别标示符或者关键字";
				word.append(ch);
			}else if(state.equals("开始")&&Character.isDigit(ch))
			{
				state="识别数字";
				word.append(ch);
			}else if(state.equals("开始")&&ch=='\"')
			{
				state="识别字符串";
				word.append(ch);
			}else if(state.equals("开始")&&Arrays.binarySearch(SEPARATORS, ch)>=0)
			{
				state="识别分隔符";
				word.append(ch);
			}else if(state.equals("开始")&&ch=='+')
			{
				state="识别++运算符";
				word.append(ch);
			}else if(state.equals("开始")&&Arrays.binarySearch(OPERATORS, ch)>=0)
			{
				state="识别运算符";
				word.append(ch);
			}else if(state.equals("识别标示符或者关键字")&&Character.isLetterOrDigit(ch))
			{
				state="识别标示符或者关键字";
				word.append(ch);
			}else if(state.equals("识别标示符或者关键字")&&!Character.isLetterOrDigit(ch))
			{
				state="开始";
				if(Arrays.binarySearch(keywords, word.toString())>=0)
				{
					tokens.add(new Token(word.toString(),TokenType.keyword));
				}else
				{
					tokens.add(new Token(word.toString(),TokenType.identifier));
					Symbol symbol=new Symbol(word.toString(),null,null);
					symbolTable.add(symbol);
				}
				sc.back();
				word=new StringBuffer();
			}else if(state.equals("识别数字")&&Character.isDigit(ch))
			{
				state="识别数字";
				word.append(ch);
			}else if(state.equals("识别数字")&&ch=='.')
			{
				state="识别小数点";
				word.append(ch);
			}else if(state.equals("识别数字")&&!Character.isDigit(ch)&&ch!='.')
			{
				state="开始";
				tokens.add(new Token(word.toString(),TokenType.digit));
				Symbol symbol=new Symbol(word.toString(),SymbolType.IntegerConstant,word.toString());
				symbolTable.add(symbol);
				sc.back();
				word=new StringBuffer();
			}else if(state.equals("识别小数点")&&Character.isDigit(ch))
			{
				state="识别小数";
				word.append(ch);
			}else if(state.equals("识别小数点")&&!Character.isDigit(ch))
			{
				System.out.println("错误:小数点后不是数字");
				break;
			}else if(state.equals("识别小数")&&Character.isDigit(ch))
			{
				state="识别小数";
				word.append(ch);
			}else if(state.equals("识别小数")&&!Character.isDigit(ch))
			{
				state="开始";
				tokens.add(new Token(word.toString(),TokenType.digit));
				Symbol symbol=new Symbol(word.toString(),SymbolType.DoubleConstant,word.toString());
				symbolTable.add(symbol);
				sc.back();
				word=new StringBuffer();
			}else if(state.equals("识别字符串")&&ch!='\"')
			{
				state="识别字符串";
				word.append(ch);
			}else if(state.equals("识别字符串")&&ch=='\"')
			{
				state="开始";
				word.append(ch);
				tokens.add(new Token(word.toString(),TokenType.string));
				Symbol symbol=new Symbol(word.toString(),SymbolType.StringConstant,word.toString());
				symbolTable.add(symbol);
				word=new StringBuffer();
			}else if(state.equals("识别分隔符"))
			{
				state="开始";
				tokens.add(new Token(word.toString(),TokenType.separator));
				sc.back();
				word=new StringBuffer();
			}else if(state.equals("识别运算符"))
			{
				state="开始";
				tokens.add(new Token(word.toString(),TokenType.operator));
				sc.back();
				word=new StringBuffer();
			}
			//开始识别++运算符
			else if(state.equals("识别++运算符")&&ch=='+')
			{
				state="开始";
				word.append(ch);
				tokens.add(new Token(word.toString(),TokenType.operator));
				word=new StringBuffer();
			}
			//识别++运算符
			else if(state.equals("识别++运算符")&&ch!='+')
			{
				state="开始";
				tokens.add(new Token(word.toString(),TokenType.operator));
				sc.back();
				word=new StringBuffer();
			}
		}

	}
	public List<Token> getTokens() {
		return tokens;
	}

	public SymbolTable getSymbolTable() {
		return symbolTable;
	}

	public static void main(String args[]) throws IOException {
		Lex lex = new Lex("input1.txt");
		System.out.println("输出Token串");
		for(Token token:lex.getTokens())
			System.out.println(token);
		System.out.println("输出符号表");
		for(Symbol symbol:lex.getSymbolTable().values())
			System.out.println(symbol);
	}
}
