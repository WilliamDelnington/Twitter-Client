package com.example.tablayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SlashFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlashFragment extends Fragment implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SlashFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SlashFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SlashFragment newInstance(String param1, String param2) {
        SlashFragment fragment = new SlashFragment();
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
        View view = inflater.inflate(R.layout.fragment_slash, container, false);

        Toolbar toolbar = view.findViewById(R.id.header);
        toolbar.inflateMenu(R.menu.menu_nav);
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        drawerLayout = view.findViewById(R.id.main_slash);
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

    /**
     * This is important. As to make the navigation bar open when clicking
     * the top-left profile icon, the method onViewCreated should be overrided
     * to set clicking event, not in the onCreateView method.
     *
     * */

    @Override
    public void onViewCreated(View view, Bundle savedInstanceRate) {
        super.onViewCreated(view, savedInstanceRate);

//      As when this was used on onCreateView, it returns null, but not when on this method.
//      And there's also a possibility of the icon returns null for the call, too.
        View icon = getView().findViewById(R.id.profile_icon);

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
        fragmentTransaction.replace(R.id.slash_fragment, fragment);
        fragmentTransaction.commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}