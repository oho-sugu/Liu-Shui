// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Image Diff Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in2out1;

public class ImgDiffFilter extends in2out1 {
	private int width,height;
	
	public ImgDiffFilter(){
		super();
		name = "Image Diff  Filter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 3;
		// 0 Src 1 Dist 
		//
		//    Src - Dist
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
				r = input[0].getValueI(x,y,0) - input[1].getValueI(x,y,0);
				g = input[0].getValueI(x,y,1) - input[1].getValueI(x,y,1);
				b = input[0].getValueI(x,y,2) - input[1].getValueI(x,y,2);
				output[0].setValue(r,x,y,0);
				output[0].setValue(g,x,y,1);
				output[0].setValue(b,x,y,2);
			}
		}
	}

	public void setParameter(){
	}
}
