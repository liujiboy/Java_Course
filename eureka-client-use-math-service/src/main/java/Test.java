

import org.springframework.web.client.RestTemplate;

public class Test {

	public static void main(String[] args) {
		RestTemplate rest=new RestTemplate();
		Double r=rest.getForObject("http://localhost:8888/add/{a}/{b}", Double.class, 1,2);
		System.out.println(r);
	}

}
