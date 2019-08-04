package com.hxz.common.page;

public class PageParam {
	public int offset;
	public int limit;

	public PageParam() {
	}

	public PageParam(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
