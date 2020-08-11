package com.mfrp.risk.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "login-service", url = "http://pod10-alb-1000270644.us-west-2.elb.amazonaws.com/")
public interface LoginProxy {

	@GetMapping("/login/validatetoken/{token}")
	public String validatetoken(@PathVariable String token);

}
