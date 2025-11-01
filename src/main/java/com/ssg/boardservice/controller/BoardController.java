package com.ssg.boardservice.controller;

import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.dto.PageRequestDTO;
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
    public void list(@Valid PageRequestDTO pageRequestDTO,
                     BindingResult bindingResult,
                     Model model) {
        log.info("GET board list...");

        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }

        model.addAttribute("responseDTO", boardService.getAll(pageRequestDTO));
    }

    @GetMapping("/register")
    public void registerGET() {
        log.info("GET board register...");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid BoardDTO boardDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        log.info("POST board register...");

        if (bindingResult.hasErrors()) {
            log.error("POST board register has error....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }

        log.info(boardDTO);
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long bId, Model model) {
        log.info("GET board detail...");
        BoardDTO boardDTO = boardService.getOne(bId);
        log.info(boardDTO);
        model.addAttribute("board", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(@Valid BoardDTO boardDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        log.info("board modify...");

        if (bindingResult.hasErrors()) {
            log.error("board modify has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bId", boardDTO.getBId());
            return "redirect:/board/modify";
        }

        log.info(boardDTO);
        boardService.edit(boardDTO);
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Long bId,
                         RedirectAttributes redirectAttributes) {
        log.info("board remove....");
        log.info("bId: {}", bId);

        boardService.remove(bId);

        return "redirect:/board/list";
    }
}
