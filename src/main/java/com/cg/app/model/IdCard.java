package com.cg.app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Description;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public  class IdCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCardId;
	@Size(min=3,max=12,message ="Name lenght must be min 3 and max 12")
	private String name;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	private String gender;
	@Size(min=3,max=30,message = "Address length must be min 5 and max 30")
	private String address;
	private String city;
	private String state;
	@Size(min=6,max=6,message = "please pass proper pincode")
	private String pincode;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "idCard")
	private Member member;
	

	
	
	
}
