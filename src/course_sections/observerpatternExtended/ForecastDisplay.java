package course_sections.observerpatternExtended;
import java.util.Observer;
import java.util.Observable;

public class ForecastDisplay implements Observer, DisplayElement{
    private float currentPressure;
    private float lastPressure;
    Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if(currentPressure > lastPressure){
            System.out.println("Improving weather on the way!");
        }else if(currentPressure == lastPressure){
            System.out.println("More of the same");
        }else if(currentPressure < lastPressure){
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void update(Observable obs, Object arg){
        if(obs instanceof WeatherData){
            WeatherData weatherData = (WeatherData) obs;
            this.lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
        }
        display();
    }
}
