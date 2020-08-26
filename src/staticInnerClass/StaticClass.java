package staticInnerClass;

public class StaticClass {
    public String name;
    protected float hp;

    private static void battleWin(){
        System.out.println("battle win");
    }

    //敌方的水晶
    static class EnemyCrystal{
        int hp=0;

        //如果水晶的血量为0，则宣布胜利
        public void checkIfVictory(){
            if(hp==0){
                StaticClass.battleWin();

                //静态内部类不能直接访问外部类的对象属性
                //System.out.println(name + " win this game");
            }
        }
    }

    public static void main(String[] args) {
        //实例化静态内部类
        StaticClass.EnemyCrystal crystal = new StaticClass.EnemyCrystal();
        crystal.checkIfVictory();
    }

}
