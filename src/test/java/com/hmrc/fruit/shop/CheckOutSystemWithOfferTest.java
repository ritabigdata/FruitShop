package com.hmrc.fruit.shop;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckOutSystemWithOfferTest {

	private CheckOutSystemWithOffer checkOutSystemWithOffer;
	private String symbol;

	@Before
	public void setUp() {
		checkOutSystemWithOffer = new CheckOutSystemWithOffer();
		symbol = NumberFormat.getCurrencyInstance().getCurrency().getSymbol();
	}

	@After
	public void tearDown() {
		checkOutSystemWithOffer = null;
	}

	@Test
	public void testPrintReceiptApplesAndOranges() {
		String[] fruits = { "Apple", "Apple", "Orange", "Apple" };
		List<String> basket = Arrays.asList(fruits);
		
		String expectedPrice = symbol + "1.45";
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		assertEquals(expectedPrice, checkoutPrice);

	}

	@Test
	public void testPrintReceiptApples() {
		String[] fruits = { "Apple", "Apple", "Apple", "Apple" };
		List<String> basket = Arrays.asList(fruits);
		
		String expectedPrice = symbol + "1.20";
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);

		assertEquals(expectedPrice, checkoutPrice);

	}

	@Test
	public void testPrintReceiptOranges() {
		String[] fruits = { "Orange", "Orange", "Orange", "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String expectedPrice = symbol + "0.75";
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		assertEquals(expectedPrice, checkoutPrice);
	}

	@Test
	public void testPrintReceiptFiveOranges() {
		String[] fruits = { "Orange","Orange", "Orange", "Orange", "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String expectedPrice = symbol + "1.00";
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		assertEquals(expectedPrice, checkoutPrice);
	}

	
	@Test
	public void testPrintReceiptApplesAndOrangesRandomOrder() {
		String[] fruits = { "Apple", "Orange", "Apple", "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		String expectedPrice = symbol + "1.10";
		assertEquals(expectedPrice, checkoutPrice);
	}

	@Test
	public void testPrintReceiptApplesAndOrangesRandomOrder2() {
		String[] fruits = {  "Orange", "Orange", "Apple", "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		String expectedPrice = symbol + "1.10";
		assertEquals(expectedPrice, checkoutPrice);
	}

	
	@Test
	public void testPrintReceiptSingleApple() {
		String[] fruits = { "Apple" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		String expectedPrice = symbol + "0.60";
		assertEquals(expectedPrice, checkoutPrice);

	}
	
	@Test
	public void testPrintReceiptTwoApple() {
		String[] fruits = { "Apple","Apple" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		String expectedPrice = symbol + "0.60";
		assertEquals(expectedPrice, checkoutPrice);

	}

	@Test
	public void testPrintReceiptSingleOrange() {
		String[] fruits = { "Orange" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		String expectedPrice = symbol + "0.25";
		assertEquals(expectedPrice, checkoutPrice);
	}

	@Test
	public void testPrintReceiptTwoOranges() {
		String[] fruits = { "Orange","Orange" };
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);
		String expectedPrice = symbol + "0.50";
		assertEquals(expectedPrice, checkoutPrice);
	}

	@Test
	public void testPrintReceiptEmptyBasket() {
		String[] fruits = {};
		List<String> basket = Arrays.asList(fruits);
		String checkoutPrice = checkOutSystemWithOffer.printReceipt(basket);;
		String expectedPrice = symbol + "0.00";
		assertEquals(expectedPrice, checkoutPrice);
	}

}
