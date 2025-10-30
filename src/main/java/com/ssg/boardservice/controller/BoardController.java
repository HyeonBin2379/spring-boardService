package com.ssg.boardservice.controller;

import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("GET board list...");
        List<BoardDTO> boardList = boardService.getAll();
        model.addAttribute("boardList", boardList);
    }

    @GetMapping("/register")
    public void registerGET() {
        log.info("GET board register...");
    }

    @PostMapping("/register")
    public void registerPOST(@Valid BoardDTO boardDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        log.info("POST board register...");
    }
}
