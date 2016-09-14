package com.hmrc.fruit.shop;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckOutSystemTest {

	private CheckOutSystem checkOutSystem;
	private String symbol;

	@Before
	public void setUp() {
		checkOutSystem = new CheckOutSystem();
		symbol = NumberFormat.getCurrencyInstance().getCurrency().getSymbol();
	}

	@After
	public void tearDown() {
		checkOutSystem = null;
	}

	@Test
	public void testPrintReceiptApplesAndOrnages() {
		String[] fruits = { "Apple", "Apple", "Orange", "Apple" };
		List<String> basket = Arrays.asList(fruits);
		
		String expectedPrice = symbol + "2.05";
		String checkoutPrice = checkOutSystem.printReceipt(basket);
		assertEquals(expectedPrice, checkoutPrice);

	}

	@Test
	public void testPrintReceiptApples() {
		String[] fruits = { "Apple", "Apple", "Apple", "Apple" };
		List<String> basket = Arrays.asList(fruits);
		
		String expectedPrice = symbol + "2.40";
		String checkoutPrice = checkOutSystem.printReceipt(basket);

		assertEquals(expectedPrice, checkoutPrice);

	}

	@Test
	public void testPrintReceiptOrnages() {
		String[] fruits = { "Orange", "Orange", "Orange", "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String expectedPrice = symbol + "1.00";
		String checkoutPrice = checkOutSystem.printReceipt(basket);
		assertEquals(expectedPrice, checkoutPrice);
	}

	@Test
	public void testPrintReceiptApplesAndOrnagesRandomOrder() {
		String[] fruits = { "Apple", "Orange", "Apple", "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystem.printReceipt(basket);
		String expectedPrice = symbol + "1.70";
		assertEquals(expectedPrice, checkoutPrice);

	}

	@Test
	public void testPrintReceiptSingleApple() {
		String[] fruits = { "Apple" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystem.printReceipt(basket);
		String expectedPrice = symbol + "0.60";
		assertEquals(expectedPrice, checkoutPrice);

	}

	@Test
	public void testPrintReceiptSingleOrange() {
		String[] fruits = { "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystem.printReceipt(basket);
		String expectedPrice = symbol + "0.25";
		assertEquals(expectedPrice, checkoutPrice);
	}

	@Test
	public void testPrintReceiptEmptyBasket() {
		String[] fruits = {};
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystem.printReceipt(basket);;
		String expectedPrice = symbol + "0.00";
		assertEquals(expectedPrice, checkoutPrice);
	}

}
