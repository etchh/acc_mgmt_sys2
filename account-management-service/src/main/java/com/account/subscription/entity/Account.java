package com.account.subscription.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "account")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	Long id;
	
	@Column(nullable = false, unique = true)
	private String accountName;

	private String address;

	private String phone;

	private String fax;

	private String mobile;

	@Column(nullable = false, unique = true)
	private String email;

	@JsonIgnore
	@Column(nullable = false)
	private String password;

	private String website;

	@Column(name = "warehouse_available")
	private boolean warehouseAvailable;

	@Column(name = "is_certified")
	private boolean isCertified;
	
	@Column(name = "type")
	private String type;	
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "packg_id")
	private Packg packg;
	
	@OneToOne
	@JoinColumn(name = "document_id")
	@RestResource(path = "accountDocument", rel="document")
	private Document document;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Packg getPackg() {
		return this.packg;
	}

	public void setPackageId(Packg packg) {
		this.packg = packg;
	}

	public Account() {

	}

	public Account(String accountName, String address, String phone, String fax, String mobile, String email,
			String password, String website, String type, String status, Packg packg) {
		super();
		this.accountName = accountName;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.website = website;
		this.type = type;
		this.packg = packg;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isWarehouseAvailable() {
		return warehouseAvailable;
	}

	public void setWarehouseAvailable(boolean warehouseAvailable) {
		this.warehouseAvailable = warehouseAvailable;
	}

	public boolean isCertified() {
		return isCertified;
	}

	public void setCertified(boolean isCertified) {
		this.isCertified = isCertified;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}


	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public void setPackg(Packg packg) {
		this.packg = packg;
	}

	@Override
	public String toString() {
		return "Account Record : " + id + "Account Name : " + accountName;
	}

}
