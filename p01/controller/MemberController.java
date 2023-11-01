//package org.zerock.p01.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.zerock.p01.dto.MemberDTO;
//import org.zerock.p01.service.MemberService;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/member")
//@Log4j2
//@RequiredArgsConstructor
//public class MemberController {
//    private final MemberService memberService;
//
//    // 회원가입
//    @GetMapping("/register")
//    public void registerGET(){
//
//    }
//
//    @PostMapping("/register")
//    public String registerPOST(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
//            return "redirect:/member/register";
//        }
//        String memberId = memberService.memberRegister(memberDTO);
//        redirectAttributes.addFlashAttribute("result", memberId);
//        return "redirect:/member/login";
//    }
//
//    @GetMapping("/login")
//    public void loginGET(){
//
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam("memberId") String memberId, @RequestParam("memberPw") String memberPw){
//        boolean loginSuccess = memberService.login(memberId, memberPw);
//        if(loginSuccess){
//            return "redirect:/todo/list";
//        }else{
//            return "redirect:/member/login?error=true";
//        }
//    }
//
//    // 로그아웃
//
//
//    // 회원 탈퇴
//    @PostMapping("/delete")
//    public String delete(String memberId, RedirectAttributes redirectAttributes){
//        memberService.memberDelete(memberId);
//        redirectAttributes.addFlashAttribute("result", "deleted");
//        return "redirect:/member/login";
//    }
//}
