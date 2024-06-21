package telran.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import telran.view.InputOutput;
import telran.view.Item;

public class CalculatorItem implements Item
{
	InputOutput inputOutput;
	static Map<String, BinaryOperator<Integer>> mapOperations;
	static
	{
		mapOperations = new HashMap<>();
		mapOperations.put("+", (o1, o2) -> o1 + o2);
		mapOperations.put("*", (o1, o2) -> o1 * o2);
		mapOperations.put("-", (o1, o2) -> o1 - o2);
		mapOperations.put("/", (o1, o2) -> o2 == 0 ? null : o1 / o2);
	}
	
	public CalculatorItem(InputOutput inputOutput)
	{
		super();
		this.inputOutput = inputOutput;
	}

	@Override
	public String displayedName()
	{
		return "Integer numbers calculator";
	}

	@Override
	public void perform()
	{
		Integer op1 = inputOutput.inputInteger("Enter first number");
		if(op1 == null)
			return;
		
		Integer op2 = inputOutput.inputInteger("Enter second number");
		if(op2 == null)
			return;
		
		String operator = inputOutput.inputString("Enter operator from", 
				new ArrayList<>(mapOperations.keySet()));
		if(operator == null)
			return;
		
		inputOutput.outputLine(mapOperations.get(operator).apply(op1, op2));
	}

}
