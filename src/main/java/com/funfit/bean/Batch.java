package com.funfit.bean;

public class Batch {
	private int batchId;
	private String batchName;

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, String batchName) {
		this.batchId = batchId;
		this.batchName = batchName;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + "]";
	}

}
