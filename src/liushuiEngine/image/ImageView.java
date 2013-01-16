// Data Array Proccessing System for Multi Purpose
//   by Suguru Oho 2002/08/04-
// Data Process Object Class Image Viewer Class
//
// This Class is Viewer Class of Image Data

package liushuiEngine.image;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

import liushuiEngine.Array;
import liushuiEngine.basicNode.Terminator;

public class ImageView extends Terminator {
	public ImageView(){
		super();
		name = "Image View Class";
		inputArrayType[0] = INT;
		inputArrayDimension[0] = 3;
	}

	public void Init(){
		super.Init();
	}
	
	public void Process(){
		MyFrame myFrame = new MyFrame();
		myFrame.setImage(input[0]);
		myFrame.show();
	}

	public void setParameter(){}
}

class MyFrame extends JFrame{
	Image image;
	int buff[];
	
	public MyFrame(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
		if(image != null){
			g.drawImage(image,4,24,this);
		}
	}
	public void setImage(Array a)
	{
		int width = a.getWidth(0);
		int height = a.getWidth(1);
		
		setSize(width+8,height+26);
		buff = new int[width*height];
		int cnt = 0;
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				buff[cnt++] = (0xff << 24) + (a.getValueI(x,y,0)<<16) +
				              (a.getValueI(x,y,1)<<8) + a.getValueI(x,y,2);
			}
		}
		
		image = createImage(new MemoryImageSource(width,height,buff,0,width));
	}
}
