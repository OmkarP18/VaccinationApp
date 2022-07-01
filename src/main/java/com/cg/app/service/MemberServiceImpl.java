package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.MemberException;
import com.cg.app.model.AdharCard;
import com.cg.app.model.IdCard;
import com.cg.app.model.Member;
import com.cg.app.model.PanCard;
import com.cg.app.repository.IdCardRepository;
import com.cg.app.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private IdCardRepository idCardRepo;
	

	@Override
	public Member addMember(Member member) {
		
		return memberRepo.save(member);
	}

	@Override
	public Member updateMember(Member member) throws MemberException {
		
		if(memberRepo.existsById(member.getMid()))
			return memberRepo.save(member);
		
		throw new MemberException("Invalid Member Data");
		
		
	}

	@Override
	public Member deleteMember(Member member) throws MemberException {
		
		if(memberRepo.existsById(member.getMid())) {
			 memberRepo.delete(member);
			 return member;
		}
			
		
		throw new MemberException("Invalid Member Data");	
		
	}

	@Override
	public Member getMemberById(Integer idcardid) throws MemberException {
		
		IdCard idCard= idCardRepo.findById(idcardid).orElseThrow(() -> new MemberException("Invalid IdCard id: "+idcardid));
		
		return idCard.getMember();
		
	}

	@Override
	public Member getMemberByAdharNo(Long adharno) throws MemberException {
		
		List<IdCard> idCards= idCardRepo.findAll();
		
		for(IdCard idCard:idCards) {
			
			AdharCard ad=(AdharCard)idCard;
			if(adharno == ad.getAdharNo())
				return ad.getMember();
		}
		
		throw new MemberException("invalid Adhar Card Number...");
		
	}

	@Override
	public Member getMemberByPanNo(String panNo) throws MemberException {
		
		List<IdCard> idCards= idCardRepo.findAll();
		
		for(IdCard idCard:idCards) {
			
			PanCard pan=(PanCard)idCard;
			if(panNo == pan.getPanoNo())
				return pan.getMember();
		}
		
		throw new MemberException("invalid Pan Card Number...");
		
	}

	@Override
	public List<Member> getAllMember() throws MemberException {
		
		List<Member> members= memberRepo.findAll();
		
		if(members.size() >0)
			return members;
		
		throw new MemberException("No Members Found");
					
	}
	
}
