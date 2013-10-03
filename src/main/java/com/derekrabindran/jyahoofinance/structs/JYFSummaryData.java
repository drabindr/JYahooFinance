package com.derekrabindran.jyahoofinance.structs;

public class JYFSummaryData {
	
	private Double price;
	private Double volume;
	private Double PE;
	private Double EPS;
	private Double week52High;
	private Double week52Low;
	private Double dayHigh;
	private Double dayLow;
	private Double movingAverage50Day;
	private Double marketCap;
	
	
	public JYFSummaryData(Double price, Double volume, Double pE, Double ePS,
			Double week52High, Double week52Low, Double dayHigh, Double dayLow,
			Double movingAverage50Day, Double marketCap) {
		super();
		this.price = price;
		this.volume = volume;
		PE = pE;
		EPS = ePS;
		this.week52High = week52High;
		this.week52Low = week52Low;
		this.dayHigh = dayHigh;
		this.dayLow = dayLow;
		this.movingAverage50Day = movingAverage50Day;
		this.marketCap = marketCap;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getVolume() {
		return volume;
	}
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	public Double getPE() {
		return PE;
	}
	public void setPE(Double pE) {
		PE = pE;
	}
	public Double getEPS() {
		return EPS;
	}
	public void setEPS(Double ePS) {
		EPS = ePS;
	}
	public Double getWeek52High() {
		return week52High;
	}
	public void setWeek52High(Double week52High) {
		this.week52High = week52High;
	}
	public Double getWeek52Low() {
		return week52Low;
	}
	public void setWeek52Low(Double week52Low) {
		this.week52Low = week52Low;
	}
	public Double getDayHigh() {
		return dayHigh;
	}
	public void setDayHigh(Double dayHigh) {
		this.dayHigh = dayHigh;
	}
	public Double getDayLow() {
		return dayLow;
	}
	public void setDayLow(Double dayLow) {
		this.dayLow = dayLow;
	}
	public Double getMovingAverage50Day() {
		return movingAverage50Day;
	}
	public void setMovingAverage50Day(Double movingAverage50Day) {
		this.movingAverage50Day = movingAverage50Day;
	}
	public Double getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(Double marketCap) {
		this.marketCap = marketCap;
	}

	@Override
	public String toString() {
		return "JYFSummaryData [price=" + price + ", volume=" + volume
				+ ", PE=" + PE + ", EPS=" + EPS + ", week52High=" + week52High
				+ ", week52Low=" + week52Low + ", dayHigh=" + dayHigh
				+ ", dayLow=" + dayLow + ", movingAverage50Day="
				+ movingAverage50Day + ", marketCap=" + marketCap + "]";
	}
	
	
	
}
