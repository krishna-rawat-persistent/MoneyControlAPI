package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Comparator;

public class Sortby2Years implements Comparator<StockFilter> {
    @Override
    public int compare(StockFilter o1, StockFilter o2) {
        if (o1.getTwoYear() < o2.getTwoYear() || (o1.getTwoYear() == 0)) return 1;
        if (o1.getTwoYear() > o2.getTwoYear()) return -1;
        return 0;
    }
}
