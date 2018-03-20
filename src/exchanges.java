

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;

public class exchanges extends HttpServlet {
	private static WebDriver driver;
	private String url;

		public static String euroRate() throws IOException {
			
			
			String jsonData = "";
			return jsonData; 
		}
		
		public static void setUp() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\0.bigdata\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//그냥 5초 기다리기
			driver.get("https://bank.shinhan.com/index.jsp#020501010100");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("wq_uuid_1578")));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id("wq_uuid_1578")).click();
			Thread.sleep(2000);
			//w2grid_input w2grid_input_readonly
			String i=driver.getPageSource();
			Document doc=null;
			i=doc.toString();
			Document shinhan=Jsoup.parse(i);
			Elements shinhanBuyRate =shinhan.select(".w2grid_input w2grid_input_readonly");
			
			//#HANA_CONTENTS_DIV > div.btnBoxCenter > a
		}
		
		public static String dollarRate() throws IOException {
			BufferedReader hana=new BufferedReader(new FileReader("C:\\0.bigdata\\Practice\\algorithm\\util\\hana.txt"));
			String hanaUrl = hana.readLine();
			Document hanaDoc = Jsoup.connect(hanaUrl).get();
			Elements hanaBuyRate = hanaDoc.select(".buy");
			Elements hanaSellRate = hanaDoc.select(".sell");
			String hanaBuyDollar = hanaBuyRate.get(0).text();
			String hanaSellDollar = hanaSellRate.get(0).text();
			
			Document wooriDoc = Jsoup.connect("https://spot.wooribank.com/pot/Dream?withyou=fx").get();
			Elements wooriBuyRate =wooriDoc.select(".font-c-r");
			String wooriBuyDollar = wooriBuyRate.get(0).text();
			
			String jsonData = "{";
			jsonData += "'bank':" + "'HANA'" + ",";
			jsonData += "fromW:" + hanaBuyDollar + ",";
			jsonData += "toW:" + hanaSellDollar + "}";
			return jsonData;	
		}
		
		

		/*
		 * final String address =
		 * "http://finance.naver.com//sise/entryJongmok.nhn?&page=" + a; Document doc =
		 * Jsoup.connect(address).get(); LinkedHashMap<String, String> list = new
		 * LinkedHashMap<String, String>();
		 * 
		 * Elements i = doc.select(".ctg a"); // 클래스 cta에서 a 태그만 빼왔다. Elements k =
		 * doc.select(".number_2"); int size = i.size(); for (int b = 0; b < size ; b++)
		 * { Element object = i.get(b); Element stock = k.get(4*b);
		 * list.put(object.text(), stock.text()); }
		 * 
		 * for (String key : list.keySet()) { System.out.println(key + " " +
		 * list.get(key)); }
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

		public static void main(String[] args) throws IOException, InterruptedException {
			
			setUp();
		}
}
	

	
