package com.knowledge.tongyaxi.Thread.thread;

/**
 * �ᥤ��᥽�åɤ�֤ĥ��饹
 * Thread6Run���饹���饹��åɤ�����
 * �����ᥤ��᥽�å��ڤǡ�ThreadRun6Counter.shouAndCountUp���R�귵���g�Ф���
 * @author tongyaxi
 *
 */
public class ThreadCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ThreadRun�򥤥󥹥��󥹻�
		ThreadRun thread = new ThreadRun();
		
		// ThreadRun�Υ��󥹥��󥹤�start()������å��_ʼ
		thread.start();
		
		for(int i=0; i<10; i++){

            //ThreadRun6Counter�Υ�����Ȥ���㤷�ơ��Y���������
            int cnt = ThreadRunCounter.showAndCountUp();
            System.out.println("Main:   " + i + "��Ŀ�Όg�С� �����󥿩`�ϡ�  " + cnt + "�Ǥ���");

            try{
                // ����`��1�����
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
	}

}
