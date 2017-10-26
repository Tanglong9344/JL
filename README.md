# JavaScoreBasic
![java.jpg](https://github.com/Tanglong9344/JavaBasic/blob/master/picture/java.jpg)
### The first program in Java
```
//Source file
public class HelloJava {
	public static void main(String args[]){
		System.out.println(Hello Java!);
	}
}
```
+ Compile:javac HelloJava.java
+ Interpret:java HelloJava
+ View code of HelloJava.class:javap -verbose HelloJava.class
![HelloJava.png](https://github.com/Tanglong9344/JavaBasic/blob/master/picture/HelloJava.png)
```
Classfile /F:/HelloJava.class
  Last modified 2017-10-26; size 429 bytes
  MD5 checksum a23cb11867f138649062347654bc1a4f
  Compiled from "HelloJava.java"
public class HelloJava
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #6.#15         // java/lang/Object."<init>":()V
   #2 = String             #16            // Hello Java!
   #3 = Fieldref           #17.#18        // java/lang/System.out:Ljava/io/PrintStream;
   #4 = Methodref          #19.#20        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Class              #21            // HelloJava
   #6 = Class              #22            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               main
  #12 = Utf8               ([Ljava/lang/String;)V
  #13 = Utf8               SourceFile
  #14 = Utf8               HelloJava.java
  #15 = NameAndType        #7:#8          // "<init>":()V
  #16 = Utf8               Hello Java!
  #17 = Class              #23            // java/lang/System
  #18 = NameAndType        #24:#25        // out:Ljava/io/PrintStream;
  #19 = Class              #26            // java/io/PrintStream
  #20 = NameAndType        #27:#28        // println:(Ljava/lang/String;)V
  #21 = Utf8               HelloJava
  #22 = Utf8               java/lang/Object
  #23 = Utf8               java/lang/System
  #24 = Utf8               out
  #25 = Utf8               Ljava/io/PrintStream;
  #26 = Utf8               java/io/PrintStream
  #27 = Utf8               println
  #28 = Utf8               (Ljava/lang/String;)V
{
  public HelloJava();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: ldc           #2                  // String Hello Java!
         2: astore_1
         3: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         6: aload_1
         7: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        10: return
      LineNumberTable:
        line 3: 0
        line 4: 3
        line 5: 10
}
SourceFile: "HelloJava.java"
```
