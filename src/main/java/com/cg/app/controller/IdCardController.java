package com.cg.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.model.AdharCard;
import com.cg.app.model.IdCard;
import com.cg.app.model.Member;
import com.cg.app.model.PanCard;
import com.cg.app.service.IdCardService;

@RestController
@RequestMapping("/idCard")
@CrossOrigin(origins = "*")
public class IdCardController {

	@Autowired
	private IdCardService idCardService;
	
	
	/*
	
	url :- http://localhost:7000/idCard/addPancard
	method :- POST
	
	request data :-
	
	{

    "panoNo": "4333333",
    "name": "amit2",
    "dob": "05/02/1990",
    "gender": "male",
    "address" : "banjara hills",
    "city": "hydrabad",
    "state": "telangana",
    "pincode": "4565654"
}
	
	
	
	*/
	
	@PostMapping("/addPancard")
	public IdCard addIdCard (@Valid @RequestBody PanCard idcard) {
		
		Member m=new Member();
		m.setIdCard(idcard);
		
		idcard.setMember(m);
		
		
		return idCardService.addIdCard(idcard);
		
	}
	

	
/*
	
	url :- http://localhost:7000/idCard/addAdharCard
	method :- POST
	
	request data :-
	
	{

    "adharNo": 7878788,
    "figerprints": "dinesh fingerprint",
    "irisscan": "dinesh irisscan",
    "name": "dinesh",
    "dob": "05/02/1990",
    "gender": "male",
    "address" : "banjara hills",
    "city": "hydrabad",
    "state": "telangana",
    "pincode": "4565654"
}
	
	
	
	*/

	
	
	
	
	
	@PostMapping("/addAdharCard")
	public IdCard addIdCard2 (@Valid @RequestBody AdharCard idcard) {

		Member m=new Member();
		m.setIdCard(idcard);
		
		idcard.setMember(m);
		
		return idCardService.addIdCard(idcard);
	}
	
	@GetMapping("/findByPanNo/{panNo}")
	public IdCard getPanCardByNumber(@PathVariable("panNo") String panNo) {
		
		return idCardService.getPanCardByNumber(panNo);
	}
	
	
	@GetMapping("/findByAdharNo/{adharno}")
	public IdCard getAdharCardByNo(@PathVariable("adharno") Long adharno) {
		
		return idCardService.getAdharCardByNo(adharno);
	}

	
	
}
