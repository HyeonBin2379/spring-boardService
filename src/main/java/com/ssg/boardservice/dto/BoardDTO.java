package com.ssg.boardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    
    private Long bId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String writer;

    @NotEmpty
    private String content;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @NotEmpty
    private String password;

    private Long hits;
    private byte[] file;
    private String userId;
}
