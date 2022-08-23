package bean;

import java.util.List;

public class Page {
	//存储页面信息
	private int totalCount;
	private int pageSize;
	private int totalPage;
	private int currentPage;
	private List<OpenRoomReconrd> openRoomReconrds;

	public int getTotalCount(){
		return totalCount;
	}
	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		//设置页面大小
		this.pageSize = pageSize;
		//自动计算出页面总数
		this.totalPage = this.totalCount % this.pageSize == 0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}
	public int getTotalPage(){
		return totalPage;
	}
	public void setTotalPage(int totalPage){
		this.totalPage = totalPage;
	}
	public int getCurrentPage(){
		return currentPage;
	}
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}
	public List<OpenRoomReconrd> getOpenRoomReconrds(){
		return openRoomReconrds;
	}
	public void setOpenRoomReconrds(List<OpenRoomReconrd> openRoomReconrds){
		this.openRoomReconrds = openRoomReconrds;
	}

	public Page() {
	}

	public Page(int totalCount, int pageSize, int totalPage, int currentPage, List<OpenRoomReconrd> openRoomReconrds) {
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.openRoomReconrds = openRoomReconrds;
	}

	@Override
	public String toString() {
		return "Page{" +
				"totalCount=" + totalCount +
				", pageSize=" + pageSize +
				", totalPage=" + totalPage +
				", currentPage=" + currentPage +
				", openRoomReconrds=" + openRoomReconrds +
				'}';
	}
}
