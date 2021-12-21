package com.amdocs.accountsappliction.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amdocs.accountsappliction.feignclient.AccountsFeignClient;
import com.amdocs.accountsappliction.helperobject.ResponseMessage;
import com.amdocs.accountsappliction.pojo.Accounts;
import com.amdocs.accountsappliction.pojo.Users;
import com.amdocs.accountsappliction.utility.Validator;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountsFeignClient accountsFeignClient;

	@Autowired
	private Validator validator;

	/*
	 * Method used to save the account
	 */
	@Override
	public ResponseMessage saveAccount(Users user) {
		try {
			ResponseMessage validatorResponse = validator.validatorForSaveUser(user);
			if (validatorResponse.isSuccess()) {
				ResponseMessage response = accountsFeignClient.save(user);
				if (response.isSuccess()) {
					logger.info("User info save successfully");
					return response;
				}
				return response;
			}
			return validatorResponse;
		} catch (Exception ex) {
			logger.info("Error occured while saveing account info");
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Method used to get single account details
	 */
	public ResponseMessage getAccount(int userID) {
		try {
			ResponseMessage response = accountsFeignClient.get(userID);
			if (response.isSuccess()) {
				logger.info("User account info is:");
				return response;
			}
			return response;
		} catch (Exception ex) {
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Method used to updated account
	 */
	public ResponseMessage updateAccount(Users user, int userID) {
		try {
			ResponseMessage validatorResponse = validator.validatorForUpdateUser(user);
			if (validatorResponse.isSuccess()) {
				ResponseMessage response = accountsFeignClient.update(user, userID);
				if (response.isSuccess()) {
					logger.info("User info updated successfully");
					return response;
				}
				return response;
			}
			return validatorResponse;
		} catch (Exception ex) {
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Method used to updated single account
	 */
	public ResponseMessage updateSingleAccount(Accounts account, int accountID) {
		try {
			ResponseMessage validatorResponse = validator.validatorForUpdateSingleAccount(account);
			if (validatorResponse.isSuccess()) {
				ResponseMessage response = accountsFeignClient.singleAccountUpdate(account, accountID);
				if (response.isSuccess()) {
					logger.info("Account info updated successfully");
					return response;
				}
				return response;
			}
			return validatorResponse;
		}catch(Exception ex) {
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Method used to delete account
	 */
	public ResponseMessage deleteAccount(int userID) {
		try {
			ResponseMessage response = accountsFeignClient.delete(userID);
			if (response.isSuccess()) {
				logger.info("User info deleted successfully");
				return response;
			}
			return response;
		} catch (Exception ex) {
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * Method used to delete single account
	 */
	public ResponseMessage deleteSingleAccount(int accountID) {
		try {
			ResponseMessage response = accountsFeignClient.singleDelete(accountID);
			if (response.isSuccess()) {
				logger.info("Account info deleted successfully");
				return response;
			}
			return response;
		} catch (Exception ex) {
			return new ResponseMessage(null, false, ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
