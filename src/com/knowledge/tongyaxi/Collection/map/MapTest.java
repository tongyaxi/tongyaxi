package com.knowledge.tongyaxi.Collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * һ��Map��ʵ����Ľṹ��
 *  |----Map:˫�����ݣ��洢key-value�Ե�����   ---�����ڸ��еĺ�����y = f(x)
 *         |----HashMap:��ΪMap����Ҫʵ���ࣻ�̲߳���ȫ�ģ�Ч�ʸߣ��洢null��key��value
 *              |----LinkedHashMap:��֤�ڱ���mapԪ��ʱ�����԰�����ӵ�˳��ʵ�ֱ�����
 *                      ԭ����ԭ�е�HashMap�ײ�ṹ�����ϣ������һ��ָ�룬ָ��ǰһ���ͺ�һ��Ԫ�ء�
 *                      ����Ƶ���ı�������������ִ��Ч�ʸ���HashMap��
 *         |----TreeMap:��֤������ӵ�key-value�Խ�������ʵ�������������ʱ����key����Ȼ�����������
 *                      �ײ�ʹ�ú����
 *         |----Hashtable:��Ϊ���ϵ�ʵ���ࣻ�̰߳�ȫ�ģ�Ч�ʵͣ����ܴ洢null��key��value
 *              |----Properties:���������������ļ���key��value����String����
 *
 *
 *      HashMap�ĵײ㣺����+����  ��jdk7��֮ǰ��
 *                    ����+����+����� ��jdk 8��
 *
 *
 *  �����⣺
 *  1. HashMap�ĵײ�ʵ��ԭ��
 *  2. HashMap �� Hashtable����ͬ��
 *  3. CurrentHashMap �� Hashtable����ͬ������ʱ������
 *
 *  ����Map�ṹ����⣺
 *    Map�е�key:����ġ������ظ��ģ�ʹ��Set�洢���е�key  ---> key���ڵ���Ҫ��дequals()��hashCode() ����HashMapΪ����
 *    Map�е�value:����ġ����ظ��ģ�ʹ��Collection�洢���е�value --->value���ڵ���Ҫ��дequals()
 *    һ����ֵ�ԣ�key-value������һ��Entry����
 *    Map�е�entry:����ġ������ظ��ģ�ʹ��Set�洢���е�entry
 *
 *  ����HashMap�ĵײ�ʵ��ԭ����jdk7Ϊ��˵����
 *      HashMap map = new HashMap():
 *      ��ʵ�����Ժ󣬵ײ㴴���˳�����16��һά����Entry[] table��
 *      ...�����Ѿ�ִ�й����put...
 *      map.put(key1,value1):
 *      ���ȣ�����key1�������hashCode()����key1��ϣֵ���˹�ϣֵ����ĳ���㷨�����Ժ󣬵õ���Entry�����еĴ��λ�á�
 *      �����λ���ϵ�����Ϊ�գ���ʱ��key1-value1��ӳɹ��� ----���1
 *      �����λ���ϵ����ݲ�Ϊ�գ�(��ζ�Ŵ�λ���ϴ���һ����������(��������ʽ����)),�Ƚ�key1���Ѿ����ڵ�һ����������
 *      �Ĺ�ϣֵ��
 *              ���key1�Ĺ�ϣֵ���Ѿ����ڵ����ݵĹ�ϣֵ������ͬ����ʱkey1-value1��ӳɹ���----���2
 *              ���key1�Ĺ�ϣֵ���Ѿ����ڵ�ĳһ������(key2-value2)�Ĺ�ϣֵ��ͬ�������Ƚϣ�����key1�������equals(key2)�������Ƚϣ�
 *                      ���equals()����false:��ʱkey1-value1��ӳɹ���----���3
 *                      ���equals()����true:ʹ��value1�滻value2��
 *
 *       ���䣺�������2�����3����ʱkey1-value1��ԭ��������������ķ�ʽ�洢��
 *
 *      �ڲ��ϵ���ӹ����У����漰���������⣬�������ٽ�ֵ(��Ҫ��ŵ�λ�÷ǿ�)ʱ�����ݡ�Ĭ�ϵ����ݷ�ʽ������Ϊԭ��������2��������ԭ�е����ݸ��ƹ�����
 *
 *      jdk8 �����jdk7�ڵײ�ʵ�ַ���Ĳ�ͬ��
 *      1. new HashMap():�ײ�û�д���һ������Ϊ16������
 *      2. jdk 8�ײ�������ǣ�Node[],����Entry[]
 *      3. �״ε���put()����ʱ���ײ㴴������Ϊ16������
 *      4. jdk7�ײ�ṹֻ�У�����+����jdk8�еײ�ṹ������+����+�������
 *         4.1 �γ�����ʱ�����ϰ��£�jdk7:�µ�Ԫ��ָ��ɵ�Ԫ�ء�jdk8���ɵ�Ԫ��ָ���µ�Ԫ�أ�
           4.2 �������ĳһ������λ���ϵ�Ԫ����������ʽ���ڵ����ݸ��� > 8 �ҵ�ǰ����ĳ��� > 64ʱ����ʱ������λ���ϵ������ݸ�Ϊʹ�ú�����洢��
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap��Ĭ��������16
 *      DEFAULT_LOAD_FACTOR��HashMap��Ĭ�ϼ������ӣ�0.75
 *      threshold�����ݵ��ٽ�ֵ��=����*������ӣ�16 * 0.75 => 12
 *      TREEIFY_THRESHOLD��Bucket�������ȴ��ڸ�Ĭ��ֵ��ת��Ϊ�����:8
 *      MIN_TREEIFY_CAPACITY��Ͱ�е�Node������ʱ��С��hash������:64
 *
 *  �ġ�LinkedHashMap�ĵײ�ʵ��ԭ���˽⣩
 *      Դ���У�
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
             Entry<K,V> before, after;//�ܹ���¼��ӵ�Ԫ�ص��Ⱥ�˳��
             Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
             }
         }
 *
 *
 *   �塢Map�ж���ķ�����
 ��ӡ�ɾ�����޸Ĳ�����
 Object put(Object key,Object value)����ָ��key-value��ӵ�(���޸�)��ǰmap������
 void putAll(Map m):��m�е�����key-value�Դ�ŵ���ǰmap��
 Object remove(Object key)���Ƴ�ָ��key��key-value�ԣ�������value
 void clear()����յ�ǰmap�е���������
 Ԫ�ز�ѯ�Ĳ�����
 Object get(Object key)����ȡָ��key��Ӧ��value
 boolean containsKey(Object key)���Ƿ����ָ����key
 boolean containsValue(Object value)���Ƿ����ָ����value
 int size()������map��key-value�Եĸ���
 boolean isEmpty()���жϵ�ǰmap�Ƿ�Ϊ��
 boolean equals(Object obj)���жϵ�ǰmap�Ͳ�������obj�Ƿ����
 Ԫ��ͼ�����ķ�����
 Set keySet()����������key���ɵ�Set����
 Collection values()����������value���ɵ�Collection����
 Set entrySet()����������key-value�Թ��ɵ�Set����

 *�ܽ᣺���÷�����
 * ��ӣ�put(Object key,Object value)
 * ɾ����remove(Object key)
 * �޸ģ�put(Object key,Object value)
 * ��ѯ��get(Object key)
 * ���ȣ�size()
 * ������keySet() / values() / entrySet()
 */
