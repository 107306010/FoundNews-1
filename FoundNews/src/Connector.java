public class Connector {
	public String url;
	public Node a;//have to modify
	public Connector(String url) {
		this.url=url;
	}
	
	public String sentToBackSide() {
		return url;
	}
	
	public Node acceptResult() {
		return a;
	}
	
	
	
	
	
	
}