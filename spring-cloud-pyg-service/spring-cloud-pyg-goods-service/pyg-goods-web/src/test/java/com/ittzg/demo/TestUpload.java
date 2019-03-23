package com.ittzg.demo;

import com.alibaba.fastjson.JSON;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.*;

/**
 * @Author: ittzg
 * @CreateDate: 2019/2/27 22:24
 * @Description:
 */
public class TestUpload {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
//        final String url = "http://localhost:8888/cmfz-tzg/guru/upload";
//        //设置请求头
//        HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType("multipart/form-data");
//        headers.setContentType(type);
//
//        //设置请求体，注意是LinkedMultiValueMap
//        FileSystemResource fileSystemResource = new FileSystemResource("J:\\c05728956b93974393ab0813811a74d4.jpg");
//        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
//        form.add("file", fileSystemResource);
//        //用HttpEntity封装整个请求报文
//        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);
//
//        String s = restTemplate.postForObject(url, files, String.class);
//        System.out.println(s);
        InputStream inputStream = null;
        OutputStream outputStream = null;

        final String url = "http://localhost:8080/file/download?fileName=用户地区分布.png";
        HttpHeaders headers = new HttpHeaders();
        List<String> mediaTypes = Arrays.asList(MediaType.TEXT_XML_VALUE,MediaType.APPLICATION_XHTML_XML_VALUE);
        headers.setAccessControlAllowHeaders(mediaTypes);
        try {
            LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
            ResponseEntity<BaseResult> forEntity = restTemplate.getForEntity(url, BaseResult.class);

//
//            ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Map<String, byte[]>>(headers), Map.class);
            System.out.println(JSON.toJSON(forEntity.toString()));

            System.out.println(forEntity.getHeaders());
            System.out.println(forEntity.getStatusCodeValue());

//            byte[] result = forEntity.getBody();
            byte[] result = {'a','b'};
            String str = new String(result);
            System.out.println(str);
//            System.out.println(body.getMsg());
            inputStream = new ByteArrayInputStream(result);

            outputStream = new FileOutputStream(new File("J://sasas.png"));

            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
            System.err.println("文件获取成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("数据流关闭异常！");
            }
        }

    }
}
