package mapreduce;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import timing.Timer;

public class Test {
	public static Map<String, Integer> countWords(String i)
	{
		Map<String, Integer> words = new HashMap<String, Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader( i));
			String line = reader.readLine();
			while (line != null) {
				String[] str = line.split("\\s|;");
				for (String s : str) {
					if (words.get(s) != null) {
						words.put(s, words.get(s) + 1);
					} else {
						words.put(s, 1);
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}
	public static Map<String, Integer> sum(Map<String, Integer> a,Map<String, Integer> b)
	{
		Map<String, Integer> words = new HashMap<String, Integer>();
		for (String k : a.keySet()) {
			words.put(k, a.get(k));
		}
		for(String k:b.keySet())
		{
			if(words.get(k)!=null)
			{
				words.put(k, words.get(k)+b.get(k));
			}else
			{
				words.put(k, b.get(k));
			}
		}
		return words;
	}
	public static void main(String[] args) {
		List<String> fileNames = Arrays
				.asList("a1.txt", "a2.txt", "a3.txt", "a4.txt");
		
		Timer.timeit(()->fileNames
				.stream()
				.map(Test::countWords)
				.reduce(Test::sum)
				.ifPresent(System.out::println));
		Timer.timeit(()->fileNames
				.parallelStream()
				.map(Test::countWords)
				.reduce(Test::sum)
				.ifPresent(System.out::println));

	}

}
