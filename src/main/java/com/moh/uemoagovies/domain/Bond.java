
package com.moh.uemoagovies.domain;

import java.time.LocalDate;
import java.util.Map;

import com.moh.uemoagovies.helpers.FrequenceCalcul;
import com.moh.uemoagovies.helpers.GoviesRepayMode;


/**
 *
 * @author soul
 */
public interface Bond {

    public double getFaceValue();
    public double getCoupon();
    public int getMaturity();
    public double getPrice();
    public LocalDate getIssueDate();
    public LocalDate getMaturityDate();
    public FrequenceCalcul getCouponFreq();
    public FrequenceCalcul getRedemFreq();
    public GoviesRepayMode getRepayMode();
    public int getGracePeriod();
  
}
