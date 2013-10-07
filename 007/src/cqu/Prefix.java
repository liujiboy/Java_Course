package cqu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Prefix  implements Serializable {
	private static final long serialVersionUID = 1075333338171914973L;
	private List<String> words=new ArrayList<String>();
	public List<String> lastWords()
	{
		
		return words.subList(1, words.size());
	}
	public Prefix(List<String> words) {
		super();
		this.words.addAll(words);
	}
	public Prefix() {
		super();
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
		Prefix other = (Prefix) obj;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}
	public List<String> getWords() {
		return words;
	}
	public void setWords(List<String> words) {
		this.words = words;
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
