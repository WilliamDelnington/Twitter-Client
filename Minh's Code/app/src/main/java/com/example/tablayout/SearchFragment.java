package com.example.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class SearchFragment extends Fragment
implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private View view, overlay;
    private ViewPager viewPager;
    private TabLayout tabLayoutTop;
    private FloatingActionButton addFab, imgFab, microFab, videocamFab;
    private TextView imgFabText, microFabText, videocamFabText, addPostFabText;
    private Boolean isFabVisible = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        // Declare views
        overlay = getActivity().findViewById(R.id.overlay);
        tabLayoutTop = view.findViewById(R.id.tab_layout_top);
        viewPager = view.findViewById(R.id.search_view_pager);

        addFab = getActivity().findViewById(R.id.add_fab);
        imgFab = getActivity().findViewById(R.id.img_fab);
        microFab = getActivity().findViewById(R.id.micro_fab);
        videocamFab = getActivity().findViewById(R.id.videocam_fab);

        addPostFabText = getActivity().findViewById(R.id.add_post_fab_text);
        imgFabText = getActivity().findViewById(R.id.img_fab_text);
        microFabText = getActivity().findViewById(R.id.micro_fab_text);
        videocamFabText = getActivity().findViewById(R.id.videocam_fab_text);

        // Add adapter to viewpager
        SearchViewPagerAdapter adapter = new SearchViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        tabLayoutTop.setupWithViewPager(viewPager);

        addFab.setVisibility(View.VISIBLE);

        // Add onClick event for addFab
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFabVisible) {
                    overlay.setVisibility(View.VISIBLE);
                    addFab.setImageResource(R.drawable.adding_icon);
                    addPostFabText.setVisibility(View.VISIBLE);
                    imgFab.setVisibility(View.VISIBLE);
                    imgFabText.setVisibility(View.VISIBLE);
                    microFab.setVisibility(View.VISIBLE);
                    microFabText.setVisibility(View.VISIBLE);
                    videocamFab.setVisibility(View.VISIBLE);
                    videocamFabText.setVisibility(View.VISIBLE);
                    isFabVisible = true;
                }
            }
        });
        overlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFabVisible) {
                    overlay.setVisibility(View.GONE);
                    addFab.setImageResource(R.drawable.adding_icon);
                    addPostFabText.setVisibility(View.GONE);
                    imgFab.setVisibility(View.GONE);
                    imgFabText.setVisibility(View.GONE);
                    microFab.setVisibility(View.GONE);
                    microFabText.setVisibility(View.GONE);
                    videocamFab.setVisibility(View.GONE);
                    videocamFabText.setVisibility(View.GONE);
                    isFabVisible = false;
                }
            }
        });
        drawerLayout = view.findViewById(R.id.search_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(),
                drawerLayout,
                R.string.openDrawer,
                R.string.closeDrawer
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = view.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceRate) {
        super.onViewCreated(view, savedInstanceRate);

//      As when this was used on onCreateView, it returns null, but not when on this method.
//      And there's also a possibility of the icon returns null for the call, too.
        View icon = getView().findViewById(R.id.account_icon);

        if (icon != null) {
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        if (item.getItemId() == R.id.Profile) {
            fragment = new ProfileFragment();
        }
        else if (item.getItemId() == R.id.Jobs) {
            fragment = new JobsFragment();
        }
        else if (item.getItemId() == R.id.Premium) {
            fragment = new PremiumFragment();
        }
        else if (item.getItemId() == R.id.Bookmarks) {
            fragment = new BookmarksFragment();
        }
        else if (item.getItemId() == R.id.Lists) {
            fragment = new ListsFragment();
        }
        else if (item.getItemId() == R.id.Spaces) {
            fragment = new SpacesFragment();
        }
        else if (item.getItemId() == R.id.Monetization) {
            fragment = new MonetizationFragment();
        }
        else {
            fragment = new Fragment();
        }

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main, fragment);
        fragmentTransaction.commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}