package com.yiwu.order_center_server.test;

/**
 * @Author: fuzf
 * @Date: 2020/11/4 19:53
 */
public class ThreadLocalTest {

    private static ThreadLocal<User> threadLocal = new ThreadLocal<User>(){
        @Override
        protected User initialValue() {
            return new User("fuzifeng", 18);
        }
    };


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new TestThread().start();
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "----" + threadLocal.get());

    }

    static class TestThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                User user = threadLocal.get();
                user.name = Thread.currentThread().getName();
                user.age = i;
                threadLocal.set(user);
                System.out.println(threadLocal.get());
            }
        }
    }
}

class User{
    public String name;
    public Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}