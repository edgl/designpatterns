package designpatterns;

public class LeafNode extends ComponentNode {

	private int item;
	
	public LeafNode(int item) {
		this.item = item;
	}
	
	public int item() {
		return item;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public LeafNode(String item) {
		this.item = Integer.parseInt(item);
	}
}
