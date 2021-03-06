// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.GIS;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class Mono2Color extends Filter {
	private int width,height;
	
	public Mono2Color(){
		super();
		name = "Monochrom Image Array to Image Array Class for graduation thesis";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 2;
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
				int mono = input[0].getValueI(x,y);
				output[0].setValue(mono,x,y,0);
				output[0].setValue(0,x,y,1);
				output[0].setValue(255-mono,x,y,2);
			}
		}
	}

	public void setParameter(){
	}
}
