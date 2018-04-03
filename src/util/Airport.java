package util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.description.modifier.SynchronizationState;

public class Airport {
	static ChromeDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\0.bigdata\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	public static String airport() throws IOException, InterruptedException {
		String airportJson = null;
		try {
			String airUrl = "https://www.airport.kr/ap_cnt/ko/dep/process/deppro.do";
			driver.get(airUrl);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"body > div.contents > div > div > div:nth-child(2) > div:nth-child(2) > div > div.boxmodel-btn-group.mt10 > a")));
			driver.findElementByCssSelector(
					"body > div.contents > div > div > div:nth-child(2) > div:nth-child(2) > div > div.boxmodel-btn-group.mt10 > a")
					.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
					"#departure_congestion_content > div > div.tab-area > div.tab-area-content.on > div.map-departure-congestion01 > div.map-absolute-area > div.congestion-mark1-5 > div.congestion-mark-number")));
			String html = driver.getPageSource();
			Document exit = Jsoup.parse(html);
			Elements exitGate1 = exit.select(
					"#departure_congestion_content > div > div.tab-area > div.tab-area-content.on > div.map-departure-congestion01 > div.map-absolute-area > div.congestion-mark1-2 > div.congestion-mark-number");
			Elements exitGate2 = exit.select(
					"#departure_congestion_content > div > div.tab-area > div.tab-area-content.on > div.map-departure-congestion01 > div.map-absolute-area > div.congestion-mark1-3 > div.congestion-mark-number");
			Elements exitGate3 = exit.select(
					"#departure_congestion_content > div > div.tab-area > div.tab-area-content.on > div.map-departure-congestion01 > div.map-absolute-area > div.congestion-mark1-4 > div.congestion-mark-number");
			Elements exitGate4 = exit.select(
					"#departure_congestion_content > div > div.tab-area > div.tab-area-content.on > div.map-departure-congestion01 > div.map-absolute-area > div.congestion-mark1-5 > div.congestion-mark-number");

			String peopleAt1 = exitGate1.text();
			String peopleAt2 = exitGate2.text();
			String peopleAt3 = exitGate3.text();
			String peopleAt4 = exitGate4.text();

			airportJson = "{";
			airportJson += "\"status\":true,";
			airportJson += "\"data\":[" + peopleAt1 + "," + peopleAt2 + "," + peopleAt3 + "," + peopleAt4;
			airportJson += "]}";
		} catch (Exception e) {
			airportJson = "{";
			airportJson += "\"status\":false,";
			airportJson += "\"message\":" + "Error : 출국장 정보를 불러올 수 없습니다. 잠시 후 다시 시도해 보시고 문제가 반복되면 관리자에게 문의하십시오.";
		} finally {
//			driver.quit();
			return airportJson;
		}
	}
}
