import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.order.BO.OrderBOImpl;
import com.order.BO.exception.BOException;
import com.order.DAO.OrderDAO;
import com.order.dto.Order;


//@SuppressWarnings("deprecation")
//@RunWith(MockitoJUnit44Runner.class)
public class OrderBOTest {
	
	@Mock
	private OrderDAO dao;
	
	//@InjectMocks (inject mock is deprecated)
	private OrderBOImpl orderBO;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		orderBO = new OrderBOImpl();
		orderBO.setDao(dao);
	}

	@Test
	public void placeOrderShouldCreateOrder() throws SQLException, BOException {
		
		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		assertTrue(orderBO.placeOrder(order));
		verify(dao).create(order);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=BOException.class)
	public void placeOrderShouldThrowException() throws SQLException, BOException {
		
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		
		orderBO.placeOrder(order);
	
	}
	
	@Test
	public void cancelOrderShouldReturnTrue() throws SQLException, BOException {
		
		int orderId = 4;
		Order order = new Order();
		when(dao.read(orderId)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		assertTrue(orderBO.cancelOrder(4));
		verify(dao).read(4);
		verify(dao).update(order);
	}
	
	/**
	 * verify(T mock, VerificationMode T) example
	 * @throws SQLException
	 * @throws BOException
	 */
	@Test
	public void cancelOrderShouldNotCancelOrder() throws SQLException, BOException {
		
		int orderId = 4;
		Order order = new Order();
		when(dao.read(orderId)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		assertFalse(orderBO.cancelOrder(4));
		verify(dao,times(4)).read(4);
		verify(dao).update(order);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected=BOException.class)
	public void cancelOrderShouldThrowException() throws SQLException, BOException {
		int orderId = 4;
		when(dao.read(orderId)).thenThrow(SQLException.class);
		orderBO.cancelOrder(4);
		
	}
	
	@Test 
	public void mockitoMatchersAndVerificationModeExample() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(1); // any Matchers example
		assertTrue(orderBO.placeOrder(order)); 
		verify(dao, times(1)).create(order); // verification Mode example
	}

}
