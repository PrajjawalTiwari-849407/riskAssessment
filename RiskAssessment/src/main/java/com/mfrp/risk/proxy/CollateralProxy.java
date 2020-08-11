package com.mfrp.risk.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@FeignClient(name = "savecollateral-service", url = "http://pod10-alb-1000270644.us-west-2.elb.amazonaws.com/")
public interface CollateralProxy {

	@GetMapping("/collateral/getCollateralId/{loanId}")
	public String getID(@PathVariable String loanId);
}
