/**
*For each graph, output "1" if the graph is acyclic and "-1" otherwise.
*
*/

import edu.princeton.cs.algs4.EdgeWeightedDigraph ;
import edu.princeton.cs.algs4.DirectedEdge ;
import edu.princeton.cs.algs4.Topological ;
public class Acyclicity {
    public static void main(String[] args) {
        In in = new In("data.txt") ;
        int g = in.readInt() ;
        for (int i = 0; i < g; i++) {
            int v = in.readInt() ;
            int e = in.readInt() ;
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(v) ;
            int w = 0 ;
            for (int j = 0; j < e; j++) {
                int v1 = in.readInt() ;
                int v2 = in.readInt() ;
                v1-- ; v2-- ;
                G.addEdge(new DirectedEdge(v1, v2, w)) ;
            }
            Topological top = new Topological(G) ;
            if(!top.hasOrder()){
                StdOut.print(-1 + " ") ;
            }
            else{
                StdOut.print(1 + " ") ;
            }

        }
    }
}
