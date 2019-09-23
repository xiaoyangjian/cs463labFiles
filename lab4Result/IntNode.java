/**
 * @author yangjianxiao
 * @version 1.0
 *
 */

public class IntNode {
	private int data;
	private IntNode link;
	
	//no-argument constructor
	public IntNode() {
		data = 0;
		link = null;
	}
	
	//constructor with parameter
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;
	}
	
	//get and set methods
	public int getData() {
		return data;
	}
	public void setData(int newData) {
		this.data = newData;
	}
	public IntNode getLink() {
		return link;
	}
	public void setLink(IntNode newLink) {
		this.link = newLink;  //?????
	}
	
	
	//toString method
	public String toString() {  //?????
		String tempStr = "";
		IntNode cursor;
		cursor = this;
		//while loop to extract all of the data starting from selNode
		while(cursor != null) {
			tempStr += cursor.getData();
			cursor = cursor.link;			
		}
		return tempStr;
	}
	
	//addNodeAfterThis method
	public void addNodeAfterThis(int newData) {
		this.link =new IntNode(newData, this.getLink());
	}
	
	//removeNodeAfterThis method
	public void removeNodeAfterThis() {
		this.link = this.link.link;
//		if(this.getLink().link != null) { 
//			this.link = this.getLink().link;
//		}else {
//			System.out.println("there isn't an available element!");
//		}
	}
	
	//listLength method
	public static int listLength(IntNode head) {
		int answer = 0;
		for(IntNode cursor = head; cursor != null; cursor = cursor.link) {
			answer++;
		}
		return answer;
	}
	
	//search method
	public static boolean search(IntNode head, int data) {
		boolean answer = false;
		IntNode cursor;
		//for loop
		for(cursor = head; cursor != null; cursor = cursor.link) {
			if(cursor.data == data) {
				answer = true;
				break;
			}
		}
		return answer;
	}
}
