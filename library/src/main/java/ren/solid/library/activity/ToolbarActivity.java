package ren.solid.library.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ren.solid.library.R;
import ren.solid.library.activity.base.BaseActivity;


/**
 * Created by _SOLID
 * Date:2016/4/22
 * Time:13:30
 * <p/>
 * ToolbarActivity
 */
public abstract class ToolbarActivity extends BaseActivity {

    protected Toolbar mToolbar;
    protected FragmentManager mFragmentManager;

    @Override
    protected void init() {
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void setUpView() {
        mToolbar = $(R.id.toolbar);
        mToolbar.setTitle(getToolbarTitle());

        setUpToolBar();

        dynamicAddSkinEnableView(mToolbar, "background", R.color.colorPrimary);
    }

    private void setUpToolBar() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getSupportActionBar().setHomeButtonEnabled(true);//决定左上角的图标是否可以点击
    }

    protected abstract String getToolbarTitle();

    @Override
    protected void setUpData() {
        mFragmentManager.beginTransaction().replace(R.id.fl_content, setFragment()).commit();
    }

    protected abstract Fragment setFragment();


    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_content;
    }
}
