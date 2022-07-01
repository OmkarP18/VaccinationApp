package com.cg.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer code;
	
	private String centername;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "center")
	private List<Appointment> appointments=new ArrayList<Appointment>();

}
