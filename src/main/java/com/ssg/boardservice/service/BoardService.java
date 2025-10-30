package com.ssg.boardservice.service;

import com.ssg.boardservice.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    void register(BoardDTO boardDTO);
    List<BoardDTO> getAll();
}
