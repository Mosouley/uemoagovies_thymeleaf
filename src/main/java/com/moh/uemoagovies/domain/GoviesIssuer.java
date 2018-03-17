
package com.moh.uemoagovies.domain;


import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * @author soul
 */
@Entity
public class GoviesIssuer extends AbstractDomainClass {


    private String flagUrl;

    @Column(unique = true, length = 30)
    private String fullName;

    @Column(unique = true, nullable = false, length = 10)
    private String shortName;

    public String getFlagUrl() {
		return flagUrl;
	}

	public void setFlagUrl(String flagUrl) {
		this.flagUrl = flagUrl;
	}

	public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public GoviesIssuer fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public GoviesIssuer shortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

}
