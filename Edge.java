public class Edge
{
	// ====== PRIVATE CLASSFIELDS ======
	private Vertex vertex1;
	private Vertex vertex2;
	private int weight;

	// ====== CONSTRUCTORS ======
	public Edge ( Vertex inVert1, Vertex inVert2, int inWeight )
	{
		vertex1 = inVert1;
		vertex2 = inVert2;
		weight = inWeight;
	} // end constructor

	// ====== ACCESSORS ======
	public Vertex[] getVertex()
	{
		Vertex[] verts = new Vertex[2];

		verts[0] = vertex1;
		verts[1] = vertex2;

		return verts;
	}

	public int getWeight() { return weight; }

	public boolean equals( Object inObj )
	{
		Edge inEdge;
		Vertex[] inVerts;
		boolean result = false;

		if ( inObj instanceof Edge )
		{
			inEdge = (Edge)inObj;
			inVerts = inEdge.getVertex();

			result = ( weight == inEdge.getWeight() ) && inVerts[0].equals(vertex1) && inVerts[1].equals(vertex2);
		}

		return result;
	}

	public String toString()
	{
		String output;
		
		output = vertex1.getName() + " to "  + vertex2.getName() + " - " + weight;

		return output;
	}
} // end class
