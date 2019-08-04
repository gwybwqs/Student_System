package com.hxz.common.vo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class R {
	@JSONField(ordinal = 1)
	private boolean success;
	@JSONField(ordinal = 2)
	private String msg;
	@JSONField(ordinal = 3)
	private Object data;
	@JSONField(ordinal = 4)
	private int total;
	@JSONField(ordinal = 5)
	private List rows;

	public R() {
	}

	public R(boolean success, String msg, Object data) {
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public R(boolean success, String msg, Object data, List rows) {
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.rows = rows;
	}

	public R(boolean success, String msg, Object data, int total, List rows) {
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.total = total;
		this.rows = rows;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
}
