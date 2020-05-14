package edu.handong.csee.java.hw3;

public class Util {
	private static int dateInNum;
	
	public static int findDate(String date, String data[][]) {
		dateInNum=0;
		dateInNum+=4;
		for(int i=4;i<data[0].length-1;i++) {
			if(data[0][i].equalsIgnoreCase(date)) {
				break;
			}
			dateInNum++;
		}
		
		
		return dateInNum;
	}
}
