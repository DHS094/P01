package org.zerock.p01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.p01.Entity.Group;


public interface GroupRepository extends JpaRepository<Group, String> {
}
