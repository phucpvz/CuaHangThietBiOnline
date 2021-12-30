package com.phuphuc.cuahangthietbionline.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.adapter.DienThoaiAdapter;
import com.phuphuc.cuahangthietbionline.model.SanPham;
import com.phuphuc.cuahangthietbionline.util.CheckConnection;
import com.phuphuc.cuahangthietbionline.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DienThoaiActivity extends AppCompatActivity {

    Toolbar tbDienThoai;
    ListView lvDienThoai;
    List<SanPham> dienThoaiList;
    DienThoaiAdapter dienThoaiAdapter;
    int idLoaiSanPham;
    int page = 1;
    View footerView;
    boolean isLoading = false;
    boolean canLoadMore = true;
    MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thoai);
        AnhXa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            getIDLoaiSanPham();
            actionToolbar();
            layDuLieuDienThoai(page);
            loadMoreData();
        } else {
            CheckConnection.showMessage(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối Internet!");
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

    private void loadMoreData() {
        lvDienThoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", dienThoaiList.get(i));
                startActivity(intent);
            }
        });

        lvDienThoai.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int first, int visible, int total) {
                if (first + visible == total && total != 0 && !isLoading && canLoadMore) {
                    isLoading = true;
                    MyThread myThread = new MyThread();
                    myThread.start();
                }
            }
        });
    }

    private void layDuLieuDienThoai(int page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = Server.LAY_SAN_PHAM + page;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null && response.length() != 2) { // []
                    lvDienThoai.removeFooterView(footerView);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        int id, giaSanPham, idLoaiSanPham;
                        String tenSanPham, hinhAnhSanPham, moTaSanPham;
                        for (int i = 0; i < jsonArray.length(); ++i) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                id = jsonObject.getInt("id");
                                tenSanPham = jsonObject.getString("tensp");
                                giaSanPham = jsonObject.getInt("giasp");
                                hinhAnhSanPham = jsonObject.getString("hinhanhsp");
                                moTaSanPham = jsonObject.getString("motasp");
                                idLoaiSanPham = jsonObject.getInt("idloaisp");
                                dienThoaiList.add(new SanPham(id, tenSanPham, giaSanPham, hinhAnhSanPham, moTaSanPham, idLoaiSanPham));
                                dienThoaiAdapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if (jsonArray.length() < 5) {
                            canLoadMore = false;
                            CheckConnection.showMessage(getApplicationContext(), "Đã hiển thị tất cả điện thoại!");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    canLoadMore = false;
                    lvDienThoai.removeFooterView(footerView);
                    CheckConnection.showMessage(getApplicationContext(), "Không còn điện thoại để hiển thị!");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("idloaisp", String.valueOf(idLoaiSanPham));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void actionToolbar() {
        setSupportActionBar(tbDienThoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbDienThoai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getIDLoaiSanPham() {
        idLoaiSanPham = getIntent().getIntExtra("idloaisanpham", -1);
//        Log.d("idloaisanpham", String.valueOf(idLoaiSanPham));
    }

    private void AnhXa() {
        tbDienThoai = findViewById(R.id.toolbarDienThoai);
        lvDienThoai = findViewById(R.id.listviewDienThoai);
        dienThoaiList = new ArrayList<>();
        dienThoaiAdapter = new DienThoaiAdapter(getApplicationContext(), dienThoaiList);
        lvDienThoai.setAdapter(dienThoaiAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerView = inflater.inflate(R.layout.progressbar, null);
        myHandler = new MyHandler();
    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0:
                    lvDienThoai.addFooterView(footerView);
                    break;
                case 1:
                    layDuLieuDienThoai(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            myHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = myHandler.obtainMessage(1);
            myHandler.sendMessage(message);
            super.run();
        }
    }
}