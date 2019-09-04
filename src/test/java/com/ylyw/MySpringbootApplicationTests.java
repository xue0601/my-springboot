package com.ylyw;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringbootApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void postParams() {
		// 获取连接客户端工具
		CloseableHttpClient httpClient = HttpClients.createDefault();

		String entityStr = null;
		CloseableHttpResponse response = null;

		try {

			// 创建POST请求对象
			HttpPost httpPost = new HttpPost("http://www.baidu.com");

        /*
         * 添加请求头信息
         */
			// 浏览器表示
			httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
			// 传输的类型
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
			httpPost.addHeader("token","123456789");

			// 执行请求
			response = httpClient.execute(httpPost);
			// 获得响应的实体对象
			HttpEntity entity = response.getEntity();
			// 使用Apache提供的工具类进行转换成字符串
			entityStr = EntityUtils.toString(entity, "UTF-8");
			System.out.println("---------------------------------");
			 System.out.println(Arrays.toString(response.getAllHeaders()));
			System.out.println("---------------------------------");

		} catch (ClientProtocolException e) {
			System.err.println("Http协议出现问题");
			e.printStackTrace();
		} catch (ParseException e) {
			System.err.println("解析错误");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO异常");
			e.printStackTrace();
		} finally {
			// 释放连接
			if (null != response) {
				try {
					response.close();
					httpClient.close();
				} catch (IOException e) {
					System.err.println("释放连接出错");
					e.printStackTrace();
				}
			}
		}

		// 打印响应内容
		System.out.println(entityStr);
	}

}
