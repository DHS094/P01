package org.zerock.p01.service;

import org.zerock.p01.Entity.Todo;
import org.zerock.p01.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    // todoInsert
    Long todoInsert(TodoDTO todoDTO);
    // todoReadOne
    TodoDTO todoReadOne(Long lno);
    // todoReadAll
//    List<Todo> todoReadAll(); // List<Todo>, model mapper 제외하고 코드 작성해보기!
    List<TodoDTO> todoReadAll();
    // todoModify
    void todoModify(TodoDTO todoDTO);
    // todoDelete
    void todoDelete(Long lno);
}
