package com.cg.app.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdharCard extends IdCard {
	
	private long adharNo;
	private String figerprints;
	private String irisscan;
}
