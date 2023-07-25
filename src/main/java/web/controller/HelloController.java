package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserServiceImp;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class HelloController {
	private UserServiceImp userServiceImp;
	@Autowired
	public HelloController(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	@GetMapping()
	public String listUsers(Model model) {
		model.addAttribute("users", userServiceImp.findAll());
		return "users";
	}
	@GetMapping("/new")
	public String newUser(@ModelAttribute("user") User user){
		return "/new";
	}
	@PostMapping()
	public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/new";
		userServiceImp.save(user);
		return "redirect:/user";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable("id") long id){
		userServiceImp.delete(id);
		return "redirect:/user";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") long id){
		model.addAttribute("user", userServiceImp.find(id));
		return "/edit";
	}
	@PostMapping("/{id}")
	public String update(@ModelAttribute("user") @Valid User user, @PathVariable("id") long id, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return "/edit";
		userServiceImp.edit(id, user);
		return "redirect:/user";
	}
}