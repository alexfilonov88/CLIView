package telran.view;

public class Menu
{
	Item[] items;
	InputOutput inputOutput;
	
	public Menu(Item[] items, InputOutput inputOutput)
	{
		super();
		this.items = items;
		this.inputOutput = inputOutput;
	}
	
	public void runMenu()
	{
		while(true)
		{
			for(int i=0; i<items.length; i++)
			{
				inputOutput.outputLine(String.format("%d. %s", i+1, items[i].displayedName()));
			}
			
			Integer selected = inputOutput.inputInteger("Enter item number", 1, items.length);
			if(selected == null)
				return;
			
			try
			{
				items[selected-1].perform();
			} catch (Exception e)
			{
				inputOutput.outputLine(e.getMessage());
			}
			
			if(items[selected-1].isExit())
				return;
		}
	}
}
