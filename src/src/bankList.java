package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class bankList {
	
	private static WebDriver driver;
	private String url;
	
	public static ArrayList<String> shinhanBank() throws IOException, InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.setBinary("C:\\0.bigdata\\chromedriver_win32\\chromedriver.exe");
	options.addArguments("--headless");
	DesiredCapabilities.chrome();
	
	ArrayList shinhanList = new ArrayList();
	System.setProperty("webdriver.chrome.driver", "C:\\0.bigdata\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	BufferedReader shinhan = new BufferedReader(new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\shinhan.txt"));
	String shinhanUrl = shinhan.readLine();
	driver.get(shinhanUrl);
	Thread.sleep(1500);
	// w2grid_input w2grid_input_readonly
	String html = driver.getPageSource();
	Document shinhanDoc = Jsoup.parse(html);
	
	Elements shinDollarBuyRate = shinhanDoc.select("#grd_list_1_cell_0_7 > nobr");
	Elements shinDollarSellRate = shinhanDoc.select("#grd_list_1_cell_0_5 > nobr");
	Elements shinEuroBuyRate = shinhanDoc.select("#grd_list_1_cell_2_7 > nobr");
	Elements shinEuroSellRate = shinhanDoc.select("#grd_list_1_cell_2_5 > nobr");
	Elements shinYuanBuyRate = shinhanDoc.select("#grd_list_1_cell_10_7 > nobr");
	Elements shinYuanSellRate = shinhanDoc.select("#grd_list_1_cell_10_5 > nobr");
	Elements shinYenBuyRate = shinhanDoc.select("#grd_list_1_cell_1_7");
	Elements shinYenSellRate = shinhanDoc.select("#grd_list_1_cell_1_5 > nobr");

	String shinBuyDollar = shinDollarBuyRate.text();
	String shinSellDollar = shinDollarSellRate.text();
	String shinBuyEuro = shinEuroBuyRate.text();
	String shinSellEuro = shinEuroSellRate.text();
	String shinBuyYuan = shinYuanBuyRate.text();
	String shinSellYuan = shinYuanSellRate.text();
	String shinBuyYen = shinYenBuyRate.text();
	String shinSellYen = shinYenSellRate.text();
	
	shinhanList.add(shinBuyDollar);
	shinhanList.add(shinSellDollar);
	shinhanList.add(shinBuyEuro);
	shinhanList.add(shinSellEuro);
	shinhanList.add(shinBuyYuan);
	shinhanList.add(shinSellYuan);
	
	return shinhanList;
	}
	

}
