package com.knowledge.tongyaxi.Collection.Set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class test02 {

	/*
    1.��TreeSet����ӵ����ݣ�Ҫ������ͬ��Ķ���
    2.��������ʽ����Ȼ����ʵ��Comparable�ӿڣ� �� ��������Comparator��


    3.��Ȼ�����У��Ƚ����������Ƿ���ͬ�ı�׼Ϊ��compareTo()����0.������equals().
    4.���������У��Ƚ����������Ƿ���ͬ�ı�׼Ϊ��compare()����0.������equals().
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
    public void test1(){
        TreeSet set = new TreeSet();

        //ʧ�ܣ�������Ӳ�ͬ��Ķ���
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

            //����һ��
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);
//
        //��������
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void test2(){
        Comparator com = new Comparator() {
            //���������С��������
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("������������Ͳ�ƥ��");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
