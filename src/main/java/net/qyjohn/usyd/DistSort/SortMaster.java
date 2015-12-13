package net.qyjohn.usyd.DistSort;

public class SortMaster
{
	int totalClients = 1;
	
	/**
	 *
	 * Constructor.
	 *
	 */

	public SortMaster(int totalClients)
	{
		// Get the total number of SortClient
		this.totalClients = totalClients;
		System.out.println(this.totalClients);
		
		// Wait for SortClient registration
		waitClientRegistration();
	}
	
	/**
	 *
	 * Wait for SortClient registration through MQ.
	 *
	 */
	  
	public void waitClientRegistration()
	{
		
	}
	
	/**
	 *
	 * Startup method. The input argument is the number of SortClient. Default to 1 SortClient if no 
	 * input argument is provided.
	 *
	 */
	
	public static void main(String args[])
	{
		int totalClients = 1;
		if (args.length != 0)
		{
			try
			{
				// Get the number of SortClient
				totalClients = Integer.parseInt(args[0]);	
			} catch (Exception e) {}
		}	
		SortMaster sm = new SortMaster(totalClients);
	}
}