package com.example.myapplication;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.example.myapplication.placeholder.PlaceholderContent;
import com.example.myapplication.databinding.FragmentItemDetailBinding;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListFragment}
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The placeholder content this fragment is presenting.
     */
    private PlaceholderContent.PlaceholderItem mItem;
    private CollapsingToolbarLayout mToolbarLayout;
    private String[] urls = {"https://github.com/", "https://developer.microsoft.com/en-us/", "https://developer.android.com/",
            "https://vuejs.org/", "https://stackoverflow.com/", "https://www.freecodecamp.org/"};

    private final View.OnDragListener dragListener = (v, event) -> {
        if (event.getAction() == DragEvent.ACTION_DROP) {
            ClipData.Item clipDataItem = event.getClipData().getItemAt(0);
            mItem = PlaceholderContent.ITEM_MAP.get(clipDataItem.getText().toString());
            updateContent();
        }
        return true;
    };
    private FragmentItemDetailBinding binding;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the placeholder content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = PlaceholderContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Tech Sites");

        binding = FragmentItemDetailBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        mToolbarLayout = rootView.findViewById(R.id.toolbar_layout);

        String targetUrl = "";

        if(mItem != null){

            if (mItem.id.equals("1")) {
                targetUrl = urls[0];
            }else if(mItem.id.equals("2")){
                targetUrl = urls[1];
            }else if(mItem.id.equals("3")){
                targetUrl = urls[2];
            }else if(mItem.id.equals("4")){
                targetUrl = urls[3];
            }else if(mItem.id.equals("5")){
                targetUrl = urls[4];
            }else if(mItem.id.equals("6")){
                targetUrl = urls[5];
            }
            WebView webView = (WebView) rootView.findViewById(R.id.item_detail);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
                    return super.shouldOverrideUrlLoading(view, request);
                }
            });
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(targetUrl);
            updateContent();
        }

        rootView.setOnDragListener(dragListener);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void updateContent() {
        if (mItem != null) {
            if (mToolbarLayout != null) {
                mToolbarLayout.setTitle(mItem.content);
            }
        }
    }
}