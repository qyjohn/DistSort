package net.qyjohn.usyd.DistSort;

import java.util.HashSet;
import org.dom4j.*;

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
		
		// Create MQ SortClient_To_Master
		PullMQ pmq = new PullMQ("localhost", "SortClient_To_Master");
		
		// Wait for SortClient registration
		waitClientRegistration(pmq);
	}
	
	/**
	 *
	 * Wait for SortClient registration through MQ.
	 *
	 */
	  
	public void waitClientRegistration(PullMQ pmq)
	{
		HashSet<String> clients = new HashSet<String>();
		while (clients.size() < totalClients)
		{
			try
			{
				String msg = pmq.pullMQ();
				Element client = DocumentHelper.parseText(msg).getRootElement();
				
			} catch (Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
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