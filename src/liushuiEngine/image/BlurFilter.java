// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Image Blur Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class BlurFilter extends Filter {
	private int width,height;
	
	public BlurFilter(){
		super();
		name = "Image Blur Filter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
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
		ArrayInt work1 = new ArrayInt(width,height,3);
		
		for(int j = 0;j < width;j++){
			for(int k = 0;k < height;k++){
				work1.setValue(input[0].getValueI(j,k,0),j,k,0);
				work1.setValue(input[0].getValueI(j,k,1),j,k,1);
				work1.setValue(input[0].getValueI(j,k,2),j,k,2);
			}
		}
		
		for(int i = 0;i < 20;i++){
		for(int y = 1;y < height-1;y++){
			for(int x = 1;x < width-1;x++){
				int r = work1.getValueI(  x,  y,0)
							+ work1.getValueI(x-1,  y,0)
							+ work1.getValueI(  x,y-1,0)
							+ work1.getValueI(x+1,  y,0)
							+ work1.getValueI(  x,y+1,0)
							+ work1.getValueI(x-1,y-1,0)
							+ work1.getValueI(x+1,y-1,0)
							+ work1.getValueI(x-1,y+1,0)
							+ work1.getValueI(x+1,y+1,0);
				int g = work1.getValueI(  x,  y,1)
							+ work1.getValueI(x-1,  y,1)
							+ work1.getValueI(  x,y-1,1)
							+ work1.getValueI(x+1,  y,1)
							+ work1.getValueI(  x,y+1,1)
							+ work1.getValueI(x-1,y-1,1)
							+ work1.getValueI(x+1,y-1,1)
							+ work1.getValueI(x-1,y+1,1)
							+ work1.getValueI(x+1,y+1,1);
				int b = work1.getValueI(  x,  y,2)
							+ work1.getValueI(x-1,  y,2)
							+ work1.getValueI(  x,y-1,2)
							+ work1.getValueI(x+1,  y,2)
							+ work1.getValueI(  x,y+1,2)
							+ work1.getValueI(x-1,y-1,2)
							+ work1.getValueI(x+1,y-1,2)
							+ work1.getValueI(x-1,y+1,2)
							+ work1.getValueI(x+1,y+1,2);
				output[0].setValue(r/9,x,y,0);
				output[0].setValue(g/9,x,y,1);
				output[0].setValue(b/9,x,y,2);
			}
		}
		work1 = (ArrayInt)output[0];
		output[0] = new ArrayInt(width,height,3);
		}
		output[0] = work1;
	}

	public void setParameter(){}
}
