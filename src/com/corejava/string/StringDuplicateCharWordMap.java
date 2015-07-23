package com.corejava.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

public class StringDuplicateCharWordMap {

	private static final Logger LOG = Logger
			.getLogger("StringDuplicateCharWordMap");

	public static void main(String[] args) {
		String str = "Ram killed	Ravan Ravan	killed by Ram t";
		char firstNonRepeatedChar = getFirstNonRepeatedChar(str);
		LOG.info("firstNonRepeatedChar :: " + firstNonRepeatedChar);
		List<Character> allNonRepeatedChar = getAllNonRepeatedChar(str);
		LOG.info("allNonRepeatedChar :: " + allNonRepeatedChar);
		getAllRepeatedChar(str);
		getAllRepeatedWord(str);
		newStringWithIntern();
		LOG.info(removeChar(str, 't'));
		byUsingCollectionsFrequency(str);
	}

	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.replaceAll("\\s", "").toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

	public static List<Character> getAllNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.replaceAll("\\s", "").toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		List<Character> nonRepeatablechars = new ArrayList<Character>();
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				nonRepeatablechars.add(entry.getKey());
			}
		}
		if (nonRepeatablechars.isEmpty())
			throw new RuntimeException("didn't find any non repeated Character");
		else
			return nonRepeatablechars;
	}

	public static void getAllRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
		for (char c : str.replaceAll("\\s", "").toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			LOG.info(entry.getKey() + " | " + entry.getValue());
		}
	}

	public static void getAllRepeatedWord(String str) {
		List<String> listStr = Arrays.asList(str.split("\\s"));
		Map<String, Integer> countsWord = new LinkedHashMap<>();
		for (String s : listStr) {
			countsWord.put(s, countsWord.containsKey(s) ? countsWord.get(s) + 1
					: 1);
		}
		for (Entry<String, Integer> entry : countsWord.entrySet()) {
			LOG.info(entry.getKey() + " | " + entry.getValue());
		}
	}

	public static void newStringWithIntern() {
		String str1 = "SriRama";
		String str2 = "SriRama".intern();
		String str3 = new String("SriRama");
		String str4 = new String("SriRama").intern();

		if (str1 == str2) {
			LOG.info("str1 and str2 are same");
		}

		if (str1 == str3) {
			LOG.info("str1 and str3 are same");
		}

		if (str1 == str4) {
			LOG.info("str1 and str4 are same");
		}

		if (str2 == str3) {
			LOG.info("str2 and str3 are same");
		}

		if (str2 == str4) {
			LOG.info("str2 and str4 are same");
		}

	}

	private static String removeChar(String str, char c) {
		if (str == null)
			return null;
		return str.replaceAll(Character.toString(c), "");
	}

	private static void byUsingCollectionsFrequency(String str) {
		List<String> list = Arrays.asList(str.split("\\s"));
		Set<String> uniqueWords = new HashSet<String>(list);
		for (String word : uniqueWords) {
			LOG.info(word + ": " + Collections.frequency(list, word));
		}
	}

}
