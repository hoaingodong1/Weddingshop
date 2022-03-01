import java.util.List;
import java.util.ArrayList;

public class HoaDon {
	private Integer idHoaDon;
	private String tenKhachHang;
	private String ngayMuaHang;
	private String sdt;
	private String email;
	private String diaChi;

	private List<ChiTietHoaDon> chiTietHoaDon = new ArrayList<ChiTietHoaDon>();
	private List<ChiTietHoaDonDV> chiTietHoaDonDV = new ArrayList<ChiTietHoaDonDV>();

	public HoaDon() {

	}

	public HoaDon(Integer idHoaDon, String tenKhachHang, String ngayMuaHang, String sdt, String email, String diaChi) {
		this.idHoaDon = idHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.ngayMuaHang = ngayMuaHang;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Integer getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(Integer id) {
		this.idHoaDon = idHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(List<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public List<ChiTietHoaDonDV> getChiTietHoaDonDV() {
		return chiTietHoaDonDV;
	}

	public void setChiTietHoaDonDV(List<ChiTietHoaDonDV> chiTietHoaDonDV) {
		this.chiTietHoaDonDV = chiTietHoaDonDV;
	}

	public String getNgayMuaHang() {
		return ngayMuaHang;
	}

	public void setNgayMuaHang(String ngayMuaHang) {
		this.ngayMuaHang = ngayMuaHang;

	}

}