package dr.jyahoofinance.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;

import dr.jyahoofinance.structs.YFHistoricalDataPoint;

public class JYFHistoricalPrices {
	
	public static Map<LocalDate, YFHistoricalDataPoint> GetPrices(
			String symbol, LocalDate start, LocalDate end) throws IOException {

		
		Map<LocalDate, YFHistoricalDataPoint> retMap = new TreeMap<LocalDate, YFHistoricalDataPoint>();
		
		// populate historical prices
		populateListWithData(symbol, start, end, retMap, false);
		
		// populate dividends
		populateListWithData(symbol, start, end, retMap, true);
		
		return retMap;
	}

	private static String buildURL(String symbol, LocalDate start, LocalDate end,
			boolean dividenCall) {

		String baseURL = "http://ichart.finance.yahoo.com/table.csv?s=%symbol%&a=%sm%&b=%sd%&c=%sy%&d=%em%&e=%ed%&f=%ey%&ignore=.csv&g=d";

		if (dividenCall) {
			baseURL = baseURL.replace("g=d", "g=v");
		}

		baseURL = baseURL.replace("%symbol%", symbol);
		baseURL = baseURL.replace("%sm%",
				Integer.toString(start.getMonthOfYear() - 1));
		baseURL = baseURL.replace("%sd%",
				Integer.toString(start.getDayOfMonth()));
		baseURL = baseURL.replace("%sy%", Integer.toString(start.getYear()));

		baseURL = baseURL.replace("%em%",
				Integer.toString(end.getMonthOfYear() - 1));
		baseURL = baseURL
				.replace("%ed%", Integer.toString(end.getDayOfMonth()));
		baseURL = baseURL.replace("%ey%", Integer.toString(end.getYear()));

		return baseURL;
	}

	private static void populateListWithData(String symbol, LocalDate start,
			LocalDate end, Map<LocalDate, YFHistoricalDataPoint> retMap,
			boolean populateDividends) throws IOException {

		URL url = new URL(buildURL(symbol, start, end, populateDividends));
		URLConnection urlConnection = url.openConnection();
		BufferedReader breader = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream()));

		String line;
		// skip header
		breader.readLine();

		while ((line = breader.readLine()) != null) {
			String[] splitLine = line.split(",");

			LocalDate date = new LocalDate(splitLine[0]);

			if (!populateDividends) {
				Double open = Double.parseDouble(splitLine[1]);
				Double high = Double.parseDouble(splitLine[2]);
				Double low = Double.parseDouble(splitLine[3]);
				Double close = Double.parseDouble(splitLine[4]);
				Double vol = Double.parseDouble(splitLine[5]);
				Double adjClose = Double.parseDouble(splitLine[6]);

				retMap.put(date, new YFHistoricalDataPoint(open, high, low, close,
						vol, adjClose));
			} else {
				Double divValue = Double.parseDouble(splitLine[1]);
				retMap.put(date, new YFHistoricalDataPoint(divValue));
			}
		}
	}
}
