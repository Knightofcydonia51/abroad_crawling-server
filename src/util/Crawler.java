package util;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import src.BankList;

public class Crawler {

	public static String allBank() throws Exception {
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

		try {
			map.put("신한은행", BankList.shinhanBank());
		} catch (Exception e) {
			System.out.println("신한은행 오류 : 고시 환율을 등록 중입니다. 잠시 후에 시도해주세요.");
		}

		map.put("하나은행", BankList.hanaBank());
		map.put("우리은행", BankList.wooriBank());
		map.put("농협은행", BankList.nhBank());
		map.put("국민은행", BankList.kbBank());

		System.out.println(map); // map Test

		ArrayList<ArrayList<Float>> merger = new ArrayList<ArrayList<Float>>();
		ArrayList<Float> buyD = new ArrayList<Float>();
		ArrayList<Float> sellD = new ArrayList<Float>();
		ArrayList<Float> buyE = new ArrayList<Float>();
		ArrayList<Float> sellE = new ArrayList<Float>();
		ArrayList<Float> buyYu = new ArrayList<Float>();
		ArrayList<Float> sellYu = new ArrayList<Float>();
		ArrayList<Float> buyYe = new ArrayList<Float>();
		ArrayList<Float> sellYe = new ArrayList<Float>();

		merger.add(buyD);
		merger.add(sellD);
		merger.add(buyE);
		merger.add(sellE);
		merger.add(buyYu);
		merger.add(sellYu);
		merger.add(buyYe);
		merger.add(sellYe);

		for (int i = 0; i < 8; i++) {
			merger.get(i).add(Float.parseFloat(map.get("신한은행").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("하나은행").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("우리은행").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("농협은행").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("국민은행").get(i)));

			java.util.Collections.sort(merger.get(i));

		}

		ArrayList<Float> calculator = new ArrayList<>();
		calculator.add(merger.get(0).get(0) - (merger.get(0).get(0) - merger.get(1).get(4)) / 4);
		calculator.add(merger.get(1).get(4) + (merger.get(0).get(0) - merger.get(1).get(4)) / 4);
		calculator.add(merger.get(2).get(0) - (merger.get(2).get(0) - merger.get(3).get(4)) / 4);
		calculator.add(merger.get(3).get(4) + (merger.get(2).get(0) - merger.get(3).get(4)) / 4);
		calculator.add(merger.get(4).get(0) - (merger.get(4).get(0) - merger.get(5).get(4)) / 4);
		calculator.add(merger.get(5).get(4) + (merger.get(4).get(0) - merger.get(5).get(4)) / 4);
		calculator.add(merger.get(6).get(0) - (merger.get(6).get(0) - merger.get(7).get(4)) / 4);
		calculator.add(merger.get(7).get(4) + (merger.get(6).get(0) - merger.get(7).get(4)) / 4);

		System.out.println(jsonMaker(map, calculator));
		return jsonMaker(map, calculator);
	}

	public static String jsonMaker(LinkedHashMap<String, ArrayList<String>> map, ArrayList<Float> calculator) {
		String[] moneyTypes = { "$", "€", "元", "￥" };
		int i = 0;
		int k = 0;
		String jsonData = "{'status':true,'entry':['$', '€', '元', '￥'],'excData':{";

		for (String moneyType : moneyTypes) { // s - 화폐이름
			jsonData += "'" + moneyType + "':[";
			for (String bankName : map.keySet()) { // bankName - 은행이름
				ArrayList<String> bankExc = map.get(bankName);
				jsonData += "{'bank':'" + bankName + "',";
				jsonData += "'fromW':'" + bankExc.get(i) + "',";
				jsonData += "'toW':'" + bankExc.get(i + 1) + "'},";
			}
			jsonData = jsonData.substring(0, jsonData.length() - 1);
			jsonData += "],";
			i += 2;
		}
		jsonData = jsonData.substring(0, jsonData.length() - 1);
		jsonData += "},'measure':{'$':1,'€':1,'元':1,'￥':100},'serviceRate':{";

		for (i = 0; i < 7; i += 2) {
			jsonData += "'" + moneyTypes[k++] + "':{";
			jsonData += "'fromW':'" + String.format("%.2f", calculator.get(i)) + "',";
			jsonData += "'toW':'" + String.format("%.2f", calculator.get(i + 1)) + "'},";
		}
		jsonData = jsonData.substring(0, jsonData.length() - 1);
		jsonData += "}}";
		jsonData = jsonData.replaceAll("'", "\"");
		return jsonData;
	}
}
