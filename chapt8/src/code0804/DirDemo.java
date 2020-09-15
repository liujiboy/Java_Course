package code0804;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
public class DirDemo
{
	public static void main(String[] args)
	{
		File dir = new File("bin/code0803");
		System.out.println("列出目录" + dir + "中的class文件");
		Filter filter = new Filter("class");
		File fs1[] = dir.listFiles(filter);
		display(fs1);
		System.out.println("列出目录" + dir + "中的子目录");
		DirFilter filter2 = new DirFilter();
		File fs2[] = dir.listFiles(filter2);
		display(fs2);
		//在创建一个子目录
		File f=new File(dir,"_newDir");
		System.out.println(f.mkdir());
		File fs3[] = dir.listFiles(filter2);
		display(fs3);
	}
	public static void display(File[] fs)
	{
		for (int i = 0; i < fs.length; i++)
		{
			if (fs[i].isDirectory())
				System.out.println("目录:" + fs[i]);
			else
				System.out.println("文件:" + fs[i]);
		}
	}
}
// 定义扩展名过滤器
class Filter implements FilenameFilter
{
	String extent;
	Filter(String extent)
	{
		this.extent = extent;
	}
	public boolean accept(File dir, String name)
	{
		return name.endsWith("." + extent);
	}
}
// 定义目录过滤器
class DirFilter implements FileFilter
{
	public boolean accept(File path)
	{
		return path.isDirectory();
	}
}
