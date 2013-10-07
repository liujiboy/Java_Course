package cqu;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Knowledge implements Serializable {
	private static final long serialVersionUID = 5453217506555389396L;
	private Map<Prefix,Suffix> map=new HashMap<Prefix,Suffix>();
	public Knowledge() {
		super();
	}
	public void addWord(Prefix prefix,String word)
	{
		Suffix suffix=map.get(prefix);
		if(suffix==null)
			suffix=new Suffix();
		suffix.addWord(word);
		map.put(prefix, suffix);
	}
	public Suffix getSuffix(Prefix prefix)
	{
		return map.get(prefix);
	}
	public Prefix randPrefix()
	{
		Set<Prefix> keys=map.keySet();
		if(keys.size()>0)
		{
			Random r=new Random();
			int index=Math.abs(r.nextInt())%keys.size();
			return (Prefix) keys.toArray()[index];
		}else
		{
			return null;
		}
	}
	public Map<Prefix, Suffix> getMap() {
		return map;
	}
	public void setMap(Map<Prefix, Suffix> map) {
		this.map = map;
	}
}
