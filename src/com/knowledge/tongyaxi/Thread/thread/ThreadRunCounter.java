package com.knowledge.tongyaxi.Thread.thread;

/**
 * �����󥿩`�΂��򱣳֤��륯�饹
 * showAndCountUp�᥽�åɤǡ������󥿩`��׷�Ӥ��ơ�
 * ׷�Ӥ��������󥿩`�΂���ȴ���롣
 */
public class ThreadRunCounter {

	public static int counter = 0;
	
	synchronized public static int showAndCountUp() {
		counter = counter + 1;
		return counter;
	}
}
