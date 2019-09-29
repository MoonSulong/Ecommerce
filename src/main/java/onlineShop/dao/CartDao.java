package onlineShop.dao;

import java.io.IOException;
import onlineShop.model.Cart;

public interface CartDao {
	Cart getCartById(int cartId);

	Cart validate(int cartId) throws IOException;
}
