package com.hmrc.fruit.shop;

public class OfferServiceFactory {

	public static Offer getOffer(String fruit) {

		String fruitName = fruit.toUpperCase();
		Offer offer = null;
		switch (fruitName) {
			case "APPLE":
				offer = new BuyOneGetOneOffer();
				break;
			case "ORANGE":
				offer = new ThreeForTwoOffer();
				break;
			default :
				offer = new NoOffer();
		}
		return offer;
	}

}
