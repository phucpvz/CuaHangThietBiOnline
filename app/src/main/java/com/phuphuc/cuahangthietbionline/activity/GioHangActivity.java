package com.phuphuc.cuahangthietbionline.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.adapter.GioHangAdapter;
import com.phuphuc.cuahangthietbionline.model.GioHang;
import com.phuphuc.cuahangthietbionline.util.DinhDang;

public class GioHangActivity extends AppCompatActivity {

    Toolbar toolbarGioHang;
    ListView lvGioHang;
    TextView txtThongBao;
    static TextView txtTongTien;
    Button btnThanhToan, btnTiepTucMua;
    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        anhXa();
        actionToolbar();
        checkData();
        loadTongTien();
        batSuKienXoaGioHang();
    }

    private void batSuKienXoaGioHang() {
        lvGioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GioHangActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm \"" + MainActivity.gioHangList.get(position).getTenSanPham() + "\" không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.gioHangList.remove(position);
                        gioHangAdapter.notifyDataSetChanged();
                        loadTongTien();
                        if (MainActivity.gioHangList.isEmpty()) {
                            txtThongBao.setVisibility(View.VISIBLE);
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static void loadTongTien() {
        long tongTien = 0;
        for (GioHang gioHang: MainActivity.gioHangList) {
            tongTien += gioHang.getTongTienSanPham();
        }
        txtTongTien.setText(DinhDang.dinhDangTienTe.format(tongTien) + " Đ");
    }

    private void checkData() {
        if (MainActivity.gioHangList.isEmpty()) {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.VISIBLE);
            lvGioHang.setVisibility(View.INVISIBLE);
        }
        else {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.INVISIBLE);
            lvGioHang.setVisibility(View.VISIBLE);
        }
    }

    private void anhXa() {
        toolbarGioHang = findViewById(R.id.toolbarGioHang);
        lvGioHang = findViewById(R.id.listviewGioHang);
        txtThongBao = findViewById(R.id.textviewThongBao);
        txtTongTien = findViewById(R.id.textviewTongTien);
        btnThanhToan = findViewById(R.id.buttonThanhToanGioHang);
        btnTiepTucMua = findViewById(R.id.buttonTiepTucMuaHang);
        gioHangAdapter = new GioHangAdapter(GioHangActivity.this, MainActivity.gioHangList);
        lvGioHang.setAdapter(gioHangAdapter);
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarGioHang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarGioHang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}