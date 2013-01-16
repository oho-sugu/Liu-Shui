// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Color Pickup Filter Class

package liushuiEngine.image;

import liushuiEngine.ArrayDouble;
import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in1out4;

public class RGBGRatioCalc extends in1out4 {
	private int width,height;
	
	public RGBGRatioCalc(){
		super();
		name = "Calc R/G Ratio Class for graduation thesis";

		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 3;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 3;
		outputArrayType[1] = INT;
		outputArrayDimension[1] = 3;
		outputArrayType[2] = INT;
		outputArrayDimension[2] = 3;
		outputArrayType[2] = DOUBLE;
		outputArrayDimension[2] = 2;
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
		
		output[0] = new ArrayInt(width,height,3);
		output[1] = new ArrayInt(width,height,3);
		output[2] = new ArrayInt(width,height,3);
		output[3] = new ArrayDouble(2,1);
		
		double[][] ratioBuffer = new double[width][height];
		double min = Double.MAX_VALUE,max = Double.MIN_VALUE;
		double summention = 0.0;
		int count = 0;
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				if(input[0].getValueI(x,y,1) != 0){
					double ratio = (double)input[0].getValueI(x,y,0) / (double)input[0].getValueI(x,y,1);
					min = Math.min(min,ratio);
					max = Math.max(max,ratio);
					ratioBuffer[x][y] = ratio;
					summention += ratio;
					count++;
				}else{
					ratioBuffer[x][y] = 0.0;
				}
			}
		}
		output[3].setValue(summention/count,0,0);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				if(ratioBuffer[x][y] != 0.0){
					int r = (int)((ratioBuffer[x][y] - min)*255/(max-min));
					r = Math.min(255,r);
					r = Math.max(  0,r);
					output[0].setValue(r,x,y,0);
					output[2].setValue(r,x,y,0);
					output[0].setValue(0,x,y,1);
					output[2].setValue(0,x,y,1);
				}else{
					output[0].setValue(0,x,y,0);
					output[2].setValue(0,x,y,0);
					output[0].setValue(0,x,y,1);
					output[2].setValue(0,x,y,1);
				}
			}
		}

		ratioBuffer = new double[width][height];
		min = Double.MAX_VALUE; max = Double.MIN_VALUE;
		summention = 0.0;
		count = 0;
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				if(input[0].getValueI(x,y,1) != 0){
					double ratio = (double)input[0].getValueI(x,y,2) / (double)input[0].getValueI(x,y,1);
					min = Math.min(min,ratio);
					max = Math.max(max,ratio);
					ratioBuffer[x][y] = ratio;
					summention += ratio;
					count++;
				}else{
					ratioBuffer[x][y] = 0.0;
				}
			}
		}
		output[3].setValue(summention/count,1,0);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				if(ratioBuffer[x][y] != 0.0){
					int b = (int)((ratioBuffer[x][y] - min)*255/(max-min));
					b = Math.min(255,b);
					b = Math.max(  0,b);
					output[0].setValue(b,x,y,2);
					output[2].setValue(b,x,y,2);
				}else{
					output[0].setValue(0,x,y,2);
					output[2].setValue(0,x,y,2);
				}
			}
		}
	}

	public void setParameter(){
	}
}
