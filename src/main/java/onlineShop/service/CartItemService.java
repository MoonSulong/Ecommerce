package onlineShop.service;

import onlineShop.model.Cart;
import onlineShop.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void removeCartItem(int CartItemId);

    void removeAllCartItems(Cart cart);
}

