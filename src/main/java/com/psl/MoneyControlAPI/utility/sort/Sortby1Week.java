package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Comparator;

public class Sortby1Week implements Comparator<StockFilter> {
    @Override
    public int compare(StockFilter o1, StockFilter o2) {
        if (o1.getOneWeek() < o2.getOneWeek()) return 1;
        if (o1.getOneWeek() > o2.getOneWeek() && o1.getOneWeek() !=0) return -1;
        return 0;
    }
}
