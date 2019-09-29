package onlineShop.dao;

import onlineShop.model.Customer;

public interface CustomerDao {
	void addCustomer(Customer customer);

    Customer getCustomerByUserName(String userName);

}
