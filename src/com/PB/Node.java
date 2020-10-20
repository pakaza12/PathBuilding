package com.PB;

import java.util.HashMap;
import java.util.List;

public class Node {
	public boolean discovered;
	public HashMap<Node, List<Node>> neighbors;
	public boolean isStart;
	public boolean isEnd;
	public boolean isBarrier;
	
	public Node(boolean discovered, HashMap<Node, List<Node>> neighbors, boolean isStart, boolean isEnd,
			boolean isBarrier) {
		super();
		this.discovered = discovered;
		this.neighbors = neighbors;
		this.isStart = isStart;
		this.isEnd = isEnd;
		this.isBarrier = isBarrier;
	}
	
	public Node(boolean discovered, boolean isStart, boolean isEnd, boolean isBarrier) {
		super();
		this.discovered = discovered;
		this.isStart = isStart;
		this.isEnd = isEnd;
		this.isBarrier = isBarrier;
	}

	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
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
		return "Node [discovered=" + discovered + ", neighbors=" + neighbors + ", isStart=" + isStart + ", isEnd="
				+ isEnd + ", isBarrier=" + isBarrier + "]";
	}

	
	
}

