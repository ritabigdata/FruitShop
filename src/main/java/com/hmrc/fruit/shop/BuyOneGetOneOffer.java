package com.hmrc.fruit.shop;

import java.math.BigDecimal;

public class BuyOneGetOneOffer implements Offer {

	@Override
	public BigDecimal applyOffer(int count, BigDecimal price) {
		
		return new BigDecimal(count/2 + count%2).multiply(price);	
		
	}

}
