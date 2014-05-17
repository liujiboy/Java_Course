package demo2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 封装源代码
 * @author 刘骥
 *
 */
public class SourceCode {
	//当前读取的位置
	private int index=0;
	//缓冲源代码
	private StringBuffer buffer=new StringBuffer();
	public SourceCode(String fileName) throws IOException
	{
		//读取全部源代码
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		String line=reader.readLine();
		while(line!=null)
		{
			buffer.append(line);
			//换行符号用\n替代（某些源代码）
			buffer.append("\n");
			line=reader.readLine();
		}
		buffer.append("#");
		reader.close();
	}
	//读下一个符号
	public char nextChar()
	{
		return buffer.charAt(index++);
	}
	//判断是否还有后续符号
	public boolean hasChar()
	{
		if(index<buffer.length()-1)
			return true;
		else
			return false;
	}
	//回退一个符号
	public void back()
	{
		index--;
	}
}
