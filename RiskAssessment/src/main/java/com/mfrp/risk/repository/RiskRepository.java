package com.mfrp.risk.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfrp.risk.model.Collateral_Risk;






@Repository
public interface RiskRepository extends JpaRepository<Collateral_Risk, String> {
	@Query("SELECT u FROM Collateral_Risk u WHERE u.Collateral_id = ?1")
	Collateral_Risk findBySanctionedLoan(String Collateral_id);
}