package com.ssg.boardservice.repository;

import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.dto.PageRequestDTO;
import com.ssg.boardservice.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

    private final BoardMapper boardMapper;

    @Override
    public void insert(BoardVO boardVO) {
        boardMapper.insert(boardVO);
    }

    @Override
    public List<BoardVO> selectAll(PageRequestDTO pageRequestDTO) {
        return boardMapper.selectAll(pageRequestDTO);
    }

    @Override
    public BoardVO selectOne(Long bId) {
        return boardMapper.selectOne(bId);
    }

    @Override
    public void update(BoardVO boardVO) {
        boardMapper.update(boardVO);
    }

    @Override
    public void delete(Long bId) {
        boardMapper.delete(bId);
    }

    @Override
    public int getCount(PageRequestDTO pageRequestDTO) {
        return boardMapper.getCount(pageRequestDTO);
    }
}
