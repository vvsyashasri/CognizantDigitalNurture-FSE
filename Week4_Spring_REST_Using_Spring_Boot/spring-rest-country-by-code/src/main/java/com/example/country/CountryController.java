package com.example.country;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static Map<String, Country> countryMap = new HashMap<>();
    static {
        countryMap.put("IN", new Country("IN", "India"));
        countryMap.put("US", new Country("US", "United States"));
        countryMap.put("JP", new Country("JP", "Japan"));
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryMap.getOrDefault(code.toUpperCase(), new Country("N/A", "Country Not Found"));
    }
}