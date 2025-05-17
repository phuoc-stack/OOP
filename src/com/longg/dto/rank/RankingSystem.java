package com.longg.dto.rank;

public interface RankingSystem {
	float applyRankPromo(float price, float shippingFee, boolean hasVoucher);
	String getDescription();
}
