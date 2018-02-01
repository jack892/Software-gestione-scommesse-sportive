package utils;

public class Message implements java.io.Serializable{
	
	private String content;
	
	public Message(){}
	
	public Message(String s){
		this.content = s;
	}
	
	public void setContent(String s){
		this.content = s;
	}
	
	public String getContent(){
		return content;
	}
}
