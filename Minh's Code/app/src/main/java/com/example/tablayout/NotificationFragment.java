package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class NotificationFragment extends Fragment
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mView;
    private View overlay;
    private DrawerLayout drawerLayout;

    // FloatingActionButtons
//    FloatingActionButton addButton;
    FloatingActionButton postButton, photosButton, spacesButton, goLiveButton;
    boolean isFabMenuOpen = false;

    // TextViews for labels
    TextView textPost, textPhotos, textSpaces, textGoLive;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialization logic can be placed here
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_notification, container, false);

        // Initialize Views
        tabLayout = mView.findViewById(R.id.tab_layout);
        viewPager = mView.findViewById(R.id.notification_ViewPager);
        overlay = mView.findViewById(R.id.overlay);

//        addButton = mView.findViewById(R.id.add_button);
        postButton = mView.findViewById(R.id.post_button);
        photosButton = mView.findViewById(R.id.photos_button);
        spacesButton = mView.findViewById(R.id.spaces_button);
        goLiveButton = mView.findViewById(R.id.go_live_button);

        textPost = mView.findViewById(R.id.text_post);
        textPhotos = mView.findViewById(R.id.text_photos);
        textSpaces = mView.findViewById(R.id.text_spaces);
        textGoLive = mView.findViewById(R.id.text_go_live);

        // Setup ViewPager with Adapter
        NotificationViewPagerAdapter adapter = new NotificationViewPagerAdapter(
                getChildFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // Add button click event
//        addButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!isFabMenuOpen) {
//                    showFabMenu();
//                    overlay.setVisibility(View.VISIBLE);  // Show overlay
//                } else {
//                    closeFabMenu();
//                    overlay.setVisibility(View.GONE);  // Hide overlay
//                }
//            }
//        });

        // Handle clicks on the overlay to close the menu
//        overlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                closeFabMenu();
//                overlay.setVisibility(View.GONE);  // Hide overlay
//            }
//        });

        // Handle clicks on the menu bar to close the menu and hide overlay
//        tabLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isFabMenuOpen) {
//                    closeFabMenu();
//                    overlay.setVisibility(View.GONE);  // Hide overlay
//                }
//            }
//        });

        // Dismiss FAB menu on outside touch
//        mView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (isFabMenuOpen && event.getAction() == MotionEvent.ACTION_DOWN) {
//                    closeFabMenu();
//                    overlay.setVisibility(View.GONE);  // Hide overlay
//                    return true;
//                }
//                return false;
//            }
//        });

        // Initialize settings button
        ImageButton btnSettings = mView.findViewById(R.id.setting_button);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến SettingFragment
                Fragment settingFragment = new SettingsFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.add(R.id.fragment_container, settingFragment); // Thay đổi ID theo layout của bạn

                transaction.addToBackStack(null); // Thêm vào back stack
                transaction.commit();
            }
        });

        drawerLayout = mView.findViewById(R.id.notification_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(),
                drawerLayout,
                R.string.openDrawer,
                R.string.closeDrawer
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = mView.findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        return mView;
    }

//    private void showFabMenu() {
//        postButton.show();
//        photosButton.show();
//        spacesButton.show();
//        goLiveButton.show();
//
//        textPost.setVisibility(View.VISIBLE);
//        textPhotos.setVisibility(View.VISIBLE);
//        textSpaces.setVisibility(View.VISIBLE);
//        textGoLive.setVisibility(View.VISIBLE);
//
//        addButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_post));  // Change to close post
//        isFabMenuOpen = true;
//    }

//    private void closeFabMenu() {
//        postButton.hide();
//        photosButton.hide();
//        spacesButton.hide();
//        goLiveButton.hide();
//
//        textPost.setVisibility(View.GONE);
//        textPhotos.setVisibility(View.GONE);
//        textSpaces.setVisibility(View.GONE);
//        textGoLive.setVisibility(View.GONE);
//
//        addButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));  // Change back to add icon
//        isFabMenuOpen = false;
//    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceRate) {
        super.onViewCreated(view, savedInstanceRate);

//      As when this was used on onCreateView, it returns null, but not when on this method.
//      And there's also a possibility of the icon returns null for the call, too.
        View icon = getView().findViewById(R.id.user_button);

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