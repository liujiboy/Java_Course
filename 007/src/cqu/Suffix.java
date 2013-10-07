package cqu;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Suffix  implements Serializable {

	private static final long serialVersionUID = 2424127993895123213L;
	private Set<String> words=new HashSet<String>();
	public void addWord(String word)
	{
		words.add(word);
	}
	public String randWord()
	{
		if(words.size()>0)
		{
			Random r=new Random();
			int index=Math.abs(r.nextInt())%words.size();
			return (String) words.toArray()[index];
		}
		else{
			return null;
		}
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suffix other = (Suffix) obj;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}
	public Set<String> getWords() {
		return words;
	}
	public void setWords(Set<String> words) {
		this.words = words;
	}
	public Suffix() {
		super();
	}
	@Override
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		for(String word:words)
		{
			buffer.append(word);
			buffer.append(" ");
		}
		return buffer.toString();
	}
}
