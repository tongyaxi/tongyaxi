package com.knowledge.tongyaxi.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Collections:����Collection��Map�Ĺ�����
 * @author tongyaxi
 *
 */
public class CollectionsTest {

	/***
	 *  reverse(List)����ת List ��Ԫ�ص�˳��
		shuffle(List)���� List ����Ԫ�ؽ����������
		sort(List)������Ԫ�ص���Ȼ˳���ָ�� List ����Ԫ�ذ���������
		sort(List��Comparator)������ָ���� Comparator ������˳��� List ����Ԫ�ؽ�������
		swap(List��int�� int)����ָ�� list �����е� i ��Ԫ�غ� j ��Ԫ�ؽ��н���
		
		Object max(Collection)������Ԫ�ص���Ȼ˳�򣬷��ظ��������е����Ԫ��
		Object max(Collection��Comparator)������ Comparator ָ����˳�򣬷��ظ��������е����Ԫ��
		Object min(Collection)
		Object min(Collection��Comparator)
		int frequency(Collection��Object)������ָ��������ָ��Ԫ�صĳ��ִ���
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 123);

        System.out.println(list);
        System.out.println(frequency);

    }
	
	/**
	 * void copy(List dest,List src)����src�е����ݸ��Ƶ�dest��
       boolean replaceAll(List list��Object oldVal��Object newVal)��ʹ����ֵ�滻 List ��������о�ֵ
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //���쳣��IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        //��ȷ�ģ�
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//list.size();
        Collections.copy(dest,list);

        System.out.println(dest);


        /*
        Collections �����ṩ�˶�� synchronizedXxx() ������
        �÷�����ʹ��ָ�����ϰ�װ���߳�ͬ���ļ��ϣ��Ӷ����Խ��
        ���̲߳������ʼ���ʱ���̰߳�ȫ����

         */
        //���ص�list1��Ϊ�̰߳�ȫ��List
        List list1 = Collections.synchronizedList(list);


    }
}
