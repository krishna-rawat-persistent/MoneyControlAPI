package com.psl.MoneyControlAPI.controller;

import com.psl.MoneyControlAPI.model.StockFilter;
import com.psl.MoneyControlAPI.service.StockFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/stocks")
    public List<StockFilter> getStocks(){
        return service.getStocks();
    }
}
