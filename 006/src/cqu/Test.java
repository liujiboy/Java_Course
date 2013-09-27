package cqu;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入拷贝源地址：");
		String src=scanner.next();
		System.out.println("请输入拷贝目的地址：");
		String dest=scanner.next();
		scanner.close();
		Copy c= copyType(src, dest);
		c.doCopy();
	}

	private static Copy copyType(String src, String dest) {
		Copy c;
		if(src.startsWith("http://"))
		{
			 c=new WebPageCopy(src,dest);
		}
		else
		{
			c=new FileCopy(src,dest);
		}
		return c;
	}

}
