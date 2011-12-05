package edu.tsu.compression.huffman;

public class Node implements Comparable {
	private Node parentNode = null;
	private Node leftChild = null;
	private Node rightChild = null; 
	private double pixel = 0;
	private int frequency = 0;
	private int total = 0;
	private int mark = 0;
	
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	public Node getParentNode() {
		return parentNode;
	}
	public float getProbability() {
		if ((leftChild!=null)&&(rightChild!=null)){
			return leftChild.getProbability()+rightChild.getProbability();
		}else{
			return frequency/(float)total;
		}
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setPixel(double pixel) {
		this.pixel = pixel;
	}
	public double getPixel() {
		return pixel;
	}
	public void addFrequency() {
		this.frequency = this.frequency+1;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
	
	public boolean isLeaf(){
		return (leftChild==null)&&(rightChild==null);
	}
	
	private String getCodeWord(Node node){
		if (node.getParentNode()!=null){
			return this.getMark()+""+this.getCodeWord(node.getParentNode());
		}
		return "";
	}
	
	public String getCodeWord(){
		String codeWord = this.getCodeWord(this);
		String newWord = "";
		for(int i=codeWord.length()-1;i>=0;i--){
			newWord+=codeWord.charAt(i);
		}
		return "0"+newWord;
	}
	
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getMark() {
		return mark;
	}
	@Override
	public int compareTo(Object node) {
		// TODO Auto-generated method stub
		Node n = (Node)node;
		if (this.getProbability()<n.getProbability()){
			return -1;
		}else if (this.getProbability()==n.getProbability()){
			return 0;
		}else{
			return 1;
		}
	}
	
}
