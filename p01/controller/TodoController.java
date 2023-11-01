package org.zerock.p01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.p01.dto.TodoDTO;
import org.zerock.p01.service.TodoService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/list")
    public void list (Model model){
        List<TodoDTO> list = todoService.todoReadAll();
        model.addAttribute("list", list);
    }

    @GetMapping("/register")
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("board POST register...");
        if(bindingResult.hasErrors()){
            log.info("has errors...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info(todoDTO);
        Long lno = todoService.todoInsert(todoDTO);
        redirectAttributes.addFlashAttribute("result", lno);
        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read (Long lno, Model model){
        TodoDTO todoDTO = todoService.todoReadOne(lno);
        log.info(todoDTO);
        model.addAttribute("todoDTO", todoDTO);
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("todo modify...");
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("lno", todoDTO.getLno());
            return "redirect:/todo/modify";
        }
        todoService.todoModify(todoDTO);
        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("lno", todoDTO.getLno());
        return "redirect:/todo/read";
    }

    @PostMapping("/delete")
    public String delete(Long lno, RedirectAttributes redirectAttributes){
        log.info("delete..."+lno);
        todoService.todoDelete(lno);
        redirectAttributes.addFlashAttribute("result", "deleted");
        return "redirect:/todo/list";
    }
}
