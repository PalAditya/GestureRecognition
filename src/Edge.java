/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
/**
002
 * This class models an undirected Edge in the Graph implementation.
003
 * An Edge contains two vertices and a weight. If no weight is
004
 * specified, the default is a weight of 1. This is so traversing
005
 * edges is assumed to be of greater distance or cost than staying
006
 * at the given vertex.
007
 *
008
 * This class also deviates from the expectations of the Comparable interface
009
 * in that a return value of 0 does not indicate that this.equals(other). The
010
 * equals() method only compares the vertices, while the compareTo() method
011
 * compares the edge weights. This provides more efficient implementation for
012
 * checking uniqueness of edges, as well as the fact that two edges of equal weight
013
 * should be considered equitably in a pathfinding or spanning tree algorithm.
014
 *
015
 * @author Michael Levet
016
 * @date June 09, 2015
017
 */

public class Edge implements Comparable<Edge> {

 

    private Vertex one, two;

    private int weight;

     

    /**
024
     *
025
     * @param one The first vertex in the Edge
026
     * @param two The second vertex in the Edge
027
     */

    Edge(Vertex one, Vertex two){

        this(one, two, 1);

    }

     

    /**
033
     *
034
     * @param one The first vertex in the Edge
035
     * @param two The second vertex of the Edge
036
     * @param weight The weight of this Edge
037
     */

    public Edge(Vertex one, Vertex two, int weight){

        this.one = (one.getLabel().compareTo(two.getLabel()) <= 0) ? one : two;

        this.two = (this.one == one) ? two : one;

        this.weight = weight;

    }

     

     

    /**
046
     *
047
     * @param current
048
     * @return The neighbor of current along this Edge
049
     */

    public Vertex getNeighbor(Vertex current){

      if(!(current.equals(one) || current.equals(two))){

            return null;

       }

         

        return (current.equals(one)) ? two : one;
 }

     

    /**
059
     *
060
     * @return Vertex this.one
061
     */

    public Vertex getOne(){

        return this.one;

    }

     

    /**
067
     *
068
     * @return Vertex this.two
069
     */

    public Vertex getTwo(){

        return this.two;

    }

     

     

    /**
076
     *
077
     * @return int The weight of this Edge
078
     */

    public int getWeight(){

        return this.weight;

    }

     

     

    /**
085
     *
086
     * @param weight The new weight of this Edge
087
     */

    public void setWeight(int weight){
        this.weight = weight;

    }

     

    

    /**
094
     * Note that the compareTo() method deviates from
095
     * the specifications in the Comparable interface. A
096
     * return value of 0 does not indicate that this.equals(other).
097
     * The equals() method checks the Vertex endpoints, while the
098
     * compareTo() is used to compare Edge weights
099
     *
100
     * @param other The Edge to compare against this
101
     * @return int this.weight - other.weight
102
     */

    public int compareTo(Edge other){

        return this.weight - other.weight;

    }

     

    /**
108
     *
109
     * @return String A String representation of this Edge
110
     */

    public String toString(){

        return "({" + one + ", " + two + "}, " + weight + ")";

    }

     

    /**
116
     *
117
     * @return int The hash code for this Edge
118
     */

    public int hashCode(){

        return (one.getLabel() + two.getLabel()).hashCode();

    }

     

    /**
124
     *
125
     * @param other The Object to compare against this
126
     * @return ture iff other is an Edge with the same Vertices as this
127
     */

    public boolean equals(Object other){

        if(!(other instanceof Edge)){

            return false;

      }

         

        Edge e = (Edge)other;

         

        return e.one.equals(this.one) && e.two.equals(this.two);

    }  

}
