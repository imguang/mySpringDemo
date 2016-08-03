package com.imguang.demo.entity;

public class PageInfo {

	public int nowPage;
	public int onePageNum = 5;
	public int totNum;

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getOnePageNum() {
		return onePageNum;
	}

	public void setOnePageNum(int onePageNum) {
		this.onePageNum = onePageNum;
	}

	public int getTotNum() {
		return totNum;
	}

	public void setTotNum(int totNum) {
		this.totNum = totNum;
	}

	@Override
	public String toString() {
		return "PageInfo [nowPage=" + nowPage + ", onePageNum=" + onePageNum
				+ ", totNum=" + totNum + "]";
	}

}
