package graph.examples;

import java.util.LinkedList;

public class Vertex {
	private Color COLOR;
	private Vertex parent;
	private int number;
	private LinkedList<Vertex> adjacentList;
	private int discoveryTime;
	private int finishedTime;

	public Vertex(Color cOLOR, Vertex parent, int number, LinkedList<Vertex> adjacents) {
		super();
		COLOR = cOLOR;
		this.parent = parent;
		this.number = number;
		this.adjacentList = adjacents;
	}

	public Color getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(Color cOLOR) {
		COLOR = cOLOR;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LinkedList<Vertex> getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(LinkedList<Vertex> adjacentList) {
		this.adjacentList = adjacentList;
	}

	public int getDiscoveryTime() {
		return discoveryTime;
	}

	public void setDiscoveryTime(int discoveryTime) {
		this.discoveryTime = discoveryTime;
	}

	public int getFinishedTime() {
		return finishedTime;
	}

	public void setFinishedTime(int finishedTime) {
		this.finishedTime = finishedTime;
	}

	@Override
	public String toString() {
		return "vertex: " + number + " discover time: " + discoveryTime;
	}

}
