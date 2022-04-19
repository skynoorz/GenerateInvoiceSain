package com.tigo.bo.GenerateInvoiceSain.endpoints;

import bo.com.tigo.gen.GetCountryRequest;
import bo.com.tigo.gen.GetCountryResponse;
import com.tigo.bo.GenerateInvoiceSain.repositories.CountryRepository;
import com.tigo.bo.GenerateInvoiceSain.socket.Cliente;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://tigo.com.bo/gen";

    @Value("${as400.puerto}")
    private int puerto; //Puerto para la conexión a as400

    @Value("${as400.host}")
    private String host; //Host para la conexión a as400

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        /** Cliente usando sockets **/
//        Cliente cli = new Cliente(puerto, host); //Se crea el cliente
//
//        System.out.println("Iniciando cliente\n");
//        cli.startClient(); //Se inicia el cliente
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
