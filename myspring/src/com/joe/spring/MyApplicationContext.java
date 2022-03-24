package com.joe.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Arrays;

/**
 * @Author: fuzf
 * @Date: 2022/3/24 22:52
 */

public class MyApplicationContext {
    //容器

    private Class configClass;

    public MyApplicationContext(Class configClass) {
        this.configClass = configClass;

        //扫描
        if(configClass.isAnnotationPresent(ComponentScan.class)){
            ComponentScan annotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = annotation.value(); //扫描路径 com.joe.service，真正扫描的是编译好的class文件

            path = path.replace(".", "/"); //相对路径 com/joe/service

            ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path); //资源为service
//            System.out.println(resource);

            File file = new File(resource.getFile());
            System.out.println(file);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                Arrays.stream(files).forEach(v->{
                    String fileName = v.getAbsolutePath();
                    System.out.println(fileName);
                    if (fileName.endsWith(".class")) {
                        String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                        System.out.println("className:" + className);
                        className = className.replace("\\", ".");
                        System.out.println("className:" + className);
                        try {
                            Class<?> clazz = classLoader.loadClass(className);
                            if (clazz.isAnnotationPresent(Component.class)) {
                                //说明是个bean
                                System.out.println("className:" + className+" 是个bean");

                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                    }

                });
            }

        }
    }

    public Object getBean(String beanName) {

        return null;
    }
}
