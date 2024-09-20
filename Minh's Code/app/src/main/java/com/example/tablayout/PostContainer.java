package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostContainer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostContainer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PostContainer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PostContainer.
     */
    // TODO: Rename and change types and number of parameters
    public static PostContainer newInstance(String param1, String param2) {
        PostContainer fragment = new PostContainer();
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
        View view = inflater.inflate(R.layout.fragment_post_container, container, false);

//        FragmentManager fragmentManager = getChildFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        //        Specifying multiple posts
//
//        TwitterPostFragment post1 = TwitterPostFragment.newInstance(
//                getResources().getString(R.string.name1),
//                getResources().getString(R.string.username1),
//                getResources().getString(R.string.date1),
//                R.drawable.image1,
//                getResources().getString(R.string.caption1)
//        );
//        TwitterPostFragment post2 = TwitterPostFragment.newInstance(
//                getResources().getString(R.string.name2),
//                getResources().getString(R.string.username2),
//                getResources().getString(R.string.date2),
//                R.drawable.image2,
//                getResources().getString(R.string.caption2)
//        );
//        TwitterPostFragment post3 = TwitterPostFragment.newInstance(
//                getResources().getString(R.string.name3),
//                getResources().getString(R.string.username3),
//                getResources().getString(R.string.date3),
//                R.drawable.image3,
//                getResources().getString(R.string.caption3)
//        );

//        System.out.println(R.id.post_container);
////        Add the post fragments to the setPost layout
//        fragmentTransaction.add(R.id.post_container, post1);
//        fragmentTransaction.add(R.id.post_container, post2);
//        fragmentTransaction.add(R.id.post_container, post3);


//        fragmentTransaction.commit();
        // Inflate the layout for this fragment
        return view;
    }
}