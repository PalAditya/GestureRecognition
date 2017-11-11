
import java.util.*;

 

/*
 * This class models a simple, undirected graph using an
005
 * incidence list representation. Vertices are identified
006
 * uniquely by their labels, and only unique vertices are allowed.
007
 * At most one Edge per vertex pair is allowed in this Graph.
008
 *
009
 * Note that the Graph is designed to manage the Edges. You
010
 * should not attempt to manually add Edges yourself.
011
 *
012
 * @author Michael Levet
013
 * @date June 09, 2015
014
 */

public class Graph {

     

    private HashMap<String, Vertex> vertices;

    private HashMap<Integer, Edge> edges;

     

    public Graph(){

        this.vertices = new HashMap<String, Vertex>();

        this.edges = new HashMap<Integer, Edge>();

    }

     

    /**
026
     * This constructor accepts an ArrayList<Vertex> and populates
027
     * this.vertices. If multiple Vertex objects have the same label,
028
     * then the last Vertex with the given label is used.
029
     *
030
     * @param vertices The initial Vertices to populate this Graph
031
     */

    public Graph(ArrayList<Vertex> vertices){

        this.vertices = new HashMap<String, Vertex>();

        this.edges = new HashMap<Integer, Edge>();

         

        for(Vertex v: vertices){

            this.vertices.put(v.getLabel(), v);

        }

         

    }
    /**
043
     * This method adds am edge between Vertices one and two
044
     * of weight 1, if no Edge between these Vertices already
045
     * exists in the Graph.
046
     *
047
     * @param one The first vertex to add
048
     * @param two The second vertex to add
049
     * @return true iff no Edge relating one and two exists in the Graph
050
     */

    public boolean addEdge(Vertex one, Vertex two){

        return addEdge(one, two, 1);

    }

     

    /**
057
     * Accepts two vertices and a weight, and adds the edge
058
     * ({one, two}, weight) iff no Edge relating one and two
059
     * exists in the Graph.
060
     *
061
     * @param one The first Vertex of the Edge
062
     * @param two The second Vertex of the Edge
063
     * @param weight The weight of the Edge
064
     * @return true iff no Edge already exists in the Graph
065
     */

    public boolean addEdge(Vertex one, Vertex two, int weight){
        if(one.equals(two)){

            return false;  
        }

        
        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }
        
        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(e) || two.containsNeighbor(e)){
            return false;

        }

             
        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);
        return true;

    }
     

    /**
089
     *
090
     * @param e The Edge to look up
091
     * @return true iff this Graph contains the Edge e
092
     */

    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }

         
        return this.edges.containsKey(e.hashCode());
    }
     
    /**
103
     * This method removes the specified Edge from the Graph,
104
     * including as each vertex's incidence neighborhood.
105
     *
106
     * @param e The Edge to remove from the Graph
107
     * @return Edge The Edge removed from the Graph
108
     */
    public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
    }
    /**
     *
117
     * @param vertex The Vertex to look up
118
     * @return true iff this Graph contains vertex
119
     */
    public boolean containsVertex(Vertex vertex){

        return this.vertices.get(vertex.getLabel()) != null;
    }
     
    /**
125
     *
126
     * @param label The specified Vertex label
127
     * @return Vertex The Vertex with the specified label
128
     */
    public Vertex getVertex(String label){
        return vertices.get(label);
    }
    /**
134
     * This method adds a Vertex to the graph. If a Vertex with the same label
135
     * as the parameter exists in the Graph, the existing Vertex is overwritten
136
     * only if overwriteExisting is true. If the existing Vertex is overwritten,
137
     * the Edges incident to it are all removed from the Graph.
138
     *
139
     * @param vertex
140
     * @param overwriteExisting
141
     * @return true iff vertex was added to the Graph
142
     */
    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }
            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }
        vertices.put(vertex.getLabel(), vertex);
        return true;
    }
    /**
161
     *
162
     * @param label The label of the Vertex to remove
163
     * @return Vertex The removed Vertex object
164
     */
    public Vertex removeVertex(String label){
        Vertex v = vertices.remove(label);
        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor((0)));
        }
        return v;
    }
    /**
176
     *
177
     * @return Set<String> The unique labels of the Graph's Vertex objects
178
     */
    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }
    /**
184
     *
185
     * @return Set<Edge> The Edges of this graph
186
     */
    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
}

