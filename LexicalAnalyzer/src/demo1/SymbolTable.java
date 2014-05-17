package demo1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 符号表
 * @author 刘骥
 *
 */
public class SymbolTable {
	private Map<String,Symbol> map=new HashMap<String,Symbol>();
	public void add(Symbol symbol)
	{
		map.put(symbol.getWord(), symbol);
	}
	public Symbol get(String word)
	{
		return map.get(word);
	}
	public Collection<Symbol> values()
	{
		return map.values();
	}
}
