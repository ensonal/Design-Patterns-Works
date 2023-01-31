package course_sections.strategypattern;

public class Quack implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("QUACK!");

    }
}
