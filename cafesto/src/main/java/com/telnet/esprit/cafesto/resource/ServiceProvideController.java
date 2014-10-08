package com.telnet.esprit.cafesto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telnet.esprit.cafesto.entity.Establishment;
import com.telnet.esprit.cafesto.entity.User;
import com.telnet.esprit.cafesto.service.IserviceServiceProvider;

@Controller
@RequestMapping("/service/SP")
public class ServiceProvideController {
	
	@Autowired
	IserviceServiceProvider iServiceProvider;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}", headers = "Accept=application/json")
	public @ResponseBody
	List<Establishment> getByid(@PathVariable int id) {

		return iServiceProvider.establisementServiceProvide(id);
	}
}
