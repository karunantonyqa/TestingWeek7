package com.qa.quickstart.demoSite;

public class BlackJack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(blackJack(24,22));
		
		
	}
	
	public int blackJack(int a, int b) {
		int c = 0;
		
		if((a <= 21 && a>0)&&(b <= 21 && b>0)) {
			c = Math.max(a, b);
		}else if(a>21 && b<21) {
			c=b;
		}else if(a<21 && b>21) {
			c=a;
		}
		return c;		
	}
	


}