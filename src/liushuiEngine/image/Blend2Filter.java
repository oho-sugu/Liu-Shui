// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB to HSB Convert Class
// This Node Convert RGB Image Data Array to HSB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in2out1;

public class Blend2Filter extends in2out1 {
	private int width,height;
	private double alpha;
	
	public Blend2Filter(){
		super();
		name = "Alpha Blend Filter Class No.2";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 3;
		// 0 Src 1 Mul 
		//
		//    Src * Mul(0-255 -> 0.0-1.0) = output
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
		
		output[0] = new ArrayInt(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				int r,g,b;
				r = (int)((double)input[0].getValueI(x,y,0) * (double)input[1].getValueI(x,y,0) / 255.0);
				if(r > 255) r = 255;
				g = (int)((double)input[0].getValueI(x,y,1) * (double)input[1].getValueI(x,y,1) / 255.0);
				if(g > 255) g = 255;
				b = (int)((double)input[0].getValueI(x,y,2) * (double)input[1].getValueI(x,y,2) / 255.0);
				if(b > 255) b = 255;
				output[0].setValue(r,x,y,0);
				output[0].setValue(g,x,y,1);
				output[0].setValue(b,x,y,2);
			}
		}
	}

	public void setParameter(){
	}
}
