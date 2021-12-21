package com.amdocs.accountsappliction.services;

import com.amdocs.accountsappliction.helperobject.ResponseMessage;
import com.amdocs.accountsappliction.pojo.Accounts;
import com.amdocs.accountsappliction.pojo.Users;

public interface AccountService {

	public ResponseMessage saveAccount(Users account);
	public ResponseMessage getAccount(int userID);
	public ResponseMessage updateAccount(Users account, int userID);
	public ResponseMessage updateSingleAccount(Accounts account, int accountID);
	public ResponseMessage deleteAccount(int userID);
	public ResponseMessage deleteSingleAccount(int accountID);
}
