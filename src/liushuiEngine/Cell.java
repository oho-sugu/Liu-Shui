// Object Cell for CUI Program

package liushuiEngine;

import java.io.Serializable;

import liushuiEngine.dataanalysis.*;
import liushuiEngine.dataconvert.*;
import liushuiEngine.dataprocess.*;
import liushuiEngine.fileIO.*;
import liushuiEngine.image.*;
import liushuiEngine.GIS.*;

public class Cell implements Serializable {
	public Node node;
	public int inpLinkx[];
	public int inpLinky[];
	public int inpLinkn[];
	
	public Cell(int num){
		createNode(num);
		if(node == null){
		} else{
			int inpSocket = node.inputArrayType.length;
			inpLinkx = new int[inpSocket];
			inpLinky = new int[inpSocket];
			inpLinkn = new int[inpSocket];
			for(int i=0;i < inpSocket;i++){
				inpLinkx[i] = 9999;
				inpLinky[i] = 9999;
				inpLinkn[i] = 9999;
			}
		}
	}

	public void createLink(int MyN,int LinkX,int LinkY,int LinkNum)
	{
		inpLinkx[MyN] = LinkX;
		inpLinky[MyN] = LinkY;
		inpLinkn[MyN] = LinkNum;
	}
	public void deleteLink(int MyN)
	{
		inpLinkx[MyN] = 9999;
		inpLinky[MyN] = 9999;
		inpLinkn[MyN] = 9999;
	}
	
