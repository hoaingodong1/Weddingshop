import java.util.Scanner;
import java.util.InputMismatchException;

public class KhachHang extends Nguoi {
	// ----------------- Sản phẩm ------------------------

	public void muaHang() {
		int stt = 0;
		Scanner scn = new Scanner(System.in);

		System.out.println("-------------------Mua sản phẩm:----------------");

		try {
			System.out.print("Mã đặt hàng: ");
			int idHoaDon = scn.nextInt();

			scn.nextLine();

			System.out.println("Nhập tên khách hàng: ");
			String tenKhachHang = scn.nextLine();

			System.out.println("Nhập ngày mua hàng: ");
			String ngayMuaHang = scn.nextLine();

			System.out.println("Nhập số điện thoại: ");
			String sdt = scn.nextLine();

			System.out.println("Nhập số email: ");
			String email = scn.nextLine();

			System.out.println("Nhập địa chỉ");
			String diaChi = scn.nextLine();

			HoaDon hoaDon = new HoaDon(idHoaDon, ngayMuaHang, tenKhachHang, sdt, email, diaChi);

			Integer idSanPham = -1;

			while (true) {
				scn = new Scanner(System.in);

				System.out.println("Nhập mã sản phẩm, nhấp -1 để thoát");
				idSanPham = scn.nextInt();

				if (idSanPham.equals(-1)) {
					break;
				}

				System.out.println("Nhập số lượng: ");
				int soLuong = scn.nextInt();

				SanPham product = null;

				for (SanPham p : Main.sanPham) {
					if (p.getIdSanPham().equals(idSanPham)) {
						product = p;
						break;
					}
				}

				if (product == null) {
					System.out.println("Mã sản phẩm không tồn tại");
				}

				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setIdCTHD(1);
				chiTietHoaDon.setIdHoaDon(hoaDon.getIdHoaDon());
				chiTietHoaDon.setGia(product.getGia());
				chiTietHoaDon.setIdSanPham(idSanPham);
				chiTietHoaDon.setsoLuong(soLuong);
				hoaDon.getChiTietHoaDon().add(chiTietHoaDon);

			}
			System.out.println(
					"\t\t——————————————————————————————————————Hóa đơn của bạn là:————————————————————————————————————————");
			Main.hoaDon.add(hoaDon);
			String header = String.format("\t\t%-8s%-20s%-15s%-20s%-20s%-23s", "Mã HĐ", "Tên khách hàng",
					"Ngày mua hàng", "Số điện thoại", "Email", "Địa chỉ");
			System.out.print(header);
			KhachHang khachHang = new KhachHang();

			for (HoaDon order : Main.hoaDon) {
				String row = String.format("\t\t%-8d%-20s%-15s%-20s%-20s%-23s", order.getIdHoaDon(),
						order.getTenKhachHang(), order.getNgayMuaHang(), order.getSdt(), order.getEmail(),
						order.getDiaChi());
				System.out.print(row);

				String orderDetailHeader = String.format("\t\t%-8s%-20s%-15s%-20s%-23s", "Mã CTHĐ", "Tên Sản Phẩm",
						"Giá", "Số Lượng", "Thành Tiền");
				System.out.println(orderDetailHeader);

				int i = 1;
				for (ChiTietHoaDon od : order.getChiTietHoaDon()) {

					SanPham p = khachHang.getByIdSP(od.getidSanPham());

					String orderDetailRow = String.format("\t\t%-8d%-20s%-15.2f%-20d%-23.2f", i, p.getTenSanPham(),
							od.getGia(), od.getSoLuong(), od.getGia() * od.getSoLuong());
					System.out.println(orderDetailRow);
					i++;
				}

			}
			System.out.println(
					"\t\t——————————————————————————————————————————————————————————————————————————————————————————————————");

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void timTheoTen() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập tên váy bạn muốn tìm: ");
		String tenSPCanTim = scn.nextLine();
		int dem = 0;
		for (int i = 0; i < Main.sanPham.size(); i++) {
			if (Main.sanPham.get(i).getTenSanPham().equals(tenSPCanTim)) {
				System.out.println(
						"\t\t\t————————————————————————————————Có sản phẩm này nhé!———————————————————————————— ");
				String header = String.format("\t\t\t%-7s %-25s%-20s%-15s%-25s", "Mã", "Tên", "Số lượng", "Giá",
						"Nhà Thiết Kế");
				System.out.println(header);
				String row = String.format("\t\t\t%-7d %-25s%-20d%-15.2f%-25s", Main.sanPham.get(i).getIdSanPham(),
						Main.sanPham.get(i).getTenSanPham(), Main.sanPham.get(i).getSoLuong(),
						Main.sanPham.get(i).getGia(), Main.sanPham.get(i).getNhaThietKe());
				System.out.println(row);
				System.out.println(
						"\t\t\t———————————————————————————————————————————————————————————————————————————————— ");
				dem++;
				break;
			}
		}
		if (dem == 0) {
			System.out.println("Không có sản phẩm này");
		}
	}

	public void giaThapNhat() {
		sapXepTheoGia();
		System.out
				.println("\t\t\t———————————————————————————Sản phẩm có giá thấp nhất————————————————————————————————");
		String header = String.format("\t\t\t|%-7s%-25s%-15s%-15s%-20s|", "Mã", "Tên", "Số lượng", "Giá",
				"Nhà Thiết Kế");
		System.out.println(header);
		String row = String.format("\t\t\t|%-7d%-25s%-15d%-15.2f%-20s|", Main.sanPham.get(1).getIdSanPham(),
				Main.sanPham.get(0).getTenSanPham(), Main.sanPham.get(0).getSoLuong(), Main.sanPham.get(0).getGia(),
				Main.sanPham.get(0).getNhaThietKe());
		System.out.println(row);
		System.out
				.println("\t\t\t————————————————————————————————————————————————————————————————————————————————————");

	}

	public void giaCaoNhat() {
		sapXepTheoGia();
		System.out.println("\t\t\t———————————————————————————Sản phẩm có giá cao nhất————————————————————————————————");
		int size = Main.sanPham.size() - 1;
		String header = String.format("\t\t\t|%-7s%-25s%-15s%-15s%-20s|", "Mã", "Tên", "Số lượng", "Giá",
				"Nhà Thiết Kế");
		System.out.println(header);
		String row = String.format("\t\t\t|%-7s%-25s%-15s%-15s%-20s|", Main.sanPham.get(size).getIdSanPham(),
				Main.sanPham.get(size).getTenSanPham(), Main.sanPham.get(size).getSoLuong(),
				Main.sanPham.get(size).getGia(), Main.sanPham.get(size).getNhaThietKe());
		System.out.println(row);
		System.out.println(
				"\t\t\t———————————————————————————————————————————————————————————————————————————————————————————————");
	}

	// -----------------------Dịch vụ ------------------------
	public void timTheoTenDV() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập tên dịch vụ bạn muốn tìm: ");
		String tenDVCanTim = scn.nextLine();
		int dem = 0;
		for (int i = 0; i < Main.dichVu.size(); i++) {
			if (Main.dichVu.get(i).getTenDichVu().equals(tenDVCanTim)) {
				System.out.println(
						"\t\t\t————————————————————————————————Có dịch vụ này nhé!————————————————————————————");
				String header = String.format("\t\t\t%-7s %-25s%-20s%-15s", "Mã DV", "Tên dịch vụ", "Số lượng", "Giá");
				System.out.println(header);
				String row = String.format("\t\t\t%-7s %-25s%-20s%-15s", Main.dichVu.get(i).getIdDichVu(),
						Main.dichVu.get(i).getTenDichVu(), Main.dichVu.get(i).getSoLuongDV(),
						Main.dichVu.get(i).getGiaDichVu());
				System.out.println(row);
				System.out.println(
						"\t\t\t———————————————————————————————————————————————————————————————————————————————");
				dem++;
				break;
			}
		}
		if (dem == 0) {
			System.out.println("Không có loại dịch vụ này");
		}
	};

