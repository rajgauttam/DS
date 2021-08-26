package com.raj.sample_prog.Assign2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Assign2Ques1 {
	/*
	 * Generate binary num till given n in decimal using queue.
	 */
	public static void main(String[] args) {
		System.out.println(genBinaryNum(16));
		System.out.println("=======");
		System.out.println(genBinaryNum2(12));
	}

	private static List<String> genBinaryNum(int n) {
		if (n < 0)
			return null;

		List<String> res = new ArrayList<String>();
		res.add("0");
		
		if (n == 0)
			return res;

		Queue<String> queue = new LinkedList<String>();

		queue.offer("1");
		while (n > 0) {
			String tmp = queue.peek();
			res.add(tmp);
			queue.offer(tmp + "0");
			queue.offer(tmp + "1");
			tmp = queue.poll();
			n--;
		}
		return res;
	}
	
	private static String genBinaryNum2(int n) {
		if (n < 0)
			return null;

		String res = "0";

		Queue<String> queue = new LinkedList<String>();
		 
		queue.offer("1");
		while (n > 0) {
			String tmp = queue.peek();
			res = tmp;
			queue.offer(tmp + "0");
			queue.offer(tmp + "1");
			tmp = queue.poll();
			n--;
		}
		return res;
	}
}
