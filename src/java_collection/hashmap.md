# HashMap
+ 非线程安全的类
+ 键、值允许为null
+ 性能
	+ 初始容量(initial capacity)
	+ 负载因子(load factor)(默认值0.75)
	+ 超过负载因子对应的容量
		1. 重散列运算
		2. 重建外部数据结构
		3. 扩容至原来的两倍
