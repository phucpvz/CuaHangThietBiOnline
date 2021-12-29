package com.phuphuc.cuahangthietbionline.model;

public class LoaiSanPham {
    private int id;
    private String tenLoaiSanPham;
    private String hinhAnhLoaiSanPham;

    public LoaiSanPham(int id, String tenLoaiSanPham, String hinhAnhLoaiSanPham) {
        this.id = id;
        this.tenLoaiSanPham = tenLoaiSanPham;
        this.hinhAnhLoaiSanPham = hinhAnhLoaiSanPham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public String getHinhAnhLoaiSanPham() {
        return hinhAnhLoaiSanPham;
    }

    public void setHinhAnhLoaiSanPham(String hinhAnhLoaiSanPham) {
        this.hinhAnhLoaiSanPham = hinhAnhLoaiSanPham;
    }
}
