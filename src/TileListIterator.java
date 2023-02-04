
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tile List Iterator
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This class contains methods where you can go through the iterator.
 * It implements the Iterator<Tile> interface.
 */
public class TileListIterator implements Iterator<Tile> {
	private Node next;
	/*
	 * This constructor sets the next value of the iterator to head.
	 * 
	 * @param head is the value that will go on the head of the iterator.
	 */

	public TileListIterator(Node head) {
		next = head;
	}

	/*
	 * This method checks if there is a next value.
	 * 
	 * @returns true if there is a next value in the iterator.
	 */
	@Override
	public boolean hasNext() {
		if (!(next == null)) {
			return true;
		}
		return false;
	}
	/*
	 * This method sets the next to the next value of the iterator
	 * 
	 * @returns the next value of the iterator.
	 * 
	 * @throws NoSuchElementException if there is no next value.
	 */

	@Override
	public Tile next() throws NoSuchElementException {
		if (next == null) {
			throw new NoSuchElementException("Error: the list is null");
		} else {
			Tile nextTile = next.getTile();
			next = next.getNext();
			return nextTile;
		}
	}
}
