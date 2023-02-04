
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tile Stack
// Course:   CS 300 Fall 2021
//
// Author:   Bill Lee
// Email:    blee266@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NA
// Partner Email:   NA
// Partner Lecturer's Name: NA
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NA
// Online Sources:  NA
//
///////////////////////////////////////////////////////////////////////////////
import java.util.EmptyStackException;
import java.util.Iterator;

/*
 * This class represents represents a linked stack of tiles.
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {
	private Node top;
	private int size;
	/*
	 * This method creates an empty stack.
	 */

	public TileStack() {
		top = null;
		size = 0;
	}
	/*
	 * This method Pushes the provided tile at top of this stack.
	 * 
	 * @param tile is an element to be added.
	 */

	@Override
	public void push(Tile element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		Node node = new Node(element);
		if (size == 0) {
			top = node;
		} else {
			node.setNext(top);
			top = node;
		}
		size++;
	}
	/*
	 * This method Removes and returns the tile at the top of this stack.
	 * 
	 * @returns the removed tile.
	 */

	@Override
	public Tile pop() {
		if (top == null) {
			throw new EmptyStackException();
		} else {
			Tile temp = top.getTile();
			top = top.getNext();
			size--;
			return temp;
		}
	}
	/*
	 * This method Returns the tile at the top of this stack
	 * 
	 * @throws EmptyStackException if this stack is empty
	 * 
	 * @returns the tile at the top of this stack.
	 */

	@Override
	public Tile peek() throws EmptyStackException {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.getTile();
	}
	/*
	 * This method Check whether this stack is empty
	 * 
	 * @rerturns true if this stack contains no elements, otherwise false.
	 */

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	/*
	 * This method Returns the size of this stack
	 * 
	 * @returns the size of this stack
	 */

	@Override
	public int size() {
		return size;
	}
	/*
	 * This method Returns an iterator to iterate through this stack starting from
	 * its top.
	 * 
	 * @returns an iterator to iterate through this stack starting from its top.
	 */

	@Override
	public Iterator<Tile> iterator() {
		TileListIterator iter = new TileListIterator(top);
		return iter;
	}

}
