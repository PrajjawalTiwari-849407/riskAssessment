package com.mfrp.risk.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;

import com.mfrp.risk.exception.RiskNotFoundException;
import com.mfrp.risk.model.Collateral_Market_Value;
import com.mfrp.risk.model.Collateral_Risk;

import com.mfrp.risk.proxy.CollateralProxy;
import com.mfrp.risk.repository.Market_value_risk;
import com.mfrp.risk.repository.RiskRepository;

@Service
public class MarketValueService {

	@Autowired
	Market_value_risk marketRepsitory;

	@Autowired
	RiskRepository riskRepository;

	@Autowired
	CalculateRiskService calculateRiskService;

	@Transactional
	public Collateral_Market_Value findById(String Id) throws RiskNotFoundException {

		return marketRepsitory.findById(Id).orElseThrow(() -> new RiskNotFoundException(Id));
	}

	@Transactional
	public Collateral_Market_Value saverisk(Collateral_Market_Value user) throws RiskNotFoundException {

		return marketRepsitory.save(user);
	}
   
	@Transactional
	public String saveF() throws RiskNotFoundException, IOException {
		File f=new File("src/main//resources/input/flatfile.xlsx").getAbsoluteFile(); 
		FileInputStream file = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // points to the starting of excel i.e excel first row
			row = (Row) sheet.getRow(i); // sheet number

			String collateralid;
			if (row.getCell(0) == null) {
				collateralid = "0";
			} else
				collateralid = row.getCell(0).toString();

			String priceperSqrFeet;
			if (row.getCell(1) == null) {
				priceperSqrFeet = "null";
			} // suppose excel cell is empty then its set to 0 the variable
			else
				priceperSqrFeet = row.getCell(1).toString(); // else copies cell data to name variable

			String area;
			if (row.getCell(2) == null) {
				area = "null";
			} else
				area = row.getCell(2).toString();

			String city;
			if (row.getCell(3) == null) {
				city = "0"; 
			} else
				city = row.getCell(3).toString();

			String bankName;
			if (row.getCell(4) == null) {
				bankName = "null";
			} // suppose excel cell is empty then its set to 0 the variable
			else
				bankName = row.getCell(4).toString(); // else copies cell data to name variable

			String rate;
			if (row.getCell(5) == null) {
				rate = "null";
			} else
				rate = row.getCell(5).toString();

			String depositAmt;
			if (row.getCell(6) == null) {
				depositAmt = "0";
			} else
				depositAmt = row.getCell(6).toString();

			String plotSize;
			if (row.getCell(7) == null) {
				plotSize = "null";
			} // suppose excel cell is empty then its set to 0 the variable
			else
				plotSize = row.getCell(7).toString(); // else copies cell data to name variable

			String date_accessed;
			if (row.getCell(8) == null) {
				date_accessed = "null";
			}     
			else
				date_accessed = row.getCell(8).toString(); 
			
			Collateral_Market_Value std = new Collateral_Market_Value();
			std.setCollateral_Id(collateralid); 
			std.setPriceperSqrFeet(Double.parseDouble(priceperSqrFeet));
			std.setArea(area);
			std.setCity(city);
			std.setBankName(bankName);
			std.setRate(Double.parseDouble(rate));
			std.setDepositAmt(Double.parseDouble(depositAmt));
			std.setPlotSize(Double.parseDouble(plotSize));
			std.setDate(date_accessed);
			marketRepsitory.save(std);
			calculateRiskService.saveRisk(std);
		}
		return "done";
	}
}
