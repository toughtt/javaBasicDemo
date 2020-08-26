package staticKeyword;
//总之一句话，静态代码块内容先执行，接着执行父类非静 态代码块和构造方法，然后执行子类非静态代码块和构造方法。
//https://www.cnblogs.com/astrocc/archive/2012/10/26/2741031.html
public class Test {
    public static void main(String[] args) {
        //A aa = new A("mm");
        B bb=new B("GG");
    }
}
