import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {
	
	public static void main(String args[]) throws IOException
	{
		Graph graph;
        FileReader read = new FileReader(args[0]);
        BufferedReader  scan = new BufferedReader(read);
        String line = scan.readLine();
        scan.close(); 
        String len [] = line.split("	");
        graph = new Graph(len.length, len.length);
       graph.populate(args[0]);
       graph.DFTOutput(args[1], args[2]);
       graph.BFTOutput(args[1], args[3]);

	}
}
