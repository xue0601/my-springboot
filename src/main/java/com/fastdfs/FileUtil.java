package com.fastdfs;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-11-30 11:52
 **/

public class FileUtil {

    /**
     * Description: 获取文件后缀名
     *
     * @param fileName
     * @return
     * @see
     */
    public static String getExtensionName(String fileName) {
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return prefix;
    }

    /**
     * 根据path获取文件名
     *
     * @param filename
     * @return
     * @author kokJuis
     * @version 1.0
     * @date 2016-12-12
     */
    public static String getOriginalFilename(String filename) {
        if (filename == null) {return "";}
        int pos = filename.lastIndexOf("/");
        if (pos == -1) {pos = filename.lastIndexOf("\\");}
        if (pos != -1){ return filename.substring(pos + 1);}
        else {return filename;}
    }

}
