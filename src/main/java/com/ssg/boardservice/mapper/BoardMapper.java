package com.ssg.boardservice.mapper;

import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {

    void insert(BoardVO boardVO);
    List<BoardVO> selectAll();
//    BoardDTO selectOne();
//    void delete(Long bId);
//    void update(BoardVO boardVO);
}
