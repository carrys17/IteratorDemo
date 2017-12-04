package com.example.shang.iteratordemo;

/**
 * Created by shang on 2017/12/4.
 */

// 迭代器接口
public interface Iterator<T> {
    // 是否有下一个元素
    boolean hasNext();

    //  返回当前元素并将位置移至下一位
    T next();
}
