# Java Garbage Collection
### 堆类别
---
+ 年轻代(Yong)
+ 年老代(Tenured)
+ 永久代(Perm)
### JVM参数
---
+ -Xmx512m
```
设置JVM实例堆最大可用内存为512M。
```
+ -Xms512m:
```
设置JVM初始内存为512m。
此值可以设置与-Xmx相同，以避免每次垃圾回收完成后JVM重新分配内存。
```
+ -Xmn192m
```
设置年轻代大小为192m。整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小。
持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。
此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8。
```
+ -Xss128k
```
设置每个线程的堆栈大小。JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。
根据应用的线程所需内存大小进行调整。在相同物理内存下，减小这个值能生成更多的线程。
但是操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右。
```
+ -XX:NewRatio=4
```
设置年轻代（包括Eden和两个Survivor区）与年老代的比值（除去持久代）。
设置为4，则年轻代与年老代所占比值为1：4，年轻代占整个堆栈的1/5
```
+ -XX:SurvivorRatio=4 
```
设置年轻代中Eden区与Survivor区的大小比值。
设置为4，则两个Survivor区与一个Eden区的比值为2:4，一个Survivor区占整个年轻代的1/6
````
+ -XX:PermSize=128M 
```
设置持久代大小为128M 
```
+ -XX:MaxPermSize=16m 
```
设置持久代最大为16m。 
MaxPermSize过小会导致：java.lang.OutOfMemoryError: PermGen space
```
+ -XX:MaxTenuringThreshold=0 
```
设置垃圾最大年龄。如果设置为0的话，则年轻代对象不经过Survivor区，直接进入年老代。
对于年老代比较多的应用，可以提高效率。如果将此值设置为一个较大值，
则年轻代对象会在Survivor区进行多次复制，
这样可以增加对象再年轻代的存活时间，增加在年轻代即被回收的概论。
```
+ -XX:+UseCMSCompactAtFullCollection
```
使用并发收集器时，开启对年老代的压缩。
``` 
+ -XX:CMSFullGCsBeforeCompaction=0
```
上面配置开启的情况下，这里设置多少次Full GC后，对年老代进行压缩
```
### 参考资料
---
[JVM 参数s](http://blog.csdn.net/mrzhoug/article/details/51148302)
