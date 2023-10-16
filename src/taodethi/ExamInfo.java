
package taodethi;


public class ExamInfo {

    public ExamInfo(String string) {
    }
    private String monHoc;
    private String maPhongThi;
    private String thoiGian;
    private String soLuongCauHoi;
    private String nguoiTaoDe;
private String[] questions;
private String[][] options;
private String[] selectedOptions;
   private String[] createdQuestions;
    private String[][] createdOptions;
    
    public ExamInfo() {
        // Constructor không tham số
    }
    
    
     public String[] getCreatedQuestions() {
        return createdQuestions;
    }

    public void setCreatedQuestions(String[] createdQuestions) {
        this.createdQuestions = createdQuestions;
    }

    public String[][] getCreatedOptions() {
        return createdOptions;
    }

    public void setCreatedOptions(String[][] createdOptions) {
        this.createdOptions = createdOptions;
    }
    
    // Các phương thức khác
    
    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public String[][] getOptions() {
        return options;
    }

    public void setOptions(String[][] options) {
        this.options = options;
    }
    // Các thuộc tính khác của đề thi

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getMaPhongThi() {
        return maPhongThi;
    }

    public void setMaPhongThi(String maPhongThi) {
        this.maPhongThi = maPhongThi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
  
    public String getSoLuongCauHoi() {
        return soLuongCauHoi;
    }

    public void setSoLuongCauHoi(String soLuongCauHoi) {
        this.soLuongCauHoi = soLuongCauHoi;
    }

    public String getNguoiTaoDe() {
        return nguoiTaoDe;
    }

    public void setNguoiTaoDe(String nguoiTaoDe) {
        this.nguoiTaoDe = nguoiTaoDe;
    }

  
}


