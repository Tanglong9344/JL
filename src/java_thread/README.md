# 线程
+ 线程状态
  + 新建状态(New)
  + 就绪状态(Runnable)
  + 运行状态(Running)
  + 阻塞状态(Blocked)
  + 死亡状态(Dead)
---
![threadState.png](pictures/threadState.png)
+ 线程创建
  + 继承Thread类
  + 实现Runnable接口
  + 匿名线程
+ 线程同步
  + synchronized 关键字
  + 使用锁(Lock)接口
+ 实例
  + [实例1](ThreadTest1.java)
---
*注：启动线程是start()方法，run()并不能启动一个新的线程*
