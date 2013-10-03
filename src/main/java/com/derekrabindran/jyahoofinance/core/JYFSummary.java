package com.derekrabindran.jyahoofinance.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.derekrabindran.jyahoofinance.structs.JYFSummaryData;

public class JYFSummary {
	
	/**
	 * Get the historical prices for a symbol for a given date range.
	 * @param symbol The symbol of the security.
	 * @param start The start date of the range.
	 * @param end The end date of the range.
	 * @return Map of sorted data points.
	 * @throws IOException
	 */
	public static JYFSummaryData GetSymbolSummary(String symbol) throws IOException {
		URL url = new URL(buildURL(symbol));
		URLConnection urlConnection = url.openConnection();
		BufferedReader breader = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream()));
		
		String line = breader.readLine();
		String[] splitLine = line.split(",");
		
		Double price = cleanNumber(splitLine[0]);
		Double vol = cleanNumber(splitLine[1]);
		Double pe = cleanNumber(splitLine[2]);
		Double eps = cleanNumber(splitLine[3]);
		Double w52low = cleanNumber(splitLine[4]);
		Double w52hi = cleanNumber(splitLine[5]);
		Double dlow = cleanNumber(splitLine[6]);
		Double dhi = cleanNumber(splitLine[7]);
		Double mv50 = cleanNumber(splitLine[8]);
		Double marketCap = cleanNumber(splitLine[9]);
		
		return new JYFSummaryData(price, vol, pe, eps, w52hi, w52low, dhi, dlow, mv50, marketCap);
	}

	/**
	 * Construct the url for the csv file.
	 * @param symbol
	 * @return
	 */
	private static String buildURL(String symbol) {
		return "http://finance.yahoo.com/d/quotes.csv?s="+ symbol + "&f=l1vr2ejkghm3j3";
	}
	
	/**
	 * Clean up the numbers.
	 * @param in
	 * @return
	 */
	private static Double cleanNumber(String in) {
		if (in.equals("N/A")) {
			return Double.NaN;
		} else {
			return Double.parseDouble(in);
		}
	}
}
