package com.psl.MoneyControlAPI.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class StockFilterService {

    public void getStocks(){
        final String url = "https://www.moneycontrol.com/mutual-funds/performance-tracker/returns/equity---etfindex.html";
        try{
            final Document document = Jsoup.connect(url).get();
//			System.out.println(document.outerHtml());
            for(Element row: document.select("table.mctable1 tr")) {

                final String schemeName =  row.select("td:nth-of-type(1)").text();
                final String auM =  row.select("td:nth-of-type(5)").text();
                final String week =  row.select("td:nth-of-type(6)").text();
                System.out.println(schemeName+" --> "+auM+" "+week);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
