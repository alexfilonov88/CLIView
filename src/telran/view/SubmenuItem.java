package telran.view;

public class SubmenuItem implements Item
{
	InputOutput inputOutput;
	Item[] items;
	String displayedName;
	
	public SubmenuItem(InputOutput inputOutput, Item[] items, String displayedName)
	{
		super();
		this.inputOutput = inputOutput;
		this.items = items;
		this.displayedName = displayedName;
	}

	@Override
	public String displayedName()
	{
		return displayedName;
	}

	@Override
	public void perform()
	{
		Menu menu = new Menu(items, inputOutput);
		menu.runMenu();
	}

}
