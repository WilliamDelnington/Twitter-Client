package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmailFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private FloatingActionButton addFab;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmailFragment newInstance(String param1, String param2) {
        EmailFragment fragment = new EmailFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);

        addFab = getActivity().findViewById(R.id.add_fab);
        addFab.setVisibility(View.GONE);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.profile_drawer);
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        drawerLayout = view.findViewById(R.id.email_drawer_layout);
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

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(v -> {
            // Switch to MailAddActivity
            Intent intent = new Intent(getActivity(), EmailAddActivity.class);
            startActivity(intent);
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceRate) {
        super.onViewCreated(view, savedInstanceRate);

        View icon = getView().findViewById(R.id.account_icon_email);

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
        if (item.getItemId() == R.id.profile_info) {
            fragment = new ProfileFragment();
        }
        else if (item.getItemId() == R.id.premium) {
            fragment = new PremiumFragment();
        }
        else if (item.getItemId() == R.id.saves) {
            fragment = new BookmarksFragment();
        }
        else if (item.getItemId() == R.id.lists) {
            fragment = new ListsFragment();
        }
        else if (item.getItemId() == R.id.spaces) {
            fragment = new SpacesFragment();
        }
        else if (item.getItemId() == R.id.monetization) {
            fragment = new MonetizationFragment();
        }
        else {
            fragment = new Fragment();
        }

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.email_fragment, fragment);
        fragmentTransaction.commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}