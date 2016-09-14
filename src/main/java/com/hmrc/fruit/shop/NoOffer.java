package com.hmrc.fruit.shop;

import java.math.BigDecimal;

public class NoOffer implements Offer {

	@Override
	public BigDecimal applyOffer(int count, BigDecimal price) {
		return price.multiply(new BigDecimal(count));
	}

}
