import java.util.*;

public class Graph
{
	// ====== PRIVATE CLASSFIELDS ====== //
	private LinkedList<Vertex> vertices;
	private LinkedList<Edge> edges;

	// ====== CONSTRUCTOR ======
	public Graph()
	{
		vertices = new LinkedList<Vertex>();
		edges = new LinkedList<Edge>();
	}

	// ====== ACCESSORS ======
	public LinkedList<Vertex> getVertices() { return vertices; }

	public LinkedList<Edge> getEdges() { return edges; }

	public String toString()
	{
		String info = "VERTICES:\n";

		for ( int i = 0; i < vertices.size(); i++ )
		{
			info = info + vertices.get(i).getName();
			
			if ( i < vertices.size() - 1 )
			{
				info = info + ", ";
			}
		} // end for

		info = info + "\n\nEDGES:\n";

		for ( Edge e : edges )
		{
			info = info + e.toString() + "\n";
		} // end for

		return info;
	} // end accessor

	// ====== MUTATORS ======
	public boolean addVertex( String name )
	{
		Vertex inVert;
		boolean result = false;

		inVert = new Vertex( name );

		if ( !vertices.contains( inVert ) )
		{
			vertices.add( inVert );
			result = true;
		}

		return result;
	}

	public boolean addVertex( Vertex inVert )
	{
		boolean result = false;

		if ( !vertices.contains( inVert ) )
		{
			vertices.add( inVert );
			result = true;
		}

		return result;
	}

	public boolean addEdge( String nameA, String nameB, int weight )
	{
		Vertex vertexA, vertexB;

		vertexA = new Vertex( nameA );
		vertexB = new Vertex( nameB );

		return addEdge( vertexA, vertexB, weight );
	} // end mutator

	public boolean addEdge( Vertex vertexA, Vertex vertexB, int weight )
	{
		addVertex( vertexA );
		addVertex( vertexB );

		return addEdge( new Edge( vertexA, vertexB, weight ) );
	} // end mutator

	public boolean addEdge( Edge inEdge )
	{
		boolean result = false;

		if ( !edges.contains( inEdge ) )
		{
			edges.add( inEdge );
			result = true;
		}

		return result;
	} // end mutator
}
