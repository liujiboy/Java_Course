package cqu;

import java.util.Scanner;

public class UI {
	private Scanner s=new Scanner(System.in);
	private void learningUI() {
		System.out.println("请输入学习文档所在的目录：");
		String dirName = s.next();
		LearningMachine machine = new LearningMachine(dirName);
		System.out.println("请输人保存知识的路径：");
		String fileName = s.next();
		machine.learn(fileName);
		System.out.println("学习完毕");
	}

	private void generatorUI() {
		System.out.println("请输人保存知识的路径：");
		String fileName = s.next();
		TextGenerator textGen=new TextGenerator(fileName);
		System.out.println("请输人文章长度：");
		int length=s.nextInt();
		String text=textGen.createText(length);
		for(int i=0;i<text.length();i++)
		{
			char c=text.charAt(i);
			System.out.print(c);
			if(c=='.')
			{
				System.out.println();
			}
		}
		System.out.println();
	}
	public void mainUI()
	{
		while (true) {
			System.out.println("1.学习写作");
			System.out.println("2.生成文章");
			System.out.println("3.退出");
			System.out.println("请选择功能：");
			String type = s.next();
			if (type.equals("1")) {
				learningUI();
			} else if (type.equals("2")) {
				generatorUI();
			} else if (type.equals("3")) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		UI ui = new UI();
		
		ui.mainUI();
	}

}
