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
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.zerock.p01.Entity.Group;
//import org.zerock.p01.dto.GroupDTO;
//import org.zerock.p01.service.GroupService;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/group")
//@Log4j2
//@RequiredArgsConstructor
//public class GroupController {
//    private final GroupService groupService;
//
//    @GetMapping("/list2")
//    public void list (Model model){
//        List<GroupDTO> list = groupService.groupReadAll();
//        model.addAttribute("list", list);
//    }
//
//    @GetMapping("/register")
//    public void registerGET(){
//
//    }
//
//    @PostMapping("/register")
//    public String regosterPOST(@Valid GroupDTO groupDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
//            return "redirect:/group/register";
//        }
//        String groupName = groupService.groupInsert(groupDTO);
//        redirectAttributes.addFlashAttribute("result", groupName);
//        return "redirect:/group/list";
//    }
//
//    @GetMapping({"/read", "/modify"})
//    public void read (String groupName, Model model){
//        GroupDTO groupDTO = groupService.groupReadOne(groupName);
//        model.addAttribute("groupDTO", groupDTO);
//    }
//
//    @PostMapping("/modify")
//    public String modify(@Valid GroupDTO groupDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
//            redirectAttributes.addAttribute("groupName", groupDTO.getGroupName());
//            return "redirect:/group/modify";
//        }
//        groupService.groupModify(groupDTO);
//        redirectAttributes.addFlashAttribute("result", "modified");
//        redirectAttributes.addAttribute("groupName", groupDTO.getGroupName());
//        return "redirect:/group/read";
//    }
//
//    @PostMapping("/delete")
//    public String delete(String groupName, RedirectAttributes redirectAttributes){
//        groupService.groupDelete(groupName);
//        redirectAttributes.addFlashAttribute("result", "deleted");
//        return "redirect:/group/list";
//    }
//}
