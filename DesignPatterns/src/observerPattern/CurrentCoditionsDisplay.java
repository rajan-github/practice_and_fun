package observerPattern;

public class CurrentCoditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humdity;
	private Subject weatherData;

	public CurrentCoditionsDisplay(Subject weatherData) {
		this.setWeatherData(weatherData);
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature + " F degrees and % " + humdity);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humdity = humidity;
		display();
	}

	public Subject getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(Subject weatherData) {
		this.weatherData = weatherData;
	}

}
