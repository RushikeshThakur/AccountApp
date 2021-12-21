package com.amdocs.accountsappliction.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.amdocs.accountsappliction.helperobject.ResponseMessage;
import com.amdocs.accountsappliction.pojo.Accounts;
import com.amdocs.accountsappliction.pojo.Users;

@Component
public class Validator {

	/*
	 * Validation while creating the new user
	 */
	public ResponseMessage validatorForSaveUser(Users user) {

		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(user.getName());
		final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);

		if (m.find() || user.getName().isBlank()) {
			return new ResponseMessage(null, false, "Name should not contains any special character",
					HttpStatus.BAD_REQUEST);
		}

		if (!pat.matcher(user.getEmailid()).matches() || user.getEmailid().isBlank()) {
			return new ResponseMessage(null, false, "Invalid Email Id", HttpStatus.BAD_REQUEST);
		}

		if (user.getMobilenumber().isBlank() || String.valueOf(user.getMobilenumber()).length() != 10) {
			return new ResponseMessage(null, false, "Invalid mobile number", HttpStatus.BAD_REQUEST);
		}
		
		if (String.valueOf(user.getSecondarymobile()).length() != 10) {
			return new ResponseMessage(null, false, "Invalid secondary mobile number", HttpStatus.BAD_REQUEST);
		}

		try {
			Date d1 = sdf.parse(user.getDob().toString());	
		} catch (ParseException e) {
			return new ResponseMessage(null, false, "Invalid DOB", HttpStatus.BAD_REQUEST);
		}
		
		if (user.getGender().length() > 1 || !user.getGender().equalsIgnoreCase("m") && !user.getGender().equalsIgnoreCase("f")) {
			return new ResponseMessage(null, false, "Invalid gender", HttpStatus.BAD_REQUEST);
		}
		
		for(Accounts account: user.getAccounts()) {
			if(account.getBranchname().length() < 3 || account.getBranchname().length() > 40 || account.getBranchname().isBlank()) {
				return new ResponseMessage(null, false, "Invalid branch name", HttpStatus.BAD_REQUEST);
			}
			
			if(!account.getAccounttype().equalsIgnoreCase("saving") && !account.getAccounttype().equalsIgnoreCase("current") || account.getAccounttype().isBlank()) {
				return new ResponseMessage(null, false, "Invalid account type", HttpStatus.BAD_REQUEST);
			}
			
			if(account.getAccountbalance() < 0) {
				return new ResponseMessage(null, false, "Account balance must be positive", HttpStatus.BAD_REQUEST);
			}
		}
		
		return new ResponseMessage(null, true, "", HttpStatus.ACCEPTED);
	}

	/*
	 * Validation while updating user info
	 */
	public ResponseMessage validatorForUpdateUser(Users user) {
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(user.getName());
		final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);

		if (m.find() || user.getName().isBlank()) {
			return new ResponseMessage(null, false, "Name should not contains any special character",
					HttpStatus.BAD_REQUEST);
		}

		if (!pat.matcher(user.getEmailid()).matches() || user.getEmailid().isBlank()) {
			return new ResponseMessage(null, false, "Invalid Email Id", HttpStatus.BAD_REQUEST);
		}

		if (user.getMobilenumber().isBlank() || String.valueOf(user.getMobilenumber()).length() != 10) {
			return new ResponseMessage(null, false, "Invalid mobile number", HttpStatus.BAD_REQUEST);
		}

		try {
			Date d1 = sdf.parse(user.getDob().toString());	
		} catch (ParseException e) {
			return new ResponseMessage(null, false, "Invalid DOB", HttpStatus.BAD_REQUEST);
		}
		
		if (String.valueOf(user.getSecondarymobile()).length() != 10) {
			return new ResponseMessage(null, false, "Invalid secondary mobile number", HttpStatus.BAD_REQUEST);
		}
		
		if (user.getGender().length() > 1 || !user.getGender().equalsIgnoreCase("m") && !user.getGender().equalsIgnoreCase("f")) {
			return new ResponseMessage(null, false, "Invalid gender", HttpStatus.BAD_REQUEST);
		}
		
		for(Accounts account: user.getAccounts()) {
			if(account.getBranchname().length() < 3 || account.getBranchname().length() > 40 || account.getBranchname().isBlank()) {
				return new ResponseMessage(null, false, "Invalid branch name", HttpStatus.BAD_REQUEST);
			}
			
			if(!account.getAccounttype().equalsIgnoreCase("saving") && !account.getAccounttype().equalsIgnoreCase("current") || account.getAccounttype().isBlank()) {
				return new ResponseMessage(null, false, "Invalid account type", HttpStatus.BAD_REQUEST);
			}
			
			if(account.getAccountbalance() < 0) {
				return new ResponseMessage(null, false, "Account balance must be positive", HttpStatus.BAD_REQUEST);
			}
		}
		
		return new ResponseMessage(null, true, "", HttpStatus.ACCEPTED);
	}
	
	/*
	 * Validation while updating single account info
	 */
	public ResponseMessage validatorForUpdateSingleAccount(Accounts account) {
		if(account.getBranchname().length() < 3 || account.getBranchname().length() > 40 || account.getBranchname().isBlank()) {
			return new ResponseMessage(null, false, "Invalid branch name", HttpStatus.BAD_REQUEST);
		}
		
		if(!account.getAccounttype().equalsIgnoreCase("saving") && !account.getAccounttype().equalsIgnoreCase("current") || account.getAccounttype().isBlank()) {
			return new ResponseMessage(null, false, "Invalid account type", HttpStatus.BAD_REQUEST);
		}
		
		if(account.getAccountbalance() < 0) {
			return new ResponseMessage(null, false, "Account balance must be positive", HttpStatus.BAD_REQUEST);
		}
		return new ResponseMessage(null, true, "", HttpStatus.ACCEPTED);
	}
	
}
