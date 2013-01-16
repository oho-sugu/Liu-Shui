// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class BinaryConvert extends Filter {
	private int width,height;
	private int threshold;
	
	public BinaryConvert(){
		super();
		name = "Binary Convert by Threshold Class for graduation thesis";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 2;
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
				if(input[0].getValueI(x,y) < threshold){
					output[0].setValue(0,x,y);
				}else{
					output[0].setValue(1,x,y);
				}
			}
		}
	}

	public void setParameter(){
		System.out.println("Input Threshold");
		System.out.print(">");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		threshold = Integer.parseInt(str[0]);
	}
}
