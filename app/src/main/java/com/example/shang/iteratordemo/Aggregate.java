package com.example.shang.iteratordemo;

/**
 * Created by shang on 2017/12/4.
 */

// 容器接口
public interface Aggregate<T> {
    // 添加一个元素
    void add(T t);
    // 移除一个元素
    void remove(T t);
    // 获取容器的迭代器
    Iterator<T> iterator();
}
