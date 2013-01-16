/**
 * Created on date
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package liushuiEngine.dataconvert;

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
public class ArraySlice extends Filter {
	private int width,height;
	
	/**
	 * Constructor for ArraySlice.
	 */
	public ArraySlice(){
		super();
		name = "Array Slicer";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
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
		
		for(int j = 0;j < width;j++){
			for(int k = 0;k < height;k++){
				output[0].setValue(input[0].getValueI(j,k,0),j,k);
			}
		}
	}

	public void setParameter(){}
}
