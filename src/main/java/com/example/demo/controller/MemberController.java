package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:3000") // 💡 Allows requests from your Next.js frontend
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    /**
     * Handles POST requests to add a new member.
     * @param dto The MemberDto containing member details.
     * @return ResponseEntity with the created Member and a 201 Created status.
     */
    @PostMapping
    public ResponseEntity<Member> addMember(@Valid @RequestBody MemberDto dto) {
        Member newMember = service.registerMember(dto);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED); // 💡 Returns a 201 status code
    }

    /**
     * Handles GET requests to retrieve a list of all members.
     * @return ResponseEntity with a list of all Members and a 200 OK status.
     */
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = service.getAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK); // 💡 Returns a 200 status code
    }
}
