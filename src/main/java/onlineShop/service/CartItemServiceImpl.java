package onlineShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop.dao.CartItemDao;
import onlineShop.model.Cart;
import onlineShop.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
   	 cartItemDao.addCartItem(cartItem);

    }

    public void removeCartItem(int CartItemId) {
   	 cartItemDao.removeCartItem(CartItemId);
    }

    public void removeAllCartItems(Cart cart) {
   	 cartItemDao.removeAllCartItems(cart);
    }
}

