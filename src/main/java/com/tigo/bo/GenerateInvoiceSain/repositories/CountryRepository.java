package com.tigo.bo.GenerateInvoiceSain.repositories;

import bo.com.tigo.gen.Country;
import bo.com.tigo.gen.Currency;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
        Country country = new Country();
        country.setName("BOLIVIA");
        country.setCurrency(Currency.EUR);
        country.setPopulation(1);
        country.setCapital("BOL");

        countries.put("BOL", country);
//        countries.put("JPN",new Country("VENEZUELA", 2, "CAP2", "EUR"));
//        countries.put("ARG",new Country("ARGENTINA", 3, "CAP3", "PLN"));
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
