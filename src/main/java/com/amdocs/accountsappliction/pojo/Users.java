package com.amdocs.accountsappliction.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Users {

	private int userid;
	private String name;
	private String emailid;
	private String mobilenumber;
	private String secondarymobile;
	private String dob;
	private String gender;
	
	private List<Accounts> accounts = new ArrayList<>();
}
