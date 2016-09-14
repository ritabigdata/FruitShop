package com.hmrc.fruit.shop;

import java.math.BigDecimal;

public interface Offer {

	BigDecimal applyOffer(int count, BigDecimal price);

}
