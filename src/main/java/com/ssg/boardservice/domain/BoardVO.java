package com.ssg.boardservice.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {

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
