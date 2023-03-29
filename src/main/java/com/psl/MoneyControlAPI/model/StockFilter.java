package com.psl.MoneyControlAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockFilter {

    private String schemeName;
    private String fundName;
    private double marketValue;
    private double oneWeek;
    private double oneMonth;
    private double threeMonth;
    private double sixMonth;
    private double oneYear;
    private double twoYear;
    private double threeYear;
    private double fiveYear;
    private double tenYear;

}
