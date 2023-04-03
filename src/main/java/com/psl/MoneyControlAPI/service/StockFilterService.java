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
import java.util.Arrays;
import java.util.List;

@Service
public class StockFilterService {
    public List<StockFilter> getStocks(String fundURL, String[] duration){
        List<StockFilter> stocks = new ArrayList<>();
        List<String> title = new ArrayList<String>();
        List<String> urls = Arrays.asList(fundURL.split(","));
        for(String urlVal: urls){
            final String url = "https://www.moneycontrol.com/mutual-funds/performance-tracker/returns/"+urlVal+".html";
            try {
                final Document document = Jsoup.connect(url).get();
                int i =6;
                for (Element row : document.select("table.mctable1 tr")) {
                    String colVal = row.select("th:nth-of-type(6)").text();
                    if(colVal.equals("YTM")){
                        i=i+1;
                    }
                    String schemeName = row.select("td:nth-of-type(1)").text();
                    if (schemeName.equals("")) {
                        continue;
                    }

                    if(schemeName.indexOf('-') > 0){
                        schemeName = schemeName.substring(0, schemeName.indexOf('-'));
                    }

                    if (title.contains(schemeName)) {
                        continue;
                    }

                    title.add(schemeName);
                    String fundName = row.select("td:nth-of-type(3)").text();
                    String auM = row.select("td:nth-of-type(5)").text();
                    auM = auM.equals("-") ? "0" : auM.replace(",", "");

                    String col1W = row.select("td:nth-of-type("+i+")").text();
                    String col1M = row.select("td:nth-of-type("+(i+1)+")").text();
                    String col3M = row.select("td:nth-of-type("+(i+2)+")").text();
                    String col6M = row.select("td:nth-of-type("+(i+3)+")").text();
                    String col1Y = row.select("td:nth-of-type("+(i+5)+")").text();
                    String col2Y = row.select("td:nth-of-type("+(i+6)+")").text();
                    String col3Y = row.select("td:nth-of-type("+(i+7)+")").text();
                    String col5Y = row.select("td:nth-of-type("+(i+8)+")").text();
                    String col10Y = row.select("td:nth-of-type("+(i+9)+")").text();

                    double marketValue = Double.parseDouble(auM);
                    double oneWeek = StringFormatter.convertToDouble(col1W);
                    double oneMonth = StringFormatter.convertToDouble(col1M);
                    double threeMonth = StringFormatter.convertToDouble(col3M);
                    double sixMonth = StringFormatter.convertToDouble(col6M);
                    double oneYear = StringFormatter.convertToDouble(col1Y);
                    double twoYear = StringFormatter.convertToDouble(col2Y);
                    double threeYear = StringFormatter.convertToDouble(col3Y);
                    double fiveYear = StringFormatter.convertToDouble(col5Y);
                    double tenYear = StringFormatter.convertToDouble(col10Y);

                    stocks.add(StockFilter.builder().schemeName(schemeName).fundName(fundName).marketValue(marketValue).oneWeek(oneWeek).oneMonth(oneMonth).threeMonth(threeMonth).sixMonth(sixMonth).oneYear(oneYear).twoYear(twoYear).threeYear(threeYear).fiveYear(fiveYear).tenYear(tenYear).build());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return LimitRecords.getTopNRecords(SortingLogic.sortedList(stocks,duration),5);
    }


}
