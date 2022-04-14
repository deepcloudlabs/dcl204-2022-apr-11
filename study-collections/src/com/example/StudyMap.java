package com.example;

import java.util.HashMap;
import java.util.Map;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyMap {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Map<String,Integer> areaCodes = new HashMap<>();
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("istanbul-avrupa", 212);
		System.out.println(areaCodes.get("ankara"));
		// Loop #1
		for (var city : areaCodes.keySet()) {
			System.out.println("%16s: %-3d".formatted(city,areaCodes.get(city)));
		}
		// Loop #2
		for (var code : areaCodes.values()) {
			System.out.println("%-3d".formatted(code));
		}
		// Loop #3
		for (var entry : areaCodes.entrySet()) {
			System.out.println("%16s: %-3d".formatted(entry.getKey(),entry.getValue()));
		}
		// Loop #4 : Functional Programming + Stream API
		areaCodes.forEach((city,code)->System.out.println("%16s: %-3d".formatted(city,code)));
		
		var alanKodlari = Map.of( // immutable map
			"ankara"			, 312,
			"istanbul-anadolu"	, 216,
			"istanbul-avrupa"	, 212
		);		
		// Error: unsupported operation exception -> alanKodlari.put("antalya", 242);
	}

}
