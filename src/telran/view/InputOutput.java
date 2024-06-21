package telran.view;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public interface InputOutput
{
	String inputString(String prompt);
	void output(Object obj);
	
	default void outputLine(Object obj)
	{
		output(obj.toString());
	}

	default <R> R inputObject(String prompt, String errorPrompt, Function<String, R> mapper)
	{
		while(true)
		{
			String answer = inputString(prompt);
			if(answer == null)
				return null;
			
			R res = mapper.apply(answer);
			if(res != null)
				return res;
			
			outputLine(errorPrompt);
		}
	}

	default Integer inputInteger(String prompt)
	{
		return inputObject(prompt, "It`s not integer number", s ->
		{
			try
			{
				return Integer.parseInt(s);
			} catch (Exception e)
			{
				return null;
			}
		});
	}
	
	default Integer inputInteger(String prompt, Integer min, Integer max)
	{
		return inputObject(prompt, 
				String.format("It`s not integer number in range [%d-%d]", min, max), s ->
		{
			try
			{
				Integer res = Integer.parseInt(s);
				return res>=min && res<=max ? res : null;
			} catch (Exception e)
			{
				return null;
			}
		});
	}
	
	default Double inputDouble(String prompt)
	{
		return null;
	}
	
	default Long inputLong(String prompt)
	{
		return null;
	}
	
	default String inputString(String prompt, List<String> options)//"+", "-", "*", "/"
	{
		return inputObject(String.format("%s %s", prompt, options), "String is not in options", 
				s -> options.contains(s) ? s : null);
	}
	
	default LocalDate inputDate(String prompt, String format)
	{
		return null;
	}
		
}
