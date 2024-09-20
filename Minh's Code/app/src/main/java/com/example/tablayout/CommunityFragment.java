package com.example.tablayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import Community_tablayout.CommunityViewPagerAdapter;


public class CommunityFragment extends Fragment  implements NavigationView.OnNavigationItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mview;
    private DrawerLayout mDrawerLayout;
    private MenuInflater inflater;
    private Menu menu;


    public CommunityFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static CommunityFragment newInstance(String param1, String param2) {
        CommunityFragment fragment = new CommunityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_community, container, false);

        tabLayout = mview.findViewById(R.id.tab_layout_community);
        viewPager= mview.findViewById(R.id.community_viewpager);


        CommunityViewPagerAdapter adapter = new CommunityViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        Toolbar toolbar = mview.findViewById(R.id.tool_bar_community);
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        mDrawerLayout = mview.findViewById(R.id.Drawer_communities);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar,R.string.app_OpenDrawer,R.string.app_CloseDrawer);
        mDrawerLayout.addDrawerListener(toggle);
            toggle.syncState();

        NavigationView navigationView = mview.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        return mview;
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if ( id == R.id.Profile ){

        } else if (id == R.id.Premium) {

        } else if (id == R.id.Bookmarks) {

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;



        }

    private void openFragment(SearchFragment searchFragment) {
    }
}
