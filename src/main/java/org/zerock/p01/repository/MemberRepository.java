package org.zerock.p01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.p01.Entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
