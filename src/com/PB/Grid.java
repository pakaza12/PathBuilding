package com.PB;

import java.util.LinkedList;

/**
 * This class represents a grid and search functions to search
 * the grid. Each spot in the grid is filled with a node from
 * the Node class. Representing an empty node, a barrier node,
 * a start node, or an end node.
 * 
 * @author Parker Zach
 */
public class Grid {
	public final int rowMin = 1;
	public final int columnMin = 1;
	public int rowNum = 1;
	public int columnNum = 1;
	public Node grid[][];
	public int start[] = {-1,-1};
	public int end[] = {-1,-1};
	public LinkedList<int[]> barrierList = new LinkedList<int[]>();
	
	
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
	
	public void clearBarrierList() {
		barrierList.clear();
	}
	
	public void printStart() {
		if(start[0] == -1 || start[1] == -1) {
			System.out.printf("There is no start node\n");
		} else {
			System.out.printf("[%d][%d]\n", start[0], start[1]);
		}
	}
	
	public void printEnd() {
		if(end[0] == -1 || end[1] == -1) {
			System.out.printf("There is no end node\n");
		} else {
			System.out.printf("[%d][%d]\n", end[0], end[1]);
		}
	}
	
	public void printBarriers() {
		for(int i = 0; i < barrierList.size(); i++) {
			System.out.printf("%d or [%d][%d] = %s\n", i, barrierList.get(i)[0], barrierList.get(i)[1], grid[barrierList.get(i)[0]][barrierList.get(i)[1]].toString());
		}
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
		 * and initialized new row
		 */
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < columnNum; j++) {
				if(i == rowNum-1) {
					Node a = new Node(false, false, false);
					grid[i][j] = a;
				} else {
					grid[i][j] = temp[i][j];
				}
			}
		}
		
	}
	
	/**
	 * Adds one column to the grid, then fills those new node
	 * spaces with blank nodes
	 * and initializes new column
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
			for(int j = 0; j < columnNum; j++) {
				if(j == columnNum-1) {
					Node a = new Node(false, false, false);
					grid[i][j] = a;
				} else {
					grid[i][j] = temp[i][j];
				}
			}
		}
		

	}
	
	/**
	 * Takes away one row from the grid
	 */
	public void subtractRow() {
		if(rowNum > rowMin) {
			if(start[0] == rowNum-1) {
				start[0] = -1;
				start[1] = -1;
			} else if(end[0] == rowNum-1) {
				end[0] = -1;
				end[1] = -1;
			}
			
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
			
		} else {
			throw new RuntimeException("You cannot have less than 1 row");
		}
	}
	
	/**
	 * Takes away one column from the grid
	 */
	public void subtractColumn() {
		if(columnNum > columnMin) {
			if(start[1] == columnNum-1) {
				start[0] = -1;
				start[1] = -1;
			} else if(end[1] == columnNum-1) {
				end[0] = -1;
				end[1] = -1;
			}
			
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
			
		} else {
			throw new RuntimeException("You cannot have less than 1 column");
		}
	}
	
	/**
	 * Adds empty nodes into the entire grid. Only should be
	 * done while creating a new grid or while wanting to 
	 * clear the old grid
	 */
	public void initGridNodes() {
		//System.out.printf("%d %d\n", rowNum, columnNum);
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < columnNum; j++) {
				Node a = new Node(false, false, false);
				grid[i][j] = a;
			}
		}
	}
	
	/**
	 * Sets a node in the grid to a barrier, end, or start node.
	 * 1 = start, 2 = end, 3 = barrier
	 * @param row
	 * @param column
	 * @param type
	 */
	public void addNode(int row, int column, int type) {
		//If it is already set to something else, set that thing to false
		if(grid[row][column].isStart()) {
			grid[row][column].setStart(false);
			start[0] = -1;
			start[1] = -1;
		} else if(grid[row][column].isEnd()) {
			grid[row][column].setEnd(false);
			end[0] = -1;
			end[1] = -1;
		} else if(grid[row][column].isBarrier()) {
			grid[row][column].setBarrier(false);
			//Finds the barrier and deletes it from the barrierList
			for(int i = 0; i < barrierList.size(); i++) {
				if(barrierList.get(i)[0] == row && barrierList.get(i)[1] == column) {
					barrierList.remove(i);
				}
			}
		}
		
		//Depending on what you want to set the node to, set the node to that
		switch(type) {
			case 1:
				grid[row][column].setStart(true);
				start[0] = row;
				start[1] = column;
				break;
			case 2:
				grid[row][column].setEnd(true);
				end[0] = row;
				end[1] = column;
				break;
			case 3:
				grid[row][column].setBarrier(true);
				int a[] = new int[2];
				a[0] = row;
				a[1] = column;
				barrierList.add(a);
				break;
			default:
				throw new RuntimeException("You tried to enter a node type that doesn't exist somehow, nice try!");
		}
	}
	
	/**
	 * Add a start space into the given row/column.
	 * If there is already a start space, replace it.
	 */
	public void addStart(int row, int column) {
		if(row < 0 || row >= rowNum || column < 0 || column >= columnNum) {
			throw new RuntimeException("The selected node is not within the grid");
		}
		
		if(start[0] >= 0 && start[1] >= 0) {
			System.out.printf("The start node has already been set at [%d][%d]\nWe will move the start node to [%d][%d]\n", start[0], start[1], row, column);
			grid[start[0]][start[1]].setStart(false);
		}
		addNode(row, column, 1);
	}
	
	public void addEnd(int row, int column) {
		if(row < 0 || row >= rowNum || column < 0 || column >= columnNum) {
			throw new RuntimeException("The selected node is not within the grid");
		}
		
		if(end[0] >= 0 && end[1] >= 0) {
			System.out.printf("The end node has already been set at [%d][%d]\nWe will move the end node to [%d][%d]\n", end[0], end[1], row, column);
			grid[end[0]][end[1]].setStart(false);
		}
		addNode(row, column, 2);
	}
	
	public void addBarrier(int row, int column) {
		if(row < 0 || column < 0 || row > rowNum-1 || column > columnNum-1) {
			throw new RuntimeException("The selected node is not within the grid");
		}
		
		boolean notIn = true;
		for(int i = 0; i < barrierList.size(); i++) {
			if(barrierList.get(i)[0] == row && barrierList.get(i)[1] == column) {
				notIn = false;
				break;
			}
		}
		if(notIn) {
			addNode(row, column, 3);
		}
	}
	
	public void removeStart() {
		if(start[0] >= 0 && start[1] >= 0 && start[0] < rowNum && start[1] < columnNum) {
			grid[end[0]][end[1]].setEnd(false);
			start[0] = -1;
			start[1] = -1;
		} else {
			throw new RuntimeException("The selected node is not within the grid");
		}
		return;
	}
	
	public void removeEnd() {
		if(end[0] >= 0 && end[1] >= 0 && end[0] < rowNum && end[1] < columnNum) {
			grid[end[0]][end[1]].setEnd(false);
			end[0] = -1;
			end[1] = -1;
		} else {
			throw new RuntimeException("The selected node is not within the grid");
		}
		return;
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
				//System.out.printf("%s\n", grid[i][j].toString());
				if(!(grid[i][j].isBarrier || grid[i][j].isEnd || grid[i][j].isStart)) {
					System.out.printf(" 0 ");
				} else if(grid[i][j].isStart) {
					System.out.printf(" 1 ");
				} else if(grid[i][j].isEnd){
					System.out.printf(" 2 ");
				} else {
					System.out.printf(" 3 ");
				}
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Grid a = new Grid(3, 3);
		a.addStart(0, 0);
		a.addColumn();
		a.printGrid();
		a.addStart(2, 2);
		a.addEnd(0, 0);
		a.addBarrier(0, 0);
		a.addBarrier(0, 1);
		a.addEnd(0, 1);
		a.printGrid();
		a.addBarrier(0, 1);
		a.addEnd(2, 3);
		a.printGrid();
		a.printEnd();
	}
	
}


