package com.songsparrow.notesharing.ui.note;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.songsparrow.notesharing.NoteActivity;
import com.songsparrow.notesharing.R;

public class NoteFragment extends Fragment {

    private NoteViewModel mViewModel;
    private TextView mTxtUpload;
    private TextView mTxtFavorite;
    private TextView mTxtLike;
    private TextView mTxtReport;
    private TextView mTxtAppeal;
    private TextView mTxtComment;
    private View mRoot;
    private Activity mActivity;

    public static NoteFragment newInstance() {
        return new NoteFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        mActivity = (Activity)context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_note, container, false);
        mTxtUpload = mRoot.findViewById(R.id.txt_upload_title);
        mTxtFavorite = mRoot.findViewById(R.id.txt_favorite_title);
        mTxtLike = mRoot.findViewById(R.id.txt_like_title);
        mTxtReport = mRoot.findViewById(R.id.txt_report_title);
        mTxtAppeal = mRoot.findViewById(R.id.txt_appeal_title);
        mTxtComment = mRoot.findViewById(R.id.txt_comments_title);
        mTxtUpload.setOnClickListener(mLsUpload);
        mTxtFavorite.setOnClickListener(mLsFavorite);
        mTxtLike.setOnClickListener(mLsLike);
        mTxtReport.setOnClickListener(mLsReport);
        mTxtAppeal.setOnClickListener(mLsAppeal);
        mTxtComment.setOnClickListener(mLsComment);
        return mRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        // TODO: Use the ViewModel
    }

    private View.OnClickListener mLsUpload = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mActivity, NoteActivity.class);
            intent.putExtra("layout","upload");
            startActivity(intent);
        }
    } ;

    private View.OnClickListener mLsFavorite = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mActivity, NoteActivity.class);
            intent.putExtra("layout","favorite");
            startActivity(intent);
        }
    };

    private View.OnClickListener mLsLike = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mActivity, NoteActivity.class);
            intent.putExtra("layout","like");
            startActivity(intent);
        }
    };

    private View.OnClickListener mLsReport = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mActivity, NoteActivity.class);
            intent.putExtra("layout","report");
            startActivity(intent);
        }
    };

    private View.OnClickListener mLsAppeal = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mActivity, NoteActivity.class);
            intent.putExtra("layout","appeal");
            startActivity(intent);
        }
    };

    private View.OnClickListener mLsComment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mActivity, NoteActivity.class);
            intent.putExtra("layout","comment");
            startActivity(intent);
        }
    };

}