public class MapTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
    public void test2(){
        Map map = new HashMap();
        
        map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }
	
	/*
    ��ӡ�ɾ�����޸Ĳ�����
    Object put(Object key,Object value)����ָ��key-value��ӵ�(���޸�)��ǰmap������
    void putAll(Map m):��m�е�����key-value�Դ�ŵ���ǰmap��
    Object remove(Object key)���Ƴ�ָ��key��key-value�ԣ�������value
    void clear()����յ�ǰmap�е���������
    */
   @SuppressWarnings({ "rawtypes", "unchecked" })
@Test
   public void test3(){
       Map map = new HashMap();
       //���
       map.put("AA",123);
       map.put(45,123);
       map.put("BB",56);
       //�޸�
       map.put("AA",87);

       System.out.println(map);

       Map map1 = new HashMap();
       map1.put("CC",123);
       map1.put("DD",123);

       map.putAll(map1);

       System.out.println(map);

       //remove(Object key)
       Object value = map.remove("CC");
       System.out.println(value);
       System.out.println(map);

       //clear()
       map.clear();//��map = null������ͬ
       System.out.println(map.size());
       System.out.println(map);
   }
   
      /*
      Ԫ�ز�ѯ�Ĳ�����
      Object get(Object key)����ȡָ��key��Ӧ��value
      boolean containsKey(Object key)���Ƿ����ָ����key
      boolean containsValue(Object value)���Ƿ����ָ����value
      int size()������map��key-value�Եĸ���
      boolean isEmpty()���жϵ�ǰmap�Ƿ�Ϊ��
      boolean equals(Object obj)���жϵ�ǰmap�Ͳ�������obj�Ƿ����
       */
      @SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
      public void test4(){
          Map map = new HashMap();
          map.put("AA",123);
          map.put(45,123);
          map.put("BB",56);
          // Object get(Object key)
          System.out.println(map.get(45));
          //containsKey(Object key)
          boolean isExist = map.containsKey("BB");
          System.out.println(isExist);

          isExist = map.containsValue(123);
          System.out.println(isExist);

          map.clear();

          System.out.println(map.isEmpty());

      }
      
      /**
       * Ԫ��ͼ�����ķ�����
         Set keySet()����������key���ɵ�Set����
         Collection values()����������value���ɵ�Collection����
         Set entrySet()����������key-value�Թ��ɵ�Set����
       */
      @SuppressWarnings("rawtypes")
	@Test
      public void test5() {
    	  Map<String,Integer> map = new HashMap<String,Integer>();
    	  map.put("1", 123);
    	  map.put("2", 456);
    	  map.put("3", 789);
    	  
    	  //�������е�key����keySet()
    	  Set set = map.keySet();
    	  Iterator i = set.iterator();
    	  while(i.hasNext()) {
    		  System.out.println(i.next());
    	  }
    	  System.out.println("------------");
    	  //�������е�value����values()
    	  Collection c =map.values();
    	  for(Object obj : c) {
    		  System.out.println(obj);
    	  }
    	  System.out.println("------------");
    	  //�������е�key-value
    	  //��ʽһ��entrySet()
    	  Set entrySet = map.entrySet();
          Iterator iterator1 = entrySet.iterator();
          while (iterator1.hasNext()){
              Object obj = iterator1.next();
              //entrySet�����е�Ԫ�ض���entry
              Map.Entry entry = (Map.Entry) obj;
              System.out.println(entry.getKey() + "---->" + entry.getValue());
          }
          System.out.println("------------");
          //��ʽ����
          Set keySet = map.keySet();
          Iterator iterator2 = keySet.iterator();
          while(iterator2.hasNext()){
              Object key = iterator2.next();
              Object value = map.get(key);
              System.out.println(key + "=====" + value);

          }
    	  
      }
	
}
