package edu.tsu.ui.main;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CompressionViewerWindow extends JFrame {

	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1775194890066608229L;

	private static CompressionViewerWindow instance = null;
	
	
	private JMenuBar menuBar;
		
	
	private CompressionViewerWindow(){
		this.setTitle("Image Compression Viewer");
		this.createMenuBar();
		this.pack();
		this.setSize(800, 600);
	}
	
	private void createMenuBar(){
		this.menuBar = new JMenuBar();
		
		//constructs the file
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		exitMenuItem.setMnemonic(KeyEvent.VK_X);
		
		openMenuItem.addActionListener(new FileMenuClickedListener());
		
		fileMenu.add(openMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		
		
		
		this.menuBar.add(fileMenu);
		this.setJMenuBar(this.menuBar);
	}
	
	
	public static CompressionViewerWindow getInstance(){
		if (instance==null){
			instance = new CompressionViewerWindow();
		}
		return instance;
	}
	
	public void showWindow(){
		this.setVisible(true);
	}
	
}
