package com.account.subscription.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feature")
public class Feature {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feature_id")
	Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
    @JoinColumn(name="packg_id")
    private Packg packg;
	
	public Feature(String name, String description, Packg packg) {
		super();
		this.name = name;
		this.description = description;
		this.packg = packg;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Packg getPackg() {
		return packg;
	}

	public void setPackg(Packg packg) {
		this.packg = packg;
	}
	@Override
	public String toString() {
		return "Feature : " + id + "Feature Name : " + name;
	}
}
