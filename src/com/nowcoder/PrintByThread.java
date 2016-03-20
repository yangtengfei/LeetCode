package com.nowcoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不用文件中
 * （不要求输出到每个文件中的数量相同）。
 * 要求启动10个线程，两两一组，分为5组。每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，
 * 需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。
 * 同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，并在所有线程结束后，在控制台打印”Done”.
 * 
 * @author yangtf
 *
 */
public class PrintByThread {
	public static void main(String[] args) throws Exception {
		// 生成 10000 个数
		PrintWriter printWriter = new PrintWriter(new FileWriter("input.txt",true));
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			printWriter.print(Math.abs(random.nextInt())%100 + " ");
		}
		printWriter.flush();printWriter.close();
		
		// 读取数据
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		String str = reader.readLine(); reader.close();
		
		// 将数据保存至数组 方便操作
		String[] strings = str.split(" ");
		int j = 0;
		for (int i = 0; i < 5; i++) {
			int[] records = new int[2000];
			for (int k = 0; k < records.length; k++) {
				records[k] = Integer.parseInt(strings[j]);
				j++;
			}
			PrintWriter writer = new PrintWriter(new FileWriter("output_" + i + ".txt"),true);
			ThreadGroup group = new ThreadGroup(records, writer);
			new Thread(group).start();
			new Thread(group).start();
		}
	}
}

class ThreadGroup implements Runnable{
	public static int count = 0;
	public static Object lock = new Object();
	public static final int EVEN = 0;
	public static final int ODD = 1;
	private int type;
	private int[] records;
	private PrintWriter writer;
	private int oddPoint = 0;
	private int evenPoint = 0;
	
	public ThreadGroup(int[] records, PrintWriter writer) {
		this.records = records;
		this.writer = writer;
		this.type = EVEN;
	}
	
	
	@Override
	public void run() {
		while(print());
	}


	private synchronized boolean print() {
		for (int i = 0; i < 10;) {
			if (oddPoint >= records.length && evenPoint >= records.length) {
				notifyAll();
				return false;
			}
			if(type == EVEN){
				if (evenPoint >= records.length) {
					break;
				}
				if (records[evenPoint] % 2 == 0) {
					i++;
					writer.print(records[evenPoint] + " ");
					writer.flush();
					synchronized (lock) {
						count ++;
						if (count % 1000 == 0) {
							System.out.println("当前完成的数量" + count);
						}
						if (count == 10000) {
							System.out.println("Done!");
						}
					}
				}
				evenPoint ++;
			}else {
				if (oddPoint >= records.length) {
					break;
				}
				if (records[oddPoint] % 2 == 1) {
					i++;
					writer.print(records[oddPoint] + " ");
					writer.flush();
					synchronized (lock) {
						count ++;
						if (count % 1000 == 0) {
							System.out.println("当前完成的数量" + count);
						}
						if (count == 10000) {
							System.out.println("Done!");
						}
					}
				}
				oddPoint ++;
			}
		}
		type = ~ type;
		notifyAll();
		try {
			wait();
		} catch (Exception e) {
			System.out.println(oddPoint);
			e.printStackTrace();
		}
		return true;
	}
}