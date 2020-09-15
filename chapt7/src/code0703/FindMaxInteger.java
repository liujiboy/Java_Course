package code0703;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FindMaxInteger {

	public static void main(String[] args) {
		String path = FindMaxInteger.class.getClassLoader().getResource("").getPath();
		File file = new File(path+"data.txt");
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			int maxValue=0;
			while((line = in.readLine())!=null)
			{
				int inputValue = Integer.parseInt(line);
				if(inputValue>maxValue)
				{
					maxValue = inputValue;
				}
			}
			System.out.println("Max int is: "+maxValue);
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在。");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("输入输出错误。");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("数字格式错误。");
			e.printStackTrace();
		}

	}

}
