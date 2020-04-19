package abstractFactory;

public abstract class AbstractFactory {

	private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
	private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

	static AbstractFactory getFactory(Architecture architecture) {
		AbstractFactory factory = null;
		switch (architecture) {

		case ENGINOLA:
			factory = ENGINOLA_TOOLKIT;
			break;
		case EMBER:
			factory = EMBER_TOOLKIT;
		}
		return factory;
	}

	public abstract CPU createCPU();

	public abstract MMU createMMU();
}
