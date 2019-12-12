public class Connector {
	public String url;
	public WebNode a;//have to modify
	public Connector(String url) {
		this.url=url;
	}
	
	public String sentToBackSide() {
		return url;
	}
	
	public WebNode acceptResult() {
		return a;
	}
	
	
	
	
	
	
}