package com.nowcoder;

/**
 * 黑默丁格有三个炮台,炮台能攻击到距离它R的敌人 (两点之间的距离为两点连续的距离,例如(3,0),(0,4)之间的距离是5),
 * 如果一个炮台能攻击 到敌人,那么就会对敌人造成1×的伤害.黑默丁格将三个炮台放在N*M方格中的点上,并且给出敌人 的坐标. 
 * 问:那么敌人受到伤害会是多大?
 * 写的复杂
 * @author yangtf
 *
 */
public class BatteryAttack {

	public static void main(String[] args) {
		int hurt = 0;
		int R = Integer.parseInt(args[0]);
		R *= R;
		XYNode battery1 = new XYNode(args[1], args[2]);
		XYNode battery2 = new XYNode(args[3], args[4]);
		XYNode battery3 = new XYNode(args[5], args[6]);
		XYNode enemy = new XYNode(args[7], args[8]);
		
		int dispf = getDistance(battery1, enemy);
		if (R >= dispf) {
			hurt ++;
		}
		int dispf2 = getDistance(battery2, enemy);
		if (R >= dispf2) {
			hurt ++;
		}
		int dispf3 = getDistance(battery3, enemy);
		if (R >= dispf3) {
			hurt ++;
		}
		
		System.out.println(hurt + "x");
	}

	private static int getDistance(XYNode battery, XYNode enemy) {
		int x = (battery.x - enemy.x);
		int y = (battery.y - enemy.y);
		return x*x + y*y;
	}

}

class XYNode{
	int x;
	int y;
	public XYNode(String x, String y){
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		
	}
}