package com.nadeem.app.dsa.algo;

import java.util.Deque;
import java.util.LinkedList;

public class PostfixToInfixConverter implements ExpressionConverter {

	@Override
	public String convert(String postfix) {
		String[] expressions = postfix.split("\\s");
		 Deque<Expression> stack = new LinkedList<Expression>();
		for (String exp : expressions) {
			if (exp.equals("+") || exp.equals("-")) {
				String right = stack.pop().getExpression();
				String left = stack.pop().getExpression();
				Expression newExp = new Expression(right + exp + left, exp);
				stack.push(newExp);
			} else if (exp.equals("*") || exp.equals("/")) {
				String right = correctExpression(stack.pop());
				String left = correctExpression(stack.pop());
				stack.push(new Expression(right +  exp +  left, exp));
			} else {
				stack.push(new Expression(exp, ""));
			}
		}
		return stack.pop().getExpression();
	}
	
	private String correctExpression(Expression exp) {
		String result = exp.getExpression();
		if (exp.getOperatorUsed().equals("+") || exp.getOperatorUsed().equals("-")) {
			result = "(" + result + ")";
		}
		return result;
	}

	private static class Expression {
		String expression;
		String operatorUsed;
		public Expression(String exp, String operator) {
			this.expression = exp;
			this.operatorUsed = operator;
		}
		public String getExpression() {
			return expression;
		}
		public String getOperatorUsed() {
			return operatorUsed;
		}		
	}	
}
