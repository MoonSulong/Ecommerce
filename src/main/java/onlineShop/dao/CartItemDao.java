package onlineShop.dao;

import onlineShop.model.Cart;
import onlineShop.model.CartItem;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);
    
    void removeCartItem(int CartItemId);
    
    void removeAllCartItems(Cart cart);
}

