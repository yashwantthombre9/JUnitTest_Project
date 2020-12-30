package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BMICalcTest {
	String first = "you are considered underweight and possibly malnourished!";
	String second = "you are within a healthy weight range for young and middle-aged adults!";
	String third  = "you are considered overweight!";
	String fourth = "you are considered obese!";

	@Test
	void test() {
		
		BMICalc bmi = new BMICalc(); // should pass this testCase
		double bmiFinal= BMICalc.findBMI(70, 2);
		System.out.println(bmiFinal);
		assertEquals(17.50,bmiFinal);
	}
	@Test
	void test1() {
		
		double bmi = BMICalc.findBMI(70, 2);
//		if( bmi > 25 && bmi < 29.9)
			assertEquals(second,BMICalc.check);//should fail this testCase
			
	}
	
	@Test
	void test2() {
		
		double bmi = BMICalc.findBMI(50, 2);
//		if(bmi < 18.5)
			assertEquals(first,BMICalc.check);//should pass this TestCase
			
	}
	
	@Test
	void test3() {
		
		double bmi = BMICalc.findBMI(70, 2);
//		if( bmi >= 18.5 && bmi <= 24.9)
			assertEquals(first,BMICalc.check);// should pass this TestCase
			
	}
	
	@Test
	void test4() {
		
		double bmi = BMICalc.findBMI(70, 1);
//		if(bmi >= 30)
			assertEquals(fourth,BMICalc.check);// should pass this TestCase
			
	}
	

}
