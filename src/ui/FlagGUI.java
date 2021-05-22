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
    	flagArray[0] = new Flag("y", 0, 0, 0, 100, 20);
    	flagArray[1] = new Flag("b", 20, 0, 20, 100, 30);
    	flagArray[2] = new Flag("r", 30, 0, 30, 100, 40);
    }

    public void initilalizeThread() {
    	threadArray[0] = new FlagThread(flagArray[0], this, 15);
    	threadArray[1] = new FlagThread(flagArray[1], this, 40);
    	threadArray[2] = new FlagThread(flagArray[2], this, 45);
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