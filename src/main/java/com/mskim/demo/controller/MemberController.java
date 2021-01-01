package com.mskim.demo.controller;

import com.mskim.demo.domain.Member;
import com.mskim.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

//    List<Member> memberList = new ArrayList<>();

    @Autowired
    MemberService memberService;

    // /member
    @GetMapping
    public String index(Model model){
        model.addAttribute("list", memberService.findAll());
        model.addAttribute("member", new Member());
        return "member";
    }
    @PostMapping
    public String create(@Valid Member member, BindingResult bindingResult, Model model){
        log.info("member : {}", member);
        log.info("bindingResult {}", bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            //Validation 에러가 있는 경우
            log.info("eeeeeeeeeeeee");
            model.addAttribute("member", member);
            return "member";
        }
        //model.addAttribute("member", member);
//        memberList.add(member);
        memberService.save(member);
        return "redirect:/member";
    }
}
