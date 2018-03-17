
package com.moh.uemoagovies.domain;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;


/**
 * @author soul
 * gives the details of the type of a govies
 */
@Entity
public class GoviesType extends AbstractDomainClass {

	@Column(nullable = false)
    @Basic
    private int conventionBase;

    @Column(unique = true, length = 50)
    @Basic
    private String fullName;

    @Column(unique = true, length = 20)
    @Basic
    private String shortName;

    @Column(length = 50)
    @Basic
    private String nomConvention;

	public int getConventionBase() {
		return conventionBase;
	}

	public void setConventionBase(int conventionBase) {
		this.conventionBase = conventionBase;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getNomConvention() {
		return nomConvention;
	}

	public void setNomConvention(String nomConvention) {
		this.nomConvention = nomConvention;
	}


   
}
