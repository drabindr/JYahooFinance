JYahooFinance
=============

Yahoo Finance Java API

This API has the following core modules:

  1) Historical Prices
  2) Live Price
  
Usage:
LocalDate, YFHistoricalDataPoint> data = 
			JYFHistoricalPrices.GetPrices("MMM", new LocalDate(2011,1,1), new LocalDate(2012,1,1));

Dependencies:
Joda Time
