package com.knowledge.tongyaxi.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Collection_API_Demo {

	public static void main(String[] args) {
		/**
		 * Collection 接口：
		 * 子接口：List  有序(存入和取出的顺序一致),可重复集，允许存放重复元素(并非是同一个元素，
		 *               而是指equals方法比较为true的元素。)
		 *         Set   无序,不可重复集.
		 *
		 * 集合中存储的都是引用类型的元素，那么引用类型变量实际上存储
		 * 的是对象的“地址”，所以实际上集合只存储了元素对象在堆中
		 * 的地址。而并不是将对象本身存入了集合中。
		 */
		//boolean add(E e)
		Collection<String> c = new ArrayList<String>();
		c.add("JAY");
		c.add("CHOU");
		System.out.println(c);   //[JAY, CHOU]
		//int size()
		int size = c.size();
		System.out.println(size);   //2
		//boolean isEmpty()
		boolean isEmpty = c.isEmpty();
		System.out.println(isEmpty);   //false
		//void clear()
		c.clear();
		System.out.println("清空过后集合个数"+c.size());
		System.out.println("是否不包含空集"+c.isEmpty());
		//boolean contains(E e)
		Collection<Point> collection = new ArrayList<Point>();
		collection.add(new Point(1,2));
		collection.add(new Point(2,2));
		System.out.println(collection);   //[(1,2), (2,2)]

		Point p = new Point(1,2);
		boolean contains = collection.contains(p);   //重写了equals,返回true
		System.out.println("是否包含："+contains);   //true

		//集合只存储了元素对象在堆中的地址。而并不是将对象本身存入了集合中。
		Collection<String> c1 = new ArrayList<String>();
		c1.add("1");
		c1.add("2");
		Collection<String> c2 = new ArrayList<String>();
		c2.add("3");

		//boolean addAll(C c);将给定集合中的所有元素添加到当前集合中。
		c1.addAll(c2);
		System.out.println(c1); //[1, 2, 3]

		Collection<String> c3 = new ArrayList<String>();
		c3.add("1");
		c3.add("2");
		//boolean containsAll(C c);判断当前集合是否包含给定集合中所有元素
		System.out.println(c1.containsAll(c3)); //true
		//boolean removeAll(C c); 删除当前集合中与给定集合的共有元素
		c1.removeAll(c3);
		System.out.println(c1);  //[3]

		/**
		 * Iterator 迭代器;迭代器是用来遍历集合元素的
		 * 遵循步骤：先问后取(适合while循环)
		 */
		Collection<String> c4 = new ArrayList<String>();
		c4.add("a");
		//c4.add("#");
		c4.add("b");
		//c4.add("#");
		c4.add("c");
		//c4.add("#");
		Iterator<String> it = c4.iterator();
		while(it.hasNext()){ //判断集合是否还有元素可以遍历。
			String str = (String)(it.next()); //返回迭代的下一个元素
			System.out.println(str);

			if("c".equals(str)){
				//迭代器的remove方法会将刚通过next方法获取的元素从集合中删除。
				it.remove();
				System.out.println(c4);
			}

		}

		/**
		 * boolean remove(E e)
		 * 将给定元素与集合中现有元素进行equals比较，删除equals比较为true的，若为多个仅删除一个。
		 */
		Collection<Point> c5 = new ArrayList<Point>();
		c5.add(new Point(1,2));
		c5.add(new Point(3,4));
		c5.add(new Point(5,6));
		c5.add(new Point(3,4));
		System.out.println(c5);

		Point p1 = new Point(3,4);
		c5.remove(p1);
		System.out.println(c5);//[(1,2), (5,6), (3,4)]

		/**
		 * List:提供了一系列基于下标的操作.
		 *      List集合就是对元素的增删改查.
		 */
		List<String> list = new ArrayList<String>();
		list.add("list");
		list.add("可重复");
		list.add("且有序");
		//E get(int index);
		String str2 = list.get(2);
		System.out.println(str2);
		//get方法遍历List集合.
		for(int i=0;i<list.size();i++){
			str2 = list.get(i);
			System.out.println(str2);
		}
		//E set (int index,E e);将给定的元素设置到指定的元素位置。--替换元素操作
		String old = list.set(1, "可可重复");
		System.out.println(list);
		System.out.println("old:"+old);
		//List subList(int start,int end);--截取子集
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list1.add(i);
		}
		System.out.println(list1);
		List<Integer> subList = list1.subList(1, 7);
		System.out.println(subList); //[1, 2, 3, 4, 5, 6]
		//对子元素操作就是对元集合中对应元素操作
		for(int i=0;i<subList.size();i++){
			int num = subList.get(i);
			num=num*10;
			subList.set(i, num);
		}
		System.out.println(subList);
		//E add(int index,element).将给定元素插入到指定位置.
		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add(1, "3");
		System.out.println(list2);
		//E remove(int index).删除并返回指定位置对应的元素.
		String old1 = list2.remove(0);
		System.out.println(list2);
		System.out.println(old1);

		/**
		 * 泛型在集合中的应用，用来约束集合中元素的类型.
		 */
		Collection<String> c6 = new ArrayList<String>();
		c6.add("泛型");
		c6.add("约束");
		c6.add("集合");
		//新循环遍历----for each;增强for循环;--遍历集合或数组。
		//新循环遍历集合就是迭代器在遍历集合，编译器只认识迭代器.
		for(String str:c6){
			System.out.println(str);
		}
		//迭代器遍历(先问后取)
		Iterator<String> it1 = c6.iterator();
		while(it1.hasNext()){
			String str1 = it1.next();
			System.out.println(str1);
		}
		/**
		 * collections是集合的工具类，提供了很多便于操作集合的方法.
		 */
		//static void sort(List list);.
		List<Integer> list3 = new ArrayList<Integer>();
		Random random = new Random();
		for(int i=0;i<10;i++){
			list3.add(random.nextInt(10));
		}
		System.out.println(list3);
		Collections.sort(list3);
		System.out.println(list3);

		/**
		 * 集合-->数组
		 * Collection提供了相应的方法
		 */
		Collection<String> c7 = new ArrayList<String>();
		c7.add("one");
		c7.add("two");
		c7.add("three");
		String[] array = c7.toArray(new String[c7.size()]);
		for(String s:array){
			System.out.println(s);
		}
		/**
		 * 数组-->集合
		 * 数组的工具类:Arrays的静态方法asList
		 */
		String[] array1 = {"one","two","three","four",};
		List<String> list4 = Arrays.asList(array);

		System.out.println(list4.size());
		System.out.println(list4);
		/*
		 * 修改集合元素就是修改对应的数组的元素
		 */
		list4.set(1, "2");
		System.out.println(list4);
		for(String str: array1){
			System.out.println(str);
		}

		/*
		 * 数组转换的集合不能添加新元素
		 * 添元素就意味着对原数组进行扩容，那么就不能表示原数组，所以
		 * 不支持此操作
		 */
		//list.add("five");
		//System.out.println(list);
		/*
		 * 想添加新元素必须额外创建一个List
		 */
		List<String> list5 = new ArrayList<String>(list4);
		//list1.addAll(list);
		list5.add("five");
		System.out.println(list5);

		/**
		 * Collections.sort(List list)
		 */
		/*
		 * Collections.sort(List list)
		 * 该方法要求集合中的元素必须可以比较大小
		 * 即:元素必须实现Comparable接口
		 */
		List<Point2> list6 = new ArrayList<Point2>();
		list6.add(new Point2(4,2));
		list6.add(new Point2(2,3));
		list6.add(new Point2(2,5));
		System.out.println(list6);

		Collections.sort(list6);
		//根据compareTo返回值来判断大小从而进行自然排序;
		System.out.println(list6);
		/*
		 * 该接口要求元素必须重写抽象方法comparaeTo(),此方法定义了当前对象与
		 * 参数给定对象间的比较规则;
		 * 此方法返回整数，该整数不关注具体值,只关注取值范围.
		 * 当返回值>0：当前对象大于参数对象（this>o）
		 * 当返回值<0：当前对象小于参数对象
		 * 当返回值=0：两个对象相等
		 */

		/*
		 * Collections.sort(List list);
		 * 该方法在排序自定义元素的集合时对我们的代码具有"入侵性";
		 * 即:当我们需要使用某个功能时，而该功能要求我们为其修改代码
		 * 修改的越多入侵性越强.如果该功能不在需要时，之前修改的代码
		 * 就不具有存在意义，增加后期维护成本.
		 *
		 * 如果希望在排序的操作中临时指定比较规则，可以采用Comparator接口回调的方式。
		 * Collections提供了一个重载sort的方法，该方法要求提供
		 * 一个额外的比较规则，该比较规则是“比较器，Comparator”.
		 *
		 * 使用该方法可以解决:
		 * 1.sort方法要求排序元素必须实现Comparable接口,而该方法不需要。
		 *   所以对元素没有入侵性.
		 * 2.java提供的类需要排序时由于已经实现了Comparable接口并定义
		 *   比较规则，但通过该方法可以传入额外的比较规则.
		 *
		 */
		List<String> list7 = new ArrayList<String>();
		list7.add("童雅茜");
		list7.add("仝亚西");
		list7.add("地表最强");
		list7.add("啊");
		System.out.println(list7);

		Collections.sort(list7, new Comparator<String>(){
			public int compare(String o1,String o2){
				return o1.length()-o2.length();
			}
		});
		System.out.println(list7);

		/**
		 * Queue:队列-常用的数据结构-特殊的线性表.-限制了对线性表的访问方式。
		 * 实现类:LinkedList--Queue经常要进行插入和删除的操作,LinkedList可以
		 * 存一组元素.并且由于链表的特性,首尾增删元素效率好。
		 *
		 */
		/*
		 * boolean offer(E e)  入队操作,想队列末尾追加给定元素.
		 */
		Queue<String> queue = new LinkedList<String>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		System.out.println(queue);
		/*
		 * E poll()  出队操作,获取并从队列中删除首元素
		 */
		String str = queue.poll();
		System.out.println(queue);//[two, three]
		System.out.println(str);//one
		/*
		 * E peek()  引用队首元素，截取队首元素，该元素不做出队操作
		 */
	    str = queue.peek();
		System.out.println(str);//two
		System.out.println(queue);//[two, three]

		for(String s:queue){
			System.out.println(s);
		}
		System.out.println(queue);

		while(queue.size()>0){//遍历完为空
			str = queue.poll();
			System.out.println(str);
		}
		System.out.println(queue);

		/**
		 * Deque:Queue的子接口
		 *     "双端队列":从队列的两端分别可以入队(offer),出队(poll),LinkedList实现；
		 */
		Deque<String> deque = new LinkedList<String>();
		deque.offer("one");
		deque.offer("two");

		deque.offerFirst("three");
		System.out.println(deque);

		deque.offerLast("four");
		System.out.println(deque);//[three, one, two, four]

		deque.pollFirst();
		System.out.println(deque);

		deque.pollLast();
		System.out.println(deque);
		/**
		 * 如果将Deque限制为只能从一端入队和出队,则可实现"栈"(stack)的数据结构;
		 * 对于栈:先进后出  (通常使用栈来完成“后退”功能。)
		 *    入栈:push
		 *    出栈:pop
		 */
		Deque<String> stack = new LinkedList<String>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		System.out.println(stack);//[three, two, one]
		String s = stack.pop();
		System.out.println(s);//three
		System.out.println(stack);

		/**
		 * Map:以键值对(key-value)的形式存储数据的数据结构.
		 *     多行两列的表格.
		 *     要求:key不能重复(不能包含两个equals为true的key)
		 *          通常会用泛型去约束key与value的类型.
		 *     实现类:java.util.HashMap  (散列表) 散列算法实现
		 */
		/*
		 * V put(K k,V v)
		 */
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("赵信", 6300);
		map.put("寒冰", 480);
		System.out.println(map);
		//相同的key是替换value的操作
		//返回值就是被替换的value的值
		//value值的类型是包装类
		Integer num = map.put("寒冰", 6300);
		System.out.println(num);//480
		System.out.println(map);

		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value值
		 */
		num = map.get("寒冰");
		System.out.println(num);//6300
	    num = map.get("小炮");
	    System.out.println(num);//null

	    /*
	     * V remove(K k)
	     * 将给定的kay所对应的kay-value从map中删除,返回值是该key所对应的value值
	     */
	    Integer od = map.remove("寒冰");
	    System.out.println(od);//6300
	    System.out.println(map);//{赵信=6300}

	    /**
	     * Map的遍历:1.遍历所有的key;2.遍历所有的value;3.遍历每一组键值对;
	     */
	    Map<String,Integer> map1 = new HashMap<String,Integer>();
	    map1.put("剑圣", 6300);
		map1.put("莫甘娜", 6300);

		/*
	     * 1.遍历所有的key: Set<K> keySet()
	     *   将当前Map中所有的key,存入一个Set集合中将其返回.
	     *   遍历该集合就是遍历所有的key.
	     */
	    Set<String> keySet = map1.keySet();
	    for(String key:keySet){
	    	System.out.println(key);
	    }
	    /*
	     * 2.遍历所有的values; Collection values()
	     *   将当前Map中的所有value存入到一个集合并返回.
	     */
	    Collection<Integer> values = map1.values();
	    for(Integer value:values){
	    	System.out.println(value);
	    }
	    /*
	     * 3.遍历每一组键值对; Set<Entry> entrySet()
	     *   将当前Map中每一组键值对(Entry实例)存入一个集合并返回.
	     *   java.util.MapEntry;
	     *   该类的每一个实例用于表示Map中的键值对.
	     */
	    Set<Entry<String,Integer>> entrySet = map1.entrySet();
	    for(Entry<String,Integer> entry:entrySet){
	    	System.out.println(entry);
	    }
	    /**
	     * HashMap:HashMap的存取是依赖于key的hashCode方法的返回值.
	     *         hashCode方法实际上在Object中的定义.
	     *         在HashMap的应用中,key元素的equals方法与hashCode方法直接影响着散列表
	     *         的查询性能.而这两个方法是Object定义的.手册上明确说明,当我们需要重写
	     *         时,两个方法应当遵循:
	     *         1.成对重写,即:当重写一个类的equals方法时就应当连同重写hashCode;
	     *         2.equals与hashCode应当具有一致性,即:两个对象equals比较为true时,
	     *           hasnCode方法返回的数字应当相同.反过来也如此.虽然不是必须的,但
	     *           尽量保持当两个对象hashCode方法返回值相等时equals也应当为true,
	     *           否则会在HasnMap中产生链表影响查询性能。
	     *         3.hashCode方法的值应当是稳定的,即:在当前对象参与equals比较的属性
	     *           值没有发生改变的前提下,多次调用hashCode方法返回的数字应当相同。
	     */

	}

}

