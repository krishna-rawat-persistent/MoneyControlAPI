package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Comparator;

public class Sortby5Years implements Comparator<StockFilter> {
    @Override
    public int compare(StockFilter o1, StockFilter o2) {
        if (o1.getFiveYear() < o2.getFiveYear() || (o1.getFiveYear() == 0)) return 1;
        if (o1.getFiveYear() > o2.getFiveYear()) return -1;
        return 0;
    }
}
