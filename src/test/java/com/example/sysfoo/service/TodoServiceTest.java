package com.example.sysfoo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.sysfoo.model.Todo;
import com.example.sysfoo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void saveTodoTest() {
        MockitoAnnotations.openMocks(this);
        Todo todo = new Todo("Test Todo");
        when(todoRepository.save(todo)).thenReturn(todo);

        Todo savedTodo = todoService.save(todo);
        assertEquals("Test Todo", savedTodo.getText());
    }
}
