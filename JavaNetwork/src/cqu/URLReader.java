package cqu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {
		URL cqu = new URL("http://www.cqu.edu.cn/");
		BufferedReader in = new BufferedReader(new InputStreamReader(cqu.openStream(),"GBK"));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
	    		System.out.println(inputLine);
		in.close();
  } 
 }
