package com.i18n;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * @program: my-springboot
 * @description: 国际化
 * @author: Xue0601
 * @create: 2018-12-24 17:43
 **/

public class PropertiesInfo {
    /**
     * PropertiesInfo实例
     */
    private static PropertiesInfo pi = null;

    private static ResourceBundle resource;

    /**
     * 资源文件基名
     * 该资源文件应该放置在classpath下
     */
    private final String PROPERTIES_BASE_NAME = "MessageResources";
    private final String CHINA_BASE_NAME = "en_eng_US";

    /**
     * 构建资源文件对象
     *
     */
    private PropertiesInfo() {
        resource = ResourceBundle.getBundle(CHINA_BASE_NAME);
    }

    /**
     *  获取一个PropertiesInfo实例
     * @return PropertiesInfo
     */
    public static synchronized PropertiesInfo getInstance() {
        if(pi == null) {
            pi = new PropertiesInfo();
        }
        return pi;
    }

    /**
     * 根据资源文件的key读取值
     * @param key
     * @return String
     */
    public String getValue(String key) {
        return resource.getString(key);
    }

    /**
     * 根据资源文件的key读取值
     * @param key
     * @param args
     * @return String
     */
    public String getValue(String key, Object args[]) {
        return MessageFormat.format(resource.getString(key), args);
    }

    public static void main(String[] args) {
        PropertiesInfo propertiesInfo = new PropertiesInfo();
        String a = propertiesInfo.getValue("name");
        System.out.println(a);
    }
}