	public void createNode(int num)
	{
		switch(num){
			case 0:
				node = null;
				break;
			case 1:
				node = new Adder();
				node.readIconImage("img/Adder.jpg");
				node.setParameter();
				node.Init();
				break;
			case 2:
				node = new FileInput();
				node.readIconImage("img/FileInput.jpg");
				node.setParameter();
				node.Init();
				break;
			case 3:
				node = new FileOutput();
				node.readIconImage("img/FileOutput.jpg");
				node.setParameter();
				node.Init();
				break;
			case 4:
				node = new Diff1Filter();
				node.readIconImage("img/Diff1Filter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 5:
				node = new CSVFilter();
				node.readIconImage("img/CSVFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 6:
				node = new ConOutput();
				node.readIconImage("img/ConOutput.jpg");
				node.setParameter();
				node.Init();
				break;
			case 7:
				node = new CSVOutput();
				node.readIconImage("img/CSVOutput.jpg");
				node.setParameter();
				node.Init();
				break;
			case 8:
				node = new TBPFilter();
				node.readIconImage("img/TBPFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 9:
				node = new TPAFilter();
				node.readIconImage("img/TPAFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 10:
				node = new TeraFilter();
				node.readIconImage("img/TeraFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 11:
				node = new BMPFilter();
				node.readIconImage("img/BMPFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 12:
				node = new ImageView();
				node.readIconImage("img/ImageView.jpg");
				node.setParameter();
				node.Init();
				break;
			case 13:
				node = new RGBInvFilter();
				node.readIconImage("img/RGBInvFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 14:
				node = new Blend1Filter();
				node.readIconImage("img/Blend1Filter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 15:
				node = new PixcelCount();
				node.readIconImage("img/PixcelCount.jpg");
				node.setParameter();
				node.Init();
				break;
			case 16:
				node = new RGB2HSBFilter();
				node.readIconImage("img/RGB2HSBFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 17:
				node = new HSB2RGBFilter();
				node.readIconImage("img/HSB2RGBFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 18:
				node = new Color1Filter();
				node.readIconImage("img/Color1Filter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 19:
				node = new PixcelCount2();
				node.readIconImage("img/PixcelCount2.jpg");
				node.setParameter();
				node.Init();
				break;
			case 20:
				node = new StDeviation();
				node.readIconImage("img/StDeviation.jpg");
				node.setParameter();
				node.Init();
				break;
			case 21:
				node = new BlurFilter();
				node.readIconImage("img/BlurFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 22:
				node = new ImgDiffFilter();
				node.readIconImage("img/ImgDiffFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 23:
				node = new BCHEncode();
				node.readIconImage("img/BCHEncode.jpg");
				node.setParameter();
				node.Init();
				break;
			case 24:
				node = new Noise();
				node.readIconImage("img/Noise.jpg");
				node.setParameter();
				node.Init();
				break;
			case 25:
				node = new BCHDecode();
				node.readIconImage("img/BCHDecode.jpg");
				node.setParameter();
				node.Init();
				break;
			case 26:
				node = new ArrayReform();
				node.readIconImage("img/ArrayReform.jpg");
				node.setParameter();
				node.Init();
				break;
			case 27:
				node = new HuffmanEncode();
				node.readIconImage("img/HuffmanEncode.jpg");
				node.setParameter();
				node.Init();
				break;
			case 28:
				node = new HuffmanDecode();
				node.readIconImage("img/HuffmanDecode.jpg");
				node.setParameter();
				node.Init();
				break;
			case 29:
				node = new And();
				node.readIconImage("img/And.jpg");
				node.setParameter();
				node.Init();
				break;
			case 30:
				node = new OhoDecode1();
				node.readIconImage("img/OhoDecode1.jpg");
				node.setParameter();
				node.Init();
				break;
			case 31:
				node = new FillRect();
				node.readIconImage("img/FillRect.jpg");
				node.setParameter();
				node.Init();
				break;
			case 32:
				node = new FillImage();
				node.readIconImage("img/FillImage.jpg");
				node.setParameter();
				node.Init();
				break;
			case 33:
				node = new PutImageXY();
				node.readIconImage("img/PutImageXY.jpg");
				node.setParameter();
				node.Init();
				break;
			case 34:
				node = new PutImageAlign();
				node.readIconImage("img/PutImageAlign.jpg");
				node.setParameter();
				node.Init();
				break;
			case 35:
				node = new AlphaPutImageXY();
				node.readIconImage("img/AlphaPutImageXY.jpg");
				node.setParameter();
				node.Init();
				break;
			case 36:
				node = new AlphaPutImageAlign();
				node.readIconImage("img/AlphaPutImageAlign.jpg");
				node.setParameter();
				node.Init();
				break;
			case 37:
				node = new AdjustResize();
				node.readIconImage("img/AdjustResize.jpg");
				node.setParameter();
				node.Init();
				break;
			case 38:
				node = new ImageFileReader();
				node.readIconImage("img/ImageFileReader.jpg");
				node.setParameter();
				node.Init();
				break;
			case 39:
				node = new JPEGWriter();
				node.readIconImage("img/JPEGWriter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 40:
				node = new GIFWriter();
				node.readIconImage("img/GIFWriter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 41:
				node = new PNGWriter();
				node.readIconImage("img/PNGWriter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 42:
				node = new CutImage();
				node.readIconImage("img/CutImage.jpg");
				node.setParameter();
				node.Init();
				break;
			case 43:
				node = new DecorateBorderImage();
				node.readIconImage("img/DecorateBorderImage.jpg");
				node.setParameter();
				node.Init();
				break;
			case 44:
				node = new Blend2Filter();
				node.readIconImage("img/Blend2Filter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 45:
				node = new BumpMap();
				node.readIconImage("img/BumpMap.jpg");
				node.setParameter();
				node.Init();
				break;
			case 46:
				node = new RippleGen();
				node.readIconImage("img/RippleGen.jpg");
				node.setParameter();
				node.Init();
				break;
			case 47:
				node = new RGBAverageArray();
				node.readIconImage("img/RGBAverageArray.jpg");
				node.setParameter();
				node.Init();
				break;
			case 48:
				node = new ArraySlice();
				node.readIconImage("img/ArraySlice.jpg");
				node.setParameter();
				node.Init();
				break;
			case 49:
				node = new Semivariance();
				node.readIconImage("img/Semivariance.jpg");
				node.setParameter();
				node.Init();
				break;
			case 50:
				node = new GreenFilter();
				node.readIconImage("img/GreenFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 51:
				node = new RevisionDynamicRange();
				node.readIconImage("img/RevisionDynamicRange.jpg");
				node.setParameter();
				node.Init();
				break;
			case 52:
				node = new BinaryConvert();
				node.readIconImage("img/BinaryConvert.jpg");
				node.setParameter();
				node.Init();
				break;
			case 53:
				node = new Monochromize();
				node.readIconImage("img/Monochromize.jpg");
				node.setParameter();
				node.Init();
				break;
			case 54:
				node = new PixcelCounter3();
				node.readIconImage("img/PixcelCounter3.jpg");
				node.setParameter();
				node.Init();
				break;
			case 55:
				node = new BinaryImageDifferenceFilter();
				node.readIconImage("img/BinaryImageDifferenceFilter.jpg");
				node.setParameter();
				node.Init();
				break;
			case 56:
				node = new Mono2Image();
				node.readIconImage("img/Mono2Image.jpg");
				node.setParameter();
				node.Init();
				break;
			case 57:
				node = new Binary2Image();
				node.readIconImage("img/Binary2Image.jpg");
				node.setParameter();
				node.Init();
				break;
			case 58:
				node = new RevisionHueDynamicRange();
				node.readIconImage("img/RevisionHueDynamicRange.jpg");
				node.setParameter();
				node.Init();
				break;
			case 59:
				node = new RGBGRatioCalc();
				node.readIconImage("img/RGBGRatioCalc.jpg");
				node.setParameter();
				node.Init();
				break;
			case 60:
				node = new NDVI();
				node.readIconImage("img/NDVI.jpg");
				node.setParameter();
				node.Init();
				break;
			case 61:
				node = new CorrectDynamicRangeD2I();
				node.readIconImage("img/CorrectDynamicRangeD2I.jpg");
				node.setParameter();
				node.Init();
				break;
			case 62:
				node = new Mono2Color();
				node.readIconImage("img/Mono2Color.jpg");
				node.setParameter();
				node.Init();
				break;
			case 63:
				node = new Mono2MonoImage();
				node.readIconImage("img/Mono2MonoImage.jpg");
				node.setParameter();
				node.Init();
				break;
			default:
				node = null;
		}
		if(node != null){
			System.out.println(node.name);
		}
	}
}
