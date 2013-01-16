// CUI Program of Multipurpose Data Processing System
// Multipurpose Data Analysis System
// MainWindow Class

package liushuiEngine;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;


public class MainWindow extends Frame {
	private int width,height;
	Image BackBuffer;
	Graphics BackGrp;
	
	
	public MainWindow(){
		super("MainWindow");
	}
	public void InitAll(){
		show();
		BackBuffer = createImage(800,600);
		BackGrp = BackBuffer.getGraphics();
	}
	
	public void paint(Graphics g){
		if(BackBuffer != null){
			g.drawImage(BackBuffer,2,20,this);
		}
	}
	
	public void draw(Cell cell[][],int wid,int hei)
	{
		int i,j;
		// Clear
		BackGrp.setColor(Color.white);
		BackGrp.fillRect(0,0,800,600);
		// Grid
		BackGrp.setColor(Color.LIGHT_GRAY);
		for(i = 0;i < 20;i++){
			BackGrp.drawLine(i*40,0,i*40,600);
		}
		for(j = 0;j < 15;j++){
			BackGrp.drawLine(0,j*40,800,j*40);
		}
		// Cell
		BackGrp.setColor(Color.black);
		for(i = 0;i < wid;i++){
			for(j = 0;j < hei;j++){
				if(cell[i][j] == null){
				} else {
					if(cell[i][j].node.getIconImage() != null){
						BackGrp.drawImage(cell[i][j].node.getIconImage(),
															i*40+4,j*40+4,null);
					}
					BackGrp.drawRect(i*40+4,j*40+4,32,32);
					if(cell[i][j].inpLinkx.length > 0){
						int length = cell[i][j].inpLinkx.length;
						for(int k = 0;k < length;k++){
							int x = cell[i][j].inpLinkx[k];
							int y = cell[i][j].inpLinky[k];
							if((x == 9999) || (y == 9999)){
							} else {
								BackGrp.drawLine(i*40+4,j*40+3+(k+1)*30/(length+1),
																 x*40+36,y*40+3+(cell[i][j].inpLinkn[k]+1)*30/(cell[x][y].inpLinkn.length+1));
							}
						}
					}
				}
			}
		}
	}
}
