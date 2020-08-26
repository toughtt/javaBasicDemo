package construFunc;

public class Pupil extends Student {
    private int score;
    private int height;
    public Pupil(){                //无参构造函数Pupil()直接继承了父类中的无参构造函数Student()
        super("nihao",2);
        score=0;
        height=1;
    }
    public void show(){
        System.out.print("姓名："+ super.name +"\n身高："+ super.height+"\n分数："+score
                + "\nPupil.height："+ height +"\n" + "\nStudent.height："+ super.height +"\n");
    }

    public void showParentPrivate() {
        System.out.println("Pupil.showParentProtect():" + super.getName());
    }
    public void baseFunc() {
        System.out.println("Pupil.baseFunc() execute!!!");
    }

    public final void finalFunc(){
        System.out.println("Student.finalFunc() execute.");
    }
}
