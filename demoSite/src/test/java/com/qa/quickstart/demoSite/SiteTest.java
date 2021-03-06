package com.qa.quickstart.demoSite;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SiteTest {
	
	@Parameters
	public static List<Integer[]> data(){
		return Arrays.asList(new Integer[][] {{10,10,22},{9,22,9},{0,22,22},{10,10,7},{19,1,19}});
	}
	
	private int inPut1;
	private int inPut2;

	private int intPected;
	
	
	public SiteTest(int expected, int input1, int input2) {
		inPut1 = input1;
		inPut2 = input2;
		intPected = expected;
	}
	
	@Test
	public void test() {
		BlackJack bj = new BlackJack();
		
		assertEquals(intPected, bj.blackJack(inPut1, inPut2));
		
//		assertEquals(10, bj.blackJack(10,22));
//		assertEquals(9, bj.blackJack(22,9));
//
//		assertEquals(0, bj.blackJack(22,22));
//		assertEquals(10, bj.blackJack(10,7));
//		assertEquals(19, bj.blackJack(1,19));

	}

}
