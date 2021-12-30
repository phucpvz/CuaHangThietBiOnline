package com.phuphuc.cuahangthietbionline.model;

public class GioHang {
    private int idSanPham;
    private String tenSanPham;
    private String hinhAnhSanPham;
    private int soLuongSanPham;
    private long tongTienSanPham;

    public GioHang(int idSanPham, String tenSanPham, String hinhAnhSanPham, int soLuongSanPham, long tongTienSanPham) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.hinhAnhSanPham = hinhAnhSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.tongTienSanPham = tongTienSanPham;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHinhAnhSanPham() {
        return hinhAnhSanPham;
    }

    public void setHinhAnhSanPham(String hinhAnhSanPham) {
        this.hinhAnhSanPham = hinhAnhSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public long getTongTienSanPham() {
        return tongTienSanPham;
    }

    public void setTongTienSanPham(long tongTienSanPham) {
        this.tongTienSanPham = tongTienSanPham;
    }
}
