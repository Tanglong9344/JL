public class ThreadTest1 {
    private static MyThread myThread = null;

    /** 暂停n秒 */
    public static void stopForNSeconds(int n){
        try{
            Thread.sleep(n * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /** 启动线程 */
    private static void threadStart(){
        if(myThread == null){
            myThread = new MyThread();
            myThread.start();
        }
    }

    /** 中断线程 */
    private static synchronized void threadInterupt(){
        if(myThread != null && !myThread.isInterrupted()){
            System.out.println("before: " + myThread.getState());
            myThread.interrupt();
            System.out.println("after: " + myThread.getState());
        }
    }

    /** 获取当前所有线程 */
    private static Thread[] getAllCurrentThread(){
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        int activeCount = threadGroup.activeCount();
        Thread[] threads = new Thread[activeCount];
        threadGroup.enumerate(threads);
        return threads;
    }

    public static void main(String[] args) {
        threadStart();
        stopForNSeconds(3);
        threadInterupt();
    }
}

/** 线程类 */
 class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (Thread.currentThread().isInterrupted()) { break; }
                //new Main().stopForNSeconds(1); // 暂停1s
                System.out.println(Thread.currentThread().getName() + " is running...");
            }
        }
        Thread.yield();
    }
}
