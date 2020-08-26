package equalsHashCode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
//https://blog.csdn.net/u012088516/article/details/86495512
//https://www.cnblogs.com/keyi/p/7119825.html
public class HashCodeTest {
    public static void main(String[] args) {
        Point p1= new Point(1,1);
        Point p2= new Point(2,1);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);
        //hashset里要求对象不能重复，则他内部必然要对添加进去的每个对象进行对比，而他的对比规则就是像上面说的那样，
        // 先hashCode()，如果hashCode()相同，再用equal()验证，如果hashCode()都不同，则肯定不同，这样对比的效率就很高了。
        Collection dataSet= new HashSet();
        dataSet.add(p1);
        dataSet.add(p2);
        dataSet.add(p1);
        Iterator iterator= dataSet.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }
        System.out.println("dataSet size:"+dataSet.size());
        System.out.println("---------------------");
        System.out.println("original p1:"+p1.hashCode());
        //修改部分属性
        p1.setX(10);
        System.out.println("later p1:"+p1.hashCode());
        System.out.println("remove stu1 : "+dataSet.remove(p1));
        System.out.println("dataSet size after update and remove:"+dataSet.size());
        dataSet.clear();
        System.out.println("dataSet size after iterator remove:"+dataSet.size());

        System.out.println("---------------------");
        //所以如果我们的对象要想放进hashSet，并且发挥hashSet的特性（即不包含一样的对象），则我们就要重写我们类的hashCode()和
        //equal()方法了。像String,Integer等这种类内部都已经重写了这两个方法。
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("a");
        Iterator iterator1 = hashSet.iterator();
        while (iterator1.hasNext()){
            String tmp =(String) iterator1.next();
            System.out.println(tmp);
        }

    }
    public static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result =1;
            result = prime*result+x;
            result = prime*result+y;
            return result;
        }

        @Override
        public String toString() {
            return "x:" + x + ",y:" + y;
        }
    }
}
