package abstractFactory;

public class Client {
	public static void main(String[] args) {
		AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
		CPU cpu = factory.createCPU();
		System.out.println(cpu);
	}

}
