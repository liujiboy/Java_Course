package cqu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class TextGenerator {
	private Knowledge knowledge;
	public TextGenerator(String fileName)
	{
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName));
			knowledge=(Knowledge) in.readObject();
			in.close();
		}  catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String createText(int length)
	{
		StringBuffer text=new StringBuffer();
		Prefix p=knowledge.randPrefix();
		text.append(p);
		while(text.length()<length)
		{
			Suffix s=knowledge.getSuffix(p);
			if(s==null)
				break;
			String word=s.randWord();
			text.append(word);
			text.append(" ");
			List<String> ws=p.lastWords();
			ws.add(word);
			Prefix np=new Prefix(ws);
			p=np;
			//System.out.println(text);
		}
		return text.toString();
	}
	
}
