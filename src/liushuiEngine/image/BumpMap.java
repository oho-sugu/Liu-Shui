// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class RGB to HSB Convert Class
// This Node Convert RGB Image Data Array to HSB Image Data Array

package liushuiEngine.image;

import liushuiEngine.ArrayInt;
import liushuiEngine.basicNode.in2out1;

public class  BumpMap extends in2out1 {
	private int width,height;
	private double lightx,lighty,lightz;

	public BumpMap(){
		super();
		name = "Bump Mapping  Filter Class";

		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
		inputArrayType[1] = INT;
		inputArrayDimension[1] = 3;
		// 0 Dist 1 Bump 

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

		double NVector[][][] = new double[width][height][3];
		double HeightMap[][] = new double[width][height];
		
		// Pre Process for Height Map Preperation
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				HeightMap[x][y] = (double)(input[1].getValueI(x,y,0)+
																		 input[1].getValueI(x,y,1)+
																		 input[1].getValueI(x,y,2))/30.0;
			}
		}
		
		// N-Vector Init
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				NVector[x][y][0] = 0.0;
				NVector[x][y][1] = 0.0;
				NVector[x][y][2] = -1.0;
			}
		}
		
		// Calc N-Vector
		for(int y = 1;y < height-1;y++){
			for(int x = 1;x < width-1;x++){
				NVector[x][y][0] = (HeightMap[x+1][y] - HeightMap[x-1][y])/2.0;
				NVector[x][y][1] = (HeightMap[x][y+1] - HeightMap[x][y-1])/2.0;
				NVector[x][y][2] = -1.0;
			}
		}
		
		// Normalize
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				double vectorLength = Math.sqrt(NVector[x][y][0]*NVector[x][y][0]+
																NVector[x][y][1]*NVector[x][y][1]+
																NVector[x][y][2]*NVector[x][y][2]);
				NVector[x][y][0] /= vectorLength;
				NVector[x][y][1] /= vectorLength;
				NVector[x][y][2] /= vectorLength;
			}
		}
		
		double lightLength = Math.sqrt(lightx*lightx+lighty*lighty+lightz*lightz);
		lightx /= lightLength;
		lighty /= lightLength;
		lightz /= lightLength;
		
		double Iin = 1.0;
		double Kd = 1.0;
		double Ks = 1.0;
		
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				double c = NVector[x][y][0]*lightx + NVector[x][y][1]*lighty + NVector[x][y][2]*lightz;
				double mulLight = -Iin*Kd*c /*+ Iin*Ks*Math.pow(c,20)*/;
				int r = (int)((double)input[0].getValueI(x,y,0)*mulLight);
				int g = (int)((double)input[0].getValueI(x,y,1)*mulLight);
				int b = (int)((double)input[0].getValueI(x,y,2)*mulLight);

				if(r < 0){ r = 0; }
				if(r > 255){ r = 255; }
				if(g < 0){ g = 0; }
				if(g > 255){ g = 255; }
				if(b < 0){ b = 0; }
				if(b > 255){ b = 255; }
					
				output[0].setValue(r,x,y,0);
				output[0].setValue(g,x,y,1);
				output[0].setValue(b,x,y,2);
			}
		}
	}

	public void setParameter(){
		System.out.println("Input Light Coord");
		System.out.print("x >");
		String str[] = new String[1];
		str[0] = "";
		comInput(str);
		lightx = Double.valueOf(str[0]).doubleValue();
		System.out.print("y >");
		str[0] = "";
		comInput(str);
		lighty = Double.valueOf(str[0]).doubleValue();
		System.out.print("z >");
		str[0] = "";
		comInput(str);
		lightz = Double.valueOf(str[0]).doubleValue();
	}
}
