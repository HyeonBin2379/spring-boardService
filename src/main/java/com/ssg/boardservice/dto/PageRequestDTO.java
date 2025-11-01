package com.ssg.boardservice.dto;

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

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    private int size = 10;

    private String link;

    public int getSkip() {
        return (page-1)*10;
    }

    public String getLink() {
        return "";
    }
}
