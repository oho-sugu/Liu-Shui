// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB to HSB Convert Class
// This Node Convert RGB Image Data Array to HSB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in2out1;

public class PutImageXY extends in2out1 {
	private int width,height;
	private int widthSrc,heightSrc;
	private int putx,puty;
	
	public PutImageXY(){
		super();
		name = "Put Image by XY";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 3;
		// 0 Dist 1 Src 
		//
		//    Src
		//   ======
		//    Dist
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
		width = input[0].getWidth(0);
		height = input[0].getWidth(1);

		widthSrc = input[1].getWidth(0);
		heightSrc = input[1].getWidth(1);
		
		output[0] = new ArrayInt(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				output[0].setValue(input[0].getValueI(x,y,0),x,y,0);
				output[0].setValue(input[0].getValueI(x,y,1),x,y,1);
				output[0].setValue(input[0].getValueI(x,y,2),x,y,2);
			}
		}
		
		for(int y = 0;y < heightSrc;y++){
			for(int x = 0;x < widthSrc;x++){
				if((putx+x >= 0) && (width > putx+x) && (puty+y >= 0) && (height > puty+y)){
					output[0].setValue(input[1].getValueI(x,y,0),putx+x,puty+y,0);
					output[0].setValue(input[1].getValueI(x,y,1),putx+x,puty+y,1);
					output[0].setValue(input[1].getValueI(x,y,2),putx+x,puty+y,2);
				}
			}
		}
	}

	public void setParameter(){
		String str[] = new String[1];
		str[0] = "";
		System.out.println("Input X Y");
		System.out.print("X>");
		comInput(str);
		putx = Integer.valueOf(str[0]).intValue();
		str[0] = "";
		System.out.print("Y>");
		comInput(str);
		puty = Integer.valueOf(str[0]).intValue();
	}
}
