package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Comparator;

public class Sortby1Month implements Comparator<StockFilter> {
    @Override
    public int compare(StockFilter o1, StockFilter o2) {
        return ComparisonLogic.logic(o1.getOneMonth(),o2.getOneMonth());
    }
}
