package org.jplas.android.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jplas.android.uts.fragments.AboutFragment;
import org.jplas.android.uts.fragments.HomeFragment;
import org.jplas.android.uts.fragments.ResultFragment;

public class InputActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
//        HomeFragment.OnFragmentInteractionListener,
        ResultFragment.OnFragmentInteractionListener {

    private HomeFragment homeFragment;
//    private ResultFragment resultFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        homeFragment = new HomeFragment();
//        resultFragment = new ResultFragment();
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_home:
                fragment = new HomeFragment();
                break;
            case R.id.action_about:
                fragment = new AboutFragment();
                break;
        }
        return loadFragment(fragment);
    }

//    @Override
//    public void onSubmitClicked(float index) {
//        resultFragment.setInformation(String.format("Biaya yang perlu dibayar: Rp.", index));
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, resultFragment)
//                .commit();
//    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onTryAgainButtonClicked(String biodata) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit();
    }
}
