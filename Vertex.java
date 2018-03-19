import java.util.*;

public class Vertex
{
	// ====== PRIVATE CLASSFIELDS ======
	private String name;
	private LinkedList<Edge> edges;

	// ====== CONSTRUCTORS ======
	public Vertex( String inName )
	{
		name = new String( inName );
		edges = new LinkedList<Edge>();
	} // end constructor

	// ====== ACCESSORS ======
	public String getName() { return name; }

	public LinkedList<Edge> getEdges() { return edges; }

	public LinkedList<Vertex> getConnected()
	{
		Vertex[] v;
		LinkedList<Vertex> verts = new LinkedList<Vertex>();

		for ( Edge e : edges )
		{
			v = e.getVertex();

			if ( equals(v[0]) )
			{
				verts.add(v[1]);
			}
			else
			{
				verts.add(v[0]);
			}
		} // end for

		return verts;
	} // end accessor

	public boolean equals( Object inObj )
	{
		Vertex inVert;
		boolean result = false;

		if ( inObj instanceof Vertex )
		{
			inVert = (Vertex)inObj;
			result = name.equals( inVert.getName() );
		}

		return result;
	} // end equals

	// ====== MUTATORS ======
	public boolean addEdge( Edge inEdge )
	{
		boolean result = false;

		if ( !edges.contains( inEdge ) )
		{
			edges.add( inEdge );
			result = true;
		} // end if

		return result;
	} // end accessor

	
	public String toString()
	{
		String output;
		LinkedList<Vertex> cons = getConnected();

		output = "VERTEX: " + name + "    CONNECTED TO: ";

		for ( int i = 0; i < cons.size(); i++ )
		{
			output = output + cons.get(i).getName();
			if ( i < edges.size() - 1 )
			{
				output = output + ", ";
			} // end if
		} // end for

		return output;
	} // end accessor
	
}
