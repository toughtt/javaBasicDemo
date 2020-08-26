package serializables;

import org.junit.Test;
//https://www.cnblogs.com/huhx/p/serializable.html
public class TestSerializable {
    @Test
    public  void testWrite(){
        Person person=new Person();
        person.setId(1);
        person.setName("张丹");
        person.setGender("female");
        SerializationUtils.write(person);
    }

    @Test
    public  void testRead(){
        Person p = (Person) SerializationUtils.read();
        System.out.println(p.getName());
        System.out.println("\n");
        System.out.println(p.getGender());
    }
}
