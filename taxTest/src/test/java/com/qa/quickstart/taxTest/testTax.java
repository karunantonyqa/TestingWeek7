package com.qa.quickstart.taxTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testTax {
	
	@Parameters
	public static List<Integer[]> data(){
		return Arrays.asList(new Integer[][] {{14999,14999}, {13500, 15000}, {18000, 19999}, {17000, 20000}, {25500, 29999}, {24000, 30000}, {36000, 44999}, {33750, 45000}});
	}
	
	private int input;
	private int exOutput;
	
	public testTax(int expected, int input1) {
		input = input1;
		exOutput = expected;
	}
	
	@Test
	public void test() {
		TaxCalc t = new TaxCalc();
		assertEquals(exOutput, t.calcTax(input));
	}

}