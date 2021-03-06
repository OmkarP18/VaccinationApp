package com.cg.app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineRegistration {
	
	@Id
	private Long mobileno;
	
	private LocalDate dateofregistration;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vaccineRegistration")
	private  List<Member> memberlist=new ArrayList<Member>();
	
}
