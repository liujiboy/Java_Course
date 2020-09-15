/**
 * 
 */
package code0604;

/**
 * CallOsProgram.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class CallOsProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		Process p = null;

		try {
			//打开记事本
			p = r.exec("notepad");
			//程序暂停1秒
			Thread.sleep(1000);
			//关闭外部程序
			p.destroy();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

	}

}
