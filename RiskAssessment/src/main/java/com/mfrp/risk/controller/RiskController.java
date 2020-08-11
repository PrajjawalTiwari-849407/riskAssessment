package com.mfrp.risk.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mfrp.risk.exception.InvalidDetails;
import com.mfrp.risk.exception.RiskNotFoundException;
import com.mfrp.risk.exception.TokenInvalidException;
import com.mfrp.risk.model.Collateral_Risk;
import com.mfrp.risk.proxy.LoginProxy;
import com.mfrp.risk.proxy.CollateralProxy;
import com.mfrp.risk.service.MarketValueService;
import com.mfrp.risk.service.RiskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Risk Assessment Microservice", description = "Operations pertaining to refreshing values and getting risk percentage")
@Slf4j
@RequestMapping("/riskapp")
public class RiskController {

	@Autowired
	CollateralProxy colToken;

	@Autowired
	RiskService riskService;

	@Autowired
	MarketValueService marketvaluerisk;

	@Autowired
	LoginProxy loginProxy;

	@GetMapping("/getCollateralRisk/{loanId}")
	@ApiOperation(value = "Find the risk percentage by loan Id", notes = "Also it calls the collateral microservice to get the associated collateral id to a particular loan Id")
	public Collateral_Risk getRiskDetailById(@RequestHeader(name = "Authorization") String token,
			@PathVariable String loanId) throws RiskNotFoundException, TokenInvalidException, InvalidDetails {
		log.debug("/getCollateralRisk/{loanId}");
		String status = loginProxy.validatetoken(token);
		if (status.equalsIgnoreCase("valid")) {
			log.info(String.format("Token Validated Sending %s to RiskService" + loanId));
			String colId = colToken.getID(loanId);
			return (Collateral_Risk) riskService.findById(colId);
		} else {
			log.warn("Invalid Token Exception");
			throw new TokenInvalidException("token expired");
		}
	}

	@GetMapping("/refresh")
	@ApiOperation(value = "It refreshes the values from flat file values to database, calculates risk percentage and store it in the database", notes = "It refreshes the values from flat file values to database, calculates risk percentage and store it in the database")
	public String refreshF() throws RiskNotFoundException, IOException {
		log.debug("/refresh");
		return marketvaluerisk.saveF();
	}

}