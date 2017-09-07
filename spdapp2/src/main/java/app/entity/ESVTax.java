package app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "esv_tax")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ESVTax extends UrlEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "value", columnDefinition=DECIMAL_10_2_DEFAULT_0_00)
	private Double value;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_start")
	private Date dateStart;

	public ESVTax() {
		super();
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

}
