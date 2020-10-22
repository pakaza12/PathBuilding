package com.PB;

import java.util.HashMap;
import java.util.List;

public class Node {
	public HashMap<Node, List<Node>> neighbors;
	public boolean isStart;
	public boolean isEnd;
	public boolean isBarrier;
	
	public Node(HashMap<Node, List<Node>> neighbors, boolean isStart, boolean isEnd,
			boolean isBarrier) {
		super();
		this.neighbors = neighbors;
		this.isStart = isStart;
		this.isEnd = isEnd;
		this.isBarrier = isBarrier;
	}
	
	public Node(boolean isStart, boolean isEnd, boolean isBarrier) {
		super();
		this.isStart = isStart;
		this.isEnd = isEnd;
		this.isBarrier = isBarrier;
	}

	public HashMap<Node, List<Node>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(HashMap<Node, List<Node>> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean isBarrier() {
		return isBarrier;
	}

	public void setBarrier(boolean isBarrier) {
		this.isBarrier = isBarrier;
	}

	@Override
	public String toString() {
		return "Node [neighbors=" + neighbors + ", isStart=" + isStart + ", isEnd="
				+ isEnd + ", isBarrier=" + isBarrier + "]";
	}

	
	
}

