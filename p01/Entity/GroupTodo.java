package org.zerock.p01.Entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tbl_groupTodo")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Column(length = 50, nullable = false)
    private String writer;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(name="regDate", updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate regDate;

    @Column(length = 10, nullable = false)
    private boolean isFinished;

    @Column(length = 50, nullable = false)
    private String groupName;

}
