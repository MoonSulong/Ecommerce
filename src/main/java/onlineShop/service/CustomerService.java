package onlineShop.service;

import onlineShop.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);

	Customer getCustomerByUserName(String userName);
}
