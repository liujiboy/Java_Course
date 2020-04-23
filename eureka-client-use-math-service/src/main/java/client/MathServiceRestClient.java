package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MathServiceRestClient {
	
	@Autowired
	private RestTemplate rest;
	
	public double add(double a,double b)
	{
		return rest.getForObject("http://math-service/add/{a}/{b}", Double.class, a,b);
	}
}
