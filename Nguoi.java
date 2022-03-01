public class Nguoi {

    // Sản phẩm
    public void xemSanPham() {
        System.out.println("\t\t\t——————————————————————————————Thông tin sản phẩm———————————————————————————————————");
        String header = String.format("\t\t\t|%-7s%-25s%-15s%-15s%-20s|", "Mã", "Tên", "Số lượng", "Giá",
                "Nhà Thiết Kế");
        System.out.println(header);
        for (SanPham p : Main.sanPham) {
            String row = String.format("\t\t\t|%-7d%-25s%-15d%-15.2f%-20s|", p.getIdSanPham(), p.getTenSanPham(),
                    p.getSoLuong(), p.getGia(), p.getNhaThietKe());
            System.out.println(row);
        }
        System.out.println("\t\t\t———————————————————————————————————————————————————————————————————————————————————");

    }

    public void sapXepTheoGia() {
        // SanPham temp = Main.sanPham.get(0);
        for (int i = 0; i < Main.sanPham.size(); i++) {
            for (int j = 0; j < Main.sanPham.size(); j++) {
                if (Main.sanPham.get(i).getGia() < Main.sanPham.get(j).getGia()) {
                    SanPham temp = Main.sanPham.get(j);
                    // Main.sanPham.get(j)=Main.sanPham.get(i);
                    Main.sanPham.set(j, Main.sanPham.get(i));
                    Main.sanPham.set(i, temp);

                }
            }
        }
    }

    // Dịch vụ
    public void xemDichVu() {
        System.out.println("\t\t\t——————————————————————————Thông tin dịch vụ————————————————————————————");
        String header = String.format("\t\t\t\t|%-7s%-25s%-15s%-15s|", "Mã", "Tên", "Số lượng", "Giá");
        System.out.println(header);
        for (DichVu dVu : Main.dichVu) {
            String row = String.format("\t\t\t\t|%-7d%-25s%-15d%-15.2f|", dVu.getIdDichVu(), dVu.getTenDichVu(),
                    dVu.getSoLuongDV(), dVu.getGiaDichVu());
            System.out.println(row);
        }
        System.out.println("\t\t\t———————————————————————————————————————————————————————————————————————");

    }

    public void sapXepDichVu() {
        // SanPham temp = Main.sanPham.get(0);
        for (int i = 0; i < Main.dichVu.size(); i++) {
            for (int j = 0; j < Main.dichVu.size(); j++) {
                if (Main.dichVu.get(i).getGiaDichVu() < Main.dichVu.get(j).getGiaDichVu()) {
                    DichVu temp = Main.dichVu.get(j);
                    // Main.sanPham.get(j)=Main.sanPham.get(i);
                    Main.dichVu.set(j, Main.dichVu.get(i));
                    Main.dichVu.set(i, temp);

                }
            }
        }
    }

    // Lấy id sản phẩm và dịch vụ
    public SanPham getByIdSP(int id) {
        SanPham product = new SanPham();

        for (SanPham p : Main.sanPham) {
            if (p.getIdSanPham().equals(id)) {
                product = p;
                break;
            }
        }
        return product;
    }

    public DichVu getByIdDV(int id) {
        DichVu service = new DichVu();

        for (DichVu s : Main.dichVu) {
            if (s.getIdDichVu().equals(id)) {
                service = s;
                break;
            }
        }
        return service;
    }
}
