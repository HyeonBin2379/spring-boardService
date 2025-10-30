package com.ssg.boardservice.service;

import com.ssg.boardservice.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    void register(BoardDTO boardDTO);
    List<BoardDTO> getAll();
    BoardDTO getOne(Long bId);
    void edit(BoardDTO boardDTO);
    void remove(Long bId);
}
