// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class File Output Class
//
// This Class is Data Output Class to File
// Write Input Array Data to File

package liushuiEngine.image;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import liushuiEngine.Array;
import liushuiEngine.basicNode.Terminator;

public class PNGWriter extends Terminator {
	private String filename;
	private int width,height;
	
	public PNGWriter(){
		super();
		name = "PNG File Writer Class";
		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		
	}

	public void Init(){
		super.Init();
	}
	
	public void setInput(int i,Array a){
		if(i < 1) input[0] = a;
	}
	public void Process(){
		width = input[0].getWidth(0);
		height = input[0].getWidth(1);
		
		BufferedImage innerImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				int red = input[0].getValueI(x,y,0);
				int green = input[0].getValueI(x,y,1);
				int blue = input[0].getValueI(x,y,2);
				int rgb = (red << 16) | (green << 8) | blue;
				innerImage.setRGB(x,y,rgb);
			}
		}
		//innerImage.flush();
		
		try {
			ImageIO.write(innerImage, "png", new File(filename));
		} catch (Exception e) {
			System.out.println("Error in PNGWriter");
			System.exit(0);
		}

	}

	public Array getOutput(int i){ return null;}
	public void setParameter(){
		System.out.println("Input File Name");
		System.out.print("File? >");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		filename = str[0];
	}
}
