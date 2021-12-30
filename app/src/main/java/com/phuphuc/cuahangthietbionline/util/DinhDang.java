package com.phuphuc.cuahangthietbionline.util;

import android.text.TextUtils;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DinhDang {
    public static DecimalFormat dinhDangTienTe = new DecimalFormat("###,###,###");

    public static void dinhDangTextView(TextView txt, int maxLines) {
        txt.setMaxLines(maxLines);
        txt.setEllipsize(TextUtils.TruncateAt.END);
    }
}
