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
import liushuiEngine.basicNode.Generator;

/**
 * @author user
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

public class FillRect extends Generator {
	private int width,height;
	private int r,g,b;

	/**
	 * Constructor for FillRect.
	 */
	public FillRect() {
		super();
		name = "Fill Rect";

		outputArrayType[0] = INT;
		outputArrayDimension[0] = 3;
	}
	public void Init(){
		super.Init();
	}

	public void Process()
	{
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

		System.out.println("Input Width & Height");
		System.out.print("Width >");
		str[0] = "";
		comInput(str);
		width = Integer.valueOf(str[0]).intValue();
		System.out.print("Height>");
		str[0] = "";
		comInput(str);
		height = Integer.valueOf(str[0]).intValue();
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
