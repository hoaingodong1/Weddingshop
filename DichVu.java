public class DichVu {
    private Integer idDichVu;
    private String tenDichVu;
    private Double giaDichVu;
    private Integer soLuongDV;

    public DichVu() {

    };

    public DichVu(Integer idDichVu, String tenDichVu, Integer soLuongDV, Double giaDichVu) {
        this.idDichVu = idDichVu;
        this.tenDichVu = tenDichVu;
        this.soLuongDV = soLuongDV;
        this.giaDichVu = giaDichVu;
    }

    public Integer getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Integer idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Double getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(Double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }

    public Integer getSoLuongDV() {
        return soLuongDV;
    }

    public void setSoLuongDV(Integer soLuongDV) {
        this.soLuongDV = soLuongDV;
    }
}
