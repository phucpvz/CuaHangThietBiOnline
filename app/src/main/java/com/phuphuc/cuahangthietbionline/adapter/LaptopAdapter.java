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

public class LaptopAdapter extends BaseAdapter {
    Context context;
    List<SanPham> laptopList;

    public LaptopAdapter(Context context, List<SanPham> laptopList) {
        this.context = context;
        this.laptopList = laptopList;
    }

    @Override
    public int getCount() {
        return laptopList.size();
    }

    @Override
    public Object getItem(int i) {
        return laptopList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txtTenLaptop, txtGiaLaptop, txtMoTaLaptop;
        ImageView imgHinhAnhLaptop;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_laptop, null);
            viewHolder.txtTenLaptop = view.findViewById(R.id.textviewTenLaptop);
            viewHolder.txtGiaLaptop = view.findViewById(R.id.textviewGiaLaptop);
            viewHolder.txtMoTaLaptop = view.findViewById(R.id.textviewMoTaLaptop);
            viewHolder.imgHinhAnhLaptop = view.findViewById(R.id.imageviewHinhAnhLaptop);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        SanPham sanPham = (SanPham) getItem(i);
        viewHolder.txtTenLaptop.setMaxLines(1);
        viewHolder.txtTenLaptop.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtTenLaptop.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaLaptop.setText("Giá: " + decimalFormat.format(sanPham.getGiaSanPham()) + " Đ");
        viewHolder.txtMoTaLaptop.setMaxLines(2);
        viewHolder.txtMoTaLaptop.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMoTaLaptop.setText(sanPham.getMoTaSanPham());
        Picasso.get().load(sanPham.getHinhAnhSanPham()).
                placeholder(R.drawable.no_image_available).error(R.drawable.forbidden).into(viewHolder.imgHinhAnhLaptop);

        return view;
    }
}
