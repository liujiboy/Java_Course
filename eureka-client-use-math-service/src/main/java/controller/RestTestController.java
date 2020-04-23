package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import client.MathServiceRestClient;

@RestController
public class RestTestController {
	@Autowired
	private MathServiceRestClient client;
	@GetMapping("/add/10/20")
	public double add()
	{
		return client.add(10, 20);
	}
}
