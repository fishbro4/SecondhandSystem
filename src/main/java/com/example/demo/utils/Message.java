package com.example.demo.utils;

public class Message {
	 private int status;//状态码
	    private Object data;//消息体
	    private String message;//提示

	    public Message(int status, Object data, String message) {
	        this.status = status;
	        this.data = data;
	        this.message = message;
	    }

	    public static Message ok() {
	        return new Message(200, null, "成功");
	    }

	    public static Message ok(Object data) {
	        return new Message(200, data, "成功");
	    }

	    public static Message ok(Object data, String message) {
	        return new Message(200, data, message);
	    }

	    public static Message error(int status, Object data, String message) {
	        return new Message(status, data, message);
	    }

	    public static Message error(int status, String message) {
	        return error(status, null, message);
	    }

	    public static Message error() {
	        return error(511, null, "失败");
	    }

	    public static Message error(String message) {
	        return error(511,null,message);
	    }

	    //自定义状态码
	    //511 失败
	    //420 token验证失败
	    public static Message error512() {
	        return error(512, "token失效，请重新登录");
	    }

	    public int getStatus() {
	        return status;
	    }

	    public void setStatus(int status) {
	        this.status = status;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    @Override
	    public String toString() {
	        return "Message{" +
	                "status=" + status +
	                ", data='" + data.toString() + '\'' +
	                ", message='" + message + '\'' +
	                '}';
	    }
}
