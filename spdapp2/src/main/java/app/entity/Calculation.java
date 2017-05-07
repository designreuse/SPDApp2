package app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "specification_calculation")
public class Calculation extends UrlEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "specification_id")
	private Specification specification;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_start")
	private Date dateStart;
	
	@Column(name = "part_number")
	private Integer partNumber;
	
	@Column(name = "opening_balance")
	private Double openingBalance = 0.0;
	
	@Column(name = "esv")
	private Double esv;
	
	@Column(name = "salary_rate")
	private Double salaryRate ;
	
	@Column(name = "premium")
	private Double premium = 0.0;
	
	@Column(name = "surcharge")
	private Double surcharge = 0.0;
	
	@Column(name = "card_service_fee")
	private Double cardServiceFee = 0.0;
	
	@Column(name = "account_service_fee")
	private Double accountServiceFee = 0.0;
	
	@Column(name = "simple_tax")
	private Double simpleTax = 0.0;
	
	@Column(name = "withdraw_cash_comission")
	private Double withdrawCashComission;
	
	@Column(name = "closing_balance")
	private Double closingBalance = 0.0;
	
	@Column(name = "rent")
	private Double rent = 0.0;
	
	@Column(name = "turnover")
	private Double turnover = 0.0;
	
	@Column(name = "money_on_hand")
	private Double moneyOnHand = 0.0;
	
	@Column(name = "money_transfer")
	private Double moneyTransfer = 0.0;
	
	@Column(name = "withdraw_cash")
	private Double withdrawCash = 0.0;
	
	public Calculation() {
	}

	public Calculation(Specification specification, Integer partNumber, Date dateStart, Double openingBalance) {
		this.specification = specification;
		this.dateStart = dateStart;
		this.partNumber = partNumber;
		this.openingBalance = openingBalance;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Integer getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(Integer partNumber) {
		this.partNumber = partNumber;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Double getEsv() {
		return esv;
	}

	public void setEsv(Double esv) {
		this.esv = esv;
	}

	public Double getSalaryRate() {
		return salaryRate;
	}

	public void setSalaryRate(Double salaryRate) {
		this.salaryRate = salaryRate;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public Double getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(Double surcharge) {
		this.surcharge = surcharge;
	}

	public Double getCardServiceFee() {
		return cardServiceFee;
	}

	public void setCardServiceFee(Double cardServiceFee) {
		this.cardServiceFee = cardServiceFee;
	}

	public Double getAccountServiceFee() {
		return accountServiceFee;
	}

	public void setAccountServiceFee(Double accountServiceFee) {
		this.accountServiceFee = accountServiceFee;
	}

	public Double getSimpleTax() {
		return simpleTax;
	}

	public void setSimpleTax(Double simpleTax) {
		this.simpleTax = simpleTax;
	}

	public Double getWithdrawCashComission() {
		return withdrawCashComission;
	}

	public void setWithdrawCashComission(Double withdrawCashComission) {
		this.withdrawCashComission = withdrawCashComission;
	}

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Double getMoneyOnHand() {
		return moneyOnHand;
	}

	public void setMoneyOnHand(Double moneyOnHand) {
		this.moneyOnHand = moneyOnHand;
	}

	public Double getMoneyTransfer() {
		return moneyTransfer;
	}

	public void setMoneyTransfer(Double moneyTransfer) {
		this.moneyTransfer = moneyTransfer;
	}

	public Double getWithdrawCash() {
		return withdrawCash;
	}

	public void setWithdrawCash(Double withdrawCash) {
		this.withdrawCash = withdrawCash;
	}

}