// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Image Blur Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class CutImage extends Filter {
	private int width,height;
	private int r,g,b;
	private int startx,starty;

	public CutImage(){
		super();
		name = "Cut Image Class";

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
		int oriwidth = input[0].getWidth(0);
		int oriheight = input[0].getWidth(1);

		if(oriwidth < width+startx){ width = oriwidth - startx; }
		if(oriheight < height+starty){ height = oriheight - starty; }
				
		output[0] = new ArrayInt(width,height,3);

		for(int i = 0;i < height;i++){
			for(int j = 0;j < width;j++){
				output[0].setValue(input[0].getValueI(j+startx,i+starty,0),j,i,0);
				output[0].setValue(input[0].getValueI(j+startx,i+starty,1),j,i,1);
				output[0].setValue(input[0].getValueI(j+startx,i+starty,2),j,i,2);
			}
		}

	}

	public void setParameter(){
		String str[] = new String[1];

		System.out.println("Input Startx & Starty");
		System.out.print("X >");
		str[0] = "";
		comInput(str);
		startx = Integer.valueOf(str[0]).intValue();
		System.out.print("Y >");
		str[0] = "";
		comInput(str);
		starty = Integer.valueOf(str[0]).intValue();
		System.out.println("Input Width & Height");
		System.out.print("Width >");
		str[0] = "";
		comInput(str);
		width = Integer.valueOf(str[0]).intValue();
		System.out.print("Height>");
		str[0] = "";
		comInput(str);
		height = Integer.valueOf(str[0]).intValue();
	}
}
