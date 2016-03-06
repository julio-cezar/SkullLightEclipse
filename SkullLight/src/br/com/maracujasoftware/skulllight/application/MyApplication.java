package br.com.maracujasoftware.skulllight.application;

import br.com.maracujasoftware.skulllight.util.IabHelper;
import android.app.Application;

public class MyApplication extends Application {
	private IabHelper mHelper;
	
	@Override
	public void onCreate(){
		super.onCreate();
	}

	public IabHelper getmHelper() {
		return mHelper;
	}
	public void setmHelper(IabHelper mHelper) {
		this.mHelper = mHelper;
	}
}
