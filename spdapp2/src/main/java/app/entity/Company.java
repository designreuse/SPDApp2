package app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends UrlEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "title")
	private String title;

	@Column(name = "edrpou")
	private String edrpou;

	@Column(name = "inn")
	private String inn;

	@Column(name = "vat_certificate")
	private String vatCertificate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval = true)
	@OrderBy("id ASC")
	private Set<CompanyAddress> addresses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval = true)
	@OrderBy("id ASC")
	private Set<CompanyDirector> directors;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval = true)
	@OrderBy("id ASC")
	private Set<CompanyAccount> accounts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval = true)
	@OrderBy("id ASC")
	private Set<Agreement> agreements;

	public Company() {
	}

	public Company(String title, String edrpou, String inn, String vatCertificate) {
		this.title = title;
		this.edrpou = edrpou;
		this.inn = inn;
		this.vatCertificate = vatCertificate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdrpou() {
		return edrpou;
	}

	public void setEdrpou(String edrpou) {
		this.edrpou = edrpou;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getVatCertificate() {
		return vatCertificate;
	}

	public void setVatCertificate(String vatCertificate) {
		this.vatCertificate = vatCertificate;
	}

	public Set<CompanyAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<CompanyAddress> addresses) {
		this.addresses = addresses;
	}

	public Set<CompanyDirector> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<CompanyDirector> directors) {
		this.directors = directors;
	}

	public Set<CompanyAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<CompanyAccount> accounts) {
		this.accounts = accounts;
	}

	public Set<Agreement> getAgreements() {
		return agreements;
	}

	public void setAgreements(Set<Agreement> agreements) {
		this.agreements = agreements;
	}

}
