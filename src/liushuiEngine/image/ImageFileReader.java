/**
 * Created on date
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package liushuiEngine.image;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

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

public class ImageFileReader extends Generator {
	private String filename = "";
	private int width,height;
	/**
	 * Constructor for FillRect.
	 */
	public ImageFileReader() {
		super();
		name = "Image File Reader (Jpeg Gif Png)";

		outputArrayType[0] = INT;
		outputArrayDimension[0] = 3;
	}

	public void Init(){
		super.Init();
	}

	public void Process()
	{
		BufferedImage innerImage = null;

		try {
			innerImage = ImageIO.read(new File(filename));
		} catch (Exception e) {
			System.out.println("Error on Image File Reader");
			System.exit(0);
		}
		
		width = innerImage.getWidth();
		height = innerImage.getHeight();

		output[0] = new ArrayInt(width,height,3);
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				int pixel = innerImage.getRGB(x,y);
				int r = 0x000000ff & (pixel >> 16);
				int g = 0x000000ff & (pixel >> 8);
				int b = 0x000000ff & pixel;
				output[0].setValue(r,x,y,0);
				output[0].setValue(g,x,y,1);
				output[0].setValue(b,x,y,2);
			}
		}
	}

	public void setParameter(){
		String str[] = new String[1];

		System.out.println("Input File Name");
		System.out.print("File? >");
		str[0] = "";
		comInput(str);
		filename = str[0];
	}

}
