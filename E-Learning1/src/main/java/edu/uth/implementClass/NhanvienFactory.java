package edu.uth.implementClass;

import edu.uth.*;
import edu.uth.interfaces.INhanvienFactory;

public class NhanvienFactory implements INhanvienFactory {
    @Override
    public Nhanvien createNhanvien(String maso, String hoten, double luongCB, String loaiNV) {
        Nhanvien nv;
        switch (loaiNV) {
            case "Laptrinhvien":
                nv = new Laptrinhvien(maso, hoten, luongCB);
                break;
            case "Ketoanvien":
                nv = new Ketoanvien(maso, hoten, luongCB);
                break;
            case "NhanvienKiemthu":
                nv = new NhanvienKiemthu(maso, hoten, luongCB);
                break;
            case "ChuyenvienPhantich":
                nv = new ChuyenvienPhantich(maso, hoten, luongCB);
                break;
            default:
                nv = null;
                break;
        }
        return nv;
    }

    @Override
    public Nhanvien createNhanvien(String loaiNV) {
        Nhanvien nv;
        switch (loaiNV) {
            case "Laptrinhvien":
                nv = new Laptrinhvien();
                break;
            case "Ketoanvien":
                nv = new Ketoanvien();
                break;
            case "NhanvienKiemthu":
                nv = new NhanvienKiemthu();
                break;
            case "ChuyenvienPhantich":
                nv = new ChuyenvienPhantich();
                break;
            default:
                nv = null;
                break;
        }
        return nv;
    }
}
