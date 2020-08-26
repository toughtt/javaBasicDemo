package construFunc;

public class Student {
    private String classRoom;
    public String name;
    public int height;
    private long money;
    private Long hello;
    public Student()
    {
        this.name="hello";
        this.height=0;
        System.out.println("name:"+name+" "+"height:"+height);
    }
    public Student(String name, int height){
        this.name= name;
        this.height = height;
    }
    public void baseFunc() {
        System.out.println("Student.baseFunc() execute.");
    }


    protected String getName() {
        return name;
    }
//
//    protected int getHeight() {
//        return height;
//    }
}
