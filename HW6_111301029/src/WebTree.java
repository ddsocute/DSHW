import java.io.IOException;
import java.util.ArrayList;

public class WebTree{
	public WebNode root;

	public WebTree(WebPage rootPage){
		this.root = new WebNode(rootPage);
	}

	public void setPostOrderScore(ArrayList<Keyword> keywords) throws IOException{
		setPostOrderScore(root, keywords);
	}

	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword> keywords) throws IOException{
		// YOUR TURN
		// 3. compute the score of children nodes via post-order, then setNodeScore for
		// startNode
		for (WebNode child : startNode.children) {
			setPostOrderScore(child, keywords);
		}
		startNode.setNodeScore(keywords);
	}

	public void eularPrintTree(){
		eularPrintTree(root);
	}

	private void eularPrintTree(WebNode startNode){
		int nodeDepth = startNode.getDepth();

		if (nodeDepth > 1)
			System.out.print("\n" + repeat("\t", nodeDepth - 1));

		System.out.print("(");
		System.out.print(startNode.webPage.name + "," + startNode.nodeScore);

		// YOUR TURN
		// 4. print child via pre-order
		for (WebNode child : startNode.children) {
			eularPrintTree(child);
		}

		System.out.print(")");

		if (startNode.isTheLastChild())
			System.out.print("\n" + repeat("\t", nodeDepth - 2));
	}

	private String repeat(String str, int repeat){
		String retVal = "";
		for (int i = 0; i < repeat; i++){
			retVal += str;
		}
		return retVal;
	}
}