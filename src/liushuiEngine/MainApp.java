// CUI Program of Multipurpose Data Processing System
// Multipurpose Data Analysis System
// Prototype is Build 2002 / 08 / 18

package liushuiEngine;
import java.io.*;

import liushuiEngine.Cell;
import liushuiEngine.MainWindow;

public class MainApp {
	static Cell cell[][];
	static int width,height;
	static int loopC = 0;
	static MainWindow mainWindow = new MainWindow();

	public static void main(String args[])
	{
		String a[] = new String[10];
		mainWindow.setSize(800,600);
		mainWindow.InitAll();
		mainWindow.show();
		for(int i = 0;i < 10;i++){
			a[i] = "";
		}
		
		// Init
		// Starting Up
		System.out.println("Multipurpose Data Processing System                ");
		System.out.println(" +---+                                             ");
		System.out.println(" |///+--+ +---+     —¬… Liu-shui                  ");
		System.out.println(" +---+  +-+||||        CUI version 0.1             ");
		System.out.println("  +---+ | +---+                                    ");
		System.out.println("  |===+-+           Copyright 2002- Suguru Oho     ");
		System.out.println("  +---+                                            ");
		System.out.println("                    Have a Happy Computing!        ");
		
		while(loopC == 0){
			System.out.print("Command>");
			for(int i = 0;i < 10;i++){
				a[i] = "";
			}
			comInput(a);
			if(a[0].equals("END")){ endSystem();}
			if(a[0].equals("QUIT")){ endSystem();}
			if(a[0].equals("SYSTEM")){ endSystem();}
			if(a[0].equals("EXIT")){ endSystem();}
			if(a[0].equals("ADD")){
				int x = Integer.valueOf(a[1]).intValue();
				int y = Integer.valueOf(a[2]).intValue();
				int type = Integer.valueOf(a[3]).intValue();
				System.out.println(""+x+y+type);
				cell[x][y] = new Cell(type);
				mainWindow.draw(cell,width,height);
				mainWindow.repaint();
			}
			if(a[0].equals("DEL")){
				int x = Integer.valueOf(a[1]).intValue();
				int y = Integer.valueOf(a[2]).intValue();
				cell[x][y] = null;
				mainWindow.draw(cell,width,height);
				mainWindow.repaint();
			}
			if(a[0].equals("LINK")){
				int x1 = Integer.valueOf(a[1]).intValue();
				int y1 = Integer.valueOf(a[2]).intValue();
				int n1 = Integer.valueOf(a[3]).intValue();
				int x2 = Integer.valueOf(a[4]).intValue();
				int y2 = Integer.valueOf(a[5]).intValue();
				int n2 = Integer.valueOf(a[6]).intValue();
				if(cell[x2][y2] != null){
					cell[x2][y2].createLink(n2,x1,y1,n1);
				} else {
					System.out.println("Node Not Found");
				}
				mainWindow.draw(cell,width,height);
				mainWindow.repaint();
			}
			if(a[0].equals("DELLINK")){
				int x1 = Integer.valueOf(a[1]).intValue();
				int y1 = Integer.valueOf(a[2]).intValue();
				int n1 = Integer.valueOf(a[3]).intValue();
				if(cell[x1][y1] != null){
					cell[x1][y1].deleteLink(n1);
				} else {
					System.out.println("Node Not Found");
				}
				mainWindow.draw(cell,width,height);
				mainWindow.repaint();
			}
			if(a[0].equals("SELECT")){}
			if(a[0].equals("CUT")){}
			if(a[0].equals("COPY")){}
			if(a[0].equals("PASTE")){}
			if(a[0].equals("SAVE")){
				String filename = a[1];
		    try {
	      ObjectOutputStream ostream = 
	        new ObjectOutputStream(new FileOutputStream(filename));
				ostream.writeObject(cell);
 		   	} catch (IOException e) {
    	  System.out.println("can not create file");
    		}
			}
			if(a[0].equals("LOAD")){
				String filename = a[1];
				try {
      		ObjectInputStream istream =
          	new ObjectInputStream(new FileInputStream(filename));
      		Object object = istream.readObject();
      		cell = (Cell[][])object;
    		} catch (Exception e) {
      		System.out.println("can not open file");
    		}
    		width = cell.length;
    		height = cell[0].length;
			}
			if(a[0].equals("OPEN")){}
			if(a[0].equals("NEW")){
				width = Integer.valueOf(a[1]).intValue();
				height = Integer.valueOf(a[2]).intValue();
				cell = new Cell[width][height];
				for(int ii = 0;ii < width;ii++){
					for(int jj = 0;jj < height;jj++){
						cell[ii][jj] = null;
					}
				}
				mainWindow.draw(cell,width,height);
				mainWindow.repaint();
			}
			if(a[0].equals("RUN")){
				Process();
				System.gc();
			}
			if(a[0].equals("GC")){
				System.gc();
			}
			if(a[0].equals("HELPCOM")){
				System.out.println("End               Quit              System            Exit");
				System.out.println("Add x y type      del x y           link x y n x y n  dellink x y n");
				System.out.println("select x y x y    cut               copy              paste x y");
				System.out.println("save filename     load filename     new width height  run");
				System.out.println("helpcom           helptype          setparam x y");
			}
			if(a[0].equals("HELPTYPE")){
				System.out.println("1 Adder.java");
				System.out.println("2 FileInput.java");
				System.out.println("3 FileOutput.java");
				System.out.println("4 Diff1Filter.java");
				System.out.println("5 CSVFilter.java");
				System.out.println("6 ConOutput.java");
				System.out.println("7 CSVOutput.java");
				System.out.println("8 TBPFilter.java");
				System.out.println("9 TPAFilter.java");
			}
			if(a[0].equals("SETPARAM")){
				int x = Integer.valueOf(a[1]).intValue();
				int y = Integer.valueOf(a[2]).intValue();
				if(cell[x][y] != null){
					cell[x][y].node.setParameter();
				} else {
					System.out.println("Node Not Found");
				}
			}
		}
	}
	private static void comInput(String str[])
	{
		int i = 0,j = 0,k = 0;
		int loopFlag = 0;
		
		while(loopFlag == 0){
			int inpCode = 0;

			try{
				inpCode = System.in.read();
			} catch(IOException e){}
			
			if(inpCode == -1){
				loopFlag = 1;
			} else if(inpCode == 10){
				loopFlag = 1; // LF
			} else if(inpCode == 13){
			} else if(inpCode == 0x20){
				if(i < str.length - 1){
					++i;
				} else {
					loopFlag = 1;
				}
			} else {
				if((0x60 < inpCode) && (inpCode < 0x7B)){
					inpCode -= 0x20;
				}
				str[i] = str[i] + (char)inpCode;
			}
		}
	}
	
	public static void endSystem()
	{
		loopC = 1;
		mainWindow.dispose();
		System.exit(0);
	}
	
	public static void Process()
	{
		for(int i = 0;i < width;i++){
			for(int j = 0;j < height;j++){
				if(cell[i][j] == null){
				} else {
					int length = cell[i][j].inpLinkx.length;
					if(length == 0){
					} else {
						for(int k = 0;k < length;k++){
							int x = cell[i][j].inpLinkx[k];
							int y = cell[i][j].inpLinky[k];
							int n = cell[i][j].inpLinkn[k];
							if(x == 9999){
							} else {
								if(cell[x][y] != null){
									cell[i][j].node.setInput(k,cell[x][y].node.getOutput(n));
								} else {
									System.out.println("Node Not Found");
								}
							}
						}
					}
					cell[i][j].node.Process();
				}
			}
		}
	}
}
