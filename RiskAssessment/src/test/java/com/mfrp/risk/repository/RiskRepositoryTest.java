package com.mfrp.risk.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mfrp.risk.model.Collateral_Market_Value;
import com.mfrp.risk.model.Collateral_Risk;
@WebMvcTest(Market_value_risk.class)
class RiskRepositoryTest {
	
		@MockBean
	    TestEntityManager entityManager;
		 
		@MockBean
		 RiskRepository riskRepository;
		
		    @Test
		    @Before(value = "Repoistory")
		    public void init() {
		    	Collateral_Risk obj = new Collateral_Risk("C1","nfdjkw",40,"2018",40000,44845);
		        entityManager.persist(obj);
		        entityManager.flush();
		        when(riskRepository.findById(obj.getCollateral_id())).thenReturn(Optional.of(obj));
		        assertEquals("C1", obj.getCollateral_id());
		    }
		    
		    @Test
		    @Before(value = "Repoistory")
		    public void ini() {
		    	Collateral_Risk obj = new Collateral_Risk("C1","nfdjkw",40,"2018",40000,44845);
		        entityManager.persist(obj);
		        entityManager.flush();
		        when(riskRepository.findBySanctionedLoan(obj.getCollateral_id())).thenReturn((obj));
		        assertEquals("C1", obj.getCollateral_id());
		    }
}
