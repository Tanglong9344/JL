# 面向对象的基本设计原则(SOLID)
### 1.单一职能原则(SRP-Single responsibility principle)
+ 描述
	+ 一个类只负责一项职责(只有一个改变的原因)
+ 优点
	+ 可以降低类的复杂度、类之间的耦合度
	+ 便于扩展和复用
	+ 提高的可读性、可维护性
	+ 降低变更引起的风险
+ 说明
```
要注意职能扩散
```
### 2.开放-封闭原则(OCP-Open Closed Principle)
+ 描述
	+ 类、模块等对于扩展是开放的(Open for extension)
	+ 对于修改是封闭的(Closed for modification)
+ 分类
	+ 梅耶开闭原则(类的继承)
	+ 多态开闭原则(抽象化接口实现)
+ 优点
	+ 增强系统的稳定性、可扩展性、可维护性
### 3.里氏替换原则(LSP-Liskov Substitution Principle)
+ 描述
	+ 子类型必须能够替换掉它的父类型(把父类都替换成它的子类，程序的行为没有变化)
+ 优点
	+ 提高系统的可扩展性、复用性
+ 说明
```
继承并且覆盖超类方法的时候，
子类中的方法的可见性必须等于或者大于超类中的方法的可见性，
子类中的方法所抛出的受检异常只能是超类中对应方法所抛出的受检异常的子类
子类中的方法的返回值也可以是对应的超类方法的返回值的子类
```
### 4.接口隔离原则(ISP-Interface Segregation Principle)
+ 描述
	+ 客户端不应该依赖它不需要的接口
	+ 一个类对另一个类的依赖应该建立在最小的接口上
+ 优点
	+ 增强系统的安全性
### 5.依赖倒转原则(DIP-Dependence Inversion Principle)
+ 描述：抽象(接口或抽象类)不应该依赖细节(具体实现)，细节应该依赖抽象。
+ 优点
	+ 便于扩展和复用
	+ 降低代码耦合度
+ 代码示例
```java
public class DIPTest {
    public static void main(String[] args){
        //狗的行为
        Dog dog = new Dog();
        AnimalBehavior dogBehavior = new AnimalBehavior(dog);
        dogBehavior.EatWhat();
        dogBehavior.HowToVoice();
        dogBehavior.WhereToSleep();

        //猫的行为
        Cat cat = new Cat();
        AnimalBehavior catBehavior = new AnimalBehavior(cat);
        catBehavior.EatWhat();
        catBehavior.HowToVoice();
        catBehavior.WhereToSleep();
    }
}

/** 接口确定动物基本行为 */
abstract class Animal {
    protected String name = this.getClass().getName();

    void eat(){};
    void voice(){};
    void sleep(){};
}

/** 狗 */
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println( name+ " love meat.");
    }

    @Override
    public void voice() {
        System.out.println(name + " Barking...");
    }

    @Override
    public void sleep() {
        System.out.println(name + " Lying on the floor.");
    }
}

/** 猫 */
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println(name + " love fish.");
    }

    @Override
    public void voice() {
        System.out.println(name + " Miaowing...");
    }

    @Override
    public void sleep() {
        System.out.println(name + " Lying in the bed.");
    }
}

/** 动物行为，依赖抽象类Animal */
class AnimalBehavior{
    private Animal animal;
    public AnimalBehavior(Animal animal){
        this.animal = animal;
    }

    public void EatWhat(){
        animal.eat();
    }

    public void HowToVoice(){
        animal.voice();
    }

    public void WhereToSleep(){
       animal.sleep();
    }
}
```
### 6.最少知识原则(LKP-Least Knowledge Principle)(迪米特法则,LOD-Law of Demeter)
+ 描述
	+ 类(模块)之间尽可能少的发生联系和作用
+ 特点
	+ 降低模块耦合度
	+ 增加代码复杂度
+ 应用
	+ 门面模式（Facade）
	+ 中介模式（Mediator
+ 说明
	+ 优先考虑将一个类设置成不变类
	+ 尽量降低一个类的访问权限
	+ 谨慎使用Serializable
	+ 尽量降低成员的访问权限
+ 狭义的迪米特法则
```
如果两个类不必彼此直接通信，
那么这两个类就不应当发生直接的相互作用。
如果其中的一个类需要调用另一个类的某一个方法的话，
可以通过第三者转发这个调用.
```
