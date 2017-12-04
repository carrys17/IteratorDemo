package com.example.shang.iteratordemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shang on 2017/12/4.
 */

// 具体容器类
public class ConcreteAggregate<T> implements Aggregate<T> {

    private List<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<T>(list);
    }
}
