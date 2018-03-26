import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Graph {
	int graph [] [];
	int visited [];
	Scanner scan;
	int width;
	int length;
	Vector vertexes = new Vector();
	
	
	public Graph(int w, int l)
	{
		graph = new int[w][l];
		width = w;
		length = l;
		visited = new int [l];
		
		for(int i = 0 ; i < visited.length; i++)
		{
			visited[i] = 0;
		}
	}
	public void WidthAndLength()
	{
		System.out.println(graph.length + " " + graph[0].length);
	}
	public void populate(String file)
	{
		int i = 0;
		 FileReader read;
		try {
			
			read = new FileReader(file);
		    BufferedReader  scan = new BufferedReader(read);
		    String line = scan.readLine();
		    while(line != null)
		    {
		    String len [] = line.split("	");
		    for(int j = 0; j< width; j++)
		    {
		    	graph[i][j] = Integer.parseInt(len[j]);
		    }
		    line = scan.readLine();
		    i++;
		   }
		    
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  
	}
	public void Display()
	{
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < length; j++)
			{
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
	}
	public boolean DepthFirst(int f, int l, int r) throws FileNotFoundException 
	{
		
		int j;
		vertexes.append(f);
		
        visited[f]=1;
        if(f == l)
        {
     	return true;   
        }
        for(j=0; j<length; j++)
        {
            if(visited[j] == 0 && graph[f][j] == 1 )
            {
            	
                boolean found = DepthFirst(j , l, r);
                if(found == true)
                {
                	return true;
                } 
            }
        }
        return false;
	}
	public void DFTOutput(String args1, String args2) throws IOException
	{
		 FileReader read2 = new FileReader(args1);
	       BufferedReader  scan2 = new BufferedReader(read2);
	       String line2 = scan2.readLine();
	       PrintWriter print = new PrintWriter(args2);
	       while(line2 != null)
	       {
	    	   String numbs [] = line2.split("	");
	    	  boolean good = DepthFirst(Integer.parseInt(numbs[0]) , Integer.parseInt(numbs[1]), 0);
	    	  if(good == false)
	    	  {
	    		  print.print(Integer.parseInt(numbs[0]) + " " + "-1" + " " + Integer.parseInt(numbs[1]) );
	    	  }
	    	  else
	    	  {
	    	  for(int i = 0 ; i < vertexes.size() ; i ++)
	    	  {
	    		 
	    		  print.print(vertexes.elementAt(i) + " ");
	    		  
	    	  }
	    	  }
	    	   print.println();
	    	   postTraversale();
	    	   line2 = scan2.readLine();
	       }
		   print.close();
	       scan2.close();
	}
	public void postTraversale()
	{
		for(int i = 0 ; i < visited.length; i++)
		{
			visited[i] = 0;
		}
	vertexes.clear();
	}

	public void BreadthFirst(int start, int end)
	{
		{
		    int v=graph.length;
		    Queue queue = new Queue(length);
		    
		    visited[start]=1;
		    queue.enqueue(start);
		    while(!queue.isEmpty())
		    {
		        int x=queue.dequeue();
		        vertexes.append(x);
		        if( x == end)
	              {
	            	  break;
	              }
		        for (int i=1; i < v; i++) 
		            if((graph[x][i] == 1) && (visited[i]) == 0)
		            {
		              
		            	queue.enqueue(i);
		            	visited[i] = 1;
		             }
		     	}
			}
		}
	public void BFTOutput(String query, String output) throws IOException
	{
		FileReader read2 = new FileReader(query);
	       BufferedReader  scan2 = new BufferedReader(read2);
	       String line2 = scan2.readLine();
	       PrintWriter print = new PrintWriter(output);
	       while(line2 != null)
	       {
	    	   String numbs [] = line2.split("	");
	    	   BreadthFirst(Integer.parseInt(numbs[0]) , Integer.parseInt(numbs[1]));
	    	   System.out.println();
	    	   if((Integer)vertexes.elementAt(vertexes.size()-1 ) != Integer.parseInt(numbs[1]))   	
	    	   {
	     		  print.print(Integer.parseInt(numbs[0]) + " " + "-1" + " " + Integer.parseInt(numbs[1]) );
	     	  }
	     	  else
	     	  {
	     	  for(int i = 0 ; i < vertexes.size() ; i ++)
	     	  {
	     		 
	     		  print.print(vertexes.elementAt(i) + " ");
	     		  
	     	  }
	     	  }
	     	   print.println();
	     	   postTraversale();
	     	   line2 = scan2.readLine();
	    	  
	    	   
	       }
		   print.close();
	       scan2.close();
	}
}
