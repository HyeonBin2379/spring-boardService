package com.ssg.boardservice.dto;

import java.util.List;
import javax.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;   // 현재 페이지 번호
    private int size;   // 1페이지당 데이터 개수
    private int total;  // 전체 데이터 개수

    @Min(value = 1)
    private int start;  // 페이지 시작번호
    private int end;    // 페이지 끝번호

    private boolean prev;
    private boolean next;
    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,
                           List<E> dtoList,
                           int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        // 페이지 번호리스트 끝 번호, 시작번호 구하기
        this.end = (int)Math.ceil(this.page/10.0) * 10;
        this.start = this.end-9;

        // 전체 페이지의 마지막 번호
        int last = (int)Math.ceil((double)this.total/this.size);
        this.end = Math.min(this.end, last);

        this.prev = this.start > 1;
        this.next = (this.end * this.size) < total;
    }
}
