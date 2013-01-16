// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Image Blur Class

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class AdjustResize extends Filter {
	private int width,height;
	private int newWidth,newHeight; 
	
	public AdjustResize(){
		super();
		name = "Image Adjust & Resize Class";

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

		if((width/newWidth) > (height/newHeight)){
			newHeight = height * newWidth / width;
		} else {
			newWidth = width * newHeight / height;
		}
		
		output[0] = new ArrayInt(newWidth,newHeight,3);
		
		int num[][] = new int[newWidth][newHeight];
		
		for(int i = 0;i < newHeight;i++){
			for(int j = 0;j < newWidth;j++){
				num[j][i] = 0;
			}
		}
		
		double xRatio = (double)newWidth / (double)width;
		double yRatio = (double)newHeight / (double)height;
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				int newx = (int)((double)x * xRatio);
				int newy = (int)((double)y * yRatio);
				output[0].setValue((input[0].getValueI(x,y,0)+output[0].getValueI(newx,newy,0)),newx,newy,0);
				output[0].setValue((input[0].getValueI(x,y,1)+output[0].getValueI(newx,newy,1)),newx,newy,1);
				output[0].setValue((input[0].getValueI(x,y,2)+output[0].getValueI(newx,newy,2)),newx,newy,2);
				num[newx][newy]++;
			}
		}
		for(int y = 0;y < newHeight;y++){
			for(int x = 0;x < newWidth;x++){
				if(num[x][y] != 0){
					output[0].setValue((int)(output[0].getValueI(x,y,0)/num[x][y]),x,y,0);
					output[0].setValue((int)(output[0].getValueI(x,y,1)/num[x][y]),x,y,1);
					output[0].setValue((int)(output[0].getValueI(x,y,2)/num[x][y]),x,y,2);
				}
			}
		}
	}

	public void setParameter(){
		String str[] = new String[1];
		str[0] = "";
		System.out.println("Input newWidth newHeight");
		System.out.print("width >");
		comInput(str);
		newWidth = Integer.valueOf(str[0]).intValue();
		str[0] = "";
		System.out.print("height>");
		comInput(str);
		newHeight = Integer.valueOf(str[0]).intValue();
	}
}
