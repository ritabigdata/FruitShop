package com.hmrc.fruit.shop;

import java.math.BigDecimal;

public class ThreeForTwoOffer implements Offer {

	@Override
	public BigDecimal applyOffer(int count, BigDecimal price) {
		return new BigDecimal(count - (count/3)).multiply(price);
	}

}
