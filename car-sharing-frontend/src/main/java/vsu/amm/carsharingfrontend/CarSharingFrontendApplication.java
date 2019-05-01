package vsu.amm.carsharingfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarSharingFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarSharingFrontendApplication.class, args);
        final String uri = "http://localhost:8080/restapi/firms";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);
    }

}
