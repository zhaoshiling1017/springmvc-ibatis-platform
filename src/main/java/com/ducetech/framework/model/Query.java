package com.ducetech.framework.model;

public class Query<T> {

	private int rows = 10;
	
	private int page = 0;
	
	private T t;

	public Query() {
		
	}
	
	public Query(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
