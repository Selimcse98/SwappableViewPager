
package swappableviewpager.vivz.slidenerd.swappableviewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    private TabbedFragment tabbedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        if (savedInstanceState == null) {
            // withholding the previously created fragment from being created
            // again
            // On orientation change, it will prevent fragment recreation
            // its necessary to reserving the fragment stack inside each tab
            L.m("onCreate first time");
            initScreen();

        } else {
            // restoring the previously created fragment
            // and getting the reference
            L.m("onCreate sub time");
            tabbedFragment = (TabbedFragment) getSupportFragmentManager().getFragments().get(0);
        }
    }

    private void initScreen() {
        // TODO Auto-generated method stub
        tabbedFragment = new TabbedFragment();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, tabbedFragment)
                .commit();
        L.m("initScreen replaced with tabfragment");
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        L.m("MainActivity onBackPressed");
        if (!tabbedFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
