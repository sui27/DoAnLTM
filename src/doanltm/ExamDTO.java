
package doanltm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExamDTO {
    private String monHoc;
    private String maPhongThi;
    private String thoiGian;
    private String soLuongCauHoi; // Đổi kiểu dữ liệu thành int
    private String nguoiTaoDe;
    private Connection connection;
    private int id;

    public ExamDTO(String monHoc, String maPhongThi, String thoiGian, String soLuongCauHoi, String nguoiTaoDe) {
        this.monHoc = monHoc;
        this.maPhongThi = maPhongThi;
        this.thoiGian = thoiGian;
        this.soLuongCauHoi = soLuongCauHoi;
        this.nguoiTaoDe = nguoiTaoDe;
    }
public ExamDTO(Connection connection, String monHoc, String maPhongThi, String thoiGian, String soLuongCauHoi, String nguoiTaoDe) {
        this.connection = connection;
        this.monHoc = monHoc;
        this.maPhongThi = maPhongThi;
        this.thoiGian = thoiGian;
        this.soLuongCauHoi = soLuongCauHoi;
        this.nguoiTaoDe = nguoiTaoDe;
    }
public String updateExam(ExamDTO exam) {
    String message = ""; // Khởi tạo thông báo mặc định
    String query = "UPDATE exam SET monhoc = ?, maphongthi = ?, thoigianthi = ?, soluongcauhoi = ?, nguoitao = ? WHERE id = ?";
    
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, exam.getMonHoc());
        statement.setString(2, exam.getMaPhongThi());
        statement.setString(3, exam.getThoiGian());
        statement.setString(4, exam.getSoLuongCauHoi());
        statement.setString(5, exam.getNguoiTaoDe());
        statement.setInt(6, exam.getId());
        
        int rowsUpdated = statement.executeUpdate();
    

        if (rowsUpdated > 0) {
            message = "Cập nhật thông tin đề thi thành công";
        } else {
            message = "Không có bản ghi nào được cập nhật";
        }
    } catch (SQLException e) {
        message = "Lỗi khi cập nhật thông tin đề thi: " + e.getMessage();
        // ...
    }
    
    return message;
}

 public int getId() {
    return id; // Trả về giá trị thực tế của id
}
public void setId(int id) {
    this.id = id;
}

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
