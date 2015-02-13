package designpatterns;

import java.util.Stack;

/**
 * 
 * @class Interpreter
 * 
 * @brief Parses incoming expression string into a parse tree and
 *        builds an expression tree from the parse tree. This class
 *        plays the role of the "Interpreter" in the Interpreter 
 *        pattern, tweaked to use the precedence of operators/operands
 *        to guide the creation of the parse tree. It also uses the
 *        Builder pattern to build the component nodes in the 
 *        Composite-based expression tree.
 *
 */
public class Interpreter {

	/** Stores numbers with multiple digits */
	private int multiDigitNumbers;
	
	/** Stores the previous symbol */
	private Integer lastValidInput;
	
	/** Tracks the precedence of the expression */
	private int accumulatedPrecedence;
	
	/** 
	 * This method first converts a string into  a parse tree and then
	 * builds an expression tree out of the parse tree. It's
	 * implemented using the Template Method pattern.
	 */
	ExpressionTree interpret(String inputExpression) {
		
		/** The parse tree is implemented as a stack */
		Stack<Symbol> parseTree = buildParseTree(inputExpression);
		
		/**
		 * If the parse tree has an element in it perform the
		 * (optional) optimization pass and then build the 
		 * ExpressionTree for the parseTree
		 */
		if (!parseTree.isEmpty()) {
			
			/** 
			 * This hook method can be overridden to optimize the
			 * parseTree prior to generating the ExpressionTree
			 */
			optimizeParseTree(parseTree);
			
			/**
			 * Build the expression tree from the parseTree
			 */
			return buildExpressionTree(parseTree);
		}
		
	}

	private ExpressionTree buildExpressionTree(Stack<Symbol> parseTree) {
		// TODO Auto-generated method stub
		return null;
		
	}

	private void optimizeParseTree(Stack<Symbol> parseTree) {
		// TODO Auto-generated method stub
		
	}

	private Stack<Symbol> buildParseTree(String inputExpression) {
		Stack<Symbol> parseTree = new Stack<Symbol>();
		
		// Keep track of the last valid input, which is useful for
		// handling unary minus (negation) operators
		lastValidInput = null;
		
		boolean handled = false;
		
		// Initialize some data members to their default values
		accumulatedPrecedence = 0;
		multiDigitNumbers = 0;
		
		for (int index = 0; index < inputExpression.length(); index++) {
			parseTree = parseNextSymbol(inputExpression, index, handled, parseTree);
			
			if(multiDigitNumbers > index)
				index = multiDigitNumbers;
		}
		
		return parseTree;
	}
	
	private Stack<Symbol> parseNextSymbol(String inputExpression, int index,
			boolean handled, Stack<Symbol> parseTree) {
		
		handled = false;
		if(Character.isDigit(inputExpression.charAt(index))) {
			handled = true;
			parseTree = insertNumberOrVariable(inputExpression, index, parseTree, false);
		}
		else if(Character.isLetterOrDigit(inputExpression.charAt(index))) {
			handled = true;
			parseTree = insertNumberOrVariable(inputExpression, index, parseTree, true);
		}
		else if(inputExpression.charAt(index) == '+') {
			handled = true;
			
			Add op = new Add();
			
		}
	}

	private Stack<Symbol> insertNumberOrVariable(String inputExpression,
			int index, Stack<Symbol> parseTree, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @class Symbol
	 * @brief Base class for the variou parse tree subclasses
	 *
	 */
	abstract class Symbol {
		
		/**
		 * The following static const  set the precedence levels of
		 * the various operations and operands
		 */
		
		/** Default precendence */
		protected int precedence = 0;
		
		/** Left symbol */
		protected Symbol left;
		
		/** Right symbol */
		protected Symbol right;
		
		/**
		 * Method for returning precedence level (higher value means
		 * higher precedence).
		 * @return
		 */
		public int precedence() {
			return precedence;
		}
		
		/** Abstract method for adding precedence */
		public abstract int addPrecedence(int accumulatedPrecedence);
		
		/** Abstract method for building a @a ComponentNode */
		abstract ComponentNode build();
		
	}
	
	class Add extends Operator {

		public Add() {
			super(null, null, addSubPrecedence);
		}
		@Override
		public int addPrecedence(int accumulatedPrecedence) {
			return precedence = addSubPrecedence + accumulatedPrecedence;
		}

		@Override
		ComponentNode build() {
			return new CompositeAddNode(left.build(), right.build());
		}
		
	}
}
