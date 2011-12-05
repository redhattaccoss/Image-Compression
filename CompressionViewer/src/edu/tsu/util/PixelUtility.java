package edu.tsu.util;

import java.awt.image.BufferedImage;

public class PixelUtility {
	public int[] getPixelRGB(BufferedImage image, int x, int y){
		int color = image.getRGB(x, y);
		int  red   = (color & 0x00ff0000) >> 16;
	    int  green = (color & 0x0000ff00) >> 8;
	    int  blue  =  color & 0x000000ff;
	    int result[] = {red, green, blue};
	    return result;
	}
}
