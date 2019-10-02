package onlineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import onlineShop.model.Cart;
import onlineShop.model.Customer;
import onlineShop.model.SalesOrder;
import onlineShop.service.CartService;
import onlineShop.service.SalesOrderService;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private SalesOrderService customerOrderService;

	@RequestMapping(value = "/order/{cartId}", method = RequestMethod.GET)
	public String createOrder(@PathVariable("cartId") int cartId) {

		SalesOrder salesOrder = new SalesOrder();
		Cart cart = cartService.getCartById(cartId);
		salesOrder.setCart(cart);

		Customer customer = cart.getCustomer();
		salesOrder.setCustomer(customer);
		salesOrder.setShippingAddress(customer.getShippingAddress());
		salesOrder.setBillingAddress(customer.getBillingAddress());
		customerOrderService.addSalesOrder(salesOrder);
		return "redirect:/checkout?cartId=" + cartId;
	}
}

