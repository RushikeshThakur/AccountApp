package com.amdocs.accountsappliction.pojo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Accounts {

	private String branchname;
	private String accounttype;
	private int accountbalance;
	
}
