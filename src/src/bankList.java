package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankList {
	
		 
	static ChromeDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\0.bigdata\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static ArrayList<String> shinhanBank() throws IOException, InterruptedException, SQLException {

		BufferedReader shinhan = new BufferedReader(
				new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\shinhan.txt"));
		String shinhanUrl = shinhan.readLine();
		String shinhanUrlWithDummy = shinhanUrl.substring(0,34) + "?" + String.valueOf((Math.random()*1000)).replace(".", "")+shinhanUrl.substring(34);
		driver.get(shinhanUrlWithDummy);
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

		String shinBuyDollar = shinDollarBuyRate.text().replace(",", "");
		String shinSellDollar = shinDollarSellRate.text().replace(",", "");
		String shinBuyEuro = shinEuroBuyRate.text().replace(",", "");
		String shinSellEuro = shinEuroSellRate.text().replace(",", "");
		String shinBuyYuan = shinYuanBuyRate.text().replace(",", "");
		String shinSellYuan = shinYuanSellRate.text().replace(",", "");
		String shinBuyYen = shinYenBuyRate.text().replace(",", "");
		String shinSellYen = shinYenSellRate.text().replace(",", "");

		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String to = transFormat.format(from);

		CrawlingDAO.insertSHINHAN(new CrawlingBean(to, shinBuyDollar, shinSellDollar, shinBuyEuro, shinSellEuro, shinBuyYuan, shinSellYuan, shinBuyYen, shinSellYen));
		
		
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

	public static ArrayList<String> hanaBank() throws IOException, SQLException {
		BufferedReader hana = new BufferedReader(
				new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\hana.txt"));
		String hanaUrl = hana.readLine();
		String hanaUrlWithDummy = hanaUrl + "&" + String.valueOf((Math.random()*1000)).replace(".", "");
		Document hanaDoc = Jsoup.connect(hanaUrlWithDummy).get();

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

		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = transFormat.format(from);

		CrawlingDAO.insertHANA(new CrawlingBean(now, hanaBuyDollar, hanaSellDollar, hanaBuyEuro, hanaSellEuro, hanaBuyYuan, hanaSellYuan, hanaBuyYen, hanaSellYen));
		
		
		
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

	public static ArrayList<String> wooriBank() throws IOException, InterruptedException, SQLException {
		BufferedReader woori = new BufferedReader(
				new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\woori.txt"));
		String wooriUrl = woori.readLine();
		String wooriUrlWithDummy = wooriUrl + "&" + String.valueOf((Math.random()*1000)).replace(".", "");
		driver.get(wooriUrlWithDummy);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#fxprint > table > tbody > tr:nth-child(1) > td:nth-child(5)")));

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

		String wooBuyDollar = wooDollarBuyRate.text().replace(",", "");
		String wooSellDollar = wooDollarSellRate.text().replace(",", "");
		String wooBuyEuro = wooEuroBuyRate.text().replace(",", "");
		String wooSellEuro = wooEuroSellRate.text().replace(",", "");
		String wooBuyYuan = wooYuanBuyRate.text().replace(",", "");
		String wooSellYuan = wooYuanSellRate.text().replace(",", "");
		String wooBuyYen = wooYenBuyRate.text().replace(",", "");
		String wooSellYen = wooYenSellRate.text().replace(",", "");
		
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = transFormat.format(from);

		CrawlingDAO.insertWOORI(new CrawlingBean(now, wooBuyDollar, wooSellDollar, wooBuyEuro, wooSellEuro, wooBuyYuan, wooSellYuan, wooBuyYen, wooSellYen));

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

	public static ArrayList<String> nhBank() throws IOException, InterruptedException, SQLException {
		BufferedReader nh = new BufferedReader(
				new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\nonghyup.txt"));
		String nhUrl = nh.readLine();
		String nhUrlWithDummy = nhUrl + "#" + String.valueOf((Math.random()*1000)).replace(".", "");
		driver.get(nhUrlWithDummy);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#cont1_4 > table > tbody > tr:nth-child(1) > td:nth-child(2)")));

		String html = driver.getPageSource();
		Document nhDoc = Jsoup.parse(html);

		Elements nhDollarBuyRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(1) > td:nth-child(2)");
		Elements nhDollarSellRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(1) > td:nth-child(3)");
		Elements nhEuroBuyRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(3) > td:nth-child(2)");
		Elements nhEuroSellRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(3) > td:nth-child(3)");
		Elements nhYuanBuyRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(4) > td:nth-child(2)");
		Elements nhYuanSellRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(4) > td:nth-child(3)");
		Elements nhYenBuyRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(2) > td:nth-child(2)");
		Elements nhYenSellRate = nhDoc.select("#cont1_4 > table > tbody > tr:nth-child(2) > td:nth-child(3)");

		String nhBuyDollar = nhDollarBuyRate.text().replace(",", "");
		String nhSellDollar = nhDollarSellRate.text().replace(",", "");
		String nhBuyEuro = nhEuroBuyRate.text().replace(",", "");
		String nhSellEuro = nhEuroSellRate.text().replace(",", "");
		String nhBuyYuan = nhYuanBuyRate.text().replace(",", "");
		String nhSellYuan = nhYuanSellRate.text().replace(",", "");
		String nhBuyYen = nhYenBuyRate.text().replace(",", "");
		String nhSellYen = nhYenSellRate.text().replace(",", "");
		
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = transFormat.format(from);

		CrawlingDAO.insertNH(new CrawlingBean(now, nhBuyDollar, nhSellDollar, nhBuyEuro, nhSellEuro, nhBuyYuan, nhSellYuan, nhBuyYen, nhSellYen));

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

	public static ArrayList<String> kbBank() throws IOException, InterruptedException, SQLException {
		BufferedReader kb = new BufferedReader(new FileReader("C:\\0.bigData\\abroad_crawling-server\\util\\kb.txt"));
		String kbUrl = kb.readLine();
		String kbUrlWithDummy = kbUrl + "&" + String.valueOf((Math.random()*1000)).replace(".", "");
		driver.get(kbUrlWithDummy);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#AllDsp1 > tr:nth-child(1) > td:nth-child(5)")));

		String html = driver.getPageSource();
		Document kbDoc = Jsoup.parse(html);
		Elements kbDollarBuyRate = kbDoc.select("#AllDsp1 > tr:nth-child(1) > td:nth-child(5)");
		Elements kbDollarSellRate = kbDoc.select("#AllDsp1 > tr:nth-child(1) > td:nth-child(6)");
		Elements kbEuroBuyRate = kbDoc.select("#AllDsp1 > tr:nth-child(3) > td:nth-child(5)");
		Elements kbEuroSellRate = kbDoc.select("#AllDsp1 > tr:nth-child(3) > td:nth-child(6)");
		Elements kbYuanBuyRate = kbDoc.select("#AllDsp1 > tr:nth-child(10) > td:nth-child(5)");
		Elements kbYuanSellRate = kbDoc.select("#AllDsp1 > tr:nth-child(10) > td:nth-child(6)");
		Elements kbYenBuyRate = kbDoc.select("#AllDsp1 > tr:nth-child(2) > td:nth-child(5)");
		Elements kbYenSellRate = kbDoc.select("#AllDsp1 > tr:nth-child(2) > td:nth-child(6)");

		String kbBuyDollar = kbDollarBuyRate.text().replace(",", "");
		String kbSellDollar = kbDollarSellRate.text().replace(",", "");
		String kbBuyEuro = kbEuroBuyRate.text().replace(",", "");
		String kbSellEuro = kbEuroSellRate.text().replace(",", "");
		String kbBuyYuan = kbYuanBuyRate.text().replace(",", "");
		String kbSellYuan = kbYuanSellRate.text().replace(",", "");
		String kbBuyYen = kbYenBuyRate.text().replace(",", "");
		String kbSellYen = kbYenSellRate.text().replace(",", "");

//		driver.quit();
		
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = transFormat.format(from);

		CrawlingDAO.insertKB(new CrawlingBean(now, kbBuyDollar, kbSellDollar, kbBuyEuro, kbSellEuro, kbBuyYuan, kbSellYuan, kbBuyYen, kbSellYen));

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
