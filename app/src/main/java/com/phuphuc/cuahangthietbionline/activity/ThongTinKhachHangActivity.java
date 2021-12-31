package com.phuphuc.cuahangthietbionline.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.phuphuc.cuahangthietbionline.R;
import com.phuphuc.cuahangthietbionline.model.GioHang;
import com.phuphuc.cuahangthietbionline.util.CheckConnection;
import com.phuphuc.cuahangthietbionline.util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ThongTinKhachHangActivity extends AppCompatActivity {

    EditText txtTenKhachHang, txtSoDienThoai, txtEmail;
    Button btnXacNhan, btnTroVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang);
        anhXa();
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            batSuKienXacNhan();
        } else {
            CheckConnection.showMessage(getApplicationContext(), "Không có kết nối Internet!");
        }
    }

    private void batSuKienXacNhan() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtTenKhachHang.getText().toString().trim();
                String sdt = txtSoDienThoai.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                if (ten.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
                    Toast.makeText(ThongTinKhachHangActivity.this, "Tất cả thông tin khách hàng không được để trông!", Toast.LENGTH_SHORT).show();
                } else {
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.THEM_DON_HANG, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            final int maDonHang;
                            try {
                                maDonHang = Integer.parseInt(response);
                            } catch (Exception ex) {
                                Toast.makeText(ThongTinKhachHangActivity.this,
                                        "Đã xảy ra lỗi khi thêm thông tin khách hàng!\n" + response + "\n" + ex.getMessage(), Toast.LENGTH_SHORT).show();
                                return;
                            }
                            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                            StringRequest request = new StringRequest(Request.Method.POST, Server.THEM_CHI_TIET_DON_HANG, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if (response.equals("1")) {
                                        MainActivity.gioHangList.clear();
                                        Toast.makeText(ThongTinKhachHangActivity.this, "Đã lưu thông tin thanh toán giỏ hàng của bạn!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        Toast.makeText(ThongTinKhachHangActivity.this, "Mời bạn tiếp tục mua hàng!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(ThongTinKhachHangActivity.this, "Xảy ra lỗi khi lưu thông tin thanh toán giỏ hàng của bạn!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(ThongTinKhachHangActivity.this,
                                            "Đã xảy ra lỗi: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }) {
                                @Nullable
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    JSONArray jsonArray = new JSONArray();
                                    for (int i = 0; i < MainActivity.gioHangList.size(); ++i) {
                                        GioHang gioHang = MainActivity.gioHangList.get(i);
                                        JSONObject jsonObject = new JSONObject();
                                        try {
                                            jsonObject.put("madonhang", maDonHang);
                                            jsonObject.put("masanpham", gioHang.getIdSanPham());
                                            jsonObject.put("soluongsanpham", gioHang.getSoLuongSanPham());
                                            jsonObject.put("tongtiensanpham", gioHang.getTongTienSanPham());
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        jsonArray.put(jsonObject);
                                    }
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("json", jsonArray.toString());
                                    return hashMap;
                                }
                            };
                            queue.add(request);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(ThongTinKhachHangActivity.this, "Lỗi thêm đơn hàng!\n" + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("tenkhachhang", ten);
                            hashMap.put("sodienthoai", sdt);
                            hashMap.put("email", email);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            }
        });
    }

    private void anhXa() {
        txtTenKhachHang = findViewById(R.id.edittextTenKhachHang);
        txtSoDienThoai = findViewById(R.id.edittextSoDienThoai);
        txtEmail = findViewById(R.id.edittextEmail);
        btnXacNhan = findViewById(R.id.buttonXacNhan);
        btnTroVe = findViewById(R.id.buttonTroVe);
    }
}