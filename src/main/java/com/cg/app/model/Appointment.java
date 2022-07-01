package com.cg.app.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingid;
	
	private long mobileno;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccinationCenter center;
	
	private LocalDate dateofbooking;
	
	private Slot slot;
	
	private boolean bookingstatus;
}
