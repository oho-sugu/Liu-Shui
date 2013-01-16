/**
 * Created on date
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package liushuiEngine.dataanalysis;

import liushuiEngine.ArrayDouble;
import liushuiEngine.basicNode.Filter;
/**
 * @author user
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Semivariance extends Filter {
	private int width,height;
	
	/**
	 * Constructor for ArraySlice.
	 */
	public Semivariance(){
		super();
		name = "Semivariance Calc";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 2;
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
		
		int maxRange = (int)(Math.sqrt(width*width + height*height)) + 2;
		
		output[0] = new ArrayDouble(2,maxRange);

		int numOfH[] = new int[maxRange];
		double valueOfH[] = new double[maxRange];

		for(int j = 0;j < maxRange;j++){
			numOfH[j] = 0;
			valueOfH[j] = 0;
		}
		
		int field[] = new int[width*height];
		int x[] = new int[width*height];
		int y[] = new int[width*height];
		
		int i = 0;
		for(int j = 0;j < width;j++){
			for(int k = 0;k < height;k++){
				field[i] = input[0].getValueI(j,k);
				x[i] = j;
				y[i] = k;
				i++;
			}
		}
		for(int j = 0;j < width*height;j++){
			for(int k = 0;k < width*height;k++){
				double xh = x[j] - x[k];
				double yh = y[j] - y[k];
				double h = Math.sqrt(xh*xh + yh*yh);
				numOfH[(int)h]++;
				valueOfH[(int)h] += (field[j] - field[k])*(field[j] - field[k]);
			}
		}
		
		for(int j = 0;j < maxRange;j++){
			output[0].setValue(j,0,j);
			output[0].setValue(valueOfH[j]/(2*numOfH[j]),1,j);
		}
	}

	public void setParameter(){}
}
