package com.nowcoder;

import java.util.Scanner;

/**
 * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.
 * 在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn.
 * 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并 且使得自己的能力值增加bi;
 * 如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数. 那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
 * 
 * @author yangtf
 *
 */
public class KillOdd {
	public static void main(String[] args) throws Exception {
		int oddNum = 3;
		int initPower = 50;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < oddNum; i++) {
			int oddPower = scanner.nextInt();
			if (initPower >= oddPower)
				initPower += oddPower;
			else
				initPower += addPower(initPower, oddPower);
		}
		
		System.out.println(initPower);
		scanner.close();
	}

	private static int addPower(int initPower, int oddPower) {
		int t = oddPower % initPower;
		while (t > 0) {
			oddPower = initPower;
			initPower = t;
			t = oddPower % initPower;
		}
		return initPower;
	}
}
