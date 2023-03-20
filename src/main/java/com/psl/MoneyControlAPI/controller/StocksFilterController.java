package com.psl.MoneyControlAPI.controller;

import com.psl.MoneyControlAPI.model.StockFilter;
import com.psl.MoneyControlAPI.service.StockFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin()
public class StocksFilterController {

    @Autowired
    StockFilterService service;

    @GetMapping("/")
    public String welcomeMsg(){
        return "Welcome to Money Control API";
    }

    @GetMapping("/stocks/{url}/{duration}")
    public List<StockFilter> getStocks(@PathVariable("url") String url, @PathVariable("duration") String duration){
        return service.getStocks(url,duration);
    }
}
