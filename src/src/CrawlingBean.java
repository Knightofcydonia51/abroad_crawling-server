package src;

public class CrawlingBean {
	private String crawltime;
	private String buyD;
	private String sellD;
	private String buyE;
	private String sellE;
	private String buyYu;
	private String sellYu;
	private String buyYe;
	private String sellYe;
	public CrawlingBean() {
		super();
	}
	public CrawlingBean(String crawltime, String buyD, String sellD, String buyE, String sellE, String buyYu,
			String sellYu, String buyYe, String sellYe) {
		super();
		this.crawltime = crawltime;
		this.buyD = buyD;
		this.sellD = sellD;
		this.buyE = buyE;
		this.sellE = sellE;
		this.buyYu = buyYu;
		this.sellYu = sellYu;
		this.buyYe = buyYe;
		this.sellYe = sellYe;
	}
	@Override
	public String toString() {
		return "CrawlingBean [crawltime=" + crawltime + ", buyD=" + buyD + ", sellD=" + sellD + ", buyE=" + buyE
				+ ", sellE=" + sellE + ", buyYu=" + buyYu + ", sellYu=" + sellYu + ", buyYe=" + buyYe + ", sellYe="
				+ sellYe + "]";
	}
	public String getCrawltime() {
		return crawltime;
	}
	public void setCrawltime(String crawltime) {
		this.crawltime = crawltime;
	}
	public String getBuyD() {
		return buyD;
	}
	public void setBuyD(String buyD) {
		this.buyD = buyD;
	}
	public String getSellD() {
		return sellD;
	}
	public void setSellD(String sellD) {
		this.sellD = sellD;
	}
	public String getBuyE() {
		return buyE;
	}
	public void setBuyE(String buyE) {
		this.buyE = buyE;
	}
	public String getSellE() {
		return sellE;
	}
	public void setSellE(String sellE) {
		this.sellE = sellE;
	}
	public String getBuyYu() {
		return buyYu;
	}
	public void setBuyYu(String buyYu) {
		this.buyYu = buyYu;
	}
	public String getSellYu() {
		return sellYu;
	}
	public void setSellYu(String sellYu) {
		this.sellYu = sellYu;
	}
	public String getBuyYe() {
		return buyYe;
	}
	public void setBuyYe(String buyYe) {
		this.buyYe = buyYe;
	}
	public String getSellYe() {
		return sellYe;
	}
	public void setSellYe(String sellYe) {
		this.sellYe = sellYe;
	}
}
