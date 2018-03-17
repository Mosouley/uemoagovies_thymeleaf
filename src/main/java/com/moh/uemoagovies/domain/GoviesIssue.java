
package com.moh.uemoagovies.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.moh.uemoagovies.helpers.FrequenceCalcul;
import com.moh.uemoagovies.helpers.GoviesRepayMode;


/**
 * @author soul
 * Entity Issue extending abstractentity for id and version
 * no formal link with other entities
 */
@Entity
public class GoviesIssue {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;
    
    private String minutesIssuance; //compte rendu des adju sous fichiers media
    
    private float nominalValue; //valeur nominale unitaire
    
	private float averageRate; //taux moyen pondere

    private float couponRate; //coupon rate

    private float bidAmount; //montant soumission

    private float getAmount; //montant obtenu
    
    private float offeredAmount; //issue amount
    
    private float offeredONC; //onc amount

    private String codeIsin; // codeIsin des titres

    private int gracePeriod; // period de differe

    private Date issueDate; // date d'emission

    private String issueReference; //reference adju
    
    private String issueDescription; // denomination du titre
    
    private String issueTranche; // reference a la tranche

    private float marginalRate; //taux marginal

    private Date maturityDate; // date d'echeance

    private FrequenceCalcul interestPeriod;// periodicite des interets

    private FrequenceCalcul repayPeriod; //periodicite des amortissements

    private GoviesRepayMode repayMode; //mode de remboursement

    private Date valueDate; //date de valeur adju

    private String issuer; //emetteur du titres code pays

    private String goviesType; // nature des titres emis
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getMinutesIssuance() {
		return minutesIssuance;
	}

	public void setMinutesIssuance(String minutesIssuance) {
		this.minutesIssuance = minutesIssuance;
	}

	public float getNominalValue() {
		return nominalValue;
	}

	public void setNominalValue(float nominalValue) {
		this.nominalValue = nominalValue;
	}

	public float getOfferedONC() {
		return offeredONC;
	}

	public void setOfferedONC(float offeredONC) {
		this.offeredONC = offeredONC;
	}

	public FrequenceCalcul getInterestPeriod() {
		return interestPeriod;
	}

	public void setInterestPeriod(FrequenceCalcul interestPeriod) {
		this.interestPeriod = interestPeriod;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(float averageRate) {
		this.averageRate = averageRate;
	}

	public float getCouponRate() {
		return couponRate;
	}

	public void setCouponRate(float couponRate) {
		this.couponRate = couponRate;
	}

	public float getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(float bidAmount) {
		this.bidAmount = bidAmount;
	}

	public float getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(float getAmount) {
		this.getAmount = getAmount;
	}

	public float getOfferedAmount() {
		return offeredAmount;
	}

	public void setOfferedAmount(float offeredAmount) {
		this.offeredAmount = offeredAmount;
	}

	public String getCodeIsin() {
		return codeIsin;
	}

	public void setCodeIsin(String codeIsin) {
		this.codeIsin = codeIsin;
	}

	public int getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssueReference() {
		return issueReference;
	}

	public void setIssueReference(String issueReference) {
		this.issueReference = issueReference;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getIssueTranche() {
		return issueTranche;
	}

	public void setIssueTranche(String issueTranche) {
		this.issueTranche = issueTranche;
	}

	public float getMarginalRate() {
		return marginalRate;
	}

	public void setMarginalRate(float marginalRate) {
		this.marginalRate = marginalRate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public FrequenceCalcul getRepayPeriod() {
		return repayPeriod;
	}

	public void setRepayPeriod(FrequenceCalcul repayPeriod) {
		this.repayPeriod = repayPeriod;
	}

	public GoviesRepayMode getRepayMode() {
		return repayMode;
	}

	public void setRepayMode(GoviesRepayMode repayMode) {
		this.repayMode = repayMode;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getGoviesType() {
		return goviesType;
	}

	public void setGoviesType(String goviesType) {
		this.goviesType = goviesType;
	}




}
