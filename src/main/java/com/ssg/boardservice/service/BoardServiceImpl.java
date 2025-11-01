package com.ssg.boardservice.service;

import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.dto.PageRequestDTO;
import com.ssg.boardservice.dto.PageResponseDTO;
import com.ssg.boardservice.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;
    private final ModelMapper modelMapper;

    @Override
    public void register(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardDAO.insert(boardVO);
    }

    @Override
    public PageResponseDTO<BoardDTO> getAll(PageRequestDTO pageRequestDTO) {
        List<BoardVO> voList = boardDAO.selectAll(pageRequestDTO);
        List<BoardDTO> dtoList = voList.stream()
                .map(boardVO -> modelMapper.map(boardVO, BoardDTO.class))
                .sorted(Comparator.comparing(BoardDTO::getBId).reversed())
                .collect(Collectors.toList());
        int total = boardDAO.getCount(pageRequestDTO);

        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
    }

    @Override
    public BoardDTO getOne(Long bId) {
        BoardVO boardVO = boardDAO.selectOne(bId);
        return modelMapper.map(boardVO, BoardDTO.class);
    }

    @Override
    public void edit(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardDAO.update(boardVO);
    }

    @Override
    public void remove(Long bId) {
        boardDAO.delete(bId);
    }
}
