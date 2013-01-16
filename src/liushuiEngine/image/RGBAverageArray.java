/**
 * Created on date
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

/**
 * @author user
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class RGBAverageArray extends Filter {
	private int width,height;
	
	public RGBAverageArray(){
		super();
		name = "RGB Average Array";

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
		
		for(int j = 0;j < width;j++){
			for(int k = 0;k < height;k++){
				int red = input[0].getValueI(j,k,0);
				int green = input[0].getValueI(j,k,1);
				int blue = input[0].getValueI(j,k,2);
				int avr = (red+green+blue)/3;
				output[0].setValue(avr,j,k,0);
				output[0].setValue(avr,j,k,1);
				output[0].setValue(avr,j,k,2);
			}
		}
	}

	public void setParameter(){}
}
