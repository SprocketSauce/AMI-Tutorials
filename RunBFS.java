import java.util.*;
import java.io.IOException;

public class RunBFS
{
	public static void main( String[] args )
	{
		String filename, target;
		LinkedList<Vertex> path;
		Vertex vertex;
		Graph graph;
		int size;

		filename = DisplayGraph.inputString( "Input graph filename: " );
		target = DisplayGraph.inputString( "Input target vertex: " );

		try
		{
			graph = GraphLoader.loadGraph( filename );

			path = BreadthSearch.search( target, graph );

			size = path.size();
			while ( size != 0 )
			{
				vertex = path.poll();
				System.out.print( vertex.getName() );
				size = path.size();
				if ( size != 0 )
					System.out.print( " -> ");
			} // end while
			System.out.println();
		}
		catch ( IOException e )
		{
			System.out.println( e.getMessage() );
		} // end try-catch
	}
}
