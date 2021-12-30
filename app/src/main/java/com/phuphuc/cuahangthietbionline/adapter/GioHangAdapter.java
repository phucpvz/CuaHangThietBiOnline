package com.phuphuc.cuahangthietbionline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.activity.GioHangActivity;
import com.phuphuc.cuahangthietbionline.model.GioHang;
import com.phuphuc.cuahangthietbionline.util.DinhDang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class GioHangAdapter extends BaseAdapter {

    Context context;
    List<GioHang> gioHangList;

    public GioHangAdapter(Context context, List<GioHang> gioHangList) {
        this.context = context;
        this.gioHangList = gioHangList;
    }

    @Override
    public int getCount() {
        return gioHangList.size();
    }

    @Override
    public Object getItem(int i) {
        return gioHangList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView txtTenGioHang, txtGiaGioHang;
        ImageView imgHinhAnhGioHang;
        Button btnMinus, btnValue, btnPlus;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_giohang, null);
            holder.txtTenGioHang = view.findViewById(R.id.textviewTenGioHang);
            holder.txtGiaGioHang = view.findViewById(R.id.textviewGiaGioHang);
            holder.imgHinhAnhGioHang = view.findViewById(R.id.imageviewGioHang);
            holder.btnMinus = view.findViewById(R.id.buttonMinus);
            holder.btnValue = view.findViewById(R.id.buttonValue);
            holder.btnPlus = view.findViewById(R.id.buttonPlus);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        GioHang gioHang = (GioHang) getItem(i);
        DinhDang.dinhDangTextView(holder.txtTenGioHang, 2);
        holder.txtTenGioHang.setText(gioHang.getTenSanPham());
        holder.txtGiaGioHang.setText("Giá: " + DinhDang.dinhDangTienTe.format(gioHang.getTongTienSanPham()) + " Đ");
        Picasso.get().load(gioHang.getHinhAnhSanPham()).
                placeholder(R.drawable.no_image_available).error(R.drawable.forbidden).into(holder.imgHinhAnhGioHang);
        int soLuong = gioHang.getSoLuongSanPham();
        holder.btnValue.setText(soLuong + "");
        if (soLuong <= 1) {
            holder.btnMinus.setVisibility(View.INVISIBLE);
        }
        else if (soLuong >= 10) {
            holder.btnPlus.setVisibility(View.INVISIBLE);
        }
        else {
            holder.btnMinus.setVisibility(View.VISIBLE);
            holder.btnPlus.setVisibility(View.VISIBLE);
        }
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuongCu = gioHang.getSoLuongSanPham();
                int soLuongMoi = soLuongCu + 1;
                long tongTienHienTai = gioHang.getTongTienSanPham();
                long tongTienMoi = tongTienHienTai * soLuongMoi / soLuongCu;
                gioHang.setSoLuongSanPham(soLuongMoi);
                gioHang.setTongTienSanPham(tongTienMoi);
                holder.txtGiaGioHang.setText(DinhDang.dinhDangTienTe.format(tongTienMoi) + " Đ");
                if (soLuongMoi > 9) {
                    holder.btnPlus.setVisibility(View.INVISIBLE);
                }
                else {
                    holder.btnPlus.setVisibility(View.VISIBLE);
                }
                holder.btnMinus.setVisibility(View.VISIBLE);
                holder.btnValue.setText(soLuongMoi + "");
                GioHangActivity.loadTongTien();
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuongCu = gioHang.getSoLuongSanPham();
                int soLuongMoi = soLuongCu - 1;
                long tongTienHienTai = gioHang.getTongTienSanPham();
                long tongTienMoi = tongTienHienTai * soLuongMoi / soLuongCu;
                gioHang.setSoLuongSanPham(soLuongMoi);
                gioHang.setTongTienSanPham(tongTienMoi);
                holder.txtGiaGioHang.setText(DinhDang.dinhDangTienTe.format(tongTienMoi) + " Đ");
                if (soLuongMoi < 2) {
                    holder.btnMinus.setVisibility(View.INVISIBLE);
                }
                else {
                    holder.btnMinus.setVisibility(View.VISIBLE);
                }
                holder.btnPlus.setVisibility(View.VISIBLE);
                holder.btnValue.setText(soLuongMoi + "");
                GioHangActivity.loadTongTien();
            }
        });
        return view;
    }
}
