package staticKeyword;

class B extends A{
    String name;
    static int b;
    static{
        b=12;
        System.out.println("这是子类的静态代码块"+b);
    }
    {
        b=10;
        System.out.println("这是子类的构造代码块"+b);
    }
    //注意:子类的构造方法，不管这个构造方法带不带参数，默认的它都会先去寻找父类的不带参数的构造方法。
    // 如果父类没有不带参数的构造方法，那么子类必须用supper关键子来调用父类带参数的构造方法，否则编译不能通过。
    B(String name) {
        super();//父类有无参构造函数时，此处写不写都一样。
        this.name = name;
        System.out.println("这是子类的name:"+name);
    }
}
