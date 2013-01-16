// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Color Pickup Filter Class

package liushuiEngine.image;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;

public class GreenFilter extends Filter {
	private int width,height;
	private double tColor = 0.33;
	private double colorBandWidth = 0.1;
	private double saturationThreshold = 0.5;
	
	public GreenFilter(){
		super();
		name = "Green Filter Class for graduation thesis";

		inputArrayType[0] = DOUBLE;
		inputArrayDimension[0] = 3;
		outputArrayType[0] = DOUBLE;
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
		
		double ih,is,ib;
		
		output[0] = new ArrayDouble(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				ih = input[0].getValueD(x,y,0);
				is = input[0].getValueD(x,y,1);
				ib = input[0].getValueD(x,y,2);

				if((tColor - colorBandWidth < ih) && (ih < tColor + colorBandWidth)){
					output[0].setValue(ih,x,y,0);
					output[0].setValue(is,x,y,1);
					output[0].setValue(ib,x,y,2);
				} else {
					output[0].setValue(0.0,x,y,0);
					output[0].setValue(0.0,x,y,1);
					output[0].setValue(0.0,x,y,2);
				}
			}
		}
		
	}

	public void setParameter(){
		System.out.println("Input Target Color");
		System.out.print(">");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		tColor = Double.valueOf(str[0]).doubleValue();
		System.out.println("Input Color Band Width");
		System.out.print(">");
		str = new String[1];
		str[0] = "";
		comInput(str);
		colorBandWidth = Double.valueOf(str[0]).doubleValue();
		System.out.println("Input Saturation Threshold");
		System.out.print(">");
		str = new String[1];
		str[0] = "";
		comInput(str);
		saturationThreshold = Double.valueOf(str[0]).doubleValue();
	}
}
