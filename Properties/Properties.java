import java.util.*;
class Client
{
	public static void main(String[] args)
	{
		Properties props = System.getProperties();
		Enumeration props_name = props.propertyNames();
		while(props_name.hasMoreElements())
		{
			String prop_name = (String)Props_name.nextElement();
			String property = props.getProperty(props_name);
			System.out.println(prop_name+":"+property);
			
		}
	}
}