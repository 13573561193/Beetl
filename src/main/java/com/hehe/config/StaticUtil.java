package com.hehe.config;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StaticUtil {

    public static void makeBeetl(String objectName,Object objectValue,String oldFileName,String newFileName){
        try{
            String root = System.getProperty("user.dir") + File.separator + "/src/main/resources/templates";
            FileResourceLoader fileResourceLoader = new FileResourceLoader(root,"GBK");
            Configuration cfg = Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(fileResourceLoader,cfg);
            Template t = gt.getTemplate("/" + oldFileName + ".html");
            t.binding(objectName,objectValue);
            FileWriter fileWriter = new FileWriter("d:/S/springboot-beetl/src/main/resources/templates/" + newFileName + ".html");
            t.renderTo(fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
