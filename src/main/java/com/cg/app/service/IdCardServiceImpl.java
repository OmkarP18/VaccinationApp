package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.IdCardException;
import com.cg.app.exception.MemberException;
import com.cg.app.model.AdharCard;
import com.cg.app.model.IdCard;
import com.cg.app.model.Member;
import com.cg.app.model.PanCard;
import com.cg.app.repository.IdCardRepository;
import com.cg.app.repository.MemberRepository;

@Service
public class IdCardServiceImpl implements IdCardService{

	
	@Autowired
	private IdCardRepository idCardRepo;
	
	@Override
	public IdCard addIdCard(IdCard idcard) {
		
		return idCardRepo.save(idcard);
		
		
	}

	@Override
	public IdCard getPanCardByNumber(String panNo) throws IdCardException {
		
		
		List<IdCard> idCards= idCardRepo.findAll();
		
		for(IdCard idCard:idCards) {
			
			PanCard pan=(PanCard)idCard;
			if(panNo == pan.getPanoNo())
				return pan;
		}
		
		throw new MemberException("invalid Pan Card Number...");
		
		
		
	}

	@Override
	public IdCard getAdharCardByNo(long adharno) throws IdCardException {
	
		
	List<IdCard> idCards= idCardRepo.findAll();
		
		for(IdCard idCard:idCards) {
			
			AdharCard ad=(AdharCard)idCard;
			if(adharno == ad.getAdharNo())
				return ad;
		}
		
		throw new MemberException("invalid Adhar Card Number...");
		
	}

}
