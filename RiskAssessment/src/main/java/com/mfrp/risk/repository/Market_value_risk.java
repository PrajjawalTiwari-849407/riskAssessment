package com.mfrp.risk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfrp.risk.model.Collateral_Market_Value;
import com.mfrp.risk.model.Collateral_Risk;

@Repository
public interface Market_value_risk extends JpaRepository<Collateral_Market_Value, String> {
}
