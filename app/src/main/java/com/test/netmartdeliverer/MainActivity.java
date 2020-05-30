package com.test.netmartdeliverer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //private ArrayList<OrderListModel> exampleList;
    List<OrderListModel> OrderingList;

    private FrameLayout newJob;

    private RecyclerView mRecyclerView;
    private OrderListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private OrderListAdapter.OnItemClickListener mListener;


    private Toolbar toolbaz;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PastFragment pastFragment;
    private TodayFragment todayFragment;
    private TomorrowFragment tomorrowFragment;
    private JobDayFragment jobDayFragment;

    String userId;
    FirebaseAuth fireAuth;
    FirebaseFirestore fireStore;
    Button resendCode;

    private String btn = "Jadi Doh Weyh!";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        FrameLayout frameLayout = newJob.findViewById(R.id.newJob);
        toolbaz = findViewById(R.id.toolbar);
        setSupportActionBar(toolbaz);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);

        fireAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();

        //get userid
        userId = fireAuth.getCurrentUser().getUid();

        //handles tab
        pastFragment = new PastFragment();
        todayFragment = new TodayFragment();
        tomorrowFragment = new TomorrowFragment();
        jobDayFragment = new JobDayFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewpage = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewpage.addFragments(pastFragment, "Past");
        viewpage.addFragments(todayFragment, "Today");
        viewpage.addFragments(tomorrowFragment, "Tomorrow");
        viewpage.addFragments(jobDayFragment, "Job Day");
        viewPager.setAdapter(viewpage);

        //badge notification
        //objects.requireNonNull is in put in case getOrCreateBadge create nullpointerexception
        BadgeDrawable badgeNotification = Objects.requireNonNull(tabLayout.getTabAt(1)).getOrCreateBadge();
        badgeNotification.setVisible(true);
        badgeNotification.setNumber(12);


    }


    //this handles the tab
      private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTabName = new ArrayList<>();

          public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
              super(fm, behavior);
          }

          private void addFragments(Fragment fragment, String title){
              fragments.add(fragment);
              fragmentTabName.add(title);
          }

          @NonNull
          @Override
          public Fragment getItem(int position) {
              return fragments.get(position);
          }

          @Override
          public int getCount() {
              return fragments.size();
          }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTabName.get(position);
        }
    }

    public void createExampleList() {
        //setOnClickListener();
        OrderingList = new ArrayList<>();
        OrderingList.add(new OrderListModel(8, R.drawable.delivery_man, "Fakhrul", 8,15,"Fish, Beef, Saffron, Vegetables, Herb, Carrot"));
        OrderingList.add(new OrderListModel(8.30, R.drawable.delivery_man, "Nizar", 8,15,"Fish, Beef, Saffron, Vegetables, Herb, Carrot"));
        OrderingList.add(new OrderListModel(9, R.drawable.delivery_man, "Zero", 8,15,"Fish, Beef, Saffron, Vegetables, Herb, Carrot"));
        OrderingList.add(new OrderListModel(9.30, R.drawable.delivery_man, "Fakhrul", 8,15,"Fish, Beef, Saffron, Vegetables, Herb, Carrot"));

    }

//    private void setOnClickListener() {
//        mListener = new OrderListAdapter.OnItemClickListener() {
//            @Override
//            public void OnItemClick(int position) {
//
//                Intent intent = new Intent(getApplicationContext(),PickUpActivity.class);
//                intent.putExtra("Hassan",OrderingList.get(position).getClientName());
//                intent.putExtra("Fakhrul",OrderingList.get(position).getItems());
//                startActivity(intent);
//
//            }
//        };
//    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.order_list);
        mRecyclerView.setHasFixedSize(true);

        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);


        mLayoutManager = new LinearLayoutManager(this);
        //mAdapter = new OrderListAdapter(exampleList);
        mAdapter = new OrderListAdapter(OrderingList, mListener);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OrderListAdapter.OnItemClickListener() {
            @Override
                public void OnItemClick(int position) {
                Toast.makeText(getApplicationContext(),btn,Toast.LENGTH_LONG).show();


            }
        });

    }

}
