package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import client.MathServiceRestClient;

@RestController
public class RestTestController {
	@Autowired
	private MathServiceRestClient client;
	@GetMapping("/add")
	public double add(int a,int b)
	{
		return client.add(a,b);
	}
}
