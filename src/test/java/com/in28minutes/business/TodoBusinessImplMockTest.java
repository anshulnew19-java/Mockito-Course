package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		TodoService mockTodoService = mock(TodoService.class);
		List<String> asList = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance" ,"Spring AOP");
		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(asList);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService); 
		List<String> filterTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		System.out.println("Filter TO DO : " + filterTodos);
		assertEquals(3, filterTodos.size());
	}

}