package com.derekrabindran.jyahoofinance.structs;

public class JYFHistoricalDataPoint extends YFData {

	
	static enum YFHistoricalDataPointType {
		Dividend, Price
	}
	
	private YFHistoricalDataPointType type;
	
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private Double volume;
	private Double adjClose;
	private Double dividendValue;
	
	// Dividend constructor
	public JYFHistoricalDataPoint(Double dividendValue) {
		super();
		this.type = YFHistoricalDataPointType.Dividend;
		this.dividendValue = dividendValue;
	}

	// price point
	public JYFHistoricalDataPoint(Double open,
			Double high, Double low, Double close, Double volume,
			Double adjClose) {
		super();
		this.type = YFHistoricalDataPointType.Price;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.adjClose = adjClose;
		this.type = YFHistoricalDataPointType.Price;
	}

	public YFHistoricalDataPointType getType() {
		return type;
	}

	public void setType(YFHistoricalDataPointType type) {
		this.type = type;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(Double adjClose) {
		this.adjClose = adjClose;
	}

	public Double getDividendValue() {
		return dividendValue;
	}

	public void setDividendValue(Double dividendValue) {
		this.dividendValue = dividendValue;
	}

	@Override
	public String toString() {
		if (this.type == YFHistoricalDataPointType.Dividend) {
			return "Dividend:\t" + this.dividendValue;
		} else {
			return "Price:\t" + this.close;	
		}
	}
	

}
