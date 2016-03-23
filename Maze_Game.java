import java.io.*;
//import java.lang.String.*;
import java.util.Arrays;
import java.util.*;


class node
{
public int number;
public node east;
public node west;
public node north;
public node south;
public node next;
}

public class Maze_Game
{
	ArrayList<Integer> create;
	ArrayList<Integer> destination;
	ArrayList<Integer> connect;
	
	private int trav[];
	node root;
	PrintWriter fout=null;
	
	public Maze_Game()
	{
		root=null;
	}
		
		
		public void Create_Maze()
		{
			Scanner sn =new Scanner(System.in);	
		    create=new ArrayList<Integer>();
		    BufferedReader fin=null;
		
		
		try
		{
		fin =new BufferedReader(new FileReader("CreateMaze.txt"));
		String s=fin.readLine();
		while(s!=null)
		{ 
		   String[]z=s.split(" ");
		   int len=z.length;
		   s=fin.readLine();
		   for(int i=0;i<len;i++)
			{ 
			   create.add(Integer.parseInt(z[i]));   
			}
		}
		
		node p=root;
		for(int i=0;i<create.size();i++)
		{
			
			node q;
			if((i%5)==0)
			{
				
			     if(i==0)
				 {
					 q=new node();
					q.number=create.get(i);
					 p=q;
					 root=p;
					 
				 }
				else {
				
				q=new node();
				q.number=create.get(i);
				p.next=q;
				p=q;
				}
			}
		}
	
				
			node m=root;
					
			for (int i=0;m!=null;i++)
			{
				node t;
				if((i%5)==0 && i!=0)
				{
					
					m=m.next;
				}
				
				if((i%5)==1)
				{
					if(create.get(i)!=0)
					{
						t=new node();
						t.number=create.get(i);
						m.east=t;
					}
				}
				
				if((i%5)==2)
				{
					if(create.get(i)!=0)
					{
						t=new node();
						t.number=create.get(i);
						m.west=t;
					}
				}
				
				if((i%5)==3)
				{
					if(create.get(i)!=0)
					{
						t=new node();
						t.number=create.get(i);
						m.north=t;
					}
				}
				
				if((i%5)==4)
				{
					if(create.get(i)!=0)
					{
						t=new node();
						t.number=create.get(i);
						m.south=t;
					}
				}
				
				
			}
				
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void travel() throws Exception
	{
		
		destination=new ArrayList<Integer>();
		Scanner sn =new Scanner(System.in);	
		
		BufferedReader fin=null;
		
		
		
		fout=new PrintWriter(new FileWriter("r.txt"));
		fin =new BufferedReader(new FileReader("TraverseMaze.txt"));
		String s=fin.readLine();
		int size=0;
		while(s!=null)
		{ 
			connect=new ArrayList<Integer>();
		   String[]z=s.split(" ");
		   int len=z.length;
		   s=fin.readLine();
		   for(int i=0;i<len;i++)
			{ 
			   connect.add(Integer.parseInt(z[i]));   
			}
						 
		
				
				
				int q=connect.size();
				int current=connect.get(0);
				
				node h=root;
				while(current!=h.number)
				{
					h=h.next;
				}
				
				
			for (int i=1;i<connect.size();i++)
			{
				
				int pos=connect.get(i);
				if(pos==0)
				{
					
						h=root;
						while(current!=h.number)
						{
						h=h.next;
						}
						h=h.east;
						if(h!=null)
						{current=h.number;}
						
					
				}
				
				if(pos==1)
				{
					
						h=root;
						while(current!=h.number)
						{
						h=h.next;
						}
						h=h.west;
						if(h!=null)
						{current=h.number;}
					
				}
				
				if(pos==2)
				{
					
						h=root;
						while(current!=h.number)
						{
						h=h.next;
						}
						h=h.north;
						if(h!=null)
						{current=h.number;}					
				}
				
				if(pos==3)
				{
					
						h=root;
						while(current!=h.number)
						{
						h=h.next;
						}
						h=h.south;
						if(h!=null)
						{current=h.number;}
					
				}
				
		
			}
			//destination.add(current);
			System.out.println(" ");
			fout.println(current);
			System.out.println("room "+current);
		}	
		
		fout.close();
		
			
	
	}
	
	
	public void check()
	{ node p=root;
	
		while(p!=null)
		{
			System.out.print(p.number+" ");
			node e=p.east;
			if(e!=null)
			{
			System.out.print(e.number+" ");
			}
			else System.out.print("null ");
			
			node w=p.west;
			if(w!=null)
			{
			System.out.print(w.number+" ");
			}
			else System.out.print("null ");
			
			node n=p.north;
			if(n!=null)
			{
			System.out.print(n.number+" ");
			}
			else System.out.print("null ");
			
			
			node s=p.south;
			if(s!=null)
			{
			System.out.print(s.number+" ");
			}
			else System.out.print("null ");
			
			p=p.next;
			System.out.println(" ");
			
		}
		
		
	}
		
}