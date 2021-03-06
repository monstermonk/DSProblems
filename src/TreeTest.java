//package tree;

import java.util.Scanner;

class Node 
{
	Node node;
	static Node root=null;
	int data;
	Node parent,lchild,rchild;
}

public class TreeTest {
	int iteartor=0;
	static String flag=null;
	static int count=0;
	static int place =0;

	public static Node createNode(int data)
	{
		Node node=new Node();
		
		node.data=data;
		node.lchild=null;
		node.rchild=null;
		if(Node.root==null)
		{
			Node.root=node;
			node.parent=null;
			System.out.println("Node "+node.data+" added successfullly as the root of the tree");
		}
		return node;
	}
	public void createTree(int data)
	{
		Node node=TreeTest.createNode(data);
		Node iterator=Node.root;
		while(iterator.lchild!=null || iterator.rchild!=null)
		{
			if(data<=iterator.data)
			{
				if(iterator.lchild!=null)
					iterator=iterator.lchild;
				else 
					break;
			}
			else{
				if(iterator.rchild!=null)
					iterator=iterator.rchild;
				else 
					break;
			}
			iteartor++;
		}
		if(iteartor!=0)
		{
			if(data<=iterator.data)
			{
				System.out.println("Node "+node.data+" added successfullly in the left of "+iterator.data);
				iterator.lchild=node;

			}
			else{
				System.out.println("Node "+node.data+" added successfullly in the right of "+iterator.data);
				iterator.rchild=node;
			}
			node.parent=iterator;
		}

		iteartor++;
	}
	
	//To find the parent of node
	public void findParent(int value)
	{
		//node=TT.searchNode(value);
	}
	
	//Print tree structure
	public void printTree(Node node)
	{
		if(node.lchild==null && node.rchild==null )
		{
			return ;
		}
		//count++;
		//System.out.println("Left child of "+node.data+" is"+node.lchild.data);
		if(node.lchild!=null)
		{
			System.out.println(node.data+" --Lchild--> "+node.lchild.data);
			printTree(node.lchild);
		}
		if(node.rchild!=null)
		{
			System.out.println(node.data+" --Rchild--> "+node.rchild.data);
		//System.out.println("Right child of "+node.data+" is"+node.rchild.data);
		printTree(node.rchild);
		}
	}
	
	//weigh --> find the number of node in the tree
	public void weigh(Node node){
	//	int noofnode=1;
		if(node==null)
		{
			return ;
		}
		count++;
		weigh(node.lchild);
		weigh(node.rchild);
	}
	//find node -  search node in the tree structure
	public Node searchNode(int value)
	{
		
		Node loc = null;
		Node iterator=Node.root;
		while(iterator!=null || iterator!=null)
		{
		//	System.out.println("serach node"+iterator.data);
			if(value==iterator.data)
			{
				loc=iterator;
			//	System.out.println("Node "+iterator.data+" found successfully in the "+flag+" of "+iterator.parent.data);
				break;

			}
			else
			{
				if(value<iterator.data)
				{
					iterator=iterator.lchild;
					flag = "left";
				}
				else{
					iterator=iterator.rchild;
					flag= "right";
				}
			}

		}
		if(loc==null)
		{
			System.out.println("Not able to find the specified node in the tree");
		}

		return loc;

	}
	
	//print post and prefix 
	
	
	// delete node from tree
	public void deleteNode(int value)
	{
		Node node=new TreeTest().searchNode(value);
		System.out.println("node value"+node.data); 
		if (node.lchild!=null && node.rchild!=null)
		{
			Node sucessor=findSucessorNode(value,node.rchild);
			System.out.println("Successor  parent"+sucessor.parent.data+" Sucessor child left then right"+sucessor.lchild+" "+sucessor.rchild);
			Node sucessorparent=new TreeTest().searchNode(sucessor.data);
			node.data=sucessor.data;
			if(flag.equalsIgnoreCase("left"))
			sucessor.parent.lchild=sucessor.rchild;
			else
			{sucessor.parent.rchild=sucessor.lchild;}
			System.out.println("Successfully deleted"+node.data);
			//node.data=sucessor.data;
			
		}
		else if(node.lchild==null && node.rchild==null)
		{
			if(flag.equalsIgnoreCase("left"))
				{node.parent.lchild=null;}
			else
				{node.parent.rchild=null;}
			System.out.println("Successfully deleted"+node.data);
		}
		else if(node.lchild==null || node.rchild==null)
		{
			if(node.lchild==null)
			{
				node.parent=node.rchild;
				System.out.println("Successfully deleted"+node.data);
			}
			if (node.rchild==null)
			{
				node.parent=node.lchild;
				System.out.println("Successfully deleted"+node.data);
			}
		}
		
		
		
	}
	
	
	public void drawUsingTraversal(char[] travs1,char[] travs2,String travstype)
	{
		
		String[] travs=travstype.split(",");
		
		if(travs[1]=="PreOrder" && travs[2]=="InOrder")
		{
			//while(travs)
			char[] preorder=travs1;
			Node.root.data=preorder[1];
			while(travs1.length>0)
			{
				searchnode(travs2);
			}
		}
		else if(travs[1]=="PostOrder" && travs[2]=="InOrder")
		{
			
		}
		else if(travs[1]=="PreOrder" && travs[2]=="PostOrder")
		{
			
		}
	}
	
	
	
	public void searchnode(char[] travs2)
	{
		while(travs2.length>0)
		{

		/*	if(tras)
				
				char[] left=travs2[TreeTest.place];*/
		}
	}
	public  Node findSucessorNode(int value,Node node) {
		// TODO Auto-generated method stub
		
		while(node.lchild!=null)
		{
			node=node.lchild;
		}
		
		System.out.println("Sucessor "+node.data);
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("started");
		long r= -100000000000000l ; 
		int b=(int)r;
		long c	=-(long) Math.pow(2, 62);
		if(r>=-(int) Math.pow(2, 63))
		{
			System.out.println("hi");
		}
		Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        //Complete this code
        double y=sc.nextDouble();
      int i=sc.nextInt();
      String s = String.valueOf(i);
          System.out.println("String: "+s);
        System.out.println("Double: "+y);
        System.out.println("Int: "+x);
        
		/*Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        String strI = String.valueOf(x);
    //    String s= Integer.parseInt(x);
        //Complete this code
        double y=sc.nextDouble();
        //sc.close();
        sc.reset();
        sc=new Scanner(System.in);
        String s=sc.nextLine();*/
       
        System.out.println("Double: "+y);
        System.out.println("Int: "+x);
		
		TreeTest TT=new TreeTest();
		TT.createTree(23);
		TT.createTree(6);
		TT.createTree(90);
		TT.createTree(12);
		TT.createTree(10);
		TT.createTree(18);
		TT.createTree(28);
		TT.createTree(89);
		TT.createTree(13);
		TT.createTree(25);
		TT.createTree(105);
		TT.createTree(3);
		TT.createTree(5);
		TT.createTree(100);
		Node node=TT.searchNode(6);
		System.out.println("node value"+node.data);
		TT.weigh(Node.root);
		System.out.println(" Node Count : "+count);
		TT.printTree(Node.root);
		TT.deleteNode(23);
		TT.printTree(Node.root);
	}

}


