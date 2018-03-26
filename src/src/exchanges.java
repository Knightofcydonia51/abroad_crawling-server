package src;

import src.BankList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
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
import org.openqa.selenium.remote.server.handler.GetAlertText;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Console;
import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.google.common.base.Converter;
import com.google.common.collect.Multiset.Entry;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Woodstox;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import java.io.BufferedReader;

public class Exchanges extends HttpServlet {

	public static void allBank() throws IOException, InterruptedException {
		// 신한, 하나, 우리, NH, IBK, KB 1
		
		
		// 신한은행
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
		
		
		
		try {
			map.put("SHINHAN", BankList.shinhanBank());
		} catch (Exception e) {
			System.out.println("고시 환율을 등록 중입니다.");
		}
		map.put("HANA", BankList.hanaBank());
		map.put("WOORI", BankList.wooriBank());
		map.put("NH", BankList.nhBank());
		map.put("KB", BankList.kbBank());
		
	
		
		
		System.out.println(map); //map Test
		System.out.println(jsonMaker(map));
		
		ArrayList<ArrayList<Double>> merger = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> buyD = new ArrayList<Double>();
		ArrayList<Double> sellD = new ArrayList<Double>();
		ArrayList<Double> buyE = new ArrayList<Double>();
		ArrayList<Double> sellE = new ArrayList<Double>();
		ArrayList<Double> buyYu = new ArrayList<Double>();
		ArrayList<Double> sellYu = new ArrayList<Double>();
		ArrayList<Double> buyYe = new ArrayList<Double>();
		ArrayList<Double> sellYe = new ArrayList<Double>();
		
		merger.add(buyD);
		merger.add(sellD);
		merger.add(buyE);
		merger.add(sellE);
		merger.add(buyYu);
		merger.add(sellYu);
		merger.add(buyYe);
		merger.add(sellYe);
		
		
//		for (int i = 0; i <8; i++) {
//			merger.get(i).add(map.get("SHINHAN").get(i));
//			merger.get(i).add(map.get("HANA").get(i));
//			merger.get(i).add(map.get("WOORI").get(i));
//			merger.get(i).add(map.get("NH").get(i));
//			merger.get(i).add(map.get("KB").get(i));
//			
//			java.util.Collections.sort(merger.get(i));
//
//		}
		//System.out.println(merger);

		

//		for(String key:map.keySet()) {
//			for (int i = 0; i <8; i++) {
//			String a=String.valueOf(map.get(key).get(i));
//			map.get(key).set(i, a);
//			}
//		}
//		
	}
		
	
	
	 public static String jsonMaker(LinkedHashMap<String, ArrayList<String>> map) {
         String[] money = { "$", "€", "元", "￥" };
         int i = 0;
         String jsonData = "{";
         jsonData += "'entry': ['$', '€', '元', '￥'], 'excData':{";

         for (String s : money) {
            jsonData += "'" + s + "':" + "[";
            for (String key : map.keySet()) {
               System.out.println(i);
               jsonData += "{" + "'bank':" + "'" + key + "'" + ",";
               jsonData += "'fromW':" +"'"+map.get(key).get(i % 4)+"'"  + ",";
               jsonData += "'toW':" +"'" +map.get(key).get(i % 4 + 1)+"'" + "}" + ",";
            }
            i += 2;
         }
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

