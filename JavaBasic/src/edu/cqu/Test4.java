package edu.cqu;
/**
 * 1024*1024*400大小的int数组超过了JVM默认的最大内存，
 * 因此程序启动时应该调大内存，通过加上-Xmx3000m这样的参数。
 * 需要注意如果使用的是32位JVM，那么3000MB的启动内存是不被支持的。
 * 故此服务器端的通常选择64的Java SE，并安装64位系统。
 * @author 刘骥
 *
 */
public class Test4 {
	public static void main(String[] args) {
		int a[]=new int[1024*1024*400];

	}

}
