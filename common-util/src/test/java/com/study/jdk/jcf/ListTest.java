package com.study.jdk.jcf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * set的存储特点为无序和互异，
 * list的存储特点为有序和存异。
 */
public class ListTest {

    public static final Logger logger = LoggerFactory.getLogger(ListTest.class);

    public static void main(String[] args) {
        final Vector<Integer> data = new Vector<>();
        final int length = 1000;
//
//        for(int i = 0; i < length; i++){
//            if(data.isEmpty()){
//                data.add(1);
//            } else {
//                data.add(data.get(data.size()-1)+1);
//            }
//        }

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < length; i++){
                    if(data.isEmpty()){
                        data.add(1);
                    } else {
                        data.add(data.get(data.size()-1)+1);
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < length; i++){
                    if(data.isEmpty()){
                        data.add(1);
                    } else {
                        data.add(data.get(data.size()-1)+1);
                    }
                }
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        for(Integer i : data){
            System.out.println("===>"+i);
        }
    }

    @Test
    public void test_ArrayList(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        for(String str : list){
            System.out.println(str);
        }
    }

    @Test
    public void test_LinkedList(){
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        for(String str : list){
            System.out.println(str);
        }
    }

    /**
     * Vector非常类似ArrayList，但是Vector是同步的。
     */
    @Test
    public void test_Vector(){
        Vector<String> vector = new Vector();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("3");
        for(String str : vector){
            System.out.println(str);
        }
    }

    /**
     * Stack继承自Vector，实现一个后进先出的堆栈。
     */
    @Test
    public void test_Stack(){
        Stack<String> stack = new Stack<>() ;
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("3");
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    @Test
    public void test(){
        String str = "1";
        System.out.println(str.hashCode());
    }
}
