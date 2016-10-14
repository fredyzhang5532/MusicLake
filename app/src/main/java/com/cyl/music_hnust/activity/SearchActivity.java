package com.cyl.music_hnust.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.cyl.music_hnust.R;
import com.cyl.music_hnust.adapter.SearchAdapter;
import com.cyl.music_hnust.model.SearchMusic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：yonglong on 2016/9/15 12:32
 * 邮箱：643872807@qq.com
 * 版本：2.5
 */
public class SearchActivity extends BaseActivity implements SearchView.OnQueryTextListener {
    private SearchView mSearchView;
    private InputMethodManager mImm;
    private String queryString;

    private SearchAdapter adapter;
    private RecyclerView recyclerView;

    private List<SearchMusic.Song> searchResults = new ArrayList<>();
    @Override
    protected void listener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_search);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.onActionViewExpanded();
        searchView.setQueryHint(getString(R.string.search_tips));
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(true);
        try {
            Field field = searchView.getClass().getDeclaredField("mGoButton");
            field.setAccessible(true);
            ImageView mGoButton = (ImageView) field.get(searchView);
            mGoButton.setImageResource(R.drawable.ic_search_white_18dp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

}
