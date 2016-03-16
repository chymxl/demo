package com.demo.service;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.entity.UserInfo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestUserService {
	
	private static final Logger LOGGER = Logger.getLogger(TestUserService.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testQueryById(){
		UserInfo userInfo = userService.getUserInfoById(1);
		LOGGER.info(JSON.toJSON(userInfo));
	}
	
	@Test
	public void testQueryAll(){
		List<UserInfo> userInfos = userService.getUsers();
		LOGGER.error(userInfos);
	}
	
	@Test
	public void testInsert(){
		UserInfo userInfo = new UserInfo();
		userInfo.setId(2);
		userInfo.setUname("jack");
		userInfo.setUnumber(2);
		int ret = userService.insert(userInfo);
		System.out.println(ret);
	}
	
	@Test
	public void testZxing() throws Exception{
		String filePath = "D://";  
        String fileName = "zxing.png";  
        JSONObject json = new JSONObject();  
        json.put(  
                "zxing",  
                "https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");  
        json.put("author", "shihy");  
        String content = json.toJSONString();// 内容  
        content = "http://20.1.78.40:8080/address";
        int width = 200; // 图像宽度  
        int height = 200; // 图像高度  
        String format = "png";// 图像类型  
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,  
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵  
        Path path = FileSystems.getDefault().getPath(filePath, fileName);  
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像  
        System.out.println("输出成功.");  
	}

}
