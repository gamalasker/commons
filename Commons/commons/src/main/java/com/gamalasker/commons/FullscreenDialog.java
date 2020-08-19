package com.gamalasker.commons;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gamalasker.commons.databinding.LayoutFullscreenDialogBinding;

import java.util.Objects;

public class FullscreenDialog extends DialogFragment {

    private static String url;
    LayoutFullscreenDialogBinding b;

    public static FullscreenDialog newInstance(String url1) {
        url = url1;
        return new FullscreenDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = LayoutFullscreenDialogBinding.inflate(inflater, container, false);

        Glide.with(getActivity()).load(url).apply(new RequestOptions().dontTransform()).into(b.imagePreviewView);

        b.backBtn.setOnClickListener(v -> {
            dismiss();
        });
        return b.getRoot();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog);
    }
}
