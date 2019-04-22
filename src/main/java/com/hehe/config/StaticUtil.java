package com.hehe.config;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StaticUtil {

    public static void makeBeetl(String objectName, Object objectValue, String oldFileName, String newFileName, HttpServletRequest request){
        try{
            String root = System.getProperty("user.dir") + File.separator + "/src/main/resources/templates";
            FileResourceLoader fileResourceLoader = new FileResourceLoader(root,"UTF-8");
            Configuration cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(fileResourceLoader,cfg);

            //共享变量
            Map<String,Object> shared = new HashMap<String,Object>();
            //获取项目根目录
            String path = System.getProperty("user.dir");
            shared.put("path", path);
            gt.setSharedVars(shared);

            Template t = gt.getTemplate("/" + oldFileName + ".html");
            t.binding("ctxPath",request.getContextPath());
            t.binding(objectName,objectValue);



            StringWriter stringWriter = new StringWriter();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path + "/src/main/resources/static/" + newFileName + ".html",false),"UTF-8");

            t.renderTo(stringWriter);
            outputStreamWriter.write(stringWriter.toString());
            outputStreamWriter.flush();
            outputStreamWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
