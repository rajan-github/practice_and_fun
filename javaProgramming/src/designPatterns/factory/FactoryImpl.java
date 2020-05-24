package designPatterns.factory;

import designPatterns.dao.BookDao;
import designPatterns.dao.InMemoryBookDao;

public class FactoryImpl extends Factory {

	@Override
	public BookDao createDao() {
		// right now we just have one DAO
		return new InMemoryBookDao();
	}
}
