// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Image Blur Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class FillImage extends Filter {
	private int width,height;
	private int r,g,b;

	public FillImage(){
		super();
		name = "Fill Image Class";

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

		for(int i = 0;i < height;i++){
			for(int j = 0;j < width;j++){
				output[0].setValue(r,j,i,0);
				output[0].setValue(g,j,i,1);
				output[0].setValue(b,j,i,2);
			}
		}

	}

	public void setParameter(){
		String str[] = new String[1];

		System.out.println("Input Color 0-255");
		System.out.print("Red  >");
		str[0] = "";
		comInput(str);
		r = Integer.valueOf(str[0]).intValue();
		System.out.print("Green>");
		str[0] = "";
		comInput(str);
		g = Integer.valueOf(str[0]).intValue();
		System.out.print("Blue >");
		str[0] = "";
		comInput(str);
		b = Integer.valueOf(str[0]).intValue();
	}
}
