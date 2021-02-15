package bit.hibooks.service.admin;

public interface BookDataManager {
	void insertItemInfo(String url, int pageNum);
	void closeCon();
}
