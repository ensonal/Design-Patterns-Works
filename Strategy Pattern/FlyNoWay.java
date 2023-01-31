package course_sections.strategypattern;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("I can not fly.");

    }
}
