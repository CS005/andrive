package com.andrive;

import android.util.Log;

import com.andrive.ui.OverlayedPreviewView;

public class BackGroundThread extends Thread{
	boolean threadFlag;
	String log;

	public void setFlag(boolean flag){
		threadFlag = flag;
	}

	public void run(){
		while(threadFlag){
			log = GetSensorNative.getPhoto();
			Log.v("BackGroundThread","run + " + log);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			OverlayedPreviewView.drawView.setPreview();
		}
	}
}