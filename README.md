JYahooFinance
=========

JYahooFinance is a simple API for querying data available through Yahoo Finance.  Some of the features include:

  - Historical Prices w/ dividends
  - Symbol Summary

Version
----

0.1

Example
----
Here are a few examples of the API in action.

#### Get historical price of 3M (MMM) from 2011/1/1 to 2012/1/1.
```java
String symbol = "MMM";
LocalDate start = new LocalDate(2011,1,1);
LocalDate end = new LocalDate(2012,1,1);

Map<LocalDate, JYFHistoricalDataPoint> data = JYFApi.GetHistoricalPrices(symbol, start, end);
```

#### Get the symbol summary for 3M (MMM).
```java
JYFSummaryData data = JYFApi.GetSymbolSummary("MMM");
```

Dependencies
-----------

JYahooFinance uses a number of open source projects to work properly:

* [Joda Time] - Great Java date and time API

License
----

MIT
