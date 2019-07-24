package com.huawei.cse.demoresource.entity;

public class Resource {
	public enum Status{
		FREE,OCCUPIED
	}
	private int resourceId;
	private int customerId;
	private String status;

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Status getStatus() {
		return Status.valueOf(status);
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Resource{" +
			"resourceId=" + resourceId +
			", customerId=" + customerId +
			", status=" + status +
			'}';
	}

	public Resource(int resourceId, int customerId, String status) throws Exception {
		if(Status.valueOf(status)==null){
			throw new Exception("wrong status");
		}
		this.resourceId = resourceId;
		this.customerId = customerId;
		this.status = status;
	}

	public Resource() {
	}

	public Resource(int customerId, String status) throws Exception {
		if(Status.valueOf(status)==null){
			throw new Exception("wrong status");
		}
		this.customerId = customerId;
		this.status = status;
	}
}
