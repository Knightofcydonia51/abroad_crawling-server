package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

import com.beust.jcommander.internal.Console;

import java.io.BufferedReader;

public class exchanges extends HttpServlet {
	private static WebDriver driver;
	private String url;

	public static LinkedHashMap<String, ArrayList<String>> allBank() throws IOException, InterruptedException {
		//신한, 하나, 우리, NH, IBK, KB 1
		
		//신한은행	
		LinkedHashMap shinhanMap = new LinkedHashMap();
		shinhanMap.put("신한", bankList.shinhanBank());
		System.out.println(shinhanMap);
		
		//하나은행
		LinkedHashMap hanaMap = new LinkedHashMap();
		hanaMap.put("하나", bankList.hanaBank());
		System.out.println(hanaMap);
		
		return null;

		//우리은행
		
		//NH
		
		//IBK
		
		//KB
		
		
		
		/*public static String jsonMaker() {
		String jsonData = "{";
		jsonData += "'bank':" + "'SHINHAN'" + ",";
		jsonData += "fromW:" + shinhanBuyDollar + ",";
		jsonData += "toW:" + hanaSellDollar + "}";
		
		jsonData += "'bank':" + "'HANA'" + ",";
		jsonData += "fromW:" + hanaBuyDollar + ",";
		jsonData += "toW:" + hanaSellDollar + "}";
		return jsonData;*/
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		allBank();

	}
}
