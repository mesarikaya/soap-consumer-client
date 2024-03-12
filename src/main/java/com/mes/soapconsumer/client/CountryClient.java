package com.mes.soapconsumer.client;

import com.mes.consumingwebservice.wsdl.GetCountryRequest;
import com.mes.consumingwebservice.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CountryClient extends WebServiceGatewaySupport {
    public static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String country){
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requested country: {}", country);

        GetCountryResponse countryResponse = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws",
                request,
                new SoapActionCallback("http://local/gs-producing-web-service/GetCountryRequest"));

        return countryResponse;
    }
}
