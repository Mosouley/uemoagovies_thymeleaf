package com.moh.uemoagovies.domain;


import java.time.LocalDate;

import java.util.Map;

import com.moh.uemoagovies.helpers.FrequenceCalcul;
import com.moh.uemoagovies.helpers.GoviesRepayMode;


/**
 *
 * @author soul
 */
public class UemoaBond implements Bond {

    
    private double faceValue;
    private double coupon;
    private int maturity;
    private double price;
    private LocalDate issueDate;
    private LocalDate maturityDate;
    private LocalDate tradingDate;
    private FrequenceCalcul couponFreq;
    private FrequenceCalcul redemFreq;
    private GoviesRepayMode repayMode;
    private int gracePeriod;
    

	@Override
	public double getFaceValue() {
		// TODO Auto-generated method stub
		return faceValue;
	}
	@Override
	public double getCoupon() {
		// TODO Auto-generated method stub
		return coupon;
	}
	@Override
	public int getMaturity() {
		// TODO Auto-generated method stub
		return maturity;
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public LocalDate getIssueDate() {
		// TODO Auto-generated method stub
		return issueDate;
	}
	@Override
	public LocalDate getMaturityDate() {
		// TODO Auto-generated method stub
		return maturityDate;
	}
	@Override
	public FrequenceCalcul getCouponFreq() {
		// TODO Auto-generated method stub
		return couponFreq;
	}
	@Override
	public FrequenceCalcul getRedemFreq() {
		// TODO Auto-generated method stub
		return redemFreq;
	}
	@Override
	public GoviesRepayMode getRepayMode() {
		// TODO Auto-generated method stub
		return repayMode;
	}
	@Override
	public int getGracePeriod() {
		// TODO Auto-generated method stub
		return gracePeriod;
	}

  

}
