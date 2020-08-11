package com.mfrp.risk.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "Collateral_Market_Value")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Collateral_Market_Value {
	@Id
	private String collateral_Id;
	private double priceperSqrFeet;
	private String area;
	private String city;
	private String bankName;
	private double rate;
	private double depositAmt;
	private double plotSize;
	private String date;
}