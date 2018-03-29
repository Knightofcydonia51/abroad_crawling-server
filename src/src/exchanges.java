package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.catalina.filters.SetCharacterEncodingFilter;
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
import com.sun.xml.internal.bind.CycleRecoverable.Context;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Woodstox;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import java.io.BufferedReader;

@WebServlet("/api/renew")
public class Exchanges extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.print(getServletContext().getAttribute("crawling"));
		} catch (Exception e) {
			
		} finally {
			out.close();
		}
		
		//서블릿 컨텍스트
				//HttpSession session -> 요청이 몇번 들어와도 같은 브라우저에서 온 거는 계속 세션에 저장됨. 
		//ServletContext context = new ServletContext();
				//context.setAttribute("crawlingResult", jsonMaker(map) + jsonMaker2(calculator)); set을 크롤러에서 해주고 겟으로 exchanges에서 받아줌. set이 되기 전에 get을 하는 
				//경우를 대비해 예외 처리.
				
	}
}
