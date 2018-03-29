package util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import src.BankList;

public class Crawler {
	

    public static String allBank() throws Exception {
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

		try {
			map.put("SHINHAN", BankList.shinhanBank());
		} catch (Exception e) {
			System.out.println("신한은행 오류 : 고시 환율을 등록 중입니다. 잠시 후에 시도해주세요.");
		}
		
		map.put("HANA", BankList.hanaBank());
		map.put("WOORI", BankList.wooriBank());
		map.put("NH", BankList.nhBank());
		map.put("KB", BankList.kbBank());

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
			merger.get(i).add(Float.parseFloat(map.get("SHINHAN").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("HANA").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("WOORI").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("NH").get(i)));
			merger.get(i).add(Float.parseFloat(map.get("KB").get(i)));

			java.util.Collections.sort(merger.get(i));

		}
		System.out.println(merger);

		ArrayList<Float> calculator = new ArrayList<>();
		calculator.add(merger.get(0).get(0) - (merger.get(0).get(0) - merger.get(1).get(4)) / 4);
		calculator.add(merger.get(1).get(4) + (merger.get(0).get(0) - merger.get(1).get(4)) / 4);
		calculator.add(merger.get(2).get(0) - (merger.get(2).get(0) - merger.get(3).get(4)) / 4);
		calculator.add(merger.get(3).get(4) + (merger.get(2).get(0) - merger.get(3).get(4)) / 4);
		calculator.add(merger.get(4).get(0) - (merger.get(4).get(0) - merger.get(5).get(4)) / 4);
		calculator.add(merger.get(5).get(4) + (merger.get(4).get(0) - merger.get(5).get(4)) / 4);
		calculator.add(merger.get(6).get(0) - (merger.get(6).get(0) - merger.get(7).get(4)) / 4);
		calculator.add(merger.get(7).get(4) + (merger.get(6).get(0) - merger.get(7).get(4)) / 4);

//		System.out.println(calculator);
//		System.out.print(jsonMaker(map));
//		System.out.println(jsonMaker2(calculator));
		
		
		return jsonMaker(map) + jsonMaker2(calculator);
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
				jsonData += "'fromW':" + "'" + map.get(key).get(i % 4) + "'" + ",";
				jsonData += "'toW':" + "'" + map.get(key).get(i % 4 + 1) + "'" + "}";
			}
			i += 2;
		}
		jsonData+= "]},";
		return jsonData;
	}

	// buyD의 1번째 값과 SELLD의 마지막 값의 차 /4 를 BUYD에는 10원 빼고 SELLD에는 10원 더함.
	public static String jsonMaker2(ArrayList<Float> calculator) {
		String[] money = { "$", "€", "元", "￥" };
		int k = 0;
		String jsonData = "'measure'" + ":{";
		jsonData += "'$': 1, '€': 1, '元': 1, '￥': 100},";
		jsonData += "'serviceRate': {";
		for (int i = 0; i < 7; i += 2) {
			jsonData += "'" + money[k] + "':" + "{";
			jsonData += "'fromW':" + "'" + String.format("%.2f", calculator.get(i)) + "'" + ",";
			jsonData += "'toW':" + "'" + String.format("%.2f", calculator.get(i + 1)) + "'" + "," + "},";
			k++;
		}
		jsonData += "}}";
		return jsonData;
	}
	
}
