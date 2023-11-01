package org.zerock.p01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.p01.Entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query(value = "alter table tbl_todolist auto_increment = 1", nativeQuery = true)
    String alter();
    @Query(value = "set @COUNT=0",nativeQuery = true)
    String set();
    @Query(value = "update tbl_todolist set bno=@count::=@count+1",nativeQuery = true)
    String updat();
}
