package onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

	@GetMapping("/index")
	public String sayIndex() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
	@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and Password");
		}

		if (logout != null) {
			model.addAttribute("logout", "You have logged out successfully");
		}
		return "login";
	}

	@GetMapping("/aboutus")
	public String sayAbout() {
		return "aboutUs";
	}
}

