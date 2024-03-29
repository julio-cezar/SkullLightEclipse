package br.com.maracujasoftware.skulllight;

import br.com.maracujasoftware.skulllight.R;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CaveiraDashboardActivity extends Activity {
	private AdView adView_1;
	private InterstitialAd interstitial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caveiras_dashboard);
		
		adView_1 = (AdView)this.findViewById(R.id.adViewColorDashboard);
	    AdRequest adRequest = new AdRequest.Builder()
	    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
	    .addTestDevice("F0777154C5F794B0B7A1EF4120502169")
	    .build();
	    adView_1.loadAd(adRequest);
	    
	    interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId("ca-app-pub-7040951679419231/9376597501");
		interstitial.loadAd(adRequest);
	}
	
	public void selecionarOpcao(View view) {
		Intent i;
		switch (view.getId()) {		
		case R.id.cav1:
			i = new Intent(CaveiraDashboardActivity.this, MoreSkullActivity.class);
			i.putExtra("skull", "skull1");
			startActivity(i);
			break;
		case R.id.cav2:
			 i = new Intent(CaveiraDashboardActivity.this, MoreSkullActivity.class);
			 i.putExtra("skull", "skull2");
			startActivity(i);
			break;
		case R.id.cav3:
			 i = new Intent(CaveiraDashboardActivity.this, MoreSkullActivity.class);
			 i.putExtra("skull", "skull3");
			startActivity(i);
			break;
		case R.id.cav4:
			 i = new Intent(CaveiraDashboardActivity.this, MoreSkullActivity.class);
			 i.putExtra("skull", "skull4");
			startActivity(i);
			break;
		}
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		interstitial.show();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		adView_1.resume();
	}
	
	
	@Override
	protected void onStop(){
		super.onStop();
		adView_1.pause();
	}
	
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		adView_1.destroy();
	}
}
