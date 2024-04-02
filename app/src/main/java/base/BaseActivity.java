package base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import org.duchoang.doan.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseActivity extends AppCompatActivity {
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mNavigationView != null) {
            mNavigationView=findViewById(R.id.bottom_nav);
        }
        if (mViewPager != null) {
            mViewPager=findViewById(R.id.view_pager);
        }


    }
}
