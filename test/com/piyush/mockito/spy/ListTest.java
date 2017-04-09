package com.piyush.mockito.spy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class ListTest {
	
	// @Spy is used for partial stubbing 
	
	@Spy
	List<String> myList = new ArrayList<String>(); 

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		
		/**
		 * spy enables a partial mocking of object. If we have two method inside a object then if the object is spied on a particular method
		 * then the other method is not mocked and when called the actual method will be called.
		 */
		
		Mockito.doReturn(3).when(myList).size(); // here only size() method is spied on so other methods will behave as usual
		assertSame(3, myList.size());
		
		Mockito.doReturn("Piyush").when(myList).get(0);
		assertEquals("Piyush", myList.get(0));
		
		
	}

}
