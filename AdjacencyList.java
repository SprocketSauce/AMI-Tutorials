import java.util.*;

public class AdjacencyList
{
	// ====== PRIVATE CLASSFIELDS ======
	private LinkedList<Vertex> vertices;
	
	// ====== CONSTRUCTOR ======
	public AdjacencyList()
	{
		vertices = new LinkedList<Vertex>();
	}

	// ====== ACCESSORS ======
	public Vertex getVertex( String name )
	{
		Vertex vert = null;
		
		for ( Vertex v : vertices )
		{
			if ( name.equals( v.getName() ) )
			{
				vert = v;
			}
		} // end for

		return vert;
	} // end accessor

	public LinkedList<Vertex> getVertices()
	{
		return vertices;
	} // end accessor

	public String toString()
	{
		String output = "";
		
		for ( Vertex v : vertices )
		{
			output = output + v.toString() + "\n";
		} // end for

		return output;
	} // end accessor

	// ====== MUTATORS ======
	public boolean addVertex( String name )
	{
		Vertex vert;
		boolean added = false;
		
		if ( getVertex( name ) == null )
		{
			vert = new Vertex( name );
			vertices.add( vert );
			added = true;
		} // end if

		return added;
	} // end mutator
	
	public void addEdge( String nameA, String nameB, int weight )
	{
		Vertex vertexA, vertexB;
		
		addVertex( nameA );
		addVertex( nameB );

		vertexA = getVertex( nameA );
		vertexB = getVertex( nameB );

		vertexA.addEdge( vertexB, weight );
		vertexB.addEdge( vertexA, weight );
	} // end mutator

} // end class
