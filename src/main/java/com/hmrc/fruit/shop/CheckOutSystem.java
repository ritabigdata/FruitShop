package com.hmrc.fruit.shop;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CheckOutSystem {

	private Map<String,BigDecimal> fruits = new HashMap<String, BigDecimal>();
	
	public CheckOutSystem() {
		fruits = new HashMap<String, BigDecimal>();
		fruits.put("APPLE", new BigDecimal("0.60"));
		fruits.put("ORANGE", new BigDecimal("0.25"));
	}

	public String printReceipt(List<String> basket) {
		Set<String> uniqueFruits = new HashSet<String>(basket);
		BigDecimal totalPrice = new BigDecimal("0.0");
		for (String fruit : uniqueFruits) {
			int count = Collections.frequency(basket, fruit);
			BigDecimal price = fruits.get(fruit.toUpperCase());
			BigDecimal totalFruitPrice = scanItem(count, price);
			totalPrice = totalPrice.add(totalFruitPrice);
		}
		return NumberFormat.getCurrencyInstance().format(totalPrice.doubleValue());
	}

	public BigDecimal scanItem(int count, BigDecimal unitCost) {
		if (unitCost != null) {
			return (new BigDecimal(count)).multiply(unitCost);
		} else {
			return BigDecimal.ZERO;
		}
	}
}
