package com.mes.soapconsumer;

import com.mes.consumingwebservice.wsdl.GetCountryResponse;
import com.mes.soapconsumer.client.CountryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumerApplication.class, args);
	}

	/*@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String country = "The Netherlands";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = countryClient.getCountry(country);
			System.err.println(response.getCountry().getPopulation());
		};
	}*/

}
