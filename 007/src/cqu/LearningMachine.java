package cqu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class LearningMachine {
	private List<String> fileNames=new ArrayList<String>();
	private Knowledge knowledge=new Knowledge();
	public LearningMachine(String dirName)
	{
		File dir=new File(dirName);
		File[] filesInDir=dir.listFiles();
		for(File f:filesInDir)
		{
			if(f.isFile()&&f.getName().endsWith(".txt"))
			{
				fileNames.add(f.getAbsolutePath());
			}
		}
	}
	public void learn(String saveTo)
	{
		for(String fileName:fileNames)
		{
			String content=readText(fileName);
			learnText(content);
		}
		save(saveTo);
	}
	private void save(String fileName) {
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(knowledge);
			out.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void learnText(String content) {
		List<String> words=new ArrayList<String>();
		String strs[]=content.split("[^a-zA-Z,.]");
		for(String str:strs)
		{
			if(!str.trim().equals(""))
			{
				words.add(str);
			}
		}
		int K=2;//前缀长度取2
		for(int i=0;i+K<words.size();i++)
		{
			Prefix prefix=new Prefix(words.subList(i, i+K));
			String word=null;
			word=words.get(i+K);
			knowledge.addWord(prefix, word);
		}
	}
	private String readText(String fileName) {
		try {
			FileReader reader=new FileReader(fileName);
			StringWriter writer=new StringWriter();
			char cbuf[]=new char[1024];
			int len=reader.read(cbuf);
			while(len!=-1)
			{
				writer.write(cbuf,0,len);
				len=reader.read(cbuf);
			}
			reader.close();
			writer.close();
			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
