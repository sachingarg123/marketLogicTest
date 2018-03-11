package com.marketlogic.sample.encoding;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class EncodingTest {

	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("@BeforeClass - runOnceBeforeClass");

	}

	@Test
	public void test_offsetPositive() {
		// Test for offset positive and with alphabet greater than z
		String encodedValue = Encoding.encode(2, "xyz");
		assertEquals("zab", encodedValue);

	}

	@Test
	public void test_offsetPositiveNegativeScenario() {
		// Test for offset positive and with alphabet greater than z
		String encodedValue = Encoding.encode(2, "xyz");
		assertNotEquals("zac", encodedValue);

	}

	@Test
	public void test_offsetNegative() {
		// Test for offset negative

		String encodedValue = Encoding.encode(-3, "xyz");
		assertEquals("uvw", encodedValue);

	}

	@Test
	public void test_offsetNegativeFalseScenario() {
		// Test for offset negative
		String encodedValue = Encoding.encode(-3, "xyz");
		assertNotEquals("abc", encodedValue);

	}

}
