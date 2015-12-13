package net.qyjohn.usyd.DistSort;

public class SortClient
{

	long maxMemory, allocatedMemory, freeMemory;
	int  cpuCount;
	String master = "127.0.0.1";

	public SortClient(String master)
	{
		this.master = master;
		Runtime runtime = Runtime.getRuntime();
		maxMemory = runtime.maxMemory();
		allocatedMemory = runtime.totalMemory();
		freeMemory = runtime.freeMemory();
		cpuCount = runtime.availableProcessors();

		System.out.println("Master Server: \t" + this.master);
		System.out.println("Max Memory: \t" + maxMemory);
		System.out.println("Allocated Memory: \t" + allocatedMemory);
		System.out.println("Free Memory: \t" + freeMemory);
		System.out.println("Number of CPU: \t" + cpuCount);
		
		getNetworkConfiguration();
		
	}

	/**
	 *
	 * Receive network configuration from the message queue.
	 *
	 */
	 
	public void getNetworkConfiguration()
	{
		
	}
	
	
	public static void main(String args[])
	{
		String master = "127.0.0.1";
		if (args.length != 0)	
		{
			// Command line argument is the IP address of the master
			master = args[0];
		}
		
		SortClient sc = new SortClient(master);
	}
}