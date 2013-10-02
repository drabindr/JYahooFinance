package dr.jyahoofinance.driver;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.LocalDate;

import dr.jyahoofinance.api.JYFHistoricalPrices;
import dr.jyahoofinance.structs.YFHistoricalDataPoint;

public class Driver {
	public static void main(String[] args) throws IOException {
		Map<LocalDate, YFHistoricalDataPoint> data = 
			JYFHistoricalPrices.GetPrices("MMM", new LocalDate(2011,1,1), new LocalDate(2012,1,1));
		
		for (Entry<LocalDate, YFHistoricalDataPoint> i : data.entrySet()) {
			System.out.println(i.getKey()+"\t"+i.getValue());
		}
		
		
	}
}
