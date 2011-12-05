package edu.tsu.compression.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import edu.tsu.compression.Algorithm;

public class Huffman implements Algorithm {

	private ProbabilityTable table = new ProbabilityTable();

	private Node rootNode;
	private ArrayList<Node> loadedNodes = new ArrayList<Node>();
	private double[][] pixels;
	private Hashtable<String, Byte> encodingBitMap = new Hashtable<String, Byte>();
	private String encodedStream = "";
	private ArrayList<Byte> binaryEncodedData = new ArrayList<Byte>();
	
	@SuppressWarnings("unchecked")
	public ArrayList<Byte> encode(double[][] pixels) {
		// TODO Auto-generated method stub
		this.pixels = pixels;
		table.calculate(pixels);
		ArrayList<Node> nodes = table.getSortedNodes();
		this.loadedNodes.addAll(nodes);
		table.display();
		ArrayList<Node> resultNodes = new ArrayList<Node>();
		if (nodes.size()>=2){
			Node firstNode = nodes.get(0);
			Node secondNode = nodes.get(1);
			nodes.remove(firstNode);
			nodes.remove(secondNode);
			Node parentNode = this.pair(firstNode, secondNode);
			resultNodes.add(parentNode);
		}else{
			Node firstNode = nodes.get(0);
			this.setRootNode(firstNode);
			nodes.remove(firstNode);
			resultNodes.remove(firstNode);
		}
		while((nodes.size()!=0)||(resultNodes.size()!=0)){
			ArrayList<Node> temporaryNodes = new ArrayList<Node>();
			temporaryNodes.addAll(nodes);
			temporaryNodes.addAll(resultNodes);
			Collections.sort(temporaryNodes);
			if (temporaryNodes.size()>=2){
				Node firstNode = temporaryNodes.get(0);
				Node secondNode = temporaryNodes.get(1);
				Node parentNode = this.pair(firstNode, secondNode);
				resultNodes.add(parentNode);
				nodes.remove(firstNode);
				resultNodes.remove(firstNode);
				nodes.remove(secondNode);
				resultNodes.remove(secondNode);
			}else{
				Node firstNode = temporaryNodes.get(0);
				this.setRootNode(firstNode);
				nodes.remove(firstNode);
				resultNodes.remove(firstNode);
			}
		}
		this.buildEncodingBitMap();
		this.encodeString();
		this.encodeStringToBits();
		return this.binaryEncodedData;
	}
	
	private void encodeString(){
		String output="";
		int width = pixels[0].length;
		int height = pixels.length;
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				for(Node n:this.loadedNodes){
					if (n.getPixel()==pixels[i][j]){
						output+=n.getCodeWord();
						break;
					}
				}
			}
		}
		this.encodedStream = output;
	}
	
	private void encodeStringToBits(){
		int remainder = this.encodedStream.length()%8;
		for(int i=0;i<(8-remainder);i++){
			this.encodedStream+="0";
		}
		for (int i=0;i<this.encodedStream.length();i+=8){
			String stringBits = this.encodedStream.substring(i, i+8);
			byte realByte = this.encodingBitMap.get(stringBits);
			binaryEncodedData.add(realByte);
		}
	}
	
	public Node pair(Node firstNode, Node secondNode) {
		Node parentNode = new Node();
		parentNode.setLeftChild(firstNode);
		parentNode.setRightChild(secondNode);
		firstNode.setMark(0);
		secondNode.setMark(1);
		firstNode.setParentNode(parentNode);
		secondNode.setParentNode(parentNode);
		return parentNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	public Node getRootNode() {
		return rootNode;
	}
	
	
	void buildEncodingBitMap(){

	    for(int cnt = 0; cnt <= 255;cnt++){
	      StringBuffer workingBuf = new StringBuffer();
	      if((cnt & 128) > 0){workingBuf.append("1");
	        }else{workingBuf.append("0");};
	      if((cnt & 64) > 0){workingBuf.append("1");
	        }else {workingBuf.append("0");};
	      if((cnt & 32) > 0){workingBuf.append("1");
	        }else {workingBuf.append("0");};
	      if((cnt & 16) > 0){workingBuf.append("1");
	        }else {workingBuf.append("0");};
	      if((cnt & 8) > 0){workingBuf.append("1");
	        }else {workingBuf.append("0");};
	      if((cnt & 4) > 0){workingBuf.append("1");
	        }else {workingBuf.append("0");};
	      if((cnt & 2) > 0){workingBuf.append("1");
	        }else {workingBuf.append("0");};
	      if((cnt & 1) > 0){workingBuf.append("1");
	        }else {workingBuf.append("0");};
	      encodingBitMap.put(workingBuf.toString(),
	                                              (byte)(cnt));
	    }//end for loop
	  }

}
