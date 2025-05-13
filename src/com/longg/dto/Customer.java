package com.longg.dto;

import com.longg.dto.rank.RankingSystem;

public class Customer {

	public String id;
	public String password;
	public RankingSystem rank;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

}
