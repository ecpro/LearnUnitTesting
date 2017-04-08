package com.order.BO;

import java.sql.SQLException;

import com.order.BO.exception.BOException;
import com.order.DAO.OrderDAO;
import com.order.dto.Order;
/**
 * 
 * @author eccspro

 */
public class OrderBOImpl implements OrderBO {
	
	private OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		
		int result = 0;
		try {
			result = dao.create(order);
		} catch (SQLException e) {
			throw new BOException(e);
		}
		
		return result > 0 ? true:false;
	}
	
	
	@Override
	public boolean cancelOrder(int id) throws BOException {
		int result = 0;
		try {
			 Order order = dao.read(id);
			 order.setStatus("cancel");
			 result = dao.update(order);
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return result > 0 ? true : false;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		
		int result = 0;
		try {
			result = dao.delete(id);
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return result > 0 ? true : false;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}
	
	public String newMethod(int x , boolean y) {
		return "";
	}

}
