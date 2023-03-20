package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Comparator;

public class Sortby6Months implements Comparator<StockFilter> {
    @Override
    public int compare(StockFilter o1, StockFilter o2) {
        if (o1.getSixMonth() < o2.getSixMonth()) return 1;
        if (o1.getSixMonth() > o2.getSixMonth()) return -1;
        return 0;
    }
}
