package cqu;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileCopy fileCopy=new FileCopy("/Users/liuji/Downloads/ubuntu-12.04.3-server-i386.iso","/Users/liuji/a.iso");
		fileCopy.doCopy();

	}

}
