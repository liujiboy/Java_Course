package demo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * S:=<语句> S
 * S:=空
 * <语句>:=<定义>
 * <语句>:=<运算>
 * <定义>:=Type ID
 * <运算>:=ID=E
 * E:=F+F
 * F:=i
 * F:=ID
 * @author liuji
 *
 */
public class TopDown2 {
	private List<Token> tokens;
	private SymbolTable table;
	private int index=0;
	private List<Code> codes=new ArrayList<Code>();
	public TopDown2(List<Token> tokens, SymbolTable table) {
		super();
		this.tokens = tokens;
		this.tokens.add(new Token("#", null));
		this.table = table;
	}
	public void S()
	{
		
		Token token=tokens.get(index++);
		if(token.getWord().equals("#"))
		{
			
		}
		else
		{
			index--;
			语句();
			S();
		}
		
	}
	public void 语句()
	{
		Token token=tokens.get(index++);
		if(token.getType()==TokenType.identifier)
		{
			index--;
			运算();
		}
		else
		{
			index--;
			定义();
		}
	}
	public void 定义()
	{
		Token token=tokens.get(index++);
		if(token.getWord().equals("int")||token.getWord().equals("double"))
		{
			SymbolType type=null;
			if(token.getWord().equals("int"))
				type=SymbolType.Integer;
			else
				type=SymbolType.Double;
			token=tokens.get(index++);
			if(token.getType()==TokenType.identifier)
			{
				Symbol symbol=table.get(token.getWord());
				symbol.setType(type);
			}
			else
			{
				throw new RuntimeException(token.getWord()+"不是标示符");
			}
		}
		else
		{
			throw new RuntimeException(token.getWord()+"不是int或者double");
		}
	}
	public void 运算()
	{
		String id=null;
		Token token=tokens.get(index++);
		if(token.getType()==TokenType.identifier)
		{
			id=token.getWord();
			token=tokens.get(index++);
			if(token.getWord().equals("="))
			{
				
			}
			else
			{
				throw new RuntimeException(token.getWord()+"不是=");
			}
			E e=E();
			SymbolType idType=table.get(id).getType();
			
			if(idType==e.f1.type&&e.f1.type==e.f2.type)
			{
				
			}else
			{
				throw new RuntimeException(id+"与"+e.f1.value+"和"+e.f2.value+"类型不匹配");
			}
			Code code=new Code();
			code.x=e.f1.value;
			code.y=e.f2.value;
			code.z=id;
			code.op=e.op;
			codes.add(code);
		}
		else
		{
			throw new RuntimeException(token.getWord()+"不是标示符");
		}
	}
	public E E()
	{
		F f1=F();
		Token token=tokens.get(index++);
		if(token.getWord().equals("+"))
		{
			
		}else
		{
			throw new RuntimeException(token.getWord()+"不是+");
		}
		F f2=F();
		E e=new E();
		e.f1=f1;
		e.f2=f2;
		e.op="+";
		return e;
	}
	public F F()
	{
		Token token=tokens.get(index++);
		if(token.getType()==TokenType.digit||token.getType()==TokenType.identifier)
		{
			F f=new F();
			f.value=token.getWord();
			if(token.getType()==TokenType.identifier)
			{
				f.type=table.get(token.getWord()).getType();
			}else
			{
				f.type=f.value.indexOf(".")>0?SymbolType.Double:SymbolType.Integer;
			}
			return f;
		}else
		{
			throw new RuntimeException(token.getWord()+"不是数字");
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Lex lex=new Lex("input4.txt");
		TopDown2 topdown=new TopDown2(lex.getTokens(),lex.getSymbolTable());
		topdown.S();
		System.out.println(topdown.codes);
		for(Symbol symbol:lex.getSymbolTable().values())
			System.out.println(symbol);
	}

}
