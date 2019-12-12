import java.io.IOException;
import java.util.ArrayList;


public class WebTree {
	public WebNode root;
	
	public WebTree(WebPage rootPage){
		this.root = new WebNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
		setPostOrderScore(root, keywords);
	}
	
	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException{
		// 1. compute the score of children nodes
		// 2. setNode score of startNode
		startNode.setNodeScore(keywords);
		if(!startNode.children.isEmpty()) {
			for(WebNode child : startNode.children) {
				setPostOrderScore(child,keywords);
				startNode.nodeScore += child.nodeScore;
			}
			
		}
	}
	
	public void eularPrintTree(){
		eularPrintTree(root);
	}
	
	private void eularPrintTree(WebNode startNode){
		int nodeDepth = startNode.getDepth();
		
		if(nodeDepth > 1) System.out.print("\n" + repeat("\t", nodeDepth-1));
		System.out.print("(");
		System.out.print(startNode.webPage.name+","+startNode.nodeScore);
		
		for(WebNode child : startNode.children){
			eularPrintTree(child);

		}
		System.out.print(")");
		if(startNode.isTheLastChild()) System.out.print("\n" + repeat("\t", nodeDepth-2));
		
	}
	
	private String repeat(String str,int repeat){
		String retVal  = "";
		for(int i=0;i<repeat;i++){
			retVal+=str;
		}
		return retVal;
	}
	private void filterURL() {
		filterURL(root);
		if(!root.webPage.url.contains("news")&&!root.webPage.url.contains("cnn")) {
			root = root.children.get(0);
		}
	}
	private void filterURL(WebNode startNode) {
		if (!startNode.children.isEmpty()) {
			for (WebNode child : startNode.children) {
				if (!child.children.isEmpty()) {
					filterURL(child);
					
				}
				else {
					if(!child.webPage.url.contains("news")&&!child.webPage.url.contains("cnn")) {
						startNode.children.remove(child);
					}
				}
			}
		}
	}
}

