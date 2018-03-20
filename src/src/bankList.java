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
	
	
	public static ArrayList<String> shinhanBank() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\0.bigdata\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		BufferedReader shinhan = new BufferedReader(
		new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\shinhan.txt"));
		String shinhanUrl = shinhan.readLine();
		driver.get(shinhanUrl);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#grd_list_1_cell_0_7 > nobr")));

		// Thread.sleep(1500);
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
		
		driver.quit();

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
		String hanaBuyYuan = hanaYuanBuyRate.text();
		String hanaSellYuan = hanaYuanSellRate.text();
		String hanaBuyYen = hanaYenBuyRate.text();
		String hanaSellYen = hanaYenSellRate.text();

		ArrayList hanaList = new ArrayList();
		hanaList.add(hanaBuyDollar);
		hanaList.add(hanaSellDollar);
		hanaList.add(hanaBuyEuro);
		hanaList.add(hanaSellEuro);
		hanaList.add(hanaBuyYuan);
		hanaList.add(hanaSellYuan);
		hanaList.add(hanaBuyYen);
		hanaList.add(hanaSellYen);

		return hanaList;
	}

	public static ArrayList<String> wooriBank() throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		BufferedReader woori = new BufferedReader(
		new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\woori.txt"));
		String wooriUrl = woori.readLine();
		driver.get(wooriUrl);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.cssSelector("#fxprint > table > tbody > tr:nth-child(1) > td:nth-child(5)")));

		// Thread.sleep(1500);
		String html = driver.getPageSource();
		Document wooDoc = Jsoup.parse(html);

		Elements wooDollarBuyRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(1) > td:nth-child(5)");
		Elements wooDollarSellRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(1) > td:nth-child(7)");
		Elements wooEuroBuyRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(3) > td:nth-child(5)");
		Elements wooEuroSellRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(3) > td:nth-child(7)");
		Elements wooYuanBuyRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(8) > td:nth-child(5)");
		Elements wooYuanSellRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(8) > td:nth-child(7)");
		Elements wooYenBuyRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(2) > td:nth-child(5)");
		Elements wooYenSellRate = wooDoc.select("#fxprint > table > tbody > tr:nth-child(2) > td:nth-child(7)");

		driver.quit();

		String wooBuyDollar = wooDollarBuyRate.text();
		String wooSellDollar = wooDollarSellRate.text();
		String wooBuyEuro = wooEuroBuyRate.text();
		String wooSellEuro = wooEuroSellRate.text();
		String wooBuyYuan = wooYuanBuyRate.text();
		String wooSellYuan = wooYuanSellRate.text();
		String wooBuyYen = wooYenBuyRate.text();
		String wooSellYen = wooYenSellRate.text();

		ArrayList wooList = new ArrayList();
		wooList.add(wooBuyDollar);
		wooList.add(wooSellDollar);
		wooList.add(wooBuyEuro);
		wooList.add(wooSellEuro);
		wooList.add(wooBuyYuan);
		wooList.add(wooSellYuan);
		wooList.add(wooBuyYen);
		wooList.add(wooSellYen);

		return wooList;
	}
	public static ArrayList<String> nhBank() throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		BufferedReader nh = new BufferedReader(
		new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\nonghyup.txt"));
		String nhUrl = nh.readLine();
		driver.get(nhUrl);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.cssSelector("#cont1_4 > table > tbody > tr:nth-child(1) > td:nth-child(2)")));

		// Thread.sleep(1500);
		String html = driver.getPageSource();
		Document nhDoc = Jsoup.parse(html);

				Elements nhDollarBuyRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(1) > td:nth-child(2)");
				Elements nhDollarSellRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(1) > td:nth-child(3)");
				Elements nhEuroBuyRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(3) > td:nth-child(2)");
				Elements nhEuroSellRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(3) > td:nth-child(3)");
				Elements nhYuanBuyRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(4) > td:nth-child(2)");
				Elements nhYuanSellRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(4) > td:nth-child(3)");
				Elements nhYenBuyRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(2) > td:nth-child(2)");
				Elements nhYenSellRate = nhDoc
						.select("#cont1_4 > table > tbody > tr:nth-child(2) > td:nth-child(3)");

				String nhBuyDollar = nhDollarBuyRate.text();
				String nhSellDollar = nhDollarSellRate.text();
				String nhBuyEuro = nhEuroBuyRate.text();
				String nhSellEuro = nhEuroSellRate.text();
				String nhBuyYuan = nhYuanBuyRate.text();
				String nhSellYuan = nhYuanSellRate.text();
				String nhBuyYen = nhYenBuyRate.text();
				String nhSellYen = nhYenSellRate.text();
				
				driver.quit();
				
				ArrayList nhList = new ArrayList();
				nhList.add(nhBuyDollar);
				nhList.add(nhSellDollar);
				nhList.add(nhBuyEuro);
				nhList.add(nhSellEuro);
				nhList.add(nhBuyYuan);
				nhList.add(nhSellYuan);
				nhList.add(nhBuyYen);
				nhList.add(nhSellYen);

				return nhList;
	}
	public static ArrayList<String> kbBank() throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		BufferedReader kb = new BufferedReader(
		new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\kb.txt"));
		String kbUrl = kb.readLine();
		driver.get(kbUrl);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.cssSelector("#AllDsp1 > tr:nth-child(1) > td:nth-child(5)")));

		// Thread.sleep(1500);
		String html = driver.getPageSource();
		Document kbDoc = Jsoup.parse(html);
				Elements kbDollarBuyRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(1) > td:nth-child(5)");
				Elements kbDollarSellRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(1) > td:nth-child(6)");
				Elements kbEuroBuyRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(3) > td:nth-child(5)");
				Elements kbEuroSellRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(3) > td:nth-child(6)");
				Elements kbYuanBuyRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(10) > td:nth-child(5)");
				Elements kbYuanSellRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(10) > td:nth-child(6)");
				Elements kbYenBuyRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(2) > td:nth-child(5)");
				Elements kbYenSellRate = kbDoc
						.select("#AllDsp1 > tr:nth-child(2) > td:nth-child(6)");

				String kbBuyDollar = kbDollarBuyRate.text();
				String kbSellDollar = kbDollarSellRate.text();
				String kbBuyEuro = kbEuroBuyRate.text();
				String kbSellEuro = kbEuroSellRate.text();
				String kbBuyYuan = kbYuanBuyRate.text();
				String kbSellYuan = kbYuanSellRate.text();
				String kbBuyYen = kbYenBuyRate.text();
				String kbSellYen = kbYenSellRate.text();
				
				driver.quit();
				
				ArrayList kbList = new ArrayList();
				kbList.add(kbBuyDollar);
				kbList.add(kbSellDollar);
				kbList.add(kbBuyEuro);
				kbList.add(kbSellEuro);
				kbList.add(kbBuyYuan);
				kbList.add(kbSellYuan);
				kbList.add(kbBuyYen);
				kbList.add(kbSellYen);
				
				return kbList;
	}
}
