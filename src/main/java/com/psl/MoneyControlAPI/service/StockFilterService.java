package com.psl.MoneyControlAPI.service;

import com.psl.MoneyControlAPI.model.StockFilter;
import com.psl.MoneyControlAPI.utility.Limit.LimitRecords;
import com.psl.MoneyControlAPI.utility.conversion.StringFormatter;
import com.psl.MoneyControlAPI.utility.sort.SortingLogic;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockFilterService {
    public List<StockFilter> getStocks(String fundURL, String[] duration){
        List<StockFilter> stocks = new ArrayList<>();
        List<String> title = new ArrayList<String>();
        final String url = "https://www.moneycontrol.com/mutual-funds/performance-tracker/returns/"+fundURL+".html";
        try {
            final Document document = Jsoup.connect(url).get();
            for(Element row: document.select("table.mctable1 tr")) {

                String schemeName =  row.select("td:nth-of-type(1)").text();
                if(schemeName.equals("")) {
                    continue;
                }
                schemeName = schemeName.substring(0, schemeName.indexOf('-'));

                if(title.contains(schemeName)) {
                    continue;
                }
                title.add(schemeName);

                String auM =  row.select("td:nth-of-type(5)").text();
                auM = auM.equals("-")?"0":auM.replace(",", "");

                String col1W = row.select("td:nth-of-type(6)").text();
                String col1M = row.select("td:nth-of-type(7)").text();
                String col3M = row.select("td:nth-of-type(8)").text();
                String col6M = row.select("td:nth-of-type(9)").text();
                String col1Y = row.select("td:nth-of-type(11)").text();
                String col2Y = row.select("td:nth-of-type(12)").text();
                String col3Y = row.select("td:nth-of-type(13)").text();
                String col5Y = row.select("td:nth-of-type(14)").text();
                String col10Y = row.select("td:nth-of-type(15)").text();

                double marketValue = Double.parseDouble(auM);
                double oneWeek =  StringFormatter.convertToDouble(col1W);
                double oneMonth =  StringFormatter.convertToDouble(col1M);
                double threeMonth =  StringFormatter.convertToDouble(col3M);
                double sixMonth =  StringFormatter.convertToDouble(col6M);
                double oneYear =  StringFormatter.convertToDouble(col1Y);
                double twoYear =  StringFormatter.convertToDouble(col2Y);
                double threeYear =  StringFormatter.convertToDouble(col3Y);
                double fiveYear =  StringFormatter.convertToDouble(col5Y);
                double tenYear =  StringFormatter.convertToDouble(col10Y);

                stocks.add(StockFilter.builder().schemeName(schemeName).marketValue(marketValue).oneWeek(oneWeek).oneMonth(oneMonth).threeMonth(threeMonth).sixMonth(sixMonth).oneYear(oneYear).twoYear(twoYear).threeYear(threeYear).fiveYear(fiveYear).tenYear(tenYear).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return LimitRecords.getTopNRecords(SortingLogic.sortedList(stocks,duration),5);
    }
}
