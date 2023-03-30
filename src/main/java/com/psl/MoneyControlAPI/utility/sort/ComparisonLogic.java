package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

public class ComparisonLogic {

    public static int logic(Double n1, Double n2){
        Double val1 = n1 == 0? -Double.MAX_VALUE : n1;
        Double val2 = n2 == 0? -Double.MAX_VALUE : n2;
        if (val1 < val2) return 1;
        if (val1 > val2) return -1;
        return 0;
    }
}
