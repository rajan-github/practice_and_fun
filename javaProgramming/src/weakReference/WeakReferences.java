package weakReference;

import java.lang.ref.WeakReference;

public class WeakReferences {
	public static void main(String[] args) throws InterruptedException {
		Person person = new Person("kappa", 24, "England");
		WeakReference<Person> wr = new WeakReference<>(person);
		System.gc();
		Thread.sleep(10000);
		System.out.println(wr.get());
	}
}
