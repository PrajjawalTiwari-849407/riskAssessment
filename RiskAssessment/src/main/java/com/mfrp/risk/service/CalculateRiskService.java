package com.mfrp.risk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfrp.risk.model.Collateral_Market_Value;
import com.mfrp.risk.model.Collateral_Risk;
import com.mfrp.risk.repository.Market_value_risk;
import com.mfrp.risk.repository.RiskRepository;

@Service
public class CalculateRiskService {

	@Autowired
	Market_value_risk marketRepsitory;

	@Autowired
	RiskRepository riskRepository;

	@Transactional
	public Collateral_Risk saveRisk(Collateral_Market_Value user) {
		Collateral_Risk obj = riskRepository.findBySanctionedLoan(user.getCollateral_Id());
		if (obj.getCollateralType().equals("realestate")) {
			try {
				double plotSize = user.getPlotSize();
				// double sanctionedLoan = cash.getSanctionedLoan();
				double sanctionedLoan = obj.getSanctioned_Loan();
				double marketValue = user.getPriceperSqrFeet() * plotSize;
				double riskPer = marketValue * 100 / sanctionedLoan;
				if (riskPer >= 100) {
					riskPer = 0;
				}
				obj.setCollateral_id(user.getCollateral_Id());
				obj.setDate_Assessed(user.getDate());
				obj.setMarket_Value(marketValue);
				obj.setPer_risk(riskPer);
				obj.setSanctioned_Loan(sanctionedLoan);
				return obj;
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else if (obj.getCollateralType().equals("deposit")) {
			try {
				double depositAmt = user.getDepositAmt();
				double sanctionedLoan = obj.getSanctioned_Loan();
				double marketValue = (user.getRate() * depositAmt) + depositAmt;
				double riskPer = marketValue * 100 / sanctionedLoan;
				if (riskPer >= 100) {
					riskPer = 0;
				}
				obj.setCollateral_id(user.getCollateral_Id());
				obj.setDate_Assessed(user.getDate());
				obj.setMarket_Value(marketValue);
				obj.setPer_risk(riskPer);
				obj.setSanctioned_Loan(sanctionedLoan);
				return obj;
			} catch (Exception ex) {
				System.out.println(ex);
			} 
		} 
		return null;
	} 
}
