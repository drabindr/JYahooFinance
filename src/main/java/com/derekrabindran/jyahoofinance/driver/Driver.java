package com.derekrabindran.jyahoofinance.driver;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.LocalDate;

import com.derekrabindran.jyahoofinance.api.JYFApi;
import com.derekrabindran.jyahoofinance.core.JYFHistoricalPrices;
import com.derekrabindran.jyahoofinance.structs.JYFHistoricalDataPoint;
import com.derekrabindran.jyahoofinance.structs.JYFSummaryData;


public class Driver {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Get Historical Prices");
		Map<LocalDate, JYFHistoricalDataPoint> data = 
			JYFHistoricalPrices.GetPrices("MMM", new LocalDate(2011,1,1), new LocalDate(2012,1,1));
		
		for (Entry<LocalDate, JYFHistoricalDataPoint> i : data.entrySet()) {
			System.out.println(i.getKey()+"\t"+i.getValue());
		}
		
		
		// Get Symbol summary
		JYFSummaryData i = JYFApi.GetSymbolSummary("MMM");
		System.out.println(i);
		
		
	}
}
