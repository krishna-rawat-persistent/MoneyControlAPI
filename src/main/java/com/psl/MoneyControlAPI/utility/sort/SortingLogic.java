package com.psl.MoneyControlAPI.utility.sort;

import com.psl.MoneyControlAPI.model.StockFilter;

import java.util.Collections;
import java.util.List;

public class SortingLogic {

    public static List<StockFilter> sortedList(List<StockFilter> stocks, String duration){
        switch (duration){
            case "oneWeek":
                Collections.sort(stocks,new Sortby1Week());
                break;

            case "oneMonth":
                Collections.sort(stocks,new Sortby1Month());
                break;

            case "threeMonth":
                Collections.sort(stocks,new Sortby3Months());
                break;

            case "sixMonth":
                Collections.sort(stocks,new Sortby6Months());
                break;

            case "oneYear":
                Collections.sort(stocks,new Sortby1Year());
                break;

            case "twoYear":
                Collections.sort(stocks,new Sortby2Years());
                break;

            case "threeYear":
                Collections.sort(stocks,new Sortby3Years());
                break;

            case "fiveYear":
                Collections.sort(stocks,new Sortby5Years());
                break;

            default:
                Collections.sort(stocks,new Sortby10Years());
        }
        return stocks;
    }
}
