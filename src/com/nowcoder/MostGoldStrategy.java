package com.nowcoder;

/**
 * 10个房间里放着随机数量的金币。每个房间只能进入一次，并只能在一个房间中拿金币。
 * 一个人采取如下策略：前四个房间只看不拿。随后的房间只要看到比前四个房间都多的金币数，就拿。否则就拿最后一个房间的金币。 
 * a) 编程计算这种策略拿到最多金币的概率。
 * b) 证明这是不是最优策略。
 */
import java.io.*;
import java.util.*;

public class MostGoldStrategy {
    public static int findMax(int[] arr) {
        int maxVal = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i]>maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(new FileOutputStream("winProb.txt"),true);
            System.out.println("How many rooms are there?");
            int numOfRooms = sc.nextInt();
            System.out.println("How many times do you want to try?");
            int numOfTrials = sc.nextInt();
            //输入条件完毕
            
            pw.println(numOfRooms+" rooms in total. Tried "+numOfTrials+" times.");
            pw.println("=============================================");
            pw.println("Rooms seen\t\tWinning Probability");
            for (int numOfRoomsSeen=1; numOfRoomsSeen<numOfRooms; numOfRoomsSeen++) {
                boolean takeGold;
                int timesWon=0, trueMaxGold, maxGoldSeen, goldTaken=0;
                int[] goldSet = new int[numOfRooms];
                Random rm = new Random();
                for (int i=0; i<numOfTrials; i++) {
                    takeGold = false;
                    for (int j=0; j<goldSet.length; j++)
                        goldSet[j] = rm.nextInt(Integer.MAX_VALUE);//向各个房间里放入随机数量的金币
                    trueMaxGold = findMax(goldSet);    //找到真实的最大数量金币
                    
                    int[] goldSeen = new int[numOfRoomsSeen];
                    for (int j=0; j<goldSeen.length; j++)
                        goldSeen[j] = goldSet[j];
                    maxGoldSeen = findMax(goldSeen);//找到观察过得最大金币数
                    
                    for (int j=numOfRoomsSeen; j<goldSet.length; j++) {
                        if (goldSet[j]>=maxGoldSeen) {//在之后的房间里发现比原来任何房间都要多的金币
                            takeGold = true;
                            goldTaken = goldSet[j];//拿走该房间的金币
                            break;
                        }
                    }
                    if (takeGold && goldTaken==trueMaxGold)//如果拿走的金币就是真实的最大金币
                        timesWon++;//获胜次数+1
                }
                pw.println(numOfRoomsSeen+"\t\t"+timesWon/(double)numOfTrials);
            }
        } 
        catch (Exception e) {    e.printStackTrace();    }
        finally {    System.out.println("See results in winProb.txt");    }
    }
}
