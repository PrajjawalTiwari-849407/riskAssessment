/**
 * 
 */
package com.mfrp.risk.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mfrp.risk.exception.RiskNotFoundException;
import com.mfrp.risk.model.Collateral_Market_Value;
import com.mfrp.risk.model.Collateral_Risk;
import com.mfrp.risk.repository.Market_value_risk;
import com.mfrp.risk.repository.RiskRepository;

import aj.org.objectweb.asm.ClassReader;

/**
 * @author prajjawal
 *
 */
@ExtendWith(MockitoExtension.class)
class MarketValueServiceTest {
	@Mock
	private Market_value_risk marketRepository;

	@InjectMocks
	private MarketValueService service;
	
	@Test 
	void shouldFindByIdSuccessFully() {
		final String id="C1";
		final Collateral_Market_Value user= new Collateral_Market_Value ("C1",4000,"delhi","delhi","icici",10,40000,50000,"2018-3-2"); 
		Mockito.lenient().when(marketRepository.findById(id)).thenReturn(Optional.of(user));
	}
	
	@Test  
	void shouldSavedUserSuccessFully() throws RiskNotFoundException {
		final String id="C1";
		final Collateral_Market_Value user= new Collateral_Market_Value ("C1",4000,"delhi","delhi","icici",10,40000,50000,"2020-03-23"); 
		 
		Mockito.lenient().when(marketRepository.findById(user.getCollateral_Id())).thenReturn(Optional.empty());
		 Mockito.lenient().when(marketRepository.save(user)).thenAnswer(invocation->invocation.getArgument(0));
		Collateral_Market_Value saveduser=service.saverisk(user);
		assertThat(saveduser).isNotNull();
		}
	  
}
