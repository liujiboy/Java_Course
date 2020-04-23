package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("math-service")
public interface MathServiceFeignClient {
	@GetMapping("/add/{a}/{b}")
	public double add(@PathVariable double a,@PathVariable double b);
}
