package telran.calculator;

import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class MenuAppl
{

	public static void main(String[] args)
	{
		InputOutput inOut = new ConsoleInputOutput();
		Item[] items = 
				{
						new CalculatorItem(inOut),
						new ExitItem()
				};
		
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}

}
