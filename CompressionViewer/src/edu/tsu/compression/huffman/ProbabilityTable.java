package edu.tsu.compression.huffman;

import java.util.ArrayList;
import java.util.Collections;

public class ProbabilityTable {
	private ArrayList<Node> nodes = new ArrayList<Node>();
	private double [][] pixels;
	
	public ProbabilityTable(double [][]pixels){
		this.pixels = pixels;
	}
	public ProbabilityTable(){
		
	}
	public void calculate(double [][]pixels){
		this.pixels = pixels;
		this.calculate();
	}
	
	@SuppressWarnings("unchecked")
	public void calculate(){
		int width = pixels[0].length;
		int height = pixels.length;
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				this.insertToNode(pixels[i][j]);
			}
		}
		Collections.sort(this.nodes);
	}
	
	private void insertToNode(double pixel){
		int width = pixels[0].length;
		int height = pixels.length;
		Node newNode;
		if (nodes.size()==0){
			newNode = new Node();
			newNode.setPixel(pixel);
			newNode.addFrequency();
			newNode.setTotal(width*height);
			this.nodes.add(newNode);
		}else{
			boolean found = false;
			
			for(int i=0;i<nodes.size();i++){
				Node temp = nodes.get(i);
				if (temp.getPixel()==pixel){
					temp.addFrequency();
					found = true;
					break;
				}
			}
			if (!found){
				newNode = new Node();
				newNode.setPixel(pixel);
				newNode.addFrequency();
				newNode.setTotal(width*height);
				this.nodes.add(newNode);
			}
		}		
	}
	
	public void display(){
		for(Node temp:this.nodes){
			System.out.println(temp.getPixel()+" = "+temp.getProbability()+" = "+temp.getFrequency()+" = "+temp.getTotal());
		}
	}
	
	public ArrayList<Node> getSortedNodes(){
		return this.nodes;
	}
	
}
