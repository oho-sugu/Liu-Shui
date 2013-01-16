// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.image;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class PixcelCounter3 extends Filter {
	private int width,height;
	
	public PixcelCounter3(){
		super();
		name = "Pixcel Count Class for graduation thesis";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 2;
		outputArrayType[0] = DOUBLE;
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

		output[0] = new ArrayDouble(2,1);
		
		int allCount = 0,count = 0;

		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				allCount++;
				if(input[0].getValueI(x,y) > 0) count++;
			}
		}
		output[0].setValue((double)count,0,0);
		output[0].setValue((double)allCount,1,0);
	}

	public void setParameter(){
	}
}
