import java.util.*;
import java.io.*;

public class GraphLoader
{
	public static Graph loadGraph( String filename ) throws IOException
	{
		Graph graph = new Graph();
		LinkedList<String> lineList;
		
		lineList = readFile( filename );

		for ( String l : lineList )
		{
			processLine( l, graph );
		} // end for

		return graph;
	} // end method

	private static LinkedList<String> readFile( String filename ) throws IOException
	{
		FileInputStream fileStrm = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		String line;
		LinkedList<String> lineList = new LinkedList<String>();

		try
		{
			fileStrm = new FileInputStream( filename );
			rdr = new InputStreamReader( fileStrm );
			bufRdr = new BufferedReader( rdr );

			line = new String( bufRdr.readLine() );
			while ( line != null )
			{
				lineList.add( line );
				line = bufRdr.readLine();
			} // end while
		}
		catch ( IOException e )
		{
			if ( fileStrm != null )
			{
				try { fileStrm.close(); } catch ( IOException e2 ) {}
			} // end if

			throw new IOException( e.getMessage() );
		} // end try-catch

		return lineList;
	} // end method

	private static void processLine( String line, Graph graph ) throws IOException
	{
		String[] splitLine;
		int weight;

		splitLine = line.split(" ");

		if ( splitLine.length != 3 )
		{
			throw new IOException( "Line contains invalid number of arguments" );
		}

		try
		{
			weight = Integer.parseInt( splitLine[2] );
		}
		catch ( NumberFormatException e )
		{
			throw new IOException( "Invalid weight" );
		}

		graph.addEdge( splitLine[0], splitLine[1], weight );
	} // end method
} // end class
