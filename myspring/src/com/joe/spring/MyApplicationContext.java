package com.joe.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器
 * @Author: fuzf
 * @Date: 2022/3/24 22:52
 */

public class MyApplicationContext {


    private Class configClass;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

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
                                System.out.println("className:" + className + " 是个bean");

                                Component component = clazz.getAnnotation(Component.class);
                                String beanName = component.value();
                                //如果Component注解没有自定义名字，那么使用默认名字
                                if (beanName.equals("")) {
                                    beanName = Introspector.decapitalize(clazz.getSimpleName());
                                }

                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(clazz);
                                //查看此bean的作用域
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    Scope scope = clazz.getAnnotation(Scope.class);
                                    beanDefinition.setScope(scope.value());
                                } else {
                                    //否则是单例
                                    beanDefinition.setScope("singleton");
                                }
                                beanDefinitionMap.put(beanName, beanDefinition);

                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }
        }

        //扫描完之后 实例化 单例bean
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {

        Class clazz = beanDefinition.getType();
        try {
            Object object = clazz.getConstructor().newInstance();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new NullPointerException();
        } else {
            String scope = beanDefinition.getScope();
            //单例
            if ("singleton".equals(scope)) {
                Object object = singletonObjects.get(beanName);
                if (object == null) {
                    //创建
                    Object bean = createBean(beanName, beanDefinition);
                    singletonObjects.put(beanName, bean);
                }
                return object;
            } else {
                //多例
                return createBean(beanName, beanDefinition);
            }
        }

    }
}
