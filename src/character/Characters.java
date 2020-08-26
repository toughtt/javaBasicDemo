package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Characters {
    public static void main(String[] args) {
        char a= 'a';
        //char b= 'aa';
        System.out.println(a);
        char b ='b';
        String s = Character.toString(b);
        System.out.println(s);
        String aa="hello";
        char[] chars = aa.toCharArray();
        aa.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).forEach(System.out::println);
        //System.out.println("answerList:"+answerList);

        System.out.println("使用空格无法达到对齐的效果");
        System.out.println("abc def");
        System.out.println("ab def");
        System.out.println("a def");

        System.out.println("使用\\t制表符可以达到对齐的效果");
        System.out.println("abc\tdef");
        System.out.println("ab\tdef");
        System.out.println("a\tdef");

        System.out.println("一个\\t制表符长度是8");
        System.out.println("12345678def");

        System.out.println("换行符 \\n");
        System.out.println("abc\ndef");

        System.out.println("单引号 \\'");
        System.out.println("abc\'def");
        System.out.println("双引号 \\\"");
        System.out.println("abc\"def");
        System.out.println("反斜杠本身 \\");
        System.out.println("abc\\def");

        char[] cs = new char[]{'崔','斯','特'};

        String hero = new String(cs);//  通过字符数组创建一个字符串对象
        System.out.println(hero);

        String name ="盖伦";
        int kill = 8;
        String title="超神";

        //格式化字符串
        //%s表示字符串，%d表示数字,%n表示换行
        String sentenceFormat ="%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";

        String sentence2 = String.format(sentenceFormat, name,kill,title);

        System.out.println(sentence2);
        char c = name.charAt(1);

        System.out.println(c);

        StringBuffer sb =new StringBuffer();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append('a');
        }

        //容器类ArrayList，用于存放对象
        ArrayList heros = new ArrayList();
        heros.add( new String("盖伦"));
        System.out.println(heros.size());

        //容器的容量"capacity"会随着对象的增加，自动增长
        //只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题
        System.out.println(heros.size());

    }

}
