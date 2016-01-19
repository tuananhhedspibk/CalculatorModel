package linkedlist;
import java.util.*;
import listnode.*;

interface LinkedListInterface{
	public boolean isEmpty();
	public void addFirstChar(char item);
	public void addLastChar(char item);
	public void addFirstDouble(double item);
	public void addLastDouble(double item);
	public void print() throws NoSuchElementException;
	public boolean findChar(char itemSearch);
	public boolean findDouble(double itemSearch);
	public void getFirst() throws NoSuchElementException;
	public void getLast() throws NoSuchElementException;
	public void removeFirst() throws NoSuchElementException;
	public void removeLast() throws NoSuchElementException;
	public void clear() throws NoSuchElementException;
}

public class LinkedList implements LinkedListInterface{
	public ListNode firstNode;
	public ListNode lastNode;

	public LinkedList(){
		firstNode = lastNode = null;
	}

	public boolean isEmpty(){
		if(firstNode == lastNode && firstNode == null){
			return true;
		}
		return false;
	}

	public void addFirstChar(char item){
		if(isEmpty()){
			firstNode = lastNode = new ListNode();
			firstNode.c = item;
		}
		else{
			ListNode node = new ListNode();
			node.c = item;
			node.next = firstNode;
			firstNode = node; 
		}
		firstNode.string = new String("Char");
	}

	public void addLastChar(char item){
		if(isEmpty()){
			firstNode = lastNode = new ListNode();
			firstNode.c = item;
		}
		else{
			lastNode = lastNode.next = new ListNode();
			lastNode.c = item;
		}
		lastNode.string = new String("Char");
	}

	public void addFirstDouble(double item){
		if(isEmpty()){
			firstNode = lastNode = new ListNode();
			firstNode.d = item;
		}
		else{
			ListNode node = new ListNode();
			node.d = item;
			node.next = firstNode;
			firstNode = node;
		}
		firstNode.string = new String("Double");
	}

	public void addLastDouble(double item){
		if(isEmpty()){
			firstNode = lastNode = new ListNode();
			firstNode.d = item;
		}
		else{
			lastNode = lastNode.next = new ListNode();
			lastNode.d = item;
		}
		lastNode.string = new String("Double");
	}

	public boolean findChar(char itemSearch) throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Can't get from empty list.");
		}
		else{
			ListNode runner = firstNode;
			while(runner != null){
				if(runner.c == itemSearch) return true;
				runner = runner.next;
			}
			return false;
		}
	}

	public boolean findDouble(double itemSearch) throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Can't get from empty list.");
		}
		else{
			ListNode runner = firstNode;
			while(runner != null){
				if(runner.d == itemSearch) return true;
				runner = runner.next;
			}
			return false;
		}
	}

	public void print() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Nothing to point ...");
		}
		ListNode runner = firstNode;
		while(runner != null){
			if(runner.string.equals("Double")){ 
				System.out.print(runner.d + " ");
			}
			else{
				System.out.print(runner.c + " ");
			}
			runner = runner.next;
		}
		System.out.println();
	}

	public void getFirst() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException ("Can't get from empty list.");
		}
		else{
			if(firstNode.string.equals("Double")){
				System.out.println(firstNode.d);
			}
			else{
				System.out.println(firstNode.c);
			}
		}	
	}

	public void getLast() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException ("Can't get from empty list.");
		}
		else{
			if(lastNode.string.equals("Double")){
				System.out.println(lastNode.d);
			}
			else{
				System.out.println(lastNode.c);
			}		
		}	
	}

	public void removeFirst() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException ("Can't remove because list is empty.");
		}
		else{
			ListNode node = firstNode,temp = firstNode;
			if(firstNode == lastNode){
				firstNode = lastNode = null;
			}
			else{
				firstNode = firstNode.next;
				temp = null;
			}
		}
	}

	public void removeLast() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Can't remove because list is empty.");
		}
		else{
			ListNode node = lastNode;
			ListNode temp = firstNode,temp1 = new ListNode();
			while(temp != lastNode){
				temp1 = temp;
				temp = temp.next;
			}
			lastNode = temp1;
			lastNode.next = null;
			temp = null;
		}
	}

	public void clear() throws NoSuchElementException{
		if(isEmpty()){
			throw new NoSuchElementException("Can't clear because list is empty.");
		}
		else{
			while(!isEmpty()){
				removeFirst();
			}
		}
	}
}