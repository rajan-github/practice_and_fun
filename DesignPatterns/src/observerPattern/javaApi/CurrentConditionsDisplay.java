package observerPattern.javaApi;

import java.util.Observable;
import java.util.Observer;

import observerPattern.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable o) {
		this.observable = o;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("current conditions: " + this.temperature + "F and humidity: " + this.humidity);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.humidity = weatherData.getHumidity();
			this.temperature = weatherData.getTemperature();
			display();
		}
	}

}
