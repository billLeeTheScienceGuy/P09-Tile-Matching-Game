//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Tile Matching Game
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
/*
 * The methods in this class represents the functions of the Tile Matching Game.
 */
public class TileMatchingGame {
	private TileStack columns[];
	/*
	 * This constructor creates a new TileMatchingGame that is empty.
	 * 
	 * @param columnCount is the number of columns that the game will contain.
	 */

	public TileMatchingGame(int columnCount) {

		TileStack generator[] = new TileStack[columnCount];
		for (int i = 0; i < columnCount; i++) {
			TileStack stack = new TileStack();
			generator[i] = stack;

		}
		columns = generator;
	}

	public int getColumnsNumber() {
		return columns.length;
	}
	/*
	 * This method returns a string representation of the stack of tiles at a given
	 * column index, and an empty string "" if the stack is empty.
	 * 
	 * @param index is the index of a column in this game.
	 * 
	 * @returns a string representation of the column at a given index of this game.
	 * 
	 * @throw IndexOutOfBoundsException if index is out of bounds of the indexes of
	 * the columns of this game.
	 */

	public String column(int index) throws IndexOutOfBoundsException {
		TileStack idxColumn = columns[index];
		String result = "";
		if (index < 0 || index > getColumnsNumber()) {
			throw new IndexOutOfBoundsException();
		}
		if (idxColumn.equals(null)) {
			if (idxColumn.isEmpty()) {
				return result;
			}
		}
		for (int i = 0; i < idxColumn.size(); i++) {
			Tile tile = idxColumn.iterator().next();
			result += tile.toString() + " ";
		}
		result.trim();
		return result;
	}
	/*
	 * This method Removes all the tiles from a column with a given index
	 * 
	 * @param index of the column to clear.
	 * 
	 * @throws IndexOutOfBoundsException if index is out of bounds of the indexes of
	 * the columns of this game.
	 */

	public void clearColumn(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > getColumnsNumber()) {
			throw new IndexOutOfBoundsException();
		}
		columns[index] = null;
	}
	/*
	 * This method Drops a tile at the top of the stack located at the given column
	 * index. If tile will be dropped at the top of an equal tile (of same color),
	 * both tiles will be removed from the stack of tiles at column index.
	 * 
	 * @param tile is a tile to drop.
	 * 
	 * @param index is the column position of the stack of tiles where tile will be
	 * dropped.
	 * 
	 * @throws IndexOutOfBoundsException if index is out of bounds of the indexes of
	 * the columns of this game.
	 */

	public void dropTile(Tile tile, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > getColumnsNumber()) {
			throw new IndexOutOfBoundsException();
		}
		if (columns[index].peek() == tile) {
			columns[index].pop();
		} else {
			columns[index].push(tile);
		}
	}

	/*
	 * This method Restarts the game. All stacks of tiles in the different columns
	 * of this game will be empty.
	 */
	public void restartGame() {
		columns = null;
	}

	/*
	 * This method returns a string representation of this tile matching game in a
	 * certain format.
	 * 
	 * @returns the string representation of the tile matching game in a certain
	 * format.
	 */
	@Override
	public String toString() {
		String list = "GAME COLUMNS:\n";
		for (int i = 0; i < columns.length; i++) {
			list += i + ": " + column(i).toString() + "\n";
		}
		return list;
	}

}
