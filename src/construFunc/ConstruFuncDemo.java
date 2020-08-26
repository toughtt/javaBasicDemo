package construFunc;

public class ConstruFuncDemo {

    public static void main(String[] args) {
        Person z = new Person("zhangsan", 3);        //实例化对象时，new Person()里直接调用Person构造函数并转转实参，相当于setter功能
        z.show();
    }

    static  class Person{
        private String name;
        private int age;
        public Person(String n,int m){                //有参数构造函数，实现给private成员变量传参数值的功能
            name=n;
            age=m;
        }
        //getter                                      //实例化对象时，完成了sett功能后，需要getter，获取实参值。
        public String getName(){
            return name;
        }
        public int getAget(){
            return age;
        }
        public void show(){                           //获取private值后，并打印输出
            System.out.println(name+"\n"+age);
        }
    }

}
