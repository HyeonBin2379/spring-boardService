package com.ssg.boardservice.repository;

import com.ssg.boardservice.domain.BoardVO;

import java.util.List;

public interface BoardDAO {

    void insert(BoardVO boardVO);
    List<BoardVO> selectAll();
//    BoardDTO selectOne();
//    void delete(Long bId);
//    void update(BoardVO boardVO);
}
