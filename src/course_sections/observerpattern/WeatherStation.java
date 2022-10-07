package course_sections.observerpattern;

public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay cd = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay sd = new StatisticsDisplay(weatherData);
        ForecastDisplay fd = new ForecastDisplay(weatherData);
        HeatIndexDisplay hd = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);
    }
}
