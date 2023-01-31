package course_sections.observerpatternExtended;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement{
    private float tempSum;
    private float numReadings;
    private float maxTemp;
    private float minTemp;
    Observable observable;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/min temperature = " +
                (tempSum/numReadings) + "/" + maxTemp + "/" + minTemp);
    }


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

    @Override
    public void update(Observable obs, Object o) {
        if(obs instanceof WeatherData){
            WeatherData weatherData  = (WeatherData) obs;
            this.tempSum += weatherData.getTemperature();
            numReadings++;
            if(weatherData.getTemperature() > this.maxTemp){
                this.maxTemp = weatherData.getTemperature();
            }
            if(weatherData.getTemperature() < this.minTemp){
                this.minTemp = weatherData.getTemperature();
            }
        }
        display();

    }
}
