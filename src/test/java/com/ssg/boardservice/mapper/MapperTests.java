package com.ssg.boardservice.mapper;

import com.ssg.boardservice.domain.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTests {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    public void testSelectAll() {
        List<BoardVO> boardList = boardMapper.selectAll();
        boardList.forEach(log::info);
    }

    @Test
    public void testInsert() {
        BoardVO boardVO = BoardVO.builder()
                .title("게시글 등록 테스트")
                .content("게시글 테스트 본문입니다.")
                .writer("tester")
                .password("password1234")
                .build();
        boardMapper.insert(boardVO);
    }

    @Test
    public void testSelectOne() {
        Long bId = 1L;
        BoardVO boardVO = boardMapper.selectOne(1L);
        log.info(boardVO);
    }

    @Test
    public void testUpdate() {
        Long bId = (long) boardMapper.selectAll().size();
        BoardVO boardVO = BoardVO.builder()
                .bId(bId)
                .title("게시글 수정 테스트")
                .content("수정된 게시글 테스트 본문입니다.")
                .writer("tester")
                .password("password1234")
                .userId("user" + bId)
                .build();
        boardMapper.update(boardVO);
    }

    @Test
    public void testDelete() {
        Long bId = (long) boardMapper.selectAll().size();
        boardMapper.delete(bId);
    }
}
