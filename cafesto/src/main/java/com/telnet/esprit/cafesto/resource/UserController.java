package com.telnet.esprit.cafesto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telnet.esprit.cafesto.entity.Administrator;
import com.telnet.esprit.cafesto.entity.Client;
import com.telnet.esprit.cafesto.entity.SuperAdministrator;
import com.telnet.esprit.cafesto.entity.User;
import com.telnet.esprit.cafesto.service.Iservice;
import com.telnet.esprit.cafesto.service.UserServiceImpl;

@Controller
@RequestMapping("/service")
public class UserController {

	@Autowired
	Iservice<User> iservice;

	@RequestMapping(method = RequestMethod.GET, value = "/{type}", headers = "Accept=application/json")
	public @ResponseBody
	List<User> getAllClient(@PathVariable String type) {

		return iservice.findBytype(type);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{type}/{id}", headers = "Accept=application/json")
	public @ResponseBody
	User getByid(@PathVariable int id) {
		System.out.println(iservice.findByid(id).getFirstName());
		return iservice.findByid(id);
	}
	@RequestMapping(value = "/SuperAdministrator/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public @ResponseBody
	User updateSuperAdmin(@RequestBody SuperAdministrator superAdmin,@PathVariable int id) {
		superAdmin.setId(id);
		iservice.update(superAdmin);
		return superAdmin;
	}

	@RequestMapping(value = "/Administrator", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	User createAdmin(@RequestBody Administrator admin) {
		admin.setSuperAdmin((SuperAdministrator) iservice.findByid(1));
		System.out.println(admin.getSuperAdmin().getFirstName());
		iservice.create(admin);
		return admin;
	}

	@RequestMapping(value = "/Administrator/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public @ResponseBody
	User updateAdmin(@RequestBody Administrator admin,@PathVariable int id) {
		admin.setId(id);
		iservice.update(admin);
		return admin;
	}

	@RequestMapping(value = "/Administrator/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public @ResponseBody
	User DeleteAdmin(@PathVariable int id) {
		Administrator admin =(Administrator) iservice.findByid(id);
		iservice.remove(admin);
		return admin;
	}

	@RequestMapping(value = "/Client", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	User createClient(@RequestBody Client client) {

		iservice.create(client);
		return client;
	}

	@RequestMapping(value = "/Client/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public @ResponseBody
	User updateClient(@RequestBody Client client, @PathVariable int id) {
		client.setId(id);

		iservice.update(client);
		return client;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	User authentification(@RequestBody String email, @RequestBody String password) {
		return iservice.Authentication(email, password);
	}
	
	@RequestMapping(value = "/findbymail", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	User find(@RequestBody String email) {
		return iservice.findbyMail(email);
	}
	
	
}
