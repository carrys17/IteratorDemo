 # IteratorDemo

# 迭代器模式

迭代器模式，又称为游标模式，是行为型设计模式之一。迭代器模式算是一个比较古老的设计模式，源于对容器的访问，比如java中的List、Map、数组等。

### 定义：

 提供一种方法顺序访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示。

 
### 使用场景：

 遍历一个容器对象时

### UML类图：

![](https://i.imgur.com/6DMLQwP.png)


### 代码清单：

 迭代器接口

	public interface Iterator<T> {
	    // 是否有下一个元素
	    boolean hasNext();
	
	    //  返回当前元素并将位置移至下一位
	    T next();
	}


 具体迭代器类

	public class ConcreteIterator<T> implements Iterator<T> {
	
	    private List<T> list = new ArrayList<>();
	    private int cursor = 0;
	
	    public ConcreteIterator(List<T> list) {
	        this.list = list;
	    }
	
	    @Override
	    public boolean hasNext() {
	        return cursor!=list.size();
	    }
	
	    @Override
	    public T next() {
	        T obj = null;
	        if (this.hasNext()){
	            obj = this.list.get(cursor++);
	        }
	        return obj;
	    }
	}



 容器接口

	public interface Aggregate<T> {
	    // 添加一个元素
	    void add(T t);
	    // 移除一个元素
	    void remove(T t);
	    // 获取容器的迭代器
	    Iterator<T> iterator();
	}

 具体容器类
	
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

 客户类

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

### 角色介绍：

Iterator：迭代器接口。负责定义、访问和遍历元素的接口。

ConcreteIterator： 具体迭代器类。目的主要是实现迭代器接口，并记录遍历的当前位置。

Aggregate：容器接口。 负责提供创建具体迭代器角色的接口。

ConcreteAggregate：具体容器类。具体迭代器角色与该容器相关联。

Client：客户类。


#### Android中的使用：

典型的就是数据库查询使用的Cursor


#### 小结：

迭代器发展到今，几乎每一种高级语言都有对应的内置实现。

