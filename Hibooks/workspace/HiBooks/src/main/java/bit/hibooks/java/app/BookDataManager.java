package bit.hibooks.java.app;

public interface BookDataManager {
	void insertItemInfo(String url, int pageNum);
	void closeCon();
}
