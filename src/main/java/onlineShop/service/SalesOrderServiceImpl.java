package onlineShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop.dao.SalesOrderDao;
import onlineShop.model.SalesOrder;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	@Autowired
	private SalesOrderDao salesOrderDao;

	public void addSalesOrder(SalesOrder salesOrder) {
		salesOrderDao.addSalesOrder(salesOrder);
	}
}
