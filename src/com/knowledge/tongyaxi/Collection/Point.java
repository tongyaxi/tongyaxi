 package com.knowledge.tongyaxi.Collection;



 /**
  * java中所有的类都继承object
  * 当我们定义的�?个类没有使用extnds继承任何类时，编译器
  * 在编译时会自动让当前类继承object
  *
  * 使用该类测试重写object的相关方�?
  * @author tarena
  *
  */
public class Point {
     private int x;
     private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * 通常�?要用到一个类的tostring方法时，就应�?
	 * 重写该方法，因为object提供的该方法返回的字符串
	 * 是该对象的句�?(地址信息)
	 *
	 * tostring方法返回的字符串应当包含当前对象�?
	 * 属�?�信息，具体格式结合实际�?求�?�定
	 */
	public String toString(){
		return "("+x+","+y+")";
	}
	/**
	 * equals方法的作用是比较当前对象与参与给定的对象
	 * 内容是否�?致，即：两个对象"像不�?"
	 * 若不重写该方法，则使用Object提供的，但是object
	 * 提供的equals方法内部比较原则就是"=="，所以不具备
	 * 实际意义
	 * equals方法并不要求两个对象�?有属性�?�必须完�?
	 * �?样，结合实际业务逻辑�?求定义判断标�?
	 */
	public boolean equals(Object obj){//只能传object类型
		if(obj==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		if(obj instanceof Point){
			Point p = (Point)obj;
			return this.x==p.x&&this.y==p.y;
		}
		return false;
	}
}
