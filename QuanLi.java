public class QuanLi extends Nguoi {
    public void slSPConLai() {
        System.out.println("\t\t\t——————————————————————————Số lượng sản phẩm còn lại——————————————————————————————");
        String header = String.format("\t\t\t%-5s %-30s%-15s%-15s%-20s", "Mã", "Tên", "Số lượng", "Giá",
                "Nhà Thiết Kế");
        System.out.println(header);
        for (SanPham p : Main.sanPham) {
            int slConLai = p.getSoLuong();
            for (HoaDon order : Main.hoaDon) {
                for (ChiTietHoaDon od : order.getChiTietHoaDon()) {
                    if (od.getidSanPham() == p.getIdSanPham()) {
                        slConLai = p.getSoLuong() - od.getSoLuong();
                    }
                }
            }
            String row = String.format("\t\t\t%-5s %-30s%-15d%-15.2f%-20s", p.getIdSanPham(), p.getTenSanPham(),
                    slConLai, p.getGia(), p.getNhaThietKe());
            System.out.println(row);

        }
        System.out.println("\t\t\t——————————————————————————————————————————————————————————————————————————————————");

    }

    public void slDVConLai() {
        System.out.println("\t\t\t————————————————————Số lượng dịch vụ còn lại—————————————————————————");
        String header = String.format("\t\t\t\t%-8s%-25s%-15s%-15s", "Mã", "Tên", "Số lượng", "Giá");
        System.out.println(header);
        for (DichVu dv : Main.dichVu) {
            int slConLai = dv.getSoLuongDV();
            for (HoaDon order : Main.hoaDon) {
                for (ChiTietHoaDonDV od : order.getChiTietHoaDonDV()) {
                    if (od.getidDichVu() == dv.getIdDichVu()) {
                        slConLai = dv.getSoLuongDV() - od.getSoLuong();
                    }
                }
            }
            String row = String.format("\t\t\t\t%-8d%-25s%-15d%-15.2f", dv.getIdDichVu(), dv.getTenDichVu(), slConLai,
                    dv.getGiaDichVu());
            System.out.println(row);

        }
        System.out.println("\t\t\t————————————————————————————————————————————————————————————————————");

    }

    public void xemHoaDon() {
        System.out.println(
                "\t\t——————————————————————————————————————Danh sách đặt hàng———————————————————————————————————————");
        String header = String.format("\t\t %-7s%-20s%-20s%-15s%-20s%-25s", "Mã", "Tên khách hàng", "Ngày mua hàng",
                "Số điện thoại", "Email", "Địa chỉ");
        System.out.print(header);
        QuanLi quanLi = new QuanLi();

        for (HoaDon order : Main.hoaDon) {
            String row = String.format("\t\t %-7d%-20s%-20s%-15s%-20s%-25s", order.getIdHoaDon(),
                    order.getTenKhachHang(), order.getNgayMuaHang(), order.getSdt(), order.getEmail(),
                    order.getDiaChi());
            System.out.print(row);

            String orderDetailHeader = String.format("\t\t %-7s%-20s%-20s%-15s%-20s", "STT", "Tên Sản Phẩm", "Giá",
                    "Số Lượng", "Thành Tiền");
            System.out.println(orderDetailHeader);

            int i = 1;
            for (ChiTietHoaDon od : order.getChiTietHoaDon()) {

                SanPham p = quanLi.getByIdSP(od.getidSanPham());

                String orderDetailRow = String.format("\t\t %-7d%-20s%-20.2f%-15d%-20.2f", i, p.getTenSanPham(),
                        od.getGia(), od.getSoLuong(), od.getGia() * od.getSoLuong());
                System.out.println(orderDetailRow);
                i++;
            }
        }
        System.out.println(
                "\t\t——————————————————————————————————————————————————————————————————————————————————————————————");

    }

    public void donHangDV() {
        System.out.println(
                "\t\t————————————————————————————————————Danh sách thuê Dịch vụ———————————————————————————————————————");
        String header = String.format("\t\t %-7s%-20s%-20s%-20s%-20s%-20s", "Mã", "Tên khách hàng", "Ngày mua hàng",
                "Số điện thoại", "Email", "Địa chỉ");
        System.out.println(header);
        QuanLi quanLi = new QuanLi();

        for (HoaDon order : Main.hoaDon) {
            String row = String.format("\t\t %-7s%-20s%-20s%-20s%-20s%-20s", order.getIdHoaDon(),
                    order.getTenKhachHang(), order.getNgayMuaHang(), order.getSdt(), order.getEmail(),
                    order.getDiaChi());
            System.out.println(row);

            String orderDetailHeader = String.format("\t\t %-7s%-20s%-20s%-20s%-20s", "STT", "Tên Sản Phẩm", "Giá",
                    "Số Lượng", "Thành Tiền");
            System.out.println(orderDetailHeader);

            int i = 1;
            for (ChiTietHoaDonDV od : order.getChiTietHoaDonDV()) {

                DichVu p = quanLi.getByIdDV(od.getidDichVu());

                String orderDetailRow = String.format("\t\t %-7d%-20s%-20.2f%-20d%-20.2f", i, p.getTenDichVu(),
                        od.getGia(), od.getSoLuong(), od.getGia() * od.getSoLuong());
                System.out.println(orderDetailRow);
                i++;
            }
        }
        System.out.println(
                "\t\t——————————————————————————————————————————————————————————————————————————————————————————————");

    }

}
