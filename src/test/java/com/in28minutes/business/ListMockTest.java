package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import java.util.ArrayList;

import org.junit.Test;

public class ListMockTest {

	@SuppressWarnings("rawtypes")
	@Test
	public void mockArrayListSizeMethodTest() {
		ArrayList arrayListMock = mock(ArrayList.class);
		when(arrayListMock.size()).thenReturn(2);
		assertEquals(2, arrayListMock.size());	
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void mockArrayListSizeMethodTestReturnMultipleValue() {
		ArrayList mockArrayList = mock(ArrayList.class);
		when(mockArrayList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, mockArrayList.size());
		assertEquals(3, mockArrayList.size());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void mockArrayListGetMethod() {
		ArrayList arrayListGetMock = mock(ArrayList.class);
		when(arrayListGetMock.get(0)).thenReturn("Anshul");
		assertEquals("Anshul", arrayListGetMock.get(0));
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void mockArrayListGetMethodWithNull() {
		ArrayList arrayListGetMock = mock(ArrayList.class);
		when(arrayListGetMock.get(0)).thenReturn("Ankit");
		assertEquals("Ankit", arrayListGetMock.get(0));
		assertEquals(null, arrayListGetMock.get(1));
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void mockArrayListGetMethodWithArgsMatchers() {
		ArrayList arrayListGetMock = mock(ArrayList.class);
		when(arrayListGetMock.get(anyInt())).thenReturn("Ankit");
		assertEquals("Ankit", arrayListGetMock.get(0));
		assertEquals("Ankit", arrayListGetMock.get(1));
		assertEquals("Ankit", arrayListGetMock.get(2));
	}
	
	@SuppressWarnings("rawtypes")
	@Test(expected = RuntimeException.class)
	public void mockArrayListGetMethodWithArgsMatchersThrowingException() {
		ArrayList arrayListGetMock = mock(ArrayList.class);
		when(arrayListGetMock.get(anyInt())).thenThrow(new RuntimeException("Somehing Wrong"));
		arrayListGetMock.get(0);
	}

}


