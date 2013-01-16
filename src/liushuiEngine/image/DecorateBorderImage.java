// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB to HSB Convert Class
// This Node Convert RGB Image Data Array to HSB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in3out1;

public class DecorateBorderImage extends in3out1 {
	private int width,height;
	private int widthSrc,heightSrc;
	private int putx,puty;
	
	public DecorateBorderImage(){
		super();
		name = "Image Decoration with border Image";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 3;
		inputArrayType[2] = INT;
		inputArrayDimension[2] = 3;
		// 0 Base 1 Border 2 Image 
		//
		//    Image
		//   =======
		//    Border
		//   =======
		//    Base
		//
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 3;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		// get image width & height
		int widthBase = input[0].getWidth(0);
		int heightBase = input[0].getWidth(1);
		int widthBorder = input[1].getWidth(0);
		int heightBorder = input[1].getWidth(1);
		int widthImage = input[2].getWidth(0);
		int heightImage = input[2].getWidth(1);

		output[0] = new ArrayInt(widthBase,heightBase,3);
		
		for(int y = 0;y < heightBase;y++){
			for(int x = 0;x < widthBase;x++){
				output[0].setValue(input[0].getValueI(x,y,0),x,y,0);
				output[0].setValue(input[0].getValueI(x,y,1),x,y,1);
				output[0].setValue(input[0].getValueI(x,y,2),x,y,2);
			}
		}
		
		int putxB = widthBase/2 - widthImage/2 - widthBorder/2;
		int putyB = heightBase/2 - heightImage/2 - heightBorder/2;
		for(int y = 0;y < heightBorder;y++){
			for(int x = 0;x < widthBorder;x++){
				if((putxB+x >= 0) && (width > putxB+x) && (putyB+y >= 0) && (height > putyB+y)){
					output[0].setValue(input[1].getValueI(x,y,0),putxB+x,putyB+y,0);
					output[0].setValue(input[1].getValueI(x,y,1),putxB+x,putyB+y,1);
					output[0].setValue(input[1].getValueI(x,y,2),putxB+x,putyB+y,2);
				}
			}
		}
		putxB = widthBase/2 + widthImage/2 - widthBorder/2;
		putyB = heightBase/2 + heightImage/2 - heightBorder/2;
		for(int y = 0;y < heightBorder;y++){
			for(int x = 0;x < widthBorder;x++){
				if((putxB+x >= 0) && (width > putxB+x) && (putyB+y >= 0) && (height > putyB+y)){
					output[0].setValue(input[1].getValueI(x,y,0),putxB+x,putyB+y,0);
					output[0].setValue(input[1].getValueI(x,y,1),putxB+x,putyB+y,1);
					output[0].setValue(input[1].getValueI(x,y,2),putxB+x,putyB+y,2);
				}
			}
		}
		

		int putx = widthBase/2 - widthImage/2;
		int puty = heightBase/2 - heightImage/2;
		
		for(int y = 0;y < heightImage;y++){
			for(int x = 0;x < widthImage;x++){
				if((putx+x >= 0) && (width > putx+x) && (puty+y >= 0) && (height > puty+y)){
					output[0].setValue(input[1].getValueI(x,y,0),putx+x,puty+y,0);
					output[0].setValue(input[1].getValueI(x,y,1),putx+x,puty+y,1);
					output[0].setValue(input[1].getValueI(x,y,2),putx+x,puty+y,2);
				}
			}
		}
	}

	public void setParameter(){
	}
}
