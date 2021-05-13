## 单例模式

**HangerSingle.java 饿汉的单例模式**：一个线程安全的单例模式的最简单粗暴的写法。这种写法，在类被加载的时候就把Singleton实例给创建出来了。饿汉式的缺点是，可能在还不需要此实例的时候就已经把实例创建出来了，没起到懒加载的效果。优点就是实现简单，而且安全可靠。

**LazySingleThreadUnsafe.java 懒汉式单例**：存在线程安全问题

**LazySingleThreadSafe.java 双重验证懒汉单例**：通过加锁，可以保证同时只有一个线程走到第二个判空代码中去，这样保证了只创建 一个实例。这里还用到了volatile关键字来修饰instance，其最关键的作用是防止指令重排

**LazySingleThreadSafeBaseInnerClass.java 静态内部类单例**：线程安全的，同时静态内部类不会在Singleton类加载时就加载，而是在调用getInstance()方法时才进行加载，达到了懒加载的效果，但是如何单例支持序列化则可以被序列化和反序列化破坏

**SingleBaseEnum.java 枚举单例类**：利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题，写法特别简单

