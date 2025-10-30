package com.ssg.boardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long bId;
    private String title;
    private String writer;
    private String text;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String password;
    private Long hits;
    private byte[] file;
    private String userId;
}
