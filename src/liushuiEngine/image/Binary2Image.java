// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class Binary2Image extends Filter {
	private int width,height;
	
	public Binary2Image(){
		super();
		name = "Binary Image Array to Image Array Class for graduation thesis";

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
				int r,g,b;
				if(input[0].getValueI(x,y) == 0){
					r = 0;
					g = 0;
					b = 0;
				}else if(input[0].getValueI(x,y) > 0){
					r = 255;
					g = 255;
					b = 255;
				}else{
					r = 255;
					g = 0;
					b = 0;
				}
				output[0].setValue(r,x,y,0);
				output[0].setValue(g,x,y,1);
				output[0].setValue(b,x,y,2);
			}
		}
	}

	public void setParameter(){
	}
}
