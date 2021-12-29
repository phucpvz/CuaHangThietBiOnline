package com.phuphuc.cuahangthietbionline.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thoai);
        AnhXa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            getIDLoaiSanPham();
            actionToolBar();
            layDuLieuDienThoai(page);
        } else {
            CheckConnection.showMessage(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối Internet!");
            finish();
        }
    }

    private void layDuLieuDienThoai(int page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = Server.LAY_DIEN_THOAI + String.valueOf(page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
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
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

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

    private void actionToolBar() {
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
        Log.d("idloaisanpham", String.valueOf(idLoaiSanPham));
    }

    private void AnhXa() {
        tbDienThoai = findViewById(R.id.toolbarDienThoai);
        lvDienThoai = findViewById(R.id.listviewDienThoai);
        dienThoaiList = new ArrayList<>();
        dienThoaiAdapter = new DienThoaiAdapter(getApplicationContext(), dienThoaiList);
        lvDienThoai.setAdapter(dienThoaiAdapter);
    }
}