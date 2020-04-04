package com.songsparrow.notesharing.ui.me;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.text.method.NumberKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.songsparrow.notesharing.MainActivity;
import com.songsparrow.notesharing.R;

import java.security.Signature;

public class MeFragment extends Fragment {

    private MeViewModel mViewModel;
    private TextView mTxtQQ;
    private TextView mTxtWeChat;
    private TextView mTxtNickName;
    private TextView mTxtUniversity;
    private TextView mTxtMajor;
    private TextView mTxtSignature;
    private TextView mTxtPassword;
    private Activity mActivity;
    private View mRoot;

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_me, container,false);
        mTxtQQ = mRoot.findViewById(R.id.txt_qq_title);
        mTxtWeChat = mRoot.findViewById(R.id.txt_wechat_title);
        mTxtNickName = mRoot.findViewById(R.id.txt_nickname_title);
        mTxtUniversity = mRoot.findViewById(R.id.txt_university_title);
        mTxtMajor = mRoot.findViewById(R.id.txt_major_title);
        mTxtSignature = mRoot.findViewById(R.id.txt_signature_title);
        mTxtPassword = mRoot.findViewById(R.id.txt_password_title);

        mTxtQQ.setOnClickListener(mSetQQ);
        mTxtWeChat.setOnClickListener(mSetWeChat);
        mTxtNickName.setOnClickListener(mSetNickname);
        mTxtUniversity.setOnClickListener(mSetUniversity);
        mTxtMajor.setOnClickListener(mSetMajor);
        mTxtSignature.setOnClickListener(mSetSignature);
        mTxtPassword.setOnClickListener(mSetPassword);
        return mRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MeViewModel.class);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        mActivity = (Activity)context;
        super.onAttach(context);
    }

    private View.OnClickListener mSetQQ = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final EditText edtQQ = new EditText(mActivity);
            edtQQ.setInputType(InputType.TYPE_CLASS_NUMBER);
            edtQQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
            final TextView txtQQ = mRoot.findViewById(R.id.txt_qq);
            edtQQ.setText(txtQQ.getText().toString());
            AlertDialog.Builder input = new AlertDialog.Builder(mActivity);
            input.setTitle(R.string.new_qq);
            input.setView(edtQQ);
            input.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    txtQQ.setText(edtQQ.getText().toString());
                }
            });
            input.show();
        }
    };

    private View.OnClickListener mSetWeChat = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final EditText edtWeChat = new EditText(mActivity);
            final TextView txtWeChat = mRoot.findViewById(R.id.txt_wechat);
            edtWeChat.setText(txtWeChat.getText().toString());
            AlertDialog.Builder input = new AlertDialog.Builder(mActivity);
            input.setTitle(R.string.new_wechat);
            input.setView(edtWeChat);
            input.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    txtWeChat.setText(edtWeChat.getText().toString());
                }
            });
            input.show();
        }
    };

    private View.OnClickListener mSetNickname = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final EditText edtNickname = new EditText(mActivity);
            edtNickname.setInputType(InputType.TYPE_CLASS_TEXT);
            edtNickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            final TextView txtNickname = mRoot.findViewById(R.id.txt_nickname);
            edtNickname.setText(txtNickname.getText().toString());
            AlertDialog.Builder input = new AlertDialog.Builder(mActivity);
            input.setTitle(R.string.new_nickname);
            input.setView(edtNickname);
            input.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    txtNickname.setText(edtNickname.getText().toString());
                }
            });
            input.show();
        }
    };

    private View.OnClickListener mSetUniversity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final EditText edtNickname = new EditText(mActivity);
            edtNickname.setInputType(InputType.TYPE_CLASS_TEXT);
            edtNickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            final TextView txtNickname = mRoot.findViewById(R.id.txt_university);
            edtNickname.setText(txtNickname.getText().toString());
            AlertDialog.Builder input = new AlertDialog.Builder(mActivity);
            input.setTitle(R.string.new_university);
            input.setView(edtNickname);
            input.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    txtNickname.setText(edtNickname.getText().toString());
                }
            });
            input.show();
        }
    };

    private View.OnClickListener mSetMajor = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String[] items = { "我是1","我是2","我是3","我是4" };
            AlertDialog.Builder singleChoiceDialog =
                    new AlertDialog.Builder(mActivity);
            singleChoiceDialog.setTitle(R.string.majors);
            singleChoiceDialog.setSingleChoiceItems(items, 0,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            singleChoiceDialog.setPositiveButton(R.string.okay,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            singleChoiceDialog.show();
        }
    };

    private View.OnClickListener mSetSignature = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final EditText edtNickname = new EditText(mActivity);
            edtNickname.setInputType(InputType.TYPE_CLASS_TEXT);
            edtNickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
            final TextView txtNickname = mRoot.findViewById(R.id.txt_signature);
            edtNickname.setText(txtNickname.getText().toString());
            AlertDialog.Builder input = new AlertDialog.Builder(mActivity);
            input.setTitle(R.string.new_nickname);
            input.setView(edtNickname);
            input.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    txtNickname.setText(edtNickname.getText().toString());
                }
            });
            input.show();
        }
    };

    private View.OnClickListener mSetPassword = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
