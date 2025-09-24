package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    Member registerMember(MemberDto dto);
    List<Member> getAllMembers();
}
