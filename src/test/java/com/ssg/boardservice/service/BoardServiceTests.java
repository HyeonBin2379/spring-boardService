package com.ssg.boardservice.service;

import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    void testGetAll() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<BoardDTO> boardDTOList = boardService.getAll(pageRequestDTO);
        boardDTOList.forEach(log::info);
    }
}