package com.order.DAO;

import java.sql.SQLException;

import com.order.dto.Order;

public interface OrderDAO {

	int create(Order order) throws SQLException;
	
	Order read(int id) throws SQLException;
	
	int update(Order order) throws SQLException;
	
	int delete(int orderId) throws SQLException;
	
}
