package org.zerock.p01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TodoDTO {
    private Long lno;
    private String title;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dueDate;
    private String writer;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate regDate;
    private boolean isFinished;
    private String groupName;
}
