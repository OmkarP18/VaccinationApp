package com.cg.app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IdCard idCard;
	
	private boolean dose1status;
	private boolean dose2status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dose1date;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dose2date;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "member")
	private Vaccine vaccine;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "member")
	private Appointment appointment;
	
	
	
	
}
