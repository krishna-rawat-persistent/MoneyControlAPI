package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Comparator;

public class Sortby3Months implements Comparator<StockFilter> {
    @Override
    public int compare(StockFilter o1, StockFilter o2) {
        if (o1.getThreeMonth() < o2.getThreeMonth() || (o1.getThreeMonth() == 0)) return 1;
        if (o1.getThreeMonth() > o2.getThreeMonth()) return -1;
        return 0;
    }
}
