package com.PB;

import java.util.HashMap;
import java.util.List;

public class Grid {
	public final int rowMin = 1;
	public final int columnMin = 1;
	public int rowNum = 1;
	public int columnNum = 1;
	// public matrix grid;
	// Then initialize the grid based off size. Make bigger/smaller reinitialize
	public Node grid[][] = new Node[1][1];
	
	public Grid(int rowNum, int columnNum) {
		if(rowNum < 1 || columnNum < 1) {
			throw new RuntimeException("You cannot have less than 1 row/column");
		}
		this.rowNum = rowNum;
		this.columnNum = columnNum;
		
		grid = null;
		grid = new Node[this.rowNum][this.columnNum];
		initGridNodes();
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColumnNum() {
		return columnNum;
	}

	public void setColumnNum(int columnNum) {
		this.columnNum = columnNum;
	}

	public int getRowMin() {
		return rowMin;
	}

	public int getColumnMin() {
		return columnMin;
	}
	
	/**
	 * Adds one row to the grid, then fills those new node
	 * spaces with blank nodes
	 */
	public void addRow() {
		setRowNum(this.rowNum + 1);
		grid = null;
		grid = new Node[this.rowNum][this.columnNum];
		initGridNodes();
	}
	
	/**
	 * Adds one column to the grid, then fills those new node
	 * spaces with blank nodes
	 */
	public void addColumn() {
		setColumnNum(this.columnNum + 1);
		grid = null;
		grid = new Node[this.rowNum][this.columnNum];
		initGridNodes();
	}
	
	/**
	 * Takes away one row from the grid
	 */
	public void subtractRow() {
		if(this.rowNum > rowMin) {
			setRowNum(this.rowNum - 1);
			grid = null;
			grid = new Node[this.rowNum][this.columnNum];
			initGridNodes();
		} else {
			throw new RuntimeException("You cannot have less than 1 row"); //Might need to be a print statement
		}
	}
	
	/**
	 * Takes away one column from the grid
	 */
	public void subtractColumn() {
		if(this.columnNum > columnMin) {
			setColumnNum(this.columnNum - 1);
			grid = null;
			grid = new Node[this.rowNum][this.columnNum];
			initGridNodes();
		} else {
			throw new RuntimeException("You cannot have less than 1 column"); //Might need to be a print statement
		}
	}
	
	public void initGridNodes() {
		//System.out.printf("%d %d\n", this.rowNum, this.columnNum);
		Node a = new Node(false, false, false, false);
		for(int i = 0; i < this.rowNum; i++) {
			for(int j = 0; j < this.columnNum; j++) {
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
				if(!this.grid[i][j].isBarrier && !this.grid[i][j].isEnd && !this.grid[i][j].isStart) {
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
	}
	
}


