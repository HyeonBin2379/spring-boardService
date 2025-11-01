package com.ssg.boardservice.service;

import com.ssg.boardservice.dto.BoardDTO;

import com.ssg.boardservice.dto.PageRequestDTO;
import com.ssg.boardservice.dto.PageResponseDTO;
import java.util.List;

public interface BoardService {

    void register(BoardDTO boardDTO);
    PageResponseDTO<BoardDTO> getAll(PageRequestDTO pageRequestDTO);
    BoardDTO getOne(Long bId);
    void edit(BoardDTO boardDTO);
    void remove(Long bId);
}
