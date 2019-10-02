package onlineShop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import onlineShop.model.Product;
import onlineShop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public ModelAndView getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return new ModelAndView("productList", "products", products);
	}

	@RequestMapping(value = "/getProductById/{productId}", method = RequestMethod.GET)
	public ModelAndView getProductById(@PathVariable(value = "productId") int productId) {
		Product product = productService.getProductById(productId);
		return new ModelAndView("productPage", "product", product);
	}

	@RequestMapping(value = "/admin/delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(value = "productId") int productId) {
		// for MAC : Path path = Paths.get("/Users/xxx/products/" + productId + ".jpg");
		// for Linux
		//Path path = Paths.get("/home/ubuntu/products/" + productId + ".jpg");
		// For windows
		Path path = Paths.get("C:\\Users\\Sulong\\Documents\\Intern\\project_laioffer\\products\\" + productId + ".jpg");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		productService.deleteProduct(productId);
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
	public ModelAndView getProductForm() {
		return new ModelAndView("addProduct", "productForm", new Product());
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute(value = "productForm") Product product, BindingResult result) {

		if (result.hasErrors()) {
			return "addProduct";
		}
		productService.addProduct(product);
		MultipartFile image = product.getProductImage();
		if (image != null && !image.isEmpty()) {
			// Path path = Paths.get("/Users/xxx/products/" + product.getId() + ".jpg");
			// for Linux
			//Path path = Paths.get("/home/ubuntu/products/" + product.getId() + ".jpg");
			Path path = Paths.get("C:\\Users\\Sulong\\Documents\\Intern\\project_laioffer\\products\\" + product.getId() + ".jpg");

			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/editProduct/{productId}")
	public ModelAndView getEditForm(@PathVariable(value = "productId") int productId) {
		Product product = productService.getProductById(productId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editProduct");
		modelAndView.addObject("editProductObj", product);
		modelAndView.addObject("productId", productId);

		return modelAndView;
	}

	@RequestMapping(value = "/admin/product/editProduct/{productId}", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product,
			@PathVariable(value = "productId") int productId) {
		product.setId(productId);
		productService.updateProduct(product);
		return "redirect:/getAllProducts";
	}

	@RequestMapping("/getProductsList")
	public @ResponseBody List<Product> getProductsListJson() {
		return productService.getAllProducts();
	}
}
