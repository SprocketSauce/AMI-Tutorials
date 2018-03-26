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

	public Vertex getVertex( String name )
	{
		Vertex vert = null;

		for ( Vertex v : vertices )
		{
			if ( name.equals( v.getName() ) )
			{
				vert = v;
			}
		}

		return vert;
	}

	public Vertex getRoot()
	{
		Vertex root;

		root = vertices.peek();

		return root;
	}

	public String toString()
	{
		String info = "VERTICES:\n";

		for ( Vertex v : vertices )
		{
			info = info + v.toString() + "\n";
		} // end for

		info = info + "\nEDGES:\n";

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

		vertexA = getVertex( nameA );
		if ( vertexA == null )
		{
			vertexA = new Vertex( nameA );
			addVertex( vertexA );
		}

		vertexB = getVertex( nameB );
		if ( vertexB == null )
		{
			vertexB = new Vertex( nameB );
			addVertex( vertexB );
		}

		return addEdge( vertexA, vertexB, weight );
	} // end mutator

	public boolean addEdge( Vertex vertexA, Vertex vertexB, int weight )
	{
		Edge inEdge;

		inEdge = new Edge( vertexA, vertexB, weight );

		vertexA.addEdge( inEdge );
		vertexB.addEdge( inEdge );

		return addEdge( inEdge );
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
