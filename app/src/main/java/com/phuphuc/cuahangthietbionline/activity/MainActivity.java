package com.phuphuc.cuahangthietbionline.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.adapter.LoaiSanPhamAdapter;
import com.phuphuc.cuahangthietbionline.adapter.SanPhamAdapter;
import com.phuphuc.cuahangthietbionline.model.GioHang;
import com.phuphuc.cuahangthietbionline.model.LoaiSanPham;
import com.phuphuc.cuahangthietbionline.model.SanPham;
import com.phuphuc.cuahangthietbionline.util.CheckConnection;
import com.phuphuc.cuahangthietbionline.util.Server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView rcvManHinhChinh;
    NavigationView navigationView;
    ListView lvManHinhChinh;
    DrawerLayout drawerLayout;
    List<LoaiSanPham> loaiSanPhamList;
    LoaiSanPhamAdapter loaiSPAdapter;
    List<SanPham> sanPhamList;
    SanPhamAdapter sanPhamAdapter;

    public static List<GioHang> gioHangList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            actionBar();
            actionViewFlipper();
            layDuLieuLoaiSanPham();
            layDuLieuSanPhamMoiNhat();
            batSuKienClickMenu();
        } else {
            CheckConnection.showMessage(getApplicationContext(), "Ứng dụng yêu cầu cần có kết nối Internet!");
            finish();
        }
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

    private void batSuKienClickMenu() {
        lvManHinhChinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.showMessage(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, DienThoaiActivity.class);
                            intent.putExtra("idloaisanpham", loaiSanPhamList.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.showMessage(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, LaptopActivity.class);
                            intent.putExtra("idloaisanpham", loaiSanPhamList.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.showMessage(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, LienHeActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.showMessage(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, ThongTinActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.showMessage(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối!");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void layDuLieuSanPhamMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.LAY_SAN_PHAM_MOI_NHAT, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int id, giaSanPham, idLoaiSanPham;
                    String tenSanPham, hinhAnhSanPham, moTaSanPham;
                    for (int i = 0; i < response.length(); ++i) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenSanPham = jsonObject.getString("tensp");
                            giaSanPham = jsonObject.getInt("giasp");
                            hinhAnhSanPham = jsonObject.getString("hinhanhsp");
                            moTaSanPham = jsonObject.getString("motasp");
                            idLoaiSanPham = jsonObject.getInt("idloaisp");
                            sanPhamList.add(new SanPham(id, tenSanPham, giaSanPham, hinhAnhSanPham, moTaSanPham, idLoaiSanPham));
                            sanPhamAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.showMessage(getApplicationContext(), error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void layDuLieuLoaiSanPham() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.LAY_LOAI_SAN_PHAM, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int id;
                    String tenLoaiSP, hinhAnhLoaiSP;
                    for (int i = 0; i < response.length(); ++i) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenLoaiSP = jsonObject.getString("tenloaisanpham");
                            hinhAnhLoaiSP = jsonObject.getString("hinhanhloaisanpham");
                            loaiSanPhamList.add(new LoaiSanPham(id, tenLoaiSP, hinhAnhLoaiSP));
                            loaiSPAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    loaiSanPhamList.add(new LoaiSanPham(0, "Liên hệ",
                            "https://i.pinimg.com/474x/a0/04/1d/a0041d1cb69c4769c575bb74620d4286.jpg"));
                    loaiSanPhamList.add(new LoaiSanPham(0, "Thông tin",
                            "https://findicons.com/files/icons/2443/bunch_of_cool_bluish_icons/512/info_user.png"));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.showMessage(getApplicationContext(), error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void actionViewFlipper() {
        List<String> listQuangCao = new ArrayList<>();
        listQuangCao.add("https://dobuonphukien.com/wp-content/uploads/2019/01/banner-1.jpg");
        listQuangCao.add("https://i2.wp.com/techtimes.vn/wp-content/uploads/2019/02/Galaxy-s10e-techtimes.jpg");
        listQuangCao.add("https://cellphones.com.vn/sforum/wp-content/uploads/2020/08/OPPO-F17-1.jpg");
        listQuangCao.add("https://reviewlaptop.vn/wp-content/uploads/2021/06/review-laptop-dell-vostro-3500-322.jpg");

        for (int i = 0; i < listQuangCao.size(); ++i) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(listQuangCao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolbarManHinhChinh);
        viewFlipper = findViewById(R.id.viewlipper);
        rcvManHinhChinh = findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.navigationview);
        lvManHinhChinh = findViewById(R.id.listviewManHinhChinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        loaiSanPhamList = new ArrayList<>();
        loaiSanPhamList.add(new LoaiSanPham(0, "Trang chính",
                "https://cdn01.dienmaycholon.vn/filewebdmclnew/DMCL21/FE/img/branch/icon-home.png"));
        loaiSPAdapter = new LoaiSanPhamAdapter(getApplicationContext(), loaiSanPhamList);
        lvManHinhChinh.setAdapter(loaiSPAdapter);
        sanPhamList = new ArrayList<>();
        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(), sanPhamList);
        rcvManHinhChinh.setHasFixedSize(true);
        rcvManHinhChinh.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rcvManHinhChinh.setAdapter(sanPhamAdapter);

        if (gioHangList == null) {
            gioHangList = new ArrayList<>();
        }
    }
}