package com.psl.MoneyControlAPI.utility.Limit;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.List;
import java.util.stream.Collectors;

public class LimitRecords {
    public static List<StockFilter> getTopNRecords(List<StockFilter> stocks, int n){
        return stocks.stream().limit(n).collect(Collectors.toList());
    }
}
