

public class IntNodeTest {

	public static void main(String[] args) {
		//test constructor
		System.out.println("1)constructor test:");
		IntNode head; 
		head = new IntNode(12,null);
		IntNode endNode = new IntNode(34,null);
		System.out.println("the head node is: " + head);
		System.out.println("the end node is: " + endNode);
		System.out.println();
		
		//test get and set method
		System.out.println("2)get and set method test:");
		System.out.println("the data of head node is: " + head.getData());
		System.out.println("the link of head node is: " + head.getLink());
		System.out.println("the initial endNode ia: " + endNode);
		endNode.setData(100);
		endNode.setLink(new IntNode(101,null));
		System.out.println("the updated endNode is: " + endNode);
		System.out.println();
		
		//test addNodeAfterThis method
		System.out.println("3)addNodeAfterThis method test:");
		head.addNodeAfterThis(34);
		head.addNodeAfterThis(0);
		head.addNodeAfterThis(28);
		System.out.println("a new linked list created by addNodeAfterThis method is: " + head);
		System.out.println();
		
		//test toString method
		System.out.println("4)toString method test:");
		System.out.println("the result that toString() method is activated by the first node is: " + head.toString());
		System.out.println("the result that toString() method is activated by the third node is: " + head.getLink().getLink().toString());
		System.out.println();
		
		//test removeNodeAfterThis method
		System.out.println("5)removeNodeAfterThis test:");
		System.out.println("the list before removeNodeAfterThis() method is: " + head);
		head.removeNodeAfterThis();
		System.out.println("the list after removing the second node is:" + head);
		System.out.println();
		
		
		//test listLength(IntNode head) method
		System.out.println("6)listLength method test:");
		System.out.println("the length of current list is: " + IntNode.listLength(head));
		System.out.println();
		
		//test search method
		System.out.println("7)search method test:");
		System.out.println("the current integer list is: " + head);
		System.out.println("is the integer number 0 in the list ? " + IntNode.search(head, 0));
		System.out.println("is the integer number 11 in the list ? " + IntNode.search(head, 11));
		System.out.println();
		System.out.println("The End!");
		

	}

}
