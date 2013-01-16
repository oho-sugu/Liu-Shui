// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB to HSB Convert Class
// This Node Convert RGB Image Data Array to HSB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in2out1;

public class Blend1Filter extends in2out1 {
	private int width,height;
	private double alpha;
	
	public Blend1Filter(){
		super();
		name = "Alpha Blend Filter Class";

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
		
		output[0] = new ArrayInt(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				int r,g,b;
				r = input[0].getValueI(x,y,0) + (int)(alpha * (double)input[1].getValueI(x,y,0));
				if(r > 255) r = 255;
				g = input[0].getValueI(x,y,1) + (int)(alpha * (double)input[1].getValueI(x,y,1));
				if(g > 255) g = 255;
				b = input[0].getValueI(x,y,2) + (int)(alpha * (double)input[1].getValueI(x,y,2));
				if(b > 255) b = 255;
				output[0].setValue(r,x,y,0);
				output[0].setValue(g,x,y,1);
				output[0].setValue(b,x,y,2);
			}
		}
	}

	public void setParameter(){
		System.out.println("Input Alpha");
		System.out.print(">");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		alpha = Double.valueOf(str[0]).doubleValue();
	}
}
