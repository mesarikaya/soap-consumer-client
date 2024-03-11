package com.mes.soapconsumer.controller;

import com.mes.consumingwebservice.wsdl.Country;
import com.mes.consumingwebservice.wsdl.GetCountryResponse;
import com.mes.soapconsumer.client.CountryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CountryController {

    private final CountryClient countryClient;

    public CountryController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @PostMapping("/countries")
    public ResponseEntity<Integer> getCountryPopulation(@RequestBody String country){

        GetCountryResponse response = countryClient.getCountry(country);

        return ResponseEntity.ok()
                .body(response.getCountry().getPopulation());
    }
}
