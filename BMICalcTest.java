package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BMICalcTest {

	@Test
	void test() {
		
		BMICalc bmi = new BMICalc();
		double bmiFinal= BMICalc.findBMI(70, 2);
		System.out.println(bmiFinal);
		assertEquals(17.50,bmiFinal);
	}

}
