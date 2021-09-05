package com.knowledge.tongyaxi.Collection;


/**
 * 使用该类来测试作为集合的元素进行排序
 * @author tarena
 *
 */

public class Point2 implements Comparable<Point2>{
	private int x;
	private int y;
	public Point2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String toString(){
		return "("+x+","+y+")";
	}

	/*
	 * 当一个类实现了Comparable接口后，接口要求必须重写方法
	 * comparaTo.该方法的作用是定义当前对象与参数给定对象比较
	 * 大小的规则�??
	 * 方法要求返回�?个整数，该整数不关注具体值，只关注取值范围：
	 * 当返回�??>0：当前对象大于参数对象（this>o�?
	 * 当返回�??<0：当前对象小于参数对�?
	 * 当返回�??=0：两个对象相�?
	 *
	 */
	public int compareTo(Point2 o) {
		//点到原点的距离长的大
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}

}
