package com.ssg.boardservice.repository;

import com.ssg.boardservice.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

    private final BoardMapper boardMapper;
}
