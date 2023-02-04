
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tile Matching Tester
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
 * This class tests the Tile Matching classes.
 */
public class TileMatchingTester {
	/*
	 * This method tests the equals in the Tile class.
	 * 
	 * @returns true if the method works.
	 */

	public static boolean tileEqualsTester() {
		try {
			Tile t1 = new Tile(Color.BLACK);
			String test1 = "test";
			if (t1.equals(test1)) {
				return false;
			}
			Tile t2 = new Tile(Color.BLACK);
			if (!(t1.equals(t2))) {
				return false;
			}
			Tile t3 = new Tile(Color.BLUE);
			if (t1.equals(t3)) {
				return false;
			}
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	/*
	 * This method tests the tileListIterator class.
	 * 
	 * @returns true if all the methods in the class works.
	 */

	public static boolean tileListIteratorTester() {
		Node one = new Node(new Tile(Color.ORANGE));
		Node two = new Node(new Tile(Color.BLUE));
		Node three = new Node(new Tile(Color.BLACK));
		Node four = new Node(new Tile(Color.YELLOW));

		one.setNext(two);
		two.setNext(three);
		three.setNext(four);

		TileListIterator tester1 = new TileListIterator(one);
		TileListIterator tester2 = new TileListIterator(four);
		String expected = "ORANGE, BLUE, BLACK, YELLOW, ";
		String result = "";
		// check if hasNext() returns a correct value.
		if (!(tester1.hasNext())) {
			return false;
		}
		// check if next() returns correct values.
		while (tester1.hasNext()) {
			result += tester1.next().toString() + ", ";
		}
		if (!(result.equals(expected))) {
			return false;
		}
		// checks if next() throws an exception when its supposed to.
		try {
			tester2.next();
		} catch (NoSuchElementException e) {
			return true;
		}

		return false;
	}
	/*
	 * This method tests the tileStack class.
	 * 
	 * @returns true if all the methods in the class works.
	 */

	public static boolean tileStackTester() {
		TileStack tester = new TileStack();
		// check if isEmpty() returns a correct value.
		if (!(tester.isEmpty() == true)) {
			return false;
		}
		Tile one = new Tile(Color.BLACK);
		Tile two = new Tile(Color.ORANGE);
		Tile three = new Tile(Color.YELLOW);
		// check if push() returns correct value, if it doesn't, then
		// the test will return false since other sections will return false.
		tester.push(one);
		tester.push(two);
		tester.push(three);
		// checks if size() returns correct values.
		if (tester.size() != 3) {
			return false;
		}
		// checks if peek() returns correct values.
		if (!(tester.peek().equals(three))) {
			return false;
		}
		// checks if pop() returns correct values.
		Tile value = tester.pop();

		if (!(value.equals(three) && tester.size() == 2)) {
			return false;
		}
		// checks if iterator() returns a correct value.
		Node nodeOne = new Node(new Tile(Color.BLACK));
		Node nodeTwo = new Node(new Tile(Color.ORANGE));

		nodeOne.setNext(nodeTwo);
		Iterator<Tile> expected = new TileListIterator(nodeOne);
		Iterator<Tile> iter = tester.iterator();
		if (!(expected == iter)) {
			return false;
		}

		return true;
	}
	/*
	 * This method tests the tileMatchingGame class.
	 * 
	 * @returns true if all the methods in the class works.
	 */

	public static boolean tileMatchingGameTester() {
		TileMatchingGame tester = new TileMatchingGame(5);

		Tile tileOne = new Tile(Color.BLACK);
		Tile tileTwo = new Tile(Color.BLUE);
		Tile tileThree = new Tile(Color.ORANGE);
		Tile tileFour = new Tile(Color.YELLOW);
		tester.dropTile(tileOne, 1);
		tester.dropTile(tileTwo, 2);
		tester.dropTile(tileThree, 2);
		tester.dropTile(tileFour, 4);
		// checks if dropTile() and column() returns correct values.
		if (!(tester.column(1).equals("BLACK"))) {
			return false;
		}
		if (!(tester.column(2).equals("BLUE ORANGE"))) {
			return false;
		}
		if (!(tester.column(3).equals(""))) {
			return false;
		}
		// checks if toString() returns the correct value.
		if (!(tester.toString()
				.equals("GAME COLUMNS:\n" + "0:" + "1: BLACK\n" + "2:BLUE ORANGE\n" + "3:" + "4: YELLOW\n"))) {
			return false;
		}
		// checks if getColumnsNumber() returns the correct value.
		if (tester.getColumnsNumber() != 5) {
			return false;
		}
		// checks if clearColumn() returns the correct result.
		tester.clearColumn(2);
		if (!(tester.column(2).equals(""))) {
			return false;
		}
		// checks if restartGame() returns the correct result.
		tester.restartGame();
		for (int i = 0; i < 5; i++) {
			if (!(tester.column(i) == "")) {
				return false;
			}
		}
		return true;

	}
	/*
	 * This method calls all the tester methods.
	 */

	public static void main(String[] args) {
		tileEqualsTester();
		tileListIteratorTester();
		tileStackTester();
		tileMatchingGameTester();

	}

}
