// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Color Pickup Filter Class

package liushuiEngine.image;

import liushuiEngine.ArrayDouble;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in1out3;

public class RevisionHueDynamicRange extends in1out3 {
	private int width,height;
	
	public RevisionHueDynamicRange(){
		super();
		name = "Revise Hue Dynamic Range Class for graduation thesis";

		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 3;
		outputArrayType[0] = DOUBLE;
		outputArrayDimension[0] = 3;
		outputArrayType[1] = DOUBLE;
		outputArrayDimension[1] = 2;
		outputArrayType[2] = INT;
		outputArrayDimension[2] = 3;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		// get image width & height
		width = input[0].getWidth(0);
		height = input[0].getWidth(1);
		
		double ih,is,ib;
		
		output[0] = new ArrayDouble(width,height,3);
		output[1] = new ArrayDouble(2,1);
		output[2] = new ArrayInt(width,height,3);
		
		double min = Double.MAX_VALUE,max = Double.MIN_VALUE;
		double summention = 0.0;
		int count = 0;
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				if(input[0].getValueD(x,y,1) != 0.0){
					min = Math.min(input[0].getValueD(x,y,0),min);
					max = Math.max(input[0].getValueD(x,y,0),max);
					summention += input[0].getValueD(x,y,0);
					count++;
				}
			}
		}
		double multiple = 1.0/(max - min);
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				if(input[0].getValueD(x,y,1)!=0.0){
					output[0].setValue((input[0].getValueD(x,y,0)-min)*multiple,x,y,0);
					output[0].setValue(input[0].getValueD(x,y,1),x,y,1);
					output[0].setValue(input[0].getValueD(x,y,2),x,y,2);
					output[2].setValue((int)((input[0].getValueD(x,y,0)-min)*multiple*255),x,y,0);
					output[2].setValue(0,x,y,1);
					output[2].setValue(255-(int)((input[0].getValueD(x,y,0)-min)*multiple*255),x,y,2);
				} else {
					output[0].setValue(input[0].getValueD(x,y,0),x,y,0);
					output[0].setValue(input[0].getValueD(x,y,1),x,y,1);
					output[0].setValue(input[0].getValueD(x,y,2),x,y,2);
					output[2].setValue(0,x,y,0);
					output[2].setValue(0,x,y,1);
					output[2].setValue(0,x,y,2);
				}
			}
		}
		output[1].setValue(summention/count,0,0);
		output[1].setValue(count,1,0);
	}

	public void setParameter(){
	}
}
