package com.longg.dto.rank;

public enum ShopARankingSystem implements RankingSystem {
	GOLD("Discount 2%"),
	SILVER("Shipping fee reduced 50%"),
	NONE("No discount"),
	DIAMOND("Discount 3%");
	
	
	private String description;

	ShopARankingSystem(String string) {
		this.description = string;
	}


	@Override
	public float applyRankPromo(float price, float shippingFee, boolean hasVoucher) {
		switch (this) {
		case DIAMOND:
			price *= 0.97f;
			break;
		case GOLD:
			price *= 0.98f;
			break;
		case SILVER:
			shippingFee *= 0.5;
			break;
		default:
			break;
		
		}
		float total = price + shippingFee;
		
		if (hasVoucher) {
	        total -= 1;
	    }
		
		return total;
		
	}



	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	

	public static RankingSystem getRankByName(String rankString) {
		return valueOf(rankString);
	}
}
