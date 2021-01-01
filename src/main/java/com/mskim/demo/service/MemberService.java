package com.mskim.demo.service;

import com.mskim.demo.domain.Member;
import com.mskim.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository repository;

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Member save(Member member) {
        return repository.save(member);
    }
}
