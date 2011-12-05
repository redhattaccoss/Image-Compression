package edu.tsu.ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class FileMenuClickedListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("Open")){
			this.openFile();
		}
	}
	
	private void openFile(){
		System.out.println("Hello World");
	}

}
