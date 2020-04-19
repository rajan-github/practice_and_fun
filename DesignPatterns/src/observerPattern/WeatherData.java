package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer ob) {
		if (ob != null)
			observers.add(ob);
	}

	@Override
	public void removeObserver(Observer ob) {
		if (observers.contains(ob))
			observers.remove(ob);
	}

	@Override
	public void notifyObservers() {
		for (Observer ob : observers)
			ob.update(temperature, humidity, pressure);
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
