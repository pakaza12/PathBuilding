package com.PB;

import java.util.HashMap;
import java.util.List;

public class Grid {
	public final int rowMin = 1;
	public final int columnMin = 1;
	public int rowNum = 1;
	public int columnNum = 1;
	public Node grid[][];
	
	public Grid(int rowNum, int columnNum) {
		if(rowNum < 1 || columnNum < 1) {
			throw new RuntimeException("You cannot have less than 1 row/column");
		}
		this.rowNum = rowNum;
		this.columnNum = columnNum;
		
		grid = new Node[this.rowNum][this.columnNum];
		initGridNodes();
	}

	public int getRowNum() {
		return this.rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColumnNum() {
		return this.columnNum;
	}

	public void setColumnNum(int columnNum) {
		this.columnNum = columnNum;
	}

	public int getRowMin() {
		return this.rowMin;
	}

	public int getColumnMin() {
		return this.columnMin;
	}
	
	/**
	 * Adds one row to the grid, then fills those new node
	 * spaces with blank nodes
	 */
	public void addRow() {
		/** Adds 1 to rowNum **/
		setRowNum(this.rowNum + 1);
		
		Node temp[][] = grid;
		grid = null;
		grid = new Node[rowNum][columnNum];
		
		/** 
		 * Copies the nodes from the original grid 
		 * into the new grid with one more row
		 */
		for(int i = 0; i < rowNum-1; i++) {
			for(int j = 0; j < columnNum; j++) {
				grid[i][j] = temp[i][j];
			}
		}
		
		initRowNodes();
	}
	
	/**
	 * Adds one column to the grid, then fills those new node
	 * spaces with blank nodes
	 */
	public void addColumn() {
		/** Adds 1 to columnNum **/
		setColumnNum(this.columnNum + 1);
		
		Node temp[][] = grid;
		grid = null;
		grid = new Node[rowNum][columnNum];
		
		/** 
		 * Copies the nodes from the original grid 
		 * into the new grid with one more column
		 */
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < columnNum-1; j++) {
				grid[i][j] = temp[i][j];
			}
		}
		
		initColumnNodes();
	}
	
	/**
	 * Takes away one row from the grid
	 */
	public void subtractRow() {
		if(rowNum > rowMin) {
			setRowNum(rowNum - 1);
			
			Node temp[][] = grid;
			grid = null;
			grid = new Node[rowNum][columnNum];
			
			/**
			 * Copies the nodes from the original grid 
			 * into the new grid with one less row
			 */
			for(int i = 0; i < rowNum; i++) {
				for(int j = 0; j < columnNum; j++) {
					grid[i][j] = temp[i][j];
				}
			}
			
			initGridNodes();
		} else {
			throw new RuntimeException("You cannot have less than 1 row"); //Might need to be a print statement
		}
	}
	
	/**
	 * Takes away one column from the grid
	 */
	public void subtractColumn() {
		if(columnNum > columnMin) {
			setColumnNum(columnNum - 1);
			
			Node temp[][] = grid;
			grid = null;
			grid = new Node[rowNum][columnNum];
			
			/** 
			 * Copies the nodes from the original grid 
			 * into the new grid with one less column
			 */
			for(int i = 0; i < rowNum; i++) {
				for(int j = 0; j < columnNum; j++) {
					grid[i][j] = temp[i][j];
				}
			}
			
			initGridNodes();
		} else {
			throw new RuntimeException("You cannot have less than 1 column"); //Might need to be a print statement
		}
	}
	
	/**
	 * Adds empty nodes into the entire grid. Only should be
	 * done while creating a new grid or while wanting to 
	 * clear the old grid
	 */
	public void initGridNodes() {
		//System.out.printf("%d %d\n", rowNum, columnNum);
		Node a = new Node(false, false, false, false);
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < columnNum; j++) {
				grid[i][j] = a;
			}
		}
	}
	
	/**
	 * Adds empty nodes into the new row within
	 * the new, larger grid
	 */
	public void initRowNodes() {
		Node a = new Node(false, false, false, false);
		for(int i = rowNum-1; i < rowNum; i++) {
			for(int j = 0; j < columnNum; j++) {
				grid[i][j] = a;
			}
		}
	}
	
	/**
	 * Adds empty nodes into the new column within
	 * the new, larger grid
	 */
	public void initColumnNodes() {
		Node a = new Node(false, false, false, false);
		for(int i = 0; i < rowNum; i++) {
			for(int j = columnNum-1; j < columnNum; j++) {
				grid[i][j] = a;
			}
		}
	}
	
	
	
	
	
	/**
	 * An empty space is represented by 0
	 * A start space is represented by 1
	 * An end space is represented by 2
	 * A barrier space is represented by 3
	 */
	public void printGrid() {
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < columnNum; j++) {
				if(!grid[i][j].isBarrier && !grid[i][j].isEnd && !grid[i][j].isStart) {
					System.out.printf(" 0 ");
				} else {
					System.out.printf(" 1 ");
				}
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Grid a = new Grid(2, 2);
		a.printGrid();
		a.addRow();
		a.printGrid();
		a.addColumn();
		a.printGrid();
		a.subtractColumn();
		a.printGrid();
	}
	
}


