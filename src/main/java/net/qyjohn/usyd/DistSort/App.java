package net.qyjohn.usyd.DistSort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try
        {
            if (args[0].equals("master"))
            {
                System.out.println( "Starting DistSort master..." );
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
            else if (args[0].equals("client"))
            {
                System.out.println( "Starting DistSort client..." );
				String master = "127.0.0.1";
				if (args.length != 0)	
				{
					// Command line argument is the IP address of the master
					master = args[0];
				}
				
				SortClient sc = new SortClient(master);
            }
        } catch (Exception e)
        {
            System.out.println( "Invalid startup parameter. Exiting..." );
        }
    }
}