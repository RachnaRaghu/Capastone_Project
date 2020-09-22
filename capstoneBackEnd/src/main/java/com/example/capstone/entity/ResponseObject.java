package com.example.capstone.entity;

public class ResponseObject {
	
	private Boolean result;
    private Object resultObject;
    
    
	public ResponseObject(Boolean result, Object resultObject) {
		super();
		this.result = result;
		this.resultObject = resultObject;
	}
	public ResponseObject() {
		// TODO Auto-generated constructor stub
	}
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public Object getResultObject() {
		return resultObject;
	}
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	
}
