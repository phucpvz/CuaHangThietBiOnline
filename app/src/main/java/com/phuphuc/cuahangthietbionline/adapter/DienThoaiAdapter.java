package com.phuphuc.cuahangthietbionline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class DienThoaiAdapter extends BaseAdapter {
    Context context;
    List<SanPham> dienThoaiList;

    public DienThoaiAdapter(Context context, List<SanPham> dienThoaiList) {
        this.context = context;
        this.dienThoaiList = dienThoaiList;
    }

    @Override
    public int getCount() {
        return dienThoaiList.size();
    }

    @Override
    public Object getItem(int i) {
        return dienThoaiList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txtTenDienThoai, txtGiaDienThoai, txtMoTaDienThoai;
        ImageView imgHinhAnhDienThoai;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_dienthoai, null);
            viewHolder.txtTenDienThoai = view.findViewById(R.id.textviewTenDienThoai);
            viewHolder.txtGiaDienThoai = view.findViewById(R.id.textviewGiaDienThoai);
            viewHolder.txtMoTaDienThoai = view.findViewById(R.id.textviewMoTaDienThoai);
            viewHolder.imgHinhAnhDienThoai = view.findViewById(R.id.imageviewHinhAnhDienThoai);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        SanPham sanPham = (SanPham) getItem(i);
        viewHolder.txtTenDienThoai.setMaxLines(1);
        viewHolder.txtTenDienThoai.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtTenDienThoai.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaDienThoai.setText("Giá: " + decimalFormat.format(sanPham.getGiaSanPham()) + " Đ");
        viewHolder.txtMoTaDienThoai.setMaxLines(2);
        viewHolder.txtMoTaDienThoai.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMoTaDienThoai.setText(sanPham.getMoTaSanPham());
        Picasso.get().load(sanPham.getHinhAnhSanPham()).
                placeholder(R.drawable.no_image_available).error(R.drawable.forbidden).into(viewHolder.imgHinhAnhDienThoai);

        return view;
    }
}
