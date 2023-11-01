package org.zerock.p01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.p01.Entity.Group;
import org.zerock.p01.dto.GroupDTO;
import org.zerock.p01.service.GroupService;
import org.zerock.p01.dto.MemberDTO;
import org.zerock.p01.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/memberGroup")
@Log4j2
@RequiredArgsConstructor
public class MGController {
    private final GroupService groupService;
    private final MemberService memberService;

    // main
    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("message", "메인 페이지");
        return "main";
    }

    // Member
    @GetMapping("/m_register")
    public void memberRegisterGET(){

    }

    @PostMapping("/m_register")
    public String memberRegisterPOST(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/memberGroup/m_register";
        }
        String memberId = memberService.memberRegister(memberDTO);
        redirectAttributes.addFlashAttribute("result", memberId);
        return "redirect:/memberGroup/login";
    }

    @GetMapping("/login")
    public void loginGET(){

    }

    @PostMapping("/login")
    public String login(@RequestParam("memberId") String memberId, @RequestParam("memberPw") String memberPw){
        boolean loginSuccess = memberService.login(memberId, memberPw);
        if(loginSuccess){
            return "redirect:/todo/list";
        }else{
            return "redirect:/memberGroup/login?error=true";
        }
    }

    // 로그아웃

    @PostMapping("/m_delete")
    public String memberDelete(String memberId, RedirectAttributes redirectAttributes){
        memberService.memberDelete(memberId);
        redirectAttributes.addFlashAttribute("result", "deleted");
        return "redirect:/memberGroup/login";
    }


    // Group
    @GetMapping("/g_list")
    public void groupList (Model model){
        List<GroupDTO> list = groupService.groupReadAll();
        model.addAttribute("list", list);
    }

    @GetMapping("/g_register")
    public void groupRegisterGET(){

    }

    @PostMapping("/g_register")
    public String groupRegisterPOST(@Valid GroupDTO groupDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/memberGroup/g_register";
        }
        String groupName = groupService.groupInsert(groupDTO);
        redirectAttributes.addFlashAttribute("result", groupName);
        return "redirect:/memberGroup/g_list";
    }

    @GetMapping({"/g_read", "/g_modify"})
    public void groupRead (String groupName, Model model){
        GroupDTO groupDTO = groupService.groupReadOne(groupName);
        model.addAttribute("groupDTO", groupDTO);
    }

    @PostMapping("/g_modify")
    public String groupModify(@Valid GroupDTO groupDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("groupName", groupDTO.getGroupName());
            return "redirect:/memberGroup/g_modify";
        }
        groupService.groupModify(groupDTO);
        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("groupName", groupDTO.getGroupName());
        return "redirect:/memberGroup/g_read";
    }

    @PostMapping("/g_delete")
    public String groupDelete(String groupName, RedirectAttributes redirectAttributes){
        groupService.groupDelete(groupName);
        redirectAttributes.addFlashAttribute("result", "deleted");
        return "redirect:/memberGroup/g_list";
    }
}
