package course_sections.observerpattern;

public class StatisticsDisplay implements Observer, DisplayElement{
    private float tempSum;
    private float numReadings;
    private float maxTemp;
    private float minTemp;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/min temperature = " +
                (tempSum/numReadings) + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;
        if(temp > maxTemp){
            maxTemp = temp;
        }
        if(temp < minTemp){
            minTemp = temp;
        }
        display();
    }
}
