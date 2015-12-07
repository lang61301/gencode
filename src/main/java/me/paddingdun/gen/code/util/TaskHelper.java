/**
 * 
 */
package me.paddingdun.gen.code.util;

import java.awt.EventQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author paddingdun
 *
 * 2015年12月7日
 */
public class TaskHelper {
	
	public static <V> void runInNonEDT(Callable<V> callable){
		FutureTask<V> ft = new FutureTask<V>(callable);
		//判断当前线程是否是edt线程,如果是edt则启动新的线程;
		if(EventQueue.isDispatchThread()){
			new Thread(ft).start();
		}else{
			ft.run();
		}
	}
	
	public static void main(String[] args)throws Exception {
//		final Integer[] a = new Integer[]{0};
//		 ExecutorService executor = Executors.newCachedThreadPool();
//		FutureTask<Integer[]> ft = new FutureTask<Integer[]>(new Runnable() {
//			public void run() {
//				System.out.println("before");
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("after");
//				a[0] = 5;
//			}
//		}, a);
//		executor.submit(ft);
//		System.out.println("ssssssssssssssss");
//		System.out.println(ft.get()[0]);
//		executor.shutdown();
//		
		FutureTask<Integer> ft = new FutureTask<Integer>(new Callable<Integer>() {

			public Integer call() throws Exception {
				System.out.println("................");
				return null;
			}
		});
		ft.run();
//		new Thread(ft).start();
	}

}
