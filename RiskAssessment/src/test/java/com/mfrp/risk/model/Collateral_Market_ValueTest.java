package com.mfrp.risk.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mfrp.risk.service.RiskService;
@ExtendWith(MockitoExtension.class)
class Collateral_Market_ValueTest {

	
	@Test
	void test() {
		Collateral_Market_Value obj=new Collateral_Market_Value("C1",4000,"delhi","delhi","icici",10,40000,50000,"2018-3-2");
		assertEquals("C1",obj.getCollateral_Id());
	}

	@Test
	void test1() {
		Collateral_Market_Value obj=new Collateral_Market_Value("C1",4000,"delhi","delhi","icici",10,40000,50000,"2018-3-2");
		assertEquals("delhi",obj.getArea());
	}
	
}
