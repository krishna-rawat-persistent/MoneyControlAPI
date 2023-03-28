package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Comparator;

public class Sortby3Years implements Comparator<StockFilter> {
    @Override
    public int compare(StockFilter o1, StockFilter o2) {
        if (o1.getThreeYear() < o2.getThreeYear() || (o1.getThreeMonth() == 0)) return 1;
        if (o1.getThreeYear() > o2.getThreeYear()) return -1;
        return 0;
    }
}
