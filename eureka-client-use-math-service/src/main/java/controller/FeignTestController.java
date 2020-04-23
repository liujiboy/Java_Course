package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import client.MathServiceFeignClient;

@RestController
public class FeignTestController {
	@Autowired
	private MathServiceFeignClient client;
	@GetMapping("/add/30/40")
	public double add()
	{
		return client.add(30, 40);
	}
	
}
