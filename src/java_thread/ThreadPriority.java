package java_thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadPriority {
	//This is a test
	public static void main(String[] args) {
		final int N=10;
		List<ThreadP> tList = new ArrayList<ThreadP>();
		for(int i=1;i<=N;i++){
			ThreadP tp = new ThreadP("Thread"+i);
			//�������ȼ�
			tp.setPriority((new java.util.Random().nextInt(N)+1));
			tList.add(tp);
		}
		//����
		tList.forEach(tp->tp.start());
	}
}

/**�߳���*/
class ThreadP extends Thread{
	public ThreadP(String name){
		super(name);
	}
	@Override
	public void run(){
		int a=6;
		while((a--)>0){
			System.out.println("�߳�����"+this.getName()+" ���ȼ���"+this.getPriority());
			try {
				Thread.sleep(1000);//����1s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}