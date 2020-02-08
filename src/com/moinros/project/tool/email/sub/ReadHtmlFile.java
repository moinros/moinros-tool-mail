package com.moinros.project.tool.email.sub;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 类注释: 读取HTML文件
 *
 * @Author moinros
 * @Date 2020年1月4日 下午9:54:35
 * @Version 1.0
 */
public class ReadHtmlFile {

    private ReadHtmlFile() {}

    private static final Map<String, String> HTMLS = new Hashtable<>();

    /**
     * 注释: 获取邮件的html模板
     */
    public static String getHtmlTemplate(String htmlPath) {
        String html = HTMLS.get(htmlPath);
        if (html == null) {
            return readHtmlFile(htmlPath);
        } else {
            return html;
        }
    }

    /**
     * 注释: 读取邮件的HTML模板
     *
     * @param htmlPath html模板路径
     */
    private static String readHtmlFile(String htmlPath) {
        InputStream is = null;
        StringBuffer sb = new StringBuffer();
        is = ReadHtmlFile.class.getClassLoader().getResourceAsStream(htmlPath);
        int dataLength = 0;
        byte[] by = new byte[1024];
        try {
            while ((dataLength = is.read(by)) != -1) {
                sb.append(new String(by, 0, dataLength, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 注释: 读取邮件的HTML模板
     *
     * @param htmlPath html模板路径
     * @param param    模板中的动态参数
     * @return String HTML模板
     */
    public static String readHtmlFile(String htmlPath, Map<String, String> param) {
        return replaceHtmlTemplate(getHtmlTemplate(htmlPath), param);
    }

    /**
     * 注释: 替换HTML模板中的动态参数
     *
     * @param html  html模版
     * @param param 模板中的动态参数
     * @return String HTML模板
     */
    public static String replaceHtmlTemplate(String html, Map<String, String> param) {
        Set<Entry<String, String>> set = param.entrySet();
        for (Entry<String, String> entry : set) {
            html = html.replace(entry.getKey(), entry.getValue());
        }
        return html;
    }
}
