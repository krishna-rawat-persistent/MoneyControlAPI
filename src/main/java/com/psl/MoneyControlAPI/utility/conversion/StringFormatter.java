package com.psl.MoneyControlAPI.utility.conversion;

public class StringFormatter {
    public static double convertToDouble(String val){
       return Double.parseDouble(val.equals("-")?"0":val.replace("%", ""));
    }
}
