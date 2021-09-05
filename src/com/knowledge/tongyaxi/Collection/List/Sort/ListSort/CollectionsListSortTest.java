package com.knowledge.tongyaxi.Collection.List.Sort.ListSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsListSortTest {

	public static void main(String[] args) {

        List<Employee> list = new ArrayList<Employee>();

        Employee e = new Employee();
        e.setLevel(1);
        e.setSalary(300);
        e.setYears(4);
        list.add(e);

        e = new Employee();
        e.setLevel(1);
        e.setSalary(500);
        e.setYears(4);
        list.add(e);

        e = new Employee();
        e.setLevel(2);
        e.setSalary(500);
        e.setYears(4);
        list.add(e);

        e = new Employee();
        e.setLevel(1);
        e.setSalary(300);
        e.setYears(5);
        list.add(e);

        System.out.println(list);
        for(Employee employee:list){
        	System.out.println(employee);
        }

        //按级别,工资,入职年数,递减排序
        Collections.sort(list, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                int a = e1.getLevel() - e2.getLevel();
                if (a != 0) {
                    return a > 0 ? -1 : 1;
                }
                a = e1.getSalary() - e2.getSalary();
                if (a != 0) {
                    return a > 0 ? -1 : 1;
                }
                a = e1.getYears() - e2.getYears();
                return a > 0 ? -1 : 1;
            }
        });

        for(Employee employee:list){
        	System.out.println(employee);
        }
}
}
