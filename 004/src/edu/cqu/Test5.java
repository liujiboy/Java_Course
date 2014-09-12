package edu.cqu;
/**
 * 由于存在垃圾回收机制，此代码不会出现内存泄漏。
 * 尽管有垃圾回收，但Java仍然要考虑内存使用问题，特别是内存受限系统，
 * 包括考虑系统的最大内存，即使释放不使用的内存（清空对该内存的所有引用）。
 * 需要注意Java的垃圾回收是不定时运行的，因此内存受限系统要特别留意new操作的时机和数量。
 * @author 刘骥
 *
 */
public class Test5 {

	public static void main(String[] args) {
		while(true)
		{
			int a[]=new int[1024*1024];
			
		}

	}

}
