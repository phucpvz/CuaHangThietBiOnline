package com.phuphuc.cuahangthietbionline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.model.LoaiSanPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LoaiSanPhamAdapter extends BaseAdapter {

    Context context;
    List<LoaiSanPham> listLoaiSP;

    public LoaiSanPhamAdapter(Context context, List<LoaiSanPham> listLoaiSP) {
        this.context = context;
        this.listLoaiSP = listLoaiSP;
    }

    @Override
    public int getCount() {
        return listLoaiSP.size();
    }

    @Override
    public Object getItem(int i) {
        return listLoaiSP.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txtTenLoaiSP;
        ImageView imgHinhAnhLoaiSP;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_loaisanpham, null);
            viewHolder.txtTenLoaiSP = view.findViewById(R.id.textviewLoaiSanPham);
            viewHolder.imgHinhAnhLoaiSP = view.findViewById(R.id.imageviewLoaiSanPham);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        LoaiSanPham loaiSanPham = (LoaiSanPham) getItem(i);
        viewHolder.txtTenLoaiSP.setText(loaiSanPham.getTenLoaiSanPham());
        Picasso.get().load(loaiSanPham.getHinhAnhLoaiSanPham()).
                placeholder(R.drawable.no_image_available).error(R.drawable.forbidden).into(viewHolder.imgHinhAnhLoaiSP);
        return view;
    }
}
