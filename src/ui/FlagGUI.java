package ui;

import model.Flag;
import thread.FlagThread;

public class FlagGUI {
	
    public final static String ESC = "\u001b[";
	private final String yellow = "\u001b[43m";
	private final String blue = "\u001b[44m";
	private final String red = "\u001b[41m";
	private final int flagColors = 3;
	private FlagThread[] threadArray;
	private Flag[] flagArray;
	
	public FlagGUI() {
		threadArray  = new FlagThread[flagColors];
		flagArray = new Flag[flagColors];
		initializeColor();
		initilalizeThread();
		
	}
    public void initProgram() {
        for (int i = 0; i < flagColors; i++) {
        	threadArray[i].start();
        }
    }

    public void initializeColor() {
    	flagArray[0] = new Flag("y", 0, 0, 0, 100, 10);
    	flagArray[1] = new Flag("b", 10, 0, 10, 100, 17);
    	flagArray[2] = new Flag("r", 17, 0, 17, 100, 22);
    }

    public void initilalizeThread() {
    	threadArray[0] = new FlagThread(flagArray[0], this, 10);
    	threadArray[1] = new FlagThread(flagArray[1], this, 30);
    	threadArray[2] = new FlagThread(flagArray[2], this, 50);
    }
    
    public void changeFlag(int horizontal, int vertical, String color) {
        if (color.equals("y")) {
            System.out.print(ESC + horizontal + "G" + ESC + vertical + "d" + yellow + " " + ESC);
        } else if (color.equals("b")) {
            System.out.print(ESC + horizontal + "G" + ESC + vertical + "d" + blue + " " + ESC);
        } else {
            System.out.print(ESC + horizontal + "G" + ESC + vertical + "d" + red + " " + ESC);
        }
    }
	public Flag[] getFlagArray() {
		return flagArray;
	}
	public void setFlagArray(Flag[] flagArray) {
		this.flagArray = flagArray;
	}
	public FlagThread[] getThreadArray() {
		return threadArray;
	}
	public void setThreadArray(FlagThread[] threadArray) {
		this.threadArray = threadArray;
	}
	public String getYellow() {
		return yellow;
	}
	public String getRed() {
		return red;
	}
	public String getBlue() {
		return blue;
	}
	
}