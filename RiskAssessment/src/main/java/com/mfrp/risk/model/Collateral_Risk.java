package com.mfrp.risk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Collateral_Risk")
public class Collateral_Risk {
	@Id
	@GeneratedValue()
	private String Collateral_id;
	private String CollateralType;
	private double Per_risk;
	private String Date_Assessed;
	private double Market_Value;
	private double Sanctioned_Loan;

}
