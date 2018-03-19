import java.util.*;
import java.io.IOException;

public class DisplayGraph
{
	public static void main( String[] args )
	{
		String filename, graphDisplay;
		Graph graph;	

		filename = inputString( "Enter name of graph file: " );
		System.out.println();
		
		try
		{
			graph = GraphLoader.loadGraph( filename );
			System.out.println( graph.toString() );
		}
		catch ( IOException e )
		{
			System.out.println( e.getMessage() );
		}
	} // end main

	private static String inputString( String prompt )
	{
		Scanner sc = new Scanner( System.in );
		String input;

		System.out.print( prompt );
		input = sc.next();

		return input;
	} // end method

} // end class
