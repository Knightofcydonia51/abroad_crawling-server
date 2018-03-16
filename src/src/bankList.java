package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bankList {
	private static WebDriver driver;
	private String url;

	public static ArrayList<String> shinhanBank() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\0.bigdata\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		BufferedReader shinhan = new BufferedReader(
				new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\shinhan.txt"));
		String shinhanUrl = shinhan.readLine();
		driver.get(shinhanUrl);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#grd_list_1_cell_0_7 > nobr")));

		// Thread.sleep(1500);
		String html = driver.getPageSource();
		System.out.println(html);
		Document shinhanDoc = Jsoup.parse(html);

		Elements shinDollarBuyRate = shinhanDoc.select("#grd_list_1_cell_0_7 > nobr");
		Elements shinDollarSellRate = shinhanDoc.select("#grd_list_1_cell_0_5 > nobr");
		Elements shinEuroBuyRate = shinhanDoc.select("#grd_list_1_cell_2_7 > nobr");
		Elements shinEuroSellRate = shinhanDoc.select("#grd_list_1_cell_2_5 > nobr");
		Elements shinYuanBuyRate = shinhanDoc.select("#grd_list_1_cell_10_7 > nobr");
		Elements shinYuanSellRate = shinhanDoc.select("#grd_list_1_cell_10_5 > nobr");
		Elements shinYenBuyRate = shinhanDoc.select("#grd_list_1_cell_1_7");
		Elements shinYenSellRate = shinhanDoc.select("#grd_list_1_cell_1_5 > nobr");

		driver.quit();

		String shinBuyDollar = shinDollarBuyRate.text();
		String shinSellDollar = shinDollarSellRate.text();
		String shinBuyEuro = shinEuroBuyRate.text();
		String shinSellEuro = shinEuroSellRate.text();
		String shinBuyYuan = shinYuanBuyRate.text();
		String shinSellYuan = shinYuanSellRate.text();
		String shinBuyYen = shinYenBuyRate.text();
		String shinSellYen = shinYenSellRate.text();

		ArrayList shinhanList = new ArrayList();
		shinhanList.add(shinBuyDollar);
		shinhanList.add(shinSellDollar);
		shinhanList.add(shinBuyEuro);
		shinhanList.add(shinSellEuro);
		shinhanList.add(shinBuyYuan);
		shinhanList.add(shinSellYuan);
		shinhanList.add(shinBuyYen);
		shinhanList.add(shinSellYen);

		return shinhanList;
	}

	public static ArrayList<String> hanaBank() throws IOException {
		BufferedReader hana = new BufferedReader(
				new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\hana.txt"));
		String hanaUrl = hana.readLine();
		Document hanaDoc = Jsoup.connect(hanaUrl).get();

		Elements hanaDollarBuyRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr.first > td.buy");
		Elements hanaDollarSellRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr.first > td.sell");
		Elements hanaEuroBuyRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr:nth-child(3) > td.buy");
		Elements hanaEuroSellRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr:nth-child(3) > td.sell");
		Elements hanaYuanBuyRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr:nth-child(4) > td.buy");
		Elements hanaYuanSellRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr:nth-child(4) > td.sell");
		Elements hanaYenBuyRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr:nth-child(2) > td.buy");
		Elements hanaYenSellRate = hanaDoc
				.select("#freetbl > ul > li.first_child.on > div > table > tbody > tr:nth-child(2) > td.sell");

		String hanaBuyDollar = hanaDollarBuyRate.text();
		String hanaSellDollar = hanaDollarSellRate.text();
		String hanaBuyEuro = hanaEuroBuyRate.text();
		String hanaSellEuro = hanaEuroSellRate.text();
		String hanaBuyYuan = hanaEuroBuyRate.text();

		return null;
	}

}
