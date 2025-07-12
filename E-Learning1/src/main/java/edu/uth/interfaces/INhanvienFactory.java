package edu.uth.interfaces;

import edu.uth.Nhanvien;

public interface INhanvienFactory {
    public Nhanvien createNhanvien(String maso, String hoten, double luongCB, String loaiNV);
    public Nhanvien createNhanvien(String loaiNV);
}
