package observerPattern;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentCoditionsDisplay ccd = new CurrentCoditionsDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 65, 29.4f);
		weatherData.setMeasurements(86, 65, 31.4f);
		ccd.display();
	}

}
