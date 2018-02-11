# 响应式编程(Reactive Programming)
+ 涵义：追踪数据变化，并即时反馈到相关的程序和组件。
+ 产生原因：桌面应用->网络应用的发展(趋势：数据在线)
+ 关键词
	1. 异步(asynchronous)
	2. 事件驱动(event-driven)
	3. 流(正在进行的 事件/信息 序列)(Stream)
	4. 响应式变量(reactive variables)
	5. 被观察者(Observable)
	6. 订阅者(Subscriber)[消费者(consumer)]
	7. 并发(Concurrent)
	8. 函数式编程(Functional Programming)
	9. 面向对象编程(Object Oriented Programming)
	10. 背压(backpressure)
```
the ability to notify the upstream that the amount of data can't be handled is called backpressure.
```
+ 要求
	+ 模块化(Modular)-事件驱动(event-driven)-使用通知(notification: 变化的异步数据流)交流
	+ 伸缩性(Scalable)-随变化的数据而变化
	+ 容错性(Fault-tolerant)[弹性(Resilient)]-对错误和突发事件迅速做出响应
	+ 实时响应(7/24 系统)-根据用户行为实时响应
+ 信息交流：线程间通信，进程间通信，网络节点间通信