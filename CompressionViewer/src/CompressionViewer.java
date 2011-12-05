import java.util.ArrayList;

import edu.tsu.compression.huffman.Huffman;
import edu.tsu.ui.main.CompressionViewerWindow;


public class CompressionViewer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double z[][] = new double[2][4];
		z[0][0] = 3;
		z[0][1] = 2;
		z[0][2] = 1;
		z[0][3] = 8;
		
		
		z[1][0] = 2;
		z[1][1] = 2;
		z[1][2] = 5;
		z[1][3] = 3;
		
		CompressionViewerWindow.getInstance().showWindow();		
		Huffman h = new Huffman();
		ArrayList<Byte> bytes = h.encode(z);
		System.out.println(bytes);
	}

}
