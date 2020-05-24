package designPatterns.factory;

import designPatterns.dao.BookDao;

public abstract class Factory {
	public abstract BookDao createDao();
}
