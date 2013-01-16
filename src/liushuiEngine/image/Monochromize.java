// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class Monochromize extends Filter {
	private int width,height;
	
	public Monochromize(){
		super();
		name = "Monochromize Class for graduation thesis";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 2;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		// get image width & height
		width = input[0].getWidth(0);
		height = input[0].getWidth(1);

		output[0] = new ArrayInt(width,height);

		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				int mono = (int)((double)(input[0].getValueI(x,y,0)+input[0].getValueI(x,y,1)+input[0].getValueI(x,y,2))/3.0);
				output[0].setValue(mono,x,y);
			}
		}
	}

	public void setParameter(){
	}
}
