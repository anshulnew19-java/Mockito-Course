package com.in28minutes.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

	@Test
	public void test() {
		// By Mocking - It creates dummy ArrayList
		List arrayListMock = mock(ArrayList.class);
		assertEquals(0, arrayListMock.size());
		arrayListMock.add("Dummy");
		stub(arrayListMock.size()).toReturn(5);
		assertEquals(5, arrayListMock.size());
		
		// By Spying - It creates real ArrayList
		List arrayListSpy = spy(ArrayList.class);
		assertEquals(0, arrayListSpy.size());
		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
		arrayListSpy.remove("Dummy");
		assertEquals(0, arrayListSpy.size());
		
		arrayListSpy.add("Pummy");
		verify(arrayListSpy).add("Pummy");
		verify(arrayListSpy, never()).clear();
	}

}
