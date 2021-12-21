package com.amdocs.accountsappliction.feignclient;

//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.netflix.eureka.loadbalancer.
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amdocs.accountsappliction.helperobject.ResponseMessage;
import com.amdocs.accountsappliction.pojo.Accounts;
import com.amdocs.accountsappliction.pojo.Users;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
//@FeignClient(name="user-service")
//@RibbonClient(name="user-service")
public interface AccountsFeignClient {
	
	@PostMapping("/user/create")
	public ResponseMessage save(@RequestBody Users user);
	
	@GetMapping("/user/get/{userID}")
	public ResponseMessage get(@PathVariable int userID);
	
	@PutMapping("/user/update/{userID}")
	public ResponseMessage update(@RequestBody Users user, @PathVariable int userID);
	
	@PutMapping("/user/account/update/{accountID}")
	public ResponseMessage singleAccountUpdate(@RequestBody Accounts account, @PathVariable int accountID);
	
	@DeleteMapping("/user/delete/{userID}")
	public ResponseMessage delete(@PathVariable int userID);
	
	@DeleteMapping("/user/account/delete/{accountID}")
	public ResponseMessage singleDelete(@PathVariable int accountID);
}
