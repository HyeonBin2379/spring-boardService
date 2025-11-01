package com.ssg.boardservice.dto;

import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    // 페이지네이션
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    private int size = 10;

    private String link;

    // 검색 조건
    private String[] types; // 완료여부 필터링
    private String keyword; // 제목, 내용, 작성자 검색용 키워드

    private LocalDate from; // 특정 기간 검색
    private LocalDate to;

    public int getSkip() {
        return (page-1)*10;
    }

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("page=%d&size=%d", page, size));

        return builder.toString();
    }
}
