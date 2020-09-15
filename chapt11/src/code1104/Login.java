/**
 * 
 */
package code1104;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Login.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */

public class Login {
	public static void main(String[] args) {
		try {
			// 验证登录的网页URL
			URL url = new URL("http://localhost:8088/webapp/action.jsp");
			// 打开该网页的URL连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置该网页连接可以向服务器发送信息
			conn.setDoOutput(true);
			// 设置请求的提交方式
			conn.setRequestMethod("POST");
			// 向服务器发送包含用户名称和密码的登录认证查询串
			conn.getOutputStream().write("username=a&password=a".getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();
			// 获取网页的标头信息中的Cookie字符串
			String cookieVal = conn.getHeaderField("Set-Cookie");
			// 连接服务器
			conn.connect();
			conn.disconnect();

			// 主网页的URL
			url = new URL("http://localhost:8088/webapp/index.jsp");
			// 打开该网页的URL连接
			conn = (HttpURLConnection) url.openConnection();
			// 设置当前连接的Cookie信息和上次连接的Cookie信息一致，维持同一会话状态
			conn.setRequestProperty("Cookie", cookieVal);
			// 获取服务器的主页返回结果
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			// 输出主页结果
			String line;
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
			rd.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
