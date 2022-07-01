package com.cg.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.model.AdharCard;
import com.cg.app.model.IdCard;
import com.cg.app.model.Member;
import com.cg.app.model.PanCard;
import com.cg.app.repository.IdCardRepository;
import com.cg.app.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
@Slf4j
public class MemberController {

	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private IdCardRepository idCardRepo;
	
	
	
	/*

	  url:- http://localhost:7000/member/registerwithAdhar/55555555
	  method: post
	  request data :-
	  
	  
	  {

    "idCard": {
        "name": "Ravi",
        "dob": "05/02/1990",
        "gender": "male",
        "address" : "banjara hills",
        "city": "hydrabad",
        "state": "telangana",
        "pincode": "4565654"
    }
}
	  
	  
	  
	  
	  
	  
	 */
	
	@PostMapping("/registerwithAdhar/{adharNumber}")
	public Member addMemberHandler( @Valid @PathVariable("adharNumber") Long adharNumber, @RequestBody Member member) {
		
		
		//getting supplied IdCard details
		 IdCard idCard= member.getIdCard();
		
		 
		 //creating new AdharCard obj
		 AdharCard ad=new AdharCard();
		 
		 //setting the supplied adharNumber
		 ad.setAdharNo(adharNumber);
		 
		 //mapping each field of IdCard to the AdharCard obj
		 ad.setAddress(idCard.getAddress());
		 ad.setCity(idCard.getCity());
		 ad.setDob(idCard.getDob());
		 ad.setGender(idCard.getGender());
		 ad.setName(idCard.getName());
		 ad.setPincode(idCard.getPincode());
		 ad.setState(idCard.getState());
		 
		 //setting 2 specific properties of AdharCard class
		 ad.setFigerprints(idCard.getName()+" fingerprint");
		 ad.setIrisscan(idCard.getName()+" Iriscan");
		 
		 //attaching this adhar card obj with member obj
		 member.setIdCard(ad);
		
		return memberService.addMember(member);
		
	}
	

	/*

	  url:- http://localhost:7000/member/registerwithPan/88888888
	  method: post
	  request data :-
	  
	  
	  {

    "idCard": {
        "name": "Ravi",
        "dob": "05/02/1990",
        "gender": "male",
        "address" : "banjara hills",
        "city": "hydrabad",
        "state": "telangana",
        "pincode": "4565654"
    }
}
	  
	  
	  
	  
	  
	  
	 */
	
	
	
	
	
	@PostMapping("/registerwithPan/{panNumber}")
	public Member addMemberHandler( @Valid @PathVariable("panNumber") String panNumber, @RequestBody Member member) {
		

		//getting supplied IdCard details
		 IdCard idCard= member.getIdCard();
		
		 
		 //creating new PanCard obj
		 PanCard pan=new PanCard();
		 
		 //setting the supplied panNumber
		 pan.setPanoNo(panNumber);
		 
		 //mapping each field of IdCard to the PanCard obj
		 pan.setAddress(idCard.getAddress());
		 pan.setCity(idCard.getCity());
		 pan.setDob(idCard.getDob());
		 pan.setGender(idCard.getGender());
		 pan.setName(idCard.getName());
		 pan.setPincode(idCard.getPincode());
		 pan.setState(idCard.getState());
		  
		 
		 //attaching this pancard obj with member obj
		 member.setIdCard(pan);
		
		return memberService.addMember(member);
		
	}
	
	
	@PutMapping("/update")
	public Member updateMember(@Valid @RequestBody Member member) {
		
		return memberService.updateMember(member);
	}
	
	
	@DeleteMapping("/delete/{idCardId}")
	public Member deleteMember(@PathVariable("idCardId") Integer idCardId) {
		
		Member member= memberService.getMemberById(idCardId);
		
		return memberService.deleteMember(member);
		
	}
	
	
	@GetMapping("/findbyID/{idCardId}")
	public Member getMemberById (@PathVariable("idCardId") Integer idCardId) {
		return memberService.getMemberById(idCardId);
	}
	
	
	@GetMapping("/findByAdharNo/{adharno}")
	public Member getMemberByAdharNo(@PathVariable("adharno") Long adharno) {
		
		return memberService.getMemberByAdharNo(adharno);
		
	}
	
	@GetMapping("/findByPanNo/{panNo}")
	public Member getMemberByPanNo(String panNo) {
		
		return memberService.getMemberByPanNo(panNo);
	}
	
	@GetMapping("/findall")
	public List<Member> getAllMember(){
		
		return memberService.getAllMember();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
