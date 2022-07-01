package com.cg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.app.model.Member;

public interface MemberRepository extends JpaRepository<Member,Integer>{

}
