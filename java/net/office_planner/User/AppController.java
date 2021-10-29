package net.office_planner.User;

import java.util.Arrays;
import java.util.List;

import net.office_planner.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@Autowired
	private UserService service;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		List<String> listDepartment = Arrays.asList("Finance", "ICT", "Human Resource", "Accounting and Finance","Purchasing","Marketing");
		model.addAttribute("listDepartment", listDepartment);
		
		return "User/signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		service.registerDefaultUser(user);
		
		return "User/users_page";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		
		return "User/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = service.get(id);
		List<Role> listRoles = service.listRoles();
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);

		List<String> listDepartment = Arrays.asList("Finance", "ICT", "Human Resource", "Accounting and Finance","Purchasing","Marketing");
		model.addAttribute("listDepartment", listDepartment);

		return "User/user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user) {
		service.save(user);
		
		return "redirect:/users";
	}

	@RequestMapping("/delete_user/{id}") //DELETE USER
	public String deleteUser(@PathVariable(name = "id") Long id) {
		userRepository.deleteById(id);
		return "User/users_page";
	}

	@GetMapping("/organizational_officer")
	public String viewOfficersPage(Model model) {

		return "User/users_page";
	}
	@GetMapping("/admin1")
	public String viewAdmin1Page(Model model) {

		return "User/admin1";
	}
	@GetMapping("/admin")
	public String viewAdminPage(Model model) {

		return "Admin/admin";
	}
}
