package com.ssg.boardservice.mapper;

import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.dto.BoardDTO;

import com.ssg.boardservice.dto.PageRequestDTO;
import java.util.List;

public interface BoardMapper {

    void insert(BoardVO boardVO);
    List<BoardVO> selectAll(PageRequestDTO pageRequestDTO);
    BoardVO selectOne(Long bId);
    void update(BoardVO boardVO);
    void delete(Long bId);
    int getCount(PageRequestDTO pageRequestDTO);
}
