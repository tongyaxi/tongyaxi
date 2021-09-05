package com.knowledge.tongyaxi.Collection.List.Sort.ListSort;

public class Employee {
	
	private int level;

    private int salary;

    private int years;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Employee [level=" + level + ", salary=" + salary + ", years="
                + years + "]";
    }

}
