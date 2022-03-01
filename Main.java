import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void manHinhChinh() {
        System.out.println();
        System.out.println("\t\t\tChào mừng bạn đến với Cửa hàng Váy cưới Hoài Ngô Đồng của chúng tôi!\n");
        System.out.println("\t\t\t————————————————————————oooooooooOoooooooooo————————————————————————");
        System.out.println("\t\t\t\t\t      ————————————————————————");
        System.out.println("\t\t\t\t\t     |     Chọn vai trò!      |");
        System.out.println("\t\t\t\t\t     |      1. Nhân viên      | ");
        System.out.println("\t\t\t\t\t     |      2. Khách hàng     |");
        System.out.println("\t\t\t\t\t     |      3. Quản lí        |");
        System.out.println("\t\t\t\t\t     |      4. Thoát.         |");
        System.out.println("\t\t\t\t\t      ————————————————————————");
    }

    public static void menu1() {
        System.out.println("\t\t\t————————————————————————oooooooooOoooooooooo————————————————————————————");
        System.out.println("\t\t\t—————————————————————— Mời bạn chọn chức năng———————————————————————————");
        System.out.println("\t\t\t|            SẢN PHẨM                                DỊCH VỤ            |");
        System.out.println("\t\t\t|   1. Thêm mới sản phẩm                   |7. Thêm dịch vụ             |");
        System.out.println("\t\t\t|   2. Sửa sản phẩm                        |8. Sửa dịch vụ              |");
        System.out.println("\t\t\t|   3. Xóa sản phẩm                        |9. Xóa dịch vụ              |");
        System.out.println("\t\t\t|   4. Hiển thị danh sách sản phẩm         |10. Hiển thị bảng dịch vụ   |");
        System.out.println("\t\t\t|   5. Sắp xếp sản phẩm theo giá           |11. Sắp xếp dịch vụ theo giá|");
        System.out.println("\t\t\t|   6. Hiển thị danh sách đơn đật hàng     |12. Hiển thị các đơn dịch vụ|");
        System.out.println("\t\t\t|   \t\t   13. Quay lại màn hình chính                          |");
        System.out.println("\t\t\t—————————————————————————————————————————————————————————————————————————");
    }

    public static void menu2() {
        System.out.println("\t\t\t————————————————————————oooooooooOoooooooooo————————————————————————————");
        System.out.println("\t\t\t———————————————————————Mời bạn chọn chức năng———————————————————————————");
        System.out.println("\t\t\t                ——————————————————————————————————————");
        System.out.println("\t\t\t\t       |      1. Sản phẩm                     |");
        System.out.println("\t\t\t\t       |      2. Dịch vụ                      |");
        System.out.println("\t\t\t\t       |      3. Quay lại màn hình chính      |");
        System.out.println("\t\t\t\t\t——————————————————————————————————————");
    }

    public static void menu3() {
        System.out.println("\t\t\t————————————————————————oooooooooOoooooooooo————————————————————————————");
        System.out.println("\t\t\t———————————————————————Mời bạn chọn chức năng———————————————————————————");
        System.out.println("\t\t\t              —————————————————————————————————————————");
        System.out.println("\t\t\t\t     | 1. Hiển thị sản phẩm                   |");
        System.out.println("\t\t\t\t     | 2. Sắp xếp sản phẩm theo giá           |");
        System.out.println("\t\t\t\t     | 3. Tìm theo tên                        |");
        System.out.println("\t\t\t\t     | 4. Mua hàng                            |");
        System.out.println("\t\t\t\t     | 5. Hiển thị sản phẩm có giá thấp nhất  |");
        System.out.println("\t\t\t\t     | 6. Hiển thị sản phẩm có giá cao nhất   |");
        System.out.println("\t\t\t\t     | 7. Quay lại màn hình chính.            |");
        System.out.println("\t\t\t              —————————————————————————————————————————");
    }

    public static void menu4() {
        System.out.println("\t\t\t————————————————————————oooooooooOoooooooooo————————————————————————————");
        System.out.println("\t\t\t—————————————————————— Mời bạn chọn chức năng———————————————————————————");
        System.out.println("\t\t\t              —————————————————————————————————————————");
        System.out.println("\t\t\t\t     | 1. Hiển thị bảng dịch vụ                |");
        System.out.println("\t\t\t\t     | 2. Sắp xếp dịch vụ theo giá             |");
        System.out.println("\t\t\t\t     | 3. Tìm theo tên dịch vụ                 |");
        System.out.println("\t\t\t\t     | 4. Thuê dịch vụ                         |");
        System.out.println("\t\t\t\t     | 5. Hiển thị dịch vụ có giá thấp nhất    |");
        System.out.println("\t\t\t\t     | 6. Hiển thị dịch vụ có giá cao nhất     |");
        System.out.println("\t\t\t\t     | 7. Quay lại màn hình chính.             |");
        System.out.println("\t\t\t              —————————————————————————————————————————");

    }

    public static void menu5() {
        System.out.println("\t\t\t————————————————————————oooooooooOoooooooooo————————————————————————————");
        System.out.println("\t\t\t—————————————————————— Mời bạn chọn chức năng———————————————————————————");
        System.out.println("\t\t\t              —————————————————————————————————————————");
        System.out.println("\t\t\t\t     | 1. Xem danh sách sản phẩm               |");
        System.out.println("\t\t\t\t     | 2. Xem danh sách dịch vụ                |");
        System.out.println("\t\t\t\t     | 3. Xem số lượng sản phẩm còn lại        |");
        System.out.println("\t\t\t\t     | 4. Xem số lượng dịch vụ còn lại         |");
        System.out.println("\t\t\t\t     | 5. Xem hóa đơn sản phẩm                 |");
        System.out.println("\t\t\t\t     | 6. Xem hóa đơn dịch vụ                  |");
        System.out.println("\t\t\t\t     | 7. Quay lại màn hình chính.             |");
        System.out.println("\t\t\t              —————————————————————————————————————————");
    }

    public static List<SanPham> sanPham = new ArrayList<SanPham>();
    public static List<HoaDon> hoaDon = new ArrayList<HoaDon>();
    public static List<DichVu> dichVu = new ArrayList<DichVu>();

    public static void main(String[] args) {
        SanPham p = new SanPham(1, "Vay Reem Acra", 100, "Acra", 100000000d);
        Main.sanPham.add(p);
        SanPham p1 = new SanPham(2, "Vay Marchesa", 200, "Marchesa", 80000000d);
        Main.sanPham.add(p1);
        SanPham p2 = new SanPham(3, "Vay Phuong My Bridal", 150, "Phuong My", 15000000d);
        Main.sanPham.add(p2);
        SanPham p3 = new SanPham(4, "Vay Oscar De La Renta", 120, "Renta", 120000000d);
        Main.sanPham.add(p3);
        SanPham p4 = new SanPham(5, "Vay Chung Thanh Phong", 121, "Chung Thanh Phong", 50000000d);
        Main.sanPham.add(p4);
        SanPham p5 = new SanPham(6, "Vay Gucci", 10, "Gucci", 250000000d);
        Main.sanPham.add(p5);
        SanPham p6 = new SanPham(7, "Amsale", 15, "Amsale", 13000000d);
        Main.sanPham.add(p6);
        SanPham p7 = new SanPham(8, "Vay Jenny Packham", 15, "Jenny", 1300000d);
        Main.sanPham.add(p7);

        DichVu dv1 = new DichVu(1, "Hoa cuoi L1", 50, 10000000d);
        Main.dichVu.add(dv1);
        DichVu dv2 = new DichVu(2, "Hoa cuoi L2", 50, 5000000d);
        Main.dichVu.add(dv2);
        DichVu dv3 = new DichVu(3, "Xe cuoi", 10, 3000000d);
        Main.dichVu.add(dv3);
        DichVu dv4 = new DichVu(4, "Ao dai", 30, 300000d);
        Main.dichVu.add(dv4);
        DichVu dv5 = new DichVu(5, "Mam co qua", 100, 300000d);
        Main.dichVu.add(dv5);
        DichVu dv6 = new DichVu(6, "Trang diem co dau", 5, 9000000d);
        Main.dichVu.add(dv6);
        DichVu dv7 = new DichVu(7, "Vay di tiec", 20, 8000000d);
        Main.dichVu.add(dv7);

        NhanVien nhanVien = new NhanVien();
        KhachHang khachHang = new KhachHang();
        QuanLi quanLi = new QuanLi();
        int chon = 0;
        do {
            manHinhChinh();
            Scanner scn = new Scanner(System.in);
            try {
                System.out.print("\t\t\t\t\t\tChọn vai trò: ");
                chon = scn.nextInt();
                switch (chon) {
                    case 1: {
                        int chon1 = 0;
                        menu1();
                        System.out.print("\t\t\t\t\t\tChọn chức năng: ");
                        chon1 = scn.nextInt();
                        switch (chon1) {
                            case 1:
                                nhanVien.themSanPham();
                                break;
                            case 2:
                                nhanVien.thayDoiSanPham();
                                break;
                            case 3:
                                nhanVien.xoaSanPham();
                                break;
                            case 4:
                                nhanVien.xemSanPham();
                                break;
                            case 5:
                                nhanVien.sapXepTheoGia();
                                nhanVien.xemSanPham();
                                break;
                            case 6:
                                nhanVien.xemHoaDon();
                                break;
                            case 7:
                                nhanVien.themDichVu();
                                break;
                            case 8:
                                nhanVien.suaDichVu();
                                break;
                            case 9:
                                nhanVien.xoaDichVu();
                                break;
                            case 10:
                                nhanVien.xemDichVu();
                                break;
                            case 11:
                                nhanVien.sapXepDichVu();
                                nhanVien.xemDichVu();
                                break;
                            case 12:
                                nhanVien.donHangDV();
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    case 2: {
                        int chon2 = 0;
                        menu2();
                        System.out.print("\t\t\t\t\t\tChọn chức năng: ");
                        chon2 = scn.nextInt();
                        switch (chon2) {
                            case 1: {
                                int chon3 = 0;
                                menu3();
                                System.out.print("\t\t\t\t\t\tChọn chức năng:  ");
                                chon3 = scn.nextInt();
                                switch (chon3) {
                                    case 1:
                                        khachHang.xemSanPham();
                                        break;
                                    case 2:
                                        khachHang.sapXepTheoGia();
                                        khachHang.xemSanPham();
                                        break;
                                    case 3:
                                        khachHang.timTheoTen();
                                        break;
                                    case 4:
                                        khachHang.muaHang();
                                        break;
                                    case 5:
                                        khachHang.giaThapNhat();
                                        break;
                                    case 6:
                                        khachHang.giaCaoNhat();
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }
                            case 2: {
                                int chon4 = 0;
                                menu4();
                                System.out.print("\t\t\t\t\t\tChọn chức năng: ");
                                chon4 = scn.nextInt();
                                switch (chon4) {
                                    case 1:
                                        khachHang.xemDichVu();
                                        break;
                                    case 2:
                                        khachHang.sapXepDichVu();
                                        khachHang.xemDichVu();
                                        break;
                                    case 3:
                                        khachHang.timTheoTenDV();
                                        break;
                                    case 4:
                                        khachHang.thueDichVu();
                                        break;
                                    case 5:
                                        khachHang.giaDVThapNhat();
                                        break;
                                    case 6:
                                        khachHang.giaDVCaoNhat();
                                        break;
                                    default:
                                        break;

                                }
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    }
                    case 3: {
                        int chon5 = 0;
                        menu5();
                        System.out.print("\t\t\t\t\t\tChọn chức năng: ");
                        chon5 = scn.nextInt();
                        switch (chon5) {
                            case 1:
                                quanLi.xemSanPham();
                                break;
                            case 2:
                                quanLi.xemDichVu();
                                break;
                            case 3:
                                quanLi.slSPConLai();
                                break;
                            case 4:
                                quanLi.slDVConLai();
                                break;
                            case 5:
                                quanLi.xemHoaDon();
                                break;
                            case 6:
                                quanLi.donHangDV();
                                break;
                            default:
                                break;
                        }
                    }
                    default:
                        break;

                }
            } catch (InputMismatchException ei) {
                System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (chon != 4);

        System.out.println("\t\t\tCảm ơn bạn đã ghé thăm shop của chúng tôi, chúc bạn một ngày tốt lành!");

    }
}
