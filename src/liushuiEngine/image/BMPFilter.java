// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class BMP Input Class
// This Node Convert BMP Data Array to Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class BMPFilter extends Filter {
	private int countInp = 0;
	private int width,height;
	
	public BMPFilter(){
		super();
		name = "BMPFilter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 1;
		outputArrayType[0] = INT;
		outputArrayDimension[0] = 3;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		if((input[0].getValueI(0) == 0x42) && (input[0].getValueI(1) == 0x4d)){
			long flSize =     (input[0].getValueI(2)) |  (input[0].getValueI(3)<<8) | 
										(input[0].getValueI(4)<<16) | (input[0].getValueI(5)<<24);
			long imgOffset =     (input[0].getValueI(10)) | (input[0].getValueI(11)<<8) |
											 (input[0].getValueI(12)<<16) | (input[0].getValueI(13)<<24);
			long imgWidth =     (input[0].getValueI(18)) | (input[0].getValueI(19)<<8) | 
										  (input[0].getValueI(20)<<16) | (input[0].getValueI(21)<<24);
			long imgHeight =    (input[0].getValueI(22)) | (input[0].getValueI(23)<<8) |
											(input[0].getValueI(24)<<16) | (input[0].getValueI(25)<<24);
			int imgBitCount = (input[0].getValueI(28)) | (input[0].getValueI(29)<<8);
			
			if(imgBitCount == 24){
				int flPoint = (int)imgOffset;
				output[0] = new ArrayInt((int)imgWidth,(int)imgHeight,3);
				for(int i = (int)imgHeight - 1;i >= 0;i--){
					for(int j = 0;j < imgWidth;j++){
						output[0].setValue(input[0].getValueI(flPoint++),j,i,2);
						output[0].setValue(input[0].getValueI(flPoint++),j,i,1);
						output[0].setValue(input[0].getValueI(flPoint++),j,i,0);
					}
				}
			}
		}
	}

	public void setParameter(){}
}
