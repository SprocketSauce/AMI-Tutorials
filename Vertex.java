import java.util.*;

public class Vertex
{
	// ====== PRIVATE CLASSFIELDS ======
	private String name;

	// ====== CONSTRUCTORS ======
	public Vertex( String inName )
	{
		name = new String( inName );
	} // end constructor

	// ====== ACCESSORS ======
	public String getName() { return name; }

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
	}

	/*
	public String toString()
	{
		String output;

		output = "VERTEX: " + name + "    EDGES: ";

		for ( int i = 0; i < edges.size(); i++ )
		{
			output = output + edges.get(i).toString();
			if ( i < edges.size() - 1 )
			{
				output = output + ", ";
			} // end if
		} // end for

		return output;
	} // end accessor
	*/
}
