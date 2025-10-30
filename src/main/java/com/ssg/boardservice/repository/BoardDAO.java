package com.ssg.boardservice.repository;

import com.ssg.boardservice.domain.BoardVO;

import java.util.List;

public interface BoardDAO {

    void insert(BoardVO boardVO);
    List<BoardVO> selectAll();
    BoardVO selectOne(Long bId);
    void update(BoardVO boardVO);
    void delete(Long bId);
}
