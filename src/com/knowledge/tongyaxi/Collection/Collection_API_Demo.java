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
		 * Collection �ӿڣ�
		 * �ӽӿڣ�List  ����(�����ȡ����˳��һ��),���ظ������������ظ�Ԫ��(������ͬһ��Ԫ�أ�
		 *               ����ָequals�����Ƚ�Ϊtrue��Ԫ�ء�)
		 *         Set   ����,�����ظ���.
		 *
		 * �����д洢�Ķ����������͵�Ԫ�أ���ô�������ͱ���ʵ���ϴ洢
		 * ���Ƕ���ġ���ַ��������ʵ���ϼ���ֻ�洢��Ԫ�ض����ڶ���
		 * �ĵ�ַ���������ǽ�����������˼����С�
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
		System.out.println("��չ��󼯺ϸ���"+c.size());
		System.out.println("�Ƿ񲻰����ռ�"+c.isEmpty());
		//boolean contains(E e)
		Collection<Point> collection = new ArrayList<Point>();
		collection.add(new Point(1,2));
		collection.add(new Point(2,2));
		System.out.println(collection);   //[(1,2), (2,2)]

		Point p = new Point(1,2);
		boolean contains = collection.contains(p);   //��д��equals,����true
		System.out.println("�Ƿ������"+contains);   //true

		//����ֻ�洢��Ԫ�ض����ڶ��еĵ�ַ���������ǽ�����������˼����С�
		Collection<String> c1 = new ArrayList<String>();
		c1.add("1");
		c1.add("2");
		Collection<String> c2 = new ArrayList<String>();
		c2.add("3");

		//boolean addAll(C c);�����������е�����Ԫ����ӵ���ǰ�����С�
		c1.addAll(c2);
		System.out.println(c1); //[1, 2, 3]

		Collection<String> c3 = new ArrayList<String>();
		c3.add("1");
		c3.add("2");
		//boolean containsAll(C c);�жϵ�ǰ�����Ƿ������������������Ԫ��
		System.out.println(c1.containsAll(c3)); //true
		//boolean removeAll(C c); ɾ����ǰ��������������ϵĹ���Ԫ��
		c1.removeAll(c3);
		System.out.println(c1);  //[3]

		/**
		 * Iterator ������;��������������������Ԫ�ص�
		 * ��ѭ���裺���ʺ�ȡ(�ʺ�whileѭ��)
		 */
		Collection<String> c4 = new ArrayList<String>();
		c4.add("a");
		//c4.add("#");
		c4.add("b");
		//c4.add("#");
		c4.add("c");
		//c4.add("#");
		Iterator<String> it = c4.iterator();
		while(it.hasNext()){ //�жϼ����Ƿ���Ԫ�ؿ��Ա�����
			String str = (String)(it.next()); //���ص�������һ��Ԫ��
			System.out.println(str);

			if("c".equals(str)){
				//��������remove�����Ὣ��ͨ��next������ȡ��Ԫ�شӼ�����ɾ����
				it.remove();
				System.out.println(c4);
			}

		}

		/**
		 * boolean remove(E e)
		 * ������Ԫ���뼯��������Ԫ�ؽ���equals�Ƚϣ�ɾ��equals�Ƚ�Ϊtrue�ģ���Ϊ�����ɾ��һ����
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
		 * List:�ṩ��һϵ�л����±�Ĳ���.
		 *      List���Ͼ��Ƕ�Ԫ�ص���ɾ�Ĳ�.
		 */
		List<String> list = new ArrayList<String>();
		list.add("list");
		list.add("���ظ�");
		list.add("������");
		//E get(int index);
		String str2 = list.get(2);
		System.out.println(str2);
		//get��������List����.
		for(int i=0;i<list.size();i++){
			str2 = list.get(i);
			System.out.println(str2);
		}
		//E set (int index,E e);��������Ԫ�����õ�ָ����Ԫ��λ�á�--�滻Ԫ�ز���
		String old = list.set(1, "�ɿ��ظ�");
		System.out.println(list);
		System.out.println("old:"+old);
		//List subList(int start,int end);--��ȡ�Ӽ�
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list1.add(i);
		}
		System.out.println(list1);
		List<Integer> subList = list1.subList(1, 7);
		System.out.println(subList); //[1, 2, 3, 4, 5, 6]
		//����Ԫ�ز������Ƕ�Ԫ�����ж�ӦԪ�ز���
		for(int i=0;i<subList.size();i++){
			int num = subList.get(i);
			num=num*10;
			subList.set(i, num);
		}
		System.out.println(subList);
		//E add(int index,element).������Ԫ�ز��뵽ָ��λ��.
		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add(1, "3");
		System.out.println(list2);
		//E remove(int index).ɾ��������ָ��λ�ö�Ӧ��Ԫ��.
		String old1 = list2.remove(0);
		System.out.println(list2);
		System.out.println(old1);

		/**
		 * �����ڼ����е�Ӧ�ã�����Լ��������Ԫ�ص�����.
		 */
		Collection<String> c6 = new ArrayList<String>();
		c6.add("����");
		c6.add("Լ��");
		c6.add("����");
		//��ѭ������----for each;��ǿforѭ��;--�������ϻ����顣
		//��ѭ���������Ͼ��ǵ������ڱ������ϣ�������ֻ��ʶ������.
		for(String str:c6){
			System.out.println(str);
		}
		//����������(���ʺ�ȡ)
		Iterator<String> it1 = c6.iterator();
		while(it1.hasNext()){
			String str1 = it1.next();
			System.out.println(str1);
		}
		/**
		 * collections�Ǽ��ϵĹ����࣬�ṩ�˺ܶ���ڲ������ϵķ���.
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
		 * ����-->����
		 * Collection�ṩ����Ӧ�ķ���
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
		 * ����-->����
		 * ����Ĺ�����:Arrays�ľ�̬����asList
		 */
		String[] array1 = {"one","two","three","four",};
		List<String> list4 = Arrays.asList(array);

		System.out.println(list4.size());
		System.out.println(list4);
		/*
		 * �޸ļ���Ԫ�ؾ����޸Ķ�Ӧ�������Ԫ��
		 */
		list4.set(1, "2");
		System.out.println(list4);
		for(String str: array1){
			System.out.println(str);
		}

		/*
		 * ����ת���ļ��ϲ��������Ԫ��
		 * ��Ԫ�ؾ���ζ�Ŷ�ԭ����������ݣ���ô�Ͳ��ܱ�ʾԭ���飬����
		 * ��֧�ִ˲���
		 */
		//list.add("five");
		//System.out.println(list);
		/*
		 * �������Ԫ�ر�����ⴴ��һ��List
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
		 * �÷���Ҫ�󼯺��е�Ԫ�ر�����ԱȽϴ�С
		 * ��:Ԫ�ر���ʵ��Comparable�ӿ�
		 */
		List<Point2> list6 = new ArrayList<Point2>();
		list6.add(new Point2(4,2));
		list6.add(new Point2(2,3));
		list6.add(new Point2(2,5));
		System.out.println(list6);

		Collections.sort(list6);
		//����compareTo����ֵ���жϴ�С�Ӷ�������Ȼ����;
		System.out.println(list6);
		/*
		 * �ýӿ�Ҫ��Ԫ�ر�����д���󷽷�comparaeTo(),�˷��������˵�ǰ������
		 * �������������ıȽϹ���;
		 * �˷�����������������������ע����ֵ,ֻ��עȡֵ��Χ.
		 * ������ֵ>0����ǰ������ڲ�������this>o��
		 * ������ֵ<0����ǰ����С�ڲ�������
		 * ������ֵ=0�������������
		 */

		/*
		 * Collections.sort(List list);
		 * �÷����������Զ���Ԫ�صļ���ʱ�����ǵĴ������"������";
		 * ��:��������Ҫʹ��ĳ������ʱ�����ù���Ҫ������Ϊ���޸Ĵ���
		 * �޸ĵ�Խ��������Խǿ.����ù��ܲ�����Ҫʱ��֮ǰ�޸ĵĴ���
		 * �Ͳ����д������壬���Ӻ���ά���ɱ�.
		 *
		 * ���ϣ��������Ĳ�������ʱָ���ȽϹ��򣬿��Բ���Comparator�ӿڻص��ķ�ʽ��
		 * Collections�ṩ��һ������sort�ķ������÷���Ҫ���ṩ
		 * һ������ıȽϹ��򣬸ñȽϹ����ǡ��Ƚ�����Comparator��.
		 *
		 * ʹ�ø÷������Խ��:
		 * 1.sort����Ҫ������Ԫ�ر���ʵ��Comparable�ӿ�,���÷�������Ҫ��
		 *   ���Զ�Ԫ��û��������.
		 * 2.java�ṩ������Ҫ����ʱ�����Ѿ�ʵ����Comparable�ӿڲ�����
		 *   �ȽϹ��򣬵�ͨ���÷������Դ������ıȽϹ���.
		 *
		 */
		List<String> list7 = new ArrayList<String>();
		list7.add("ͯ����");
		list7.add("������");
		list7.add("�ر���ǿ");
		list7.add("��");
		System.out.println(list7);

		Collections.sort(list7, new Comparator<String>(){
			public int compare(String o1,String o2){
				return o1.length()-o2.length();
			}
		});
		System.out.println(list7);

		/**
		 * Queue:����-���õ����ݽṹ-��������Ա�.-�����˶����Ա�ķ��ʷ�ʽ��
		 * ʵ����:LinkedList--Queue����Ҫ���в����ɾ���Ĳ���,LinkedList����
		 * ��һ��Ԫ��.�����������������,��β��ɾԪ��Ч�ʺá�
		 *
		 */
		/*
		 * boolean offer(E e)  ��Ӳ���,�����ĩβ׷�Ӹ���Ԫ��.
		 */
		Queue<String> queue = new LinkedList<String>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		System.out.println(queue);
		/*
		 * E poll()  ���Ӳ���,��ȡ���Ӷ�����ɾ����Ԫ��
		 */
		String str = queue.poll();
		System.out.println(queue);//[two, three]
		System.out.println(str);//one
		/*
		 * E peek()  ���ö���Ԫ�أ���ȡ����Ԫ�أ���Ԫ�ز������Ӳ���
		 */
	    str = queue.peek();
		System.out.println(str);//two
		System.out.println(queue);//[two, three]

		for(String s:queue){
			System.out.println(s);
		}
		System.out.println(queue);

		while(queue.size()>0){//������Ϊ��
			str = queue.poll();
			System.out.println(str);
		}
		System.out.println(queue);

		/**
		 * Deque:Queue���ӽӿ�
		 *     "˫�˶���":�Ӷ��е����˷ֱ�������(offer),����(poll),LinkedListʵ�֣�
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
		 * �����Deque����Ϊֻ�ܴ�һ����Ӻͳ���,���ʵ��"ջ"(stack)�����ݽṹ;
		 * ����ջ:�Ƚ����  (ͨ��ʹ��ջ����ɡ����ˡ����ܡ�)
		 *    ��ջ:push
		 *    ��ջ:pop
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
		 * Map:�Լ�ֵ��(key-value)����ʽ�洢���ݵ����ݽṹ.
		 *     �������еı��.
		 *     Ҫ��:key�����ظ�(���ܰ�������equalsΪtrue��key)
		 *          ͨ�����÷���ȥԼ��key��value������.
		 *     ʵ����:java.util.HashMap  (ɢ�б�) ɢ���㷨ʵ��
		 */
		/*
		 * V put(K k,V v)
		 */
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("����", 6300);
		map.put("����", 480);
		System.out.println(map);
		//��ͬ��key���滻value�Ĳ���
		//����ֵ���Ǳ��滻��value��ֵ
		//valueֵ�������ǰ�װ��
		Integer num = map.put("����", 6300);
		System.out.println(num);//480
		System.out.println(map);

		/*
		 * V get(K k)
		 * ���ݸ�����key��ȡ��Ӧ��valueֵ
		 */
		num = map.get("����");
		System.out.println(num);//6300
	    num = map.get("С��");
	    System.out.println(num);//null

	    /*
	     * V remove(K k)
	     * ��������kay����Ӧ��kay-value��map��ɾ��,����ֵ�Ǹ�key����Ӧ��valueֵ
	     */
	    Integer od = map.remove("����");
	    System.out.println(od);//6300
	    System.out.println(map);//{����=6300}

	    /**
	     * Map�ı���:1.�������е�key;2.�������е�value;3.����ÿһ���ֵ��;
	     */
	    Map<String,Integer> map1 = new HashMap<String,Integer>();
	    map1.put("��ʥ", 6300);
		map1.put("Ī����", 6300);

		/*
	     * 1.�������е�key: Set<K> keySet()
	     *   ����ǰMap�����е�key,����һ��Set�����н��䷵��.
	     *   �����ü��Ͼ��Ǳ������е�key.
	     */
	    Set<String> keySet = map1.keySet();
	    for(String key:keySet){
	    	System.out.println(key);
	    }
	    /*
	     * 2.�������е�values; Collection values()
	     *   ����ǰMap�е�����value���뵽һ�����ϲ�����.
	     */
	    Collection<Integer> values = map1.values();
	    for(Integer value:values){
	    	System.out.println(value);
	    }
	    /*
	     * 3.����ÿһ���ֵ��; Set<Entry> entrySet()
	     *   ����ǰMap��ÿһ���ֵ��(Entryʵ��)����һ�����ϲ�����.
	     *   java.util.MapEntry;
	     *   �����ÿһ��ʵ�����ڱ�ʾMap�еļ�ֵ��.
	     */
	    Set<Entry<String,Integer>> entrySet = map1.entrySet();
	    for(Entry<String,Integer> entry:entrySet){
	    	System.out.println(entry);
	    }
	    /**
	     * HashMap:HashMap�Ĵ�ȡ��������key��hashCode�����ķ���ֵ.
	     *         hashCode����ʵ������Object�еĶ���.
	     *         ��HashMap��Ӧ����,keyԪ�ص�equals������hashCode����ֱ��Ӱ����ɢ�б�
	     *         �Ĳ�ѯ����.��������������Object�����.�ֲ�����ȷ˵��,��������Ҫ��д
	     *         ʱ,��������Ӧ����ѭ:
	     *         1.�ɶ���д,��:����дһ�����equals����ʱ��Ӧ����ͬ��дhashCode;
	     *         2.equals��hashCodeӦ������һ����,��:��������equals�Ƚ�Ϊtrueʱ,
	     *           hasnCode�������ص�����Ӧ����ͬ.������Ҳ���.��Ȼ���Ǳ����,��
	     *           �������ֵ���������hashCode��������ֵ���ʱequalsҲӦ��Ϊtrue,
	     *           �������HasnMap�в�������Ӱ���ѯ���ܡ�
	     *         3.hashCode������ֵӦ�����ȶ���,��:�ڵ�ǰ�������equals�Ƚϵ�����
	     *           ֵû�з����ı��ǰ����,��ε���hashCode�������ص�����Ӧ����ͬ��
	     */

	}

}

