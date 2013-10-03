package com.derekrabindran.jyahoofinance.api;

import java.io.IOException;
import java.util.Map;

import org.joda.time.LocalDate;

import com.derekrabindran.jyahoofinance.structs.JYFHistoricalDataPoint;
import com.derekrabindran.jyahoofinance.structs.JYFSummaryData;


public class JYFApi {

	/**
	 * Get the historical prices for a symbol for a given date range.
	 * @param symbol The symbol of the security.
	 * @param start The start date of the range.
	 * @param end The end date of the range.
	 * @return Map of sorted data points.
	 * @throws IOException
	 */
	public static Map<LocalDate, JYFHistoricalDataPoint> GetHistoricalPrices(String symbol, LocalDate start, LocalDate end) throws IOException {
		return JYFHistoricalPrices.GetPrices(symbol, start, end);
	}
	
	/**
	 * Get the summary for a symbol.
	 * @param symbol
	 * @return JYFSummaryData which contains summary fields.
	 * @throws IOException
	 */
	public static JYFSummaryData GetSymbolSummary(String symbol) throws IOException {
		return JYFSummary.GetSymbolSummary(symbol);
	}
	
}
