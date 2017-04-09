package com.piyush.mockito.spy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class ListTest {
	
	// @Spy is used for partial stubbing 
	// @Mock is used for complete stubbing
	@Mock
	List<String> myList = new ArrayList<String>(); 

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		myList.add("Piyush");
		myList.add("Ravi");
	}

	@Test
	public void test() {
		
		// stub example
		Mockito.when(myList.size()).thenReturn(4);
		assertEquals(4, myList.size());
		
		// to call the acutal method and not stub example
		
		Mockito.when(myList.get(1)).thenCallRealMethod();
		assertEquals("Ravi", myList.get(1));
		
	}

}
