// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class HSB to RGB Convert Class
// This Node Convert HSB Image Data Array to RGB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.Filter;

public class HSB2RGBFilter extends Filter {
	private int width,height;
	
	public HSB2RGBFilter(){
		super();
		name = "HSB2RGBFilter Class";

		inputArrayType[0] = DOUBLE;
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
		int rgb[] = new int[3];
		
		output[0] = new ArrayInt(width,height,3);
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				rgb = HSBtoRGB(input[0].getValueD(x,y,0),
				               input[0].getValueD(x,y,1),input[0].getValueD(x,y,2));
				output[0].setValue(rgb[0],x,y,0);
				output[0].setValue(rgb[1],x,y,1);
				output[0].setValue(rgb[2],x,y,2);
			}
		}
		
	}

	public void setParameter(){}
	
	public int[] HSBtoRGB(double hue, double sat, double bri)
	{
		double phase, ofs, d1, d2, d3;
		int ret[] = new int[3];
		double r=0,g=0,b=0;
		
		// ƒOƒŒƒC‚Ì‚Æ‚«
		if(sat==0.0) {
			r = g = b = bri;
			ret[0] = (int)(r * 255);
			ret[1] = (int)(g * 255);
			ret[2] = (int)(b * 255);
			return ret;
		}
		phase = ( hue - Math.floor(hue) ) * 6.0;
		ofs = phase - Math.floor(phase);
		d1 = bri * ( 1.0 - sat );
		d2 = bri * ( 1.0 - sat * ofs );
		d3 = bri * ( 1.0 - sat * (1.0 - ofs) );
	
		switch((int)phase) {
		case 0:
			r = bri;
			g = d3;
			b = d1;
			break;
		case 1:
			r = d2;
			g = bri;
			b = d1;
			break;
		case 2:
			r = d1;
			g = bri;
			b = d3;
			break;
		case 3:
			r = d1;
			g = d2;
			b = bri;
			break;
		case 4:
			r = d3;
			g = d1;
			b = bri;
			break;
		case 5:
			r = bri;
			g = d1;
			b = d2;
			break;
		}
	
		ret[0] = (int)(r * 255);
		ret[1] = (int)(g * 255);
		ret[2] = (int)(b * 255);
	
		return ret;
	}
}
