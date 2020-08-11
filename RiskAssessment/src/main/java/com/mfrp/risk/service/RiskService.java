package com.mfrp.risk.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfrp.risk.exception.RiskNotFoundException;
import com.mfrp.risk.model.Collateral_Market_Value;
import com.mfrp.risk.model.Collateral_Risk;
import com.mfrp.risk.proxy.CollateralProxy;
import com.mfrp.risk.repository.RiskRepository;

@Service
public class RiskService {

	@Autowired
	RiskRepository riskRepository;

	
	@Transactional
	public Collateral_Risk findById(String Id) throws RiskNotFoundException {
		//Collateral_Risk obj = riskRepository.findBySanctionedLoan(user.getCollateral_Id());
		return riskRepository.findById(Id).orElseThrow(() -> new RiskNotFoundException(Id));
	}

}