package com.longg.dto;

import com.longg.dto.rank.RankingSystem;
import com.longg.dto.rank.ShopARankingSystem;

public class Customer {

	public String id;
	public String password;
	public String rankString;
	public RankingSystem rank;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String password, String rankString) {
		super();
		this.id = id;
		this.password = password;
		this.rankString = rankString;
	}
	
	public void initializeRank(Shop currentShop) {
		this.rank = ShopARankingSystem.getRankByName(rankString);
	}
}
