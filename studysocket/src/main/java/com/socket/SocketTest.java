package com.socket;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author cyq
 * @date 2020-05-12
 */
public class SocketTest {
    public static void main(String[] args) {
        File file = new File("E:\\quickfix配置.txt");
       Properties properties = System.getProperties();
        ArrayList arrayList = new ArrayList(Arrays.asList(properties.toString().split(",")));
        for (Object o : arrayList) {
            System.out.println(o);
        }
//        try {
//            InputStream inputStream = new FileInputStream(file);
//            Reader reader = new InputStreamReader(inputStream,"GBK");
//            char[] bytes = new char[1024];
//            int a = reader.read(bytes);
//            System.out.println("");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
