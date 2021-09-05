package com.knowledge.tongyaxi.Collection.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TreeMapTest {
	
	private static Logger logger = Logger.getLogger(TreeMapTest.class);

	//向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序 、定制排序
    //自然排序
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test01() {
		TreeMap treeMap = new TreeMap();
		
		User user1 = new User("Tom",23);
		User user2 = new User("Jerry",26);
		User user3 = new User("Kimi",77);
		User user4 = new User("Kate",66);
		
		treeMap.put(user1, 98);
		treeMap.put(user2, 99);
		treeMap.put(user3, 23);
		treeMap.put(user4, 44);
		
		Set set = treeMap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			Map.Entry entry = (Map.Entry)obj;
			logger.info(entry.getKey() + "----" + entry.getValue());
		}
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	// 定制排序
	@Test
	public void test02() {
		TreeMap treeMap = new TreeMap(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				//按照年龄从小到大排列
				if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配！");
			}
			
		});
		
		User user1 = new User("Tom",23);
		User user2 = new User("Jerry",32);
		User user3 = new User("Kimi",20);
		User user4 = new User("Kate",18);
		
		treeMap.put(user1, 98);
		treeMap.put(user2, 99);
		treeMap.put(user3, 23);
		treeMap.put(user4, 44);
		
		Set set = treeMap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			Map.Entry entry = (Map.Entry)obj;
			logger.info(entry.getKey() + "----" + entry.getValue());
		}
	}
	
	
}
