package enums;

public class ChooseSeason {
    public static Season season = Season.SPRING;
    public static void main(String[] args) {
        switch (season){
            case AUTUMN:
                System.out.println("now is autumn");
                break;
            case SPRING:
                System.out.println("now is spring");
                break;
        }
    }
}