	public void thueDichVu() {
		int stt = 0;
		Scanner scn = new Scanner(System.in);

		System.out.println("-------------------Thue dich Vu:----------------");

		try {
			System.out.print("Mã thuê DV: ");
			int idHoaDon = scn.nextInt();

			scn.nextLine();

			System.out.println("Nhập tên khách hàng: ");
			String tenKhachHang = scn.nextLine();

			System.out.println("Nhập ngày thuê DV: ");
			String ngayMuaHang = scn.nextLine();

			System.out.println("Nhập số điện thoại: ");
			String sdt = scn.nextLine();

			System.out.println("Nhập số email: ");
			String email = scn.nextLine();

			System.out.println("Nhập địa chỉ");
			String diaChi = scn.nextLine();

			HoaDon hoaDon = new HoaDon(idHoaDon, ngayMuaHang, tenKhachHang, sdt, email, diaChi);

			Integer idDichVu = -1;

			while (true) {
				scn = new Scanner(System.in);

				System.out.println("Nhập mã dịch vụ, nhấp -1 để thoát");
				idDichVu = scn.nextInt();

				if (idDichVu.equals(-1)) {
					break;
				}

				System.out.println("Nhập số lượng: ");
				int soLuong = scn.nextInt();

				DichVu dichVuu = null;

				for (DichVu dv : Main.dichVu) {
					if (dv.getIdDichVu().equals(idDichVu)) {
						dichVuu = dv;
						break;
					}
				}

				if (dichVuu == null) {
					System.out.println("Mã dịch vụ không tồn tại");
				}

				ChiTietHoaDonDV chiTietHoaDonDV = new ChiTietHoaDonDV();
				chiTietHoaDonDV.setIdCTHDDV(1);
				chiTietHoaDonDV.setIdHoaDon(hoaDon.getIdHoaDon());
				chiTietHoaDonDV.setGia(dichVuu.getGiaDichVu());
				chiTietHoaDonDV.setIdDichVu(idDichVu);
				chiTietHoaDonDV.setsoLuong(soLuong);
				hoaDon.getChiTietHoaDonDV().add(chiTietHoaDonDV);

			}
			System.out.println(
					"\t\t——————————————————————————————————————Hóa đơn của bạn là:————————————————————————————————————————");
			Main.hoaDon.add(hoaDon);
			String header = String.format("\t\t%-8s%-20s%-15s%-20s%-20s%-23s", "Mã HĐ", "Tên khách hàng",
					"Ngày thuê DV", "Số điện thoại", "Email", "Địa chỉ");
			System.out.print(header);
			KhachHang khachHang = new KhachHang();

			for (HoaDon order : Main.hoaDon) {
				String row = String.format("\t\t%-8d%-20s%-15s%-20s%-20s%-23s", order.getIdHoaDon(),
						order.getTenKhachHang(), order.getNgayMuaHang(), order.getSdt(), order.getEmail(),
						order.getDiaChi());
				System.out.print(row);

				String orderDetailHeader = String.format("\t\t%-8s%-20s%-15s%-20s%-23s", "Mã CTHĐ", "Tên dịch vụ",
						"Giá", "Số Lượng", "Thành Tiền");
				System.out.println(orderDetailHeader);

				int i = 1;
				for (ChiTietHoaDonDV od : order.getChiTietHoaDonDV()) {

					DichVu s = khachHang.getByIdDV(od.getidDichVu());

					String orderDetailRow = String.format("\t\t%-8d%-20s%-15.2f%-20d%-23.2f", i, s.getTenDichVu(),
							od.getGia(), od.getSoLuong(), od.getGia() * od.getSoLuong());
					System.out.println(orderDetailRow);
					i++;
				}

			}
			System.out.println(
					"\t\t——————————————————————————————————————————————————————————————————————————————————————————————————");

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	};

	public void giaDVThapNhat() {
		sapXepDichVu();
		System.out.println("\t\t\t————————————————————————Dịch vụ có giá thấp nhất—————————————————————————");
		String header = String.format("\t\t\t|  %-10s%-20s%-20s%-20s|", "Mã", "Tên", "Số lượng", "Giá");
		System.out.println(header);
		String row = String.format("\t\t\t|  %-10d%-20s%-20d%-20.2f|", Main.dichVu.get(0).getIdDichVu(),
				Main.dichVu.get(0).getTenDichVu(), Main.dichVu.get(0).getSoLuongDV(),
				Main.dichVu.get(0).getGiaDichVu());
		System.out.println(row);
		System.out.println("\t\t\t—————————————————————————————————————————————————————————————————————————");

	}

	public void giaDVCaoNhat() {
		sapXepDichVu();
		int size = Main.dichVu.size() - 1;
		System.out.println("\t\t\t————————————————————————Dịch vụ có giá thấp nhất—————————————————————————");
		String header = String.format("\t\t\t|  %-10s%-20s%-20s%-20s|", "Mã", "Tên", "Số lượng", "Giá");
		System.out.println(header);
		String row = String.format("\t\t\t|  %-10d%-20s%-20d%-20.2f|", Main.dichVu.get(size).getIdDichVu(),
				Main.dichVu.get(size).getTenDichVu(), Main.dichVu.get(size).getSoLuongDV(),
				Main.dichVu.get(size).getGiaDichVu());
		System.out.println(row);
		System.out.println("\t\t\t—————————————————————————————————————————————————————————————————————————");

	};

}