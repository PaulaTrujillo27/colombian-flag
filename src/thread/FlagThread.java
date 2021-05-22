package thread;
import model.Flag;
import ui.FlagGUI;

public class FlagThread extends Thread{
	private Flag cf;
	private FlagGUI cfui;
	private int sleep;

	public FlagThread(Flag cf, FlagGUI cfui, int sleep) {
		this.cf = cf;
		this.cfui = cfui;
		this.sleep = sleep;
	}

	public Flag getCf() {
		return cf;
	}

	public void setCf(Flag cf) {
		this.cf = cf;
	}

	public FlagGUI getCfui() {
		return cfui;
	}

	public void setCfui(FlagGUI cfui) {
		this.cfui = cfui;
	}

	public int getSleep() {
		return sleep;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	 @Override
	    public void run() {
	        setPosition();
	    }

	    public void setPosition() {
	        for (int i = 0; i < cf.getWidth(); i++) {
	            cf.setHorizontal();
	            for (int j = cf.getSavePosition(); j < cf.getHeight(); j++) {
	                cfui.changeFlag(cf.getHorizontal(), cf.getVertical(), cf.getColor());
	                cf.setVertical(i);
	                try {
	                    Thread.sleep(sleep);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	            cf.setVerticalPosition();
	        }
	    }
	}