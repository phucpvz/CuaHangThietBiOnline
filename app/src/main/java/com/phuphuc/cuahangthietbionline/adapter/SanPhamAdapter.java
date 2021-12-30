package com.phuphuc.cuahangthietbionline.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.activity.ChiTietSanPhamActivity;
import com.phuphuc.cuahangthietbionline.model.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ItemHolder> {

    Context context;
    List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat, null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.txtTenSP.setMaxLines(3);
        holder.txtTenSP.setEllipsize(TextUtils.TruncateAt.END);
        holder.txtTenSP.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSP.setText("Giá: " + decimalFormat.format(sanPham.getGiaSanPham()) + " Đ");
        Picasso.get().load(sanPham.getHinhAnhSanPham()).
                placeholder(R.drawable.no_image_available).error(R.drawable.forbidden).into(holder.imgHinhAnhSP);
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        ImageView imgHinhAnhSP;
        TextView txtTenSP, txtGiaSP;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhAnhSP = itemView.findViewById(R.id.imageviewHinhSanPham);
            txtTenSP = itemView.findViewById(R.id.textviewTenSanPham);
            txtGiaSP = itemView.findViewById(R.id.textviewGiaSanPham);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                    intent.putExtra("thongtinsanpham", sanPhamList.get(getAdapterPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    Toast.makeText(context, sanPhamList.get(getAdapterPosition()).getTenSanPham(), Toast.LENGTH_SHORT).show();
                    context.startActivity(intent);
                }
            });
        }
    }
}
