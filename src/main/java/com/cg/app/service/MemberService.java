package com.cg.app.service;

import java.util.List;

import com.cg.app.exception.MemberException;
import com.cg.app.model.Member;

public interface MemberService {
	public Member addMember(Member member);
	public Member updateMember(Member member)throws MemberException;
	public Member deleteMember(Member member)throws MemberException;
	public Member getMemberById (Integer idcardid)throws MemberException;
	public Member getMemberByAdharNo(Long adharno)throws MemberException;
	public Member getMemberByPanNo(String panNo)throws MemberException;
	public List<Member> getAllMember()throws MemberException;
}
