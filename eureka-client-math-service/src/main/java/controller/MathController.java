package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	@GetMapping(value="/add/{a}/{b}")
	public double add(@PathVariable double a,@PathVariable double b)
	{
		return a+b;
	}
}
