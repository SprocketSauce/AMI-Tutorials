import java.util.*;

public class BreadthSearch
{
	public static LinkedList<Vertex> search( String target, Graph graph )
	{
		Vertex subRoot, pointer, found;
		int index;
		Queue<Vertex> open = new LinkedList<Vertex>();
		Queue<Vertex> openP = new LinkedList<Vertex>();
		LinkedList<Vertex> closed = new LinkedList<Vertex>();
		LinkedList<Vertex> closedP = new LinkedList<Vertex>();
		LinkedList<Vertex> children;
		LinkedList<Vertex> path = new LinkedList<Vertex>();

		open.add( graph.getRoot() );
		openP.add( graph.getRoot() );
		found = null;
		pointer = null;

		while ( open.peek() != null && found == null )
		{
			subRoot = open.poll();
			pointer = openP.poll();

			if ( subRoot.getName().equals( target ) )
			{
				found = subRoot;
			}
			else
			{
				children = subRoot.getConnected();
				for ( Vertex c : children )
				{
					if ( !closed.contains(c) && !open.contains(c) )
					{
						open.add(c);
						openP.add( subRoot );
					} // end if
				} // end for

				closed.add( subRoot );
				closedP.add( pointer );
			} // end if-else
		} // end while

		path.add( found );

		while ( !found.equals( pointer ) )
		{
			index = closed.indexOf( pointer );
			found = pointer;
			pointer = closedP.get( index );
			path.addFirst( found );
		} // end while

		return path;
	} // end method
} // end class
