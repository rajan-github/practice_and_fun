package designPatterns.factory;

import designPatterns.dao.BookDao;

public class Student {
	public static void main(String[] args) {
		Factory factory = new FactoryImpl();
		BookDao dao = factory.createDao();
		System.out.println(dao);
		//work with dao.
	}
}
