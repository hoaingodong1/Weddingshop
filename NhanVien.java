import java.util.Scanner;
import java.util.InputMismatchException;

public class NhanVien extends Nguoi {

	public void themSanPham() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập thông tin sản phẩm:");

		try {
			System.out.print("Nhập mã sản phẩm: ");
			int id = scn.nextInt();

			scn.nextLine();

			System.out.println("Nhập tên sản phẩm : ");
			String ten = scn.nextLine();

			System.out.println("Nhập số lượng: ");
			int soLuong = scn.nextInt();

			scn.nextLine();

			System.out.println("Nhà thiết kế:");
			String nhaThietKe = scn.nextLine();

			System.out.println("Giá:");
			Double gia = scn.nextDouble();

			SanPham p = new SanPham(id, ten, soLuong, nhaThietKe, gia);
			Main.sanPham.add(p);

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void thayDoiSanPham() {
		Scanner inputs = new Scanner(System.in);

		try {
			System.out.println("Nhập mã: ");
			Integer id = inputs.nextInt();
			SanPham product = null;

			for (SanPham p : Main.sanPham) {
				if (p.getIdSanPham().equals(id)) {
					product = p;
					break;
				}
			}

			if (product == null) {
				System.out.println("Mã sản phẩm không tồn tại. Xin vui lòng nhập lại!");
			}

			System.out.println("\t\t\t————————————————————————————Thông tin sản phẩm————————————————————————————");
			String header = String.format("\t\t\t%-7s%-25s%-15s%-15s%-20s", "Mã", "Tên", "Số lượng", "Giá",
					"Nhà Thiết Kế");
			System.out.println(header);
			String row = String.format("\t\t\t%-7d%-25s%-15d%-15.2f%-20s", product.getIdSanPham(),
					product.getTenSanPham(), product.getSoLuong(), product.getGia(), product.getNhaThietKe());
			System.out.println(row);
			System.out.println("\t\t\t——————————————————————————————————————————————————————————————————————————");

			for (int i = 0; i < Main.sanPham.size(); i++) {
				if (id.equals(Main.sanPham.get(i).getIdSanPham())) {

					inputs.nextLine();

					System.out.println("Nhập lại tên: ");
					String tenSanPham = inputs.nextLine();

					System.out.println("Chỉnh lại số lượng: ");
					int soLuong = inputs.nextInt();

					inputs.nextLine();

					System.out.println("Nhập lại nhà thiết kế:");
					String nhaThietKe = inputs.nextLine();

					System.out.println("Giá:");
					Double gia = inputs.nextDouble();

					Main.sanPham.get(i).setTenSanPham(tenSanPham);
					Main.sanPham.get(i).setSoLuong(soLuong);
					Main.sanPham.get(i).setNhaThietKe(nhaThietKe);
					Main.sanPham.get(i).setGia(gia);

				}
			}

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void xoaSanPham() {
		Scanner scn = new Scanner(System.in);

		try {
			System.out.println("Nhập mã: ");
			Integer id = scn.nextInt();
			SanPham product = null;

			for (SanPham p : Main.sanPham) {
				if (p.getIdSanPham().equals(id)) {
					product = p;
					break;
				}
			}

			if (product == null) {
				System.out.println("Mã sản phẩm không tồn tại. Xin vui lòng nhập lại!");
			}

			for (int i = 0; i < Main.sanPham.size(); i++) {
				if (id.equals(Main.sanPham.get(i).getIdSanPham())) {

					Main.sanPham.remove(i);

				}
			}

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void xemHoaDon() {
		System.out.println(
				"\t\t——————————————————————————————————————Danh sách đặt hàng———————————————————————————————————————");
		String header = String.format("\t\t %-7s%-20s%-20s%-15s%-20s%-25s", "Mã", "Tên khách hàng", "Ngày mua hàng",
				"Số điện thoại", "Email", "Địa chỉ");
		System.out.print(header);
		NhanVien nhanVien = new NhanVien();

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

				SanPham p = nhanVien.getByIdSP(od.getidSanPham());

				String orderDetailRow = String.format("\t\t %-7d%-20s%-20.2f%-15d%-20.2f", i, p.getTenSanPham(),
						od.getGia(), od.getSoLuong(), od.getGia() * od.getSoLuong());
				System.out.println(orderDetailRow);
				i++;
			}
		}
		System.out.println(
				"\t\t——————————————————————————————————————————————————————————————————————————————————————————————");

	}

	public void themDichVu() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Nhập thông tin dịch vụ:");

		try {
			System.out.print("Nhập mã dịch vụ: ");
			int idDichVu = scn.nextInt();

			scn.nextLine();

			System.out.println("Nhập tên dịch vụ : ");
			String tenDichVu = scn.nextLine();

			System.out.println("Nhập số lượng: ");
			int soLuong = scn.nextInt();

			scn.nextLine();

			System.out.println("Giá:");
			Double giaDichVu = scn.nextDouble();

			DichVu dv = new DichVu(idDichVu, tenDichVu, soLuong, giaDichVu);
			Main.dichVu.add(dv);

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void suaDichVu() {
		Scanner scn = new Scanner(System.in);

		try {
			System.out.println("Nhập mã: ");
			Integer id = scn.nextInt();
			DichVu dVu = null;

			for (DichVu dv : Main.dichVu) {
				if (dv.getIdDichVu().equals(id)) {
					dVu = dv;
					break;
				}
			}

			if (dVu == null) {
				System.out.println("Mã dịch vụ không tồn tại. Xin vui lòng nhập lại!");
			}

			System.out.println("\t\t\t————————————————————————————Thông tin dịch vụ————————————————————————————");
			String header = String.format("\t\t\t%-10s %-20s%-20s%-20s", "Mã", "Tên", "Số lượng", "Giá");
			System.out.println(header);
			String row = String.format("\t\t\t%-10s %-20s%-20s%-20s", dVu.getIdDichVu(), dVu.getTenDichVu(),
					dVu.getSoLuongDV(), dVu.getGiaDichVu());
			System.out.println(row);
			System.out.println("\t\t\t—————————————————————————————————————————————————————————————————————————");

			for (int i = 0; i < Main.dichVu.size(); i++) {
				if (id.equals(Main.dichVu.get(i).getIdDichVu())) {

					scn.nextLine();

					System.out.println("Nhập lại tên: ");
					String tenDichVu = scn.nextLine();

					System.out.println("Chỉnh lại số lượng: ");
					int soLuongDV = scn.nextInt();

					scn.nextLine();

					System.out.println("Giá:");
					Double giaDichVu = scn.nextDouble();

					Main.dichVu.get(i).setTenDichVu(tenDichVu);
					Main.dichVu.get(i).setSoLuongDV(soLuongDV);
					Main.dichVu.get(i).setGiaDichVu(giaDichVu);

				}
			}

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void xoaDichVu() {
		Scanner scn = new Scanner(System.in);

		try {
			System.out.println("Nhập mã: ");
			Integer id = scn.nextInt();
			DichVu dVu = null;

			for (DichVu dv : Main.dichVu) {
				if (dv.getIdDichVu().equals(id)) {
					dVu = dv;
					break;
				}
			}

			if (dVu == null) {
				System.out.println("Mã dịch vụ không tồn tại. Xin vui lòng nhập lại!");
			}

			for (int i = 0; i < Main.dichVu.size(); i++) {
				if (id.equals(Main.dichVu.get(i).getIdDichVu())) {

					Main.dichVu.remove(i);

				}
			}

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void donHangDV() {
		System.out.println(
				"\t\t——————————————————————————————————————Danh sách đặt hàng———————————————————————————————————————");
		String header = String.format("\t\t %-7s%-20s%-20s%-20s%-20s%-20s", "Mã", "Tên khách hàng", "Ngày mua hàng",
				"Số điện thoại", "Email", "Địa chỉ");
		System.out.println(header);
		NhanVien nhanVien = new NhanVien();

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

				DichVu p = nhanVien.getByIdDV(od.getidDichVu());

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
