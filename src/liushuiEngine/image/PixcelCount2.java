// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Pixcel Count 2 Class

package liushuiEngine.image;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class PixcelCount2 extends Filter {
	private int width,height;
	private int borderValue;
	
	public PixcelCount2(){
		super();
		name = "Pixcel Counter No.2 Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
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
		
		int cnt = 0;
		
		output[0] = new ArrayDouble(1,1);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				if(borderValue < input[0].getValueI(x,y,0)){
					cnt++;
				} else if(borderValue < input[0].getValueI(x,y,1)){
					cnt++;
				} else if(borderValue < input[0].getValueI(x,y,2)){
					cnt++;
				}
			}
		}
		
		output[0].setValue((double)cnt,0,0);
	}

	public void setParameter(){
		System.out.println("Input Border Value");
		System.out.print(">");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		borderValue = Integer.valueOf(str[0]).intValue();
	}
}
