package com.phuphuc.cuahangthietbionline.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.model.GioHang;
import com.phuphuc.cuahangthietbionline.model.SanPham;
import com.phuphuc.cuahangthietbionline.util.DinhDang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    Toolbar toolbarChiTietSP;
    ImageView imgHinh;
    TextView txtTen, txtGia, txtMoTa;
    Spinner spSoLuong;
    Button btnThemGioHang;

    SanPham sanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        anhXa();
        actionToolbar();
        getInformation();
        thietKeSpinner();
        batSuKienClickThemGioHang();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuGioHang:
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void batSuKienClickThemGioHang() {
        btnThemGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isExist = false;
                int soLuong = Integer.parseInt(spSoLuong.getSelectedItem().toString());
                for (int i = 0; i < MainActivity.gioHangList.size(); ++i) {
                    GioHang hang = MainActivity.gioHangList.get(i);
                    if (hang.getIdSanPham() == sanPham.getId()) {
                        hang.setSoLuongSanPham(hang.getSoLuongSanPham() + soLuong);
                        if (hang.getSoLuongSanPham() > 10) {
                            hang.setSoLuongSanPham(10);
                        }
                        hang.setTongTienSanPham(hang.getSoLuongSanPham() * sanPham.getGiaSanPham());
                        isExist = true;
                    }
                }
                if (!isExist) {
                    long tongTien = soLuong * sanPham.getGiaSanPham();
                    MainActivity.gioHangList.add(new GioHang(sanPham.getId(), sanPham.getTenSanPham(), sanPham.getHinhAnhSanPham(), soLuong, tongTien));
                }
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void thietKeSpinner() {
        int soLuongToiDa = 10;
        Integer[] mangSoLuong = new Integer[soLuongToiDa];
        for (int i = 0; i < soLuongToiDa; ++i) {
            mangSoLuong[i] = i + 1;
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mangSoLuong);
        spSoLuong.setAdapter(arrayAdapter);
    }

    private void getInformation() {
        sanPham = (SanPham) getIntent().getSerializableExtra("thongtinsanpham");
        DinhDang.dinhDangTextView(txtTen, 2);
        txtTen.setText(sanPham.getTenSanPham());
        txtGia.setText("Giá: " + DinhDang.dinhDangTienTe.format(sanPham.getGiaSanPham()) + " Đ");
        txtMoTa.setText(sanPham.getMoTaSanPham());
        Picasso.get().load(sanPham.getHinhAnhSanPham()).
                placeholder(R.drawable.no_image_available).error(R.drawable.forbidden).into(imgHinh);
    }

    private void anhXa() {
        toolbarChiTietSP = findViewById(R.id.toolbarChiTietSanPham);
        imgHinh = findViewById(R.id.imageviewHinhChiTietSanPham);
        txtTen = findViewById(R.id.textviewTenChiTietSanPham);
        txtGia = findViewById(R.id.textviewGiaChiTietSanPham);
        txtMoTa = findViewById(R.id.textviewMoTaChiTietSanPham);
        spSoLuong = findViewById(R.id.spinner);
        btnThemGioHang = findViewById(R.id.buttonThemGioHang);
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarChiTietSP);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTietSP.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}