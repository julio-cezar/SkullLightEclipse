package br.com.maracujasoftware.skulllight;

import br.com.maracujasoftware.skulllight.R;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class DashboardActivity extends Activity {
	private AdView adView_1;
	private LinearLayout linearlayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		/*linearlayout = (LinearLayout) findViewById(R.id.LinearLayoutDash);
		
		adView_1 = new AdView(this);
		adView_1.setAdUnitId("ca-app-pub-7040951679419231/2112623107");
		adView_1.setAdSize(AdSize.BANNER);
		linearlayout.addView(adView_1);
		
		AdRequest adRequest = new AdRequest.Builder()
		.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
		.addTestDevice("F0777154C5F794B0B7A1EF4120502169")
		.build();	
		adView_1.loadAd(adRequest);*/
		
		if (ContextCompat.checkSelfPermission(DashboardActivity.this,
                Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED) {
			
			ActivityCompat.requestPermissions(DashboardActivity.this,
	                new String[]{Manifest.permission.CAMERA},
	                14);
			
		}
		
		adView_1 = (AdView)this.findViewById(R.id.adView);
	    AdRequest adRequest = new AdRequest.Builder()
	    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
	    .addTestDevice("F0777154C5F794B0B7A1EF4120502169")
	    .build();
	    adView_1.loadAd(adRequest);
		
	}
	
	public void selecionarOpcao(View view) {
		Intent i;
		switch (view.getId()) {		
		case R.id.bt_flash:
			i = new Intent(DashboardActivity.this, FlashActivity.class);
			startActivity(i);
			break;
		case R.id.bt_screen:
			 i = new Intent(DashboardActivity.this, SkullActivity.class);
			startActivity(i);
			break;
		case R.id.bt_more:
			 i = new Intent(DashboardActivity.this, CaveiraDashboardActivity.class);
			startActivity(i);
			break;
		case R.id.bt_doacao:
			 i = new Intent(DashboardActivity.this, DonationActivity.class);
			startActivity(i);
			break;
		}
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
