package com.example.shang.iteratordemo;

/**
 * Created by shang on 2017/12/4.
 */

// 客户类
public class Client {
    public static void main(String []args){
        // 容器
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("hello");
        aggregate.add("hi");
        aggregate.add("byebye");
        // 容器的迭代器
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
