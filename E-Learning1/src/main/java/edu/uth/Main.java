package edu.uth;

import edu.uth.implementClass.NhanvienFactory;
import edu.uth.implementClass.TienthuongNgoaigio;
import edu.uth.implementClass.TienthuongNgoaitinh;
import edu.uth.implementClass.TienthuongThongthuong;
import edu.uth.interfaces.INhanvienFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CHUONG TRINH QUAN LY NHAN VIEN ===\n");
        
        // Tao factory de tao nhan vien
        INhanvienFactory factory = new NhanvienFactory();
        
        // Tao cac loai nhan vien khac nhau
        System.out.println("1. Tao moi cac nhan vien:");
        
        // Tao lap trinh vien
        var lapTrinhVien = factory.createNhanvien("NV001", "Nguyen Van A", 15000000, "Laptrinhvien");
        lapTrinhVien.setPhuongthucTinhThuong(new TienthuongThongthuong());
        System.out.println("- Da tao " + lapTrinhVien);
        
        // Tao ke toan vien
        var keToanVien = factory.createNhanvien("NV002", "Tran Thi B", 12000000, "Ketoanvien");
        keToanVien.setPhuongthucTinhThuong(new TienthuongNgoaigio());
        System.out.println("- Da tao " + keToanVien);
        
        // Tao nhan vien kiem thu
        var kiemThuVien = factory.createNhanvien("NV003", "Le Van C", 13000000, "NhanvienKiemthu");
        kiemThuVien.setPhuongthucTinhThuong(new TienthuongNgoaitinh());
        System.out.println("- Da tao " + kiemThuVien);
        
        // Tao chuyen vien phan tich
        var phanTichVien = factory.createNhanvien("NV004", "Pham Thi D", 18000000, "ChuyenvienPhantich");
        phanTichVien.setPhuongthucTinhThuong(new TienthuongThongthuong());
        System.out.println("- Da tao " + phanTichVien);
        
        // Tinh va hien thi tien thuong
        System.out.println("\n2. Tinh tien thuong cho nhan vien:");
        tinhVaHienThiThuong(lapTrinhVien);
        tinhVaHienThiThuong(keToanVien);
        tinhVaHienThiThuong(kiemThuVien);
        tinhVaHienThiThuong(phanTichVien);
    }
    
    private static void tinhVaHienThiThuong(Nhanvien nv) {
        if (nv != null) {
            double tienThuong = nv.getPhuongthucTinhThuong() != null 
                ? nv.getPhuongthucTinhThuong().tinhTienThuong(nv.getLuongCB())
                : 0;
            System.out.println(String.format("- %s (Ma so: %s): %,.0f VND", 
                nv.getHoten(), nv.getMaso(), tienThuong));
        }
    }
}