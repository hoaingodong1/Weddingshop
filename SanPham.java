public class SanPham {
    private Integer idSanPham;
    private String tenSanPham;
    private Integer soLuong;
    private String nhaThietKe;
    private Double gia;

    public SanPham() {

    }

    public SanPham(Integer idSanPham, String tenSanPham, Integer soLuong, String nhaThietKe, Double gia) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.nhaThietKe = nhaThietKe;
        this.gia = gia;
    }

    public SanPham(String tenSanPham, Integer soLuong, String nhaThietKe, Double gia) {
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.nhaThietKe = nhaThietKe;
        this.gia = gia;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaThietKe() {
        return nhaThietKe;
    }

    public void setNhaThietKe(String nhaThietKe) {
        this.nhaThietKe = nhaThietKe;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

}