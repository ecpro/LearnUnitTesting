import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import com.piyush.mockito.scrapbook.A;
import com.piyush.mockito.scrapbook.B;

public class ATest {
	
	@Mock
	private B b;
	
	private A a;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void useVoidMethodShouldStubOutVoidMethod() throws Exception {
		doNothing().when(b).voidMethod(); // doNothing()  is explicit stubbing which is usually not required here
		a = new A(b);
		int val = a.usesVoidMethod();
		verify(b).voidMethod();;
	}
	
	@Test(expected=RuntimeException.class)
	public void doNothingExmpleToShowItsUsesInConsecutiveCalls() throws Exception {
		doThrow(RuntimeException.class).doNothing().when(b).voidMethod();
		
		/**
		 * Here on first call of a.useVoidMethod() runtime exception is thrown and second call it will excecute normally 
		 * This is because of stub chaining as done above.
		 */
		
		a.usesVoidMethod();
		verify(b).voidMethod();
		a.usesVoidMethod();
		verify(b).voidMethod();
		
		
	}

}
