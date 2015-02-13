package designpatterns;

public class InstrumentedExpressionTree extends ExpressionTree {

	public InstrumentedExpressionTree(ComponentNode root) {
		super(root);
	}
	
	@Override
	public void accept(Visitor visitor) {
		System.out.println("starting accept call");
		super.accept(visitor);
		System.out.println("end accept() call");
	}

	
}
