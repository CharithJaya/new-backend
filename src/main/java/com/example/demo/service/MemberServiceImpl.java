package com.example.demo.service;


import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member registerMember(MemberDto dto) {
        Member member = Member.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .course(dto.getCourse())
                .emergencyContact(dto.getEmergencyContact())
                .address(dto.getAddress())
                .build();
        return repository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return repository.findAll();
    }
}
