package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.data.api.TodoService;

// To Run Junit with Mockito
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockInjectMocksTest {
	
	// Mock Creation
	@Mock
	TodoService mockTodoService;
	
	// Class Object/Instance Creation
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		List<String> asList = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance" ,"Spring AOP");
		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(asList);
		List<String> filterTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(3, filterTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock_Empty() {
		List<String> asList = Arrays.asList();
		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(asList);
		List<String> filterTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filterTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock_BDD() {
		//Given
		List<String> asList = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance" ,"Spring AOP");
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(asList);
		
		//When
		List<String> filterTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		//Then
		assertThat(filterTodos.size(),is(3));
	}
	
	@Test
	public void testTodosNotRelatedToSpring_usingAMock_BDD() {
		//Given
		List<String> asList = Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance" ,"Spring AOP");
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(asList);
		
		//When
		todoBusinessImpl.deleteNotRelatedToSpring("Dummy");
		
		//Then-1
		verify(mockTodoService).deleteTodo("Learn to Dance");
		//Then-2
		verify(mockTodoService,times(1)).deleteTodo("Learn to Dance");
		//Then-3
		verify(mockTodoService,atLeast(1)).deleteTodo("Learn to Dance");
		//Then-4
		verify(mockTodoService,never()).deleteTodo("Learn Spring MVC");
	}
}
