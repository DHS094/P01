package org.zerock.p01.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="tbl_mem")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Member {
    @Id
    @Column (name="member_id", length=50, nullable=false)
    private String memberId;

    @Column (length=50, nullable=false)
    private String memberPw;

    @Column (length=50, nullable=false)
    private String memberName;

    @Column (length=50, nullable = false)
    private String affiliation;

//    @Column (length = 50)
//    private String uuid; // 기본 기능 구현하고 나서 설정

//    public void register(){
//        Member member = Member.builder()
//                .memberId("userID...")
//                .memberPw("password...")
//                .memberName("Name...")
//                .affiliation("aff...")
//                .build();
//    }

}

