
package Thi;

import doanltm.Home;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import taodethi.Taodethi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;


public class Thi extends javax.swing.JFrame {
     private String monHoc;
    private String maPhongThi;
    private String thoiGian;
    private String soLuongCauHoi;
    private String nguoiTaoDe;

    String username = Home.getInstance().getCurrentUsername();
    String gender = Home.getInstance().getCurrentGender();

    private int index = 0;
    private Object selectedTextField;
    private ButtonGroup buttonGroup;

    private int countdownTimeInSeconds;
    private int secondsRemaining;
    private Timer timer;
    
    private List<String> userAnswers = new ArrayList<>();private ArrayList<String> questions = new ArrayList<>(); // Khởi tạo danh sách câu hỏi
    private ArrayList<String> ketQuaDungCuaCauHoi = new ArrayList<>(); // Khởi tạo danh sách câu trả lời đúng
    private List<String> correctAnswers = new ArrayList<>();
     
      // Phương thức để thêm câu hỏi và đáp án đúng vào danh sách
private void saveQuestionAndCorrectAnswer(String question, String correctAnswer, String userAnswer) {
    questions.add(question);
    ketQuaDungCuaCauHoi.add(correctAnswer);
    userAnswers.add(userAnswer); // Lưu trữ câu trả lời của người dùng
}
private void loadQuestionFromTaodethi() {
   questions.clear();
    ketQuaDungCuaCauHoi.clear();

    String[] createdQuestions = Taodethi.getInstance().getCreatedQuestions();
    String[][] createdOptions = Taodethi.getInstance().getCreatedOptions();

    // Kiểm tra xem đã lấy dữ liệu thành công chưa
    if (createdQuestions != null && createdOptions != null) {
        // Xóa danh sách câu hỏi và câu trả lời đúng đang có (nếu có)
        questions.clear();
        ketQuaDungCuaCauHoi.clear();

        // In thông tin câu hỏi và tùy chọn để kiểm tra
        System.out.println("Số câu hỏi từ Taodethi: " + createdQuestions.length);
        for (int i = 0; i < createdQuestions.length; i++) {
            System.out.println("Câu hỏi " + (i + 1) + ": " + createdQuestions[i]);
            System.out.println("Tùy chọn A: " + createdOptions[i][0]);
            System.out.println("Tùy chọn B: " + createdOptions[i][1]);
            System.out.println("Tùy chọn C: " + createdOptions[i][2]);
            System.out.println("Tùy chọn D: " + createdOptions[i][3]);

            String question = createdQuestions[i];

            // TODO: Truy vấn đáp án đúng từ cơ sở dữ liệu dựa trên câu hỏi hiện tại
            String correctAnswer = getCorrectAnswerFromDatabase(question);

            saveQuestionAndCorrectAnswer(question, correctAnswer, null); // Đáp án của người dùng chưa biết nên truyền là null
        }

        // Kiểm tra lại số câu hỏi và số đáp án đúng sau khi lưu vào danh sách
        System.out.println("Số câu hỏi sau khi lưu vào danh sách: " + questions.size());
        System.out.println("Số đáp án đúng sau khi lưu vào danh sách: " + ketQuaDungCuaCauHoi.size());
    }
}
private String getCorrectAnswerFromDatabase(String question) {
     String correctAnswer = ""; // Khởi tạo biến để lưu đáp án đúng

    try {
        // Kết nối đến cơ sở dữ liệu và truy vấn thông tin câu hỏi
        java.sql. Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        Statement stmt = conn.createStatement();
        String sql = "SELECT cau_hoi, dap_an_dung FROM question";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String dbQuestion = rs.getString("cau_hoi"); // Lấy câu hỏi từ cơ sở dữ liệu
            String dbCorrectAnswer = rs.getString("dap_an_dung"); // Lấy đáp án đúng từ cơ sở dữ liệu
            
            // So sánh câu hỏi trong cơ sở dữ liệu với câu hỏi truyền vào
            if (dbQuestion.equals(question)) {
                correctAnswer = dbCorrectAnswer; // Lưu đáp án đúng nếu câu hỏi trùng khớp
                break; // Dừng vòng lặp khi tìm thấy đáp án đúng
            }
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return correctAnswer;
}



    public Thi() {
     
       
     // Khởi tạo danh sách câu hỏi và câu trả lời đúng
    questions = new ArrayList<>();
    ketQuaDungCuaCauHoi = new ArrayList<>();
    userAnswers = new ArrayList<>(); // Thêm dòng này để khởi tạo danh sách userAnswers



    // Gọi phương thức initQuestions() để thêm các câu hỏi và câu trả lời đúng vào danh sách
    initQuestions();
        // Khởi tạo Timer và cập nhật thời gian đếm ngược
    timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateClockLabel();
        }
    });
    timer.start();
        initComponents();
         // Tạo một nhóm nút radio để nhóm các nút radio lại với nhau
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);
         
        options = new String[4][4];
      
         
        Taodethi taodethi = Taodethi.getInstance();
        String question = taodethi.getCurrentQuestion();
        String optionA = taodethi.getCurrentOptionA();
        String optionB = taodethi.getCurrentOptionB();
        String optionC = taodethi.getCurrentOptionC();
        String optionD = taodethi.getCurrentOptionD();

// Cập nhật thông tin câu hỏi và các lựa chọn lên giao diện
updateQuestionAndOptions(question, optionA, optionB, optionC, optionD);

 



    
    }
 public void setCountdownTime(int minutes) {
    this.countdownTimeInSeconds = minutes * 60;
    this.secondsRemaining = countdownTimeInSeconds;
    updateClockLabel();
}

       public void setExamInfo(String monHoc, String maPhongThi, String thoiGian, String soLuongCauHoi, String nguoiTaoDe) {
        // Thiết lập thông tin vào các thành phần tương ứng trên trang Thi
        this.monHoc = monHoc;
        this.maPhongThi = maPhongThi;
        this.thoiGian = thoiGian;
        this.soLuongCauHoi = soLuongCauHoi;
        this.nguoiTaoDe = nguoiTaoDe;

        monhoc.setText(monHoc);
        maphongthi.setText(maPhongThi);
        Thoigian.setSelectedItem(thoiGian);
        Soluongcauhoi.setSelectedItem(soLuongCauHoi);
        NguoiTao.setText(nguoiTaoDe);

        // Vô hiệu hóa việc chỉnh sửa các thành phần giao diện
        monhoc.setEditable(false);
        monhoc.setForeground(Color.BLACK); // Đặt màu chữ là đen
        maphongthi.setEditable(false);
        maphongthi.setForeground(Color.BLACK);
        Thoigian.setEditable(false);
        Thoigian.setForeground(Color.BLACK);
        Soluongcauhoi.setEditable(false);
        Soluongcauhoi.setForeground(Color.BLACK);
        NguoiTao.setEditable(false);
        NguoiTao.setForeground(Color.BLACK);
    }


  public void setUserInfo(String username, String gender) {
        this.username = username;
        this.gender = gender;

        nguoidung.setText(username);

        if (gender != null) {
            switch (gender) {
                case "Nam":
                    nam.setSelected(true);
                    nu.setSelected(false);
                    nu.setEnabled(false);
                    nu.setForeground(Color.BLACK);// Vô hiệu hóa radio button "Nữ"
                    break;
                case "Nữ":
                    nam.setSelected(false);
                    nu.setSelected(true);
                    nam.setEnabled(false);
                    nam.setForeground(Color.BLACK);// Vô hiệu hóa radio button "Nam"
                    break;
                default:
                    nam.setSelected(false);
                    nu.setSelected(false);
                    nam.setEnabled(true); // Kích hoạt lại radio button "Nam"
                    nu.setEnabled(true); // Kích hoạt lại radio button "Nữ"
                    break;
            }
        } else {
            nam.setSelected(false);
            nu.setSelected(false);
            nam.setEnabled(true); // Kích hoạt lại radio button "Nam"
            nu.setEnabled(true); // Kích hoạt lại radio button "Nữ"
        }
    }
    
    public void updateQuestionAndOptions(String question, String optionA, String optionB, String optionC, String optionD) {
      Cauhoiso.setText(String.valueOf(index + 1));
    CauHoi.setText(question);
    jTextField_1.setText(optionA);
    jTextField_2.setText(optionB);
    jTextField_3.setText(optionC);
    jTextField_4.setText(optionD);

    // Xóa tất cả màu nền của các JTextField đáp án
    jTextField_1.setBackground(null);
    jTextField_2.setBackground(null);
    jTextField_3.setBackground(null);
    jTextField_4.setBackground(null);

    // Đặt selection cho nhóm nút radio về null để xóa kết quả đã chọn
    buttonGroup.clearSelection();

    // Đánh dấu là chưa chọn đáp án mới
    isAnswerSelected = false;
}

private void updateClockLabel() {
    // Chuyển đổi số giây còn lại thành số phút
    int minutes = secondsRemaining / 60;
    int seconds = secondsRemaining % 60;

    // Cập nhật đồng hồ đếm ngược lên JLabel demgioo
    demgioo.setText(String.format("%02d:%02d", minutes, seconds));

    // Giảm số giây còn lại đi 1 sau mỗi lần cập nhật
    secondsRemaining--;

    // Kiểm tra nếu số giây còn lại nhỏ hơn 0 thì dừng Timer
    if (secondsRemaining < 0) {
        timer.stop();
        isStarted = false; // Đánh dấu là đã kết thúc làm bài

        // Ghi nhận thời gian kết thúc làm bài
        endTime = System.currentTimeMillis();

        // Tính thời gian làm bài (tính bằng giây)
        long timeTakenInSeconds = (endTime - startTime) / 1000;

        // Hiển thị thông báo về thời gian làm bài (ví dụ: in ra console)
        System.out.println("Thời gian làm bài: " + timeTakenInSeconds + " giây");

        // Xử lý khi đồng hồ đếm ngược kết thúc
        // Ví dụ: hiển thị thông báo hoặc thực hiện hành động nào đó
        JOptionPane.showMessageDialog(this, "Đã hết thời gian!");
    }
}





private boolean isStarted = false; // Biến để kiểm tra xem bắt đầu làm bài hay chưa
private long startTime; // Thời gian bắt đầu làm bài
private long endTime;   // Thời gian kết thúc làm bài

 private void ThoigianActionPerformed(java.awt.event.ActionEvent evt) {
    // Lấy thời gian đã chọn từ ComboBox và cập nhật lại giá trị countdownTimeInSeconds
    String selectedTime = Thoigian.getSelectedItem().toString();
    int selectedTimeInSeconds = Integer.parseInt(selectedTime) * 60;
    countdownTimeInSeconds = selectedTimeInSeconds;
    secondsRemaining = countdownTimeInSeconds;

    // Kiểm tra xem đã bắt đầu làm bài chưa
    if (!isStarted) {
        // Ghi nhận thời gian bắt đầu làm bài
        startTime = System.currentTimeMillis();
        isStarted = true;
    }

    // Cập nhật lại đồng hồ đếm ngược
    updateClockLabel();
}
 
  
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        Cauhoiso = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        HEADER2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nguoidung = new javax.swing.JTextField();
        nam = new javax.swing.JRadioButton();
        nu = new javax.swing.JRadioButton();
        HEADER1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        monhoc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Thoigian = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        maphongthi = new javax.swing.JTextField();
        NguoiTao = new javax.swing.JTextField();
        Soluongcauhoi = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        CauHoi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField_1 = new javax.swing.JTextField();
        demgioo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField_3 = new javax.swing.JTextField();
        jTextField_4 = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        xemketqua = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField_2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\letra\\Downloads\\2904768.png")); // NOI18N
        jLabel1.setText("THI TRẮC NGHIỆM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(601, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Cauhoiso.setBackground(new java.awt.Color(255, 0, 0));
        Cauhoiso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cauhoiso.setForeground(new java.awt.Color(255, 255, 255));
        Cauhoiso.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 0)));
        Cauhoiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CauhoisoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Câu Hỏi Số:");

        HEADER2.setBackground(new java.awt.Color(255, 255, 255));
        HEADER2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true), "Thông Tin Thí Sinh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16), new java.awt.Color(51, 102, 255))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Giới Tính");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Tên Thí Sinh");

        nguoidung.setEditable(false);
        nguoidung.setBackground(new java.awt.Color(255, 255, 204));
        nguoidung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nguoidung.setBorder(null);

        nam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nam.setText("Nam");

        nu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nu.setText("Nữ");

        javax.swing.GroupLayout HEADER2Layout = new javax.swing.GroupLayout(HEADER2);
        HEADER2.setLayout(HEADER2Layout);
        HEADER2Layout.setHorizontalGroup(
            HEADER2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HEADER2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HEADER2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HEADER2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HEADER2Layout.createSequentialGroup()
                        .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        HEADER2Layout.setVerticalGroup(
            HEADER2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HEADER2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(HEADER2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(nguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(HEADER2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(nam)
                    .addComponent(nu))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        HEADER1.setBackground(new java.awt.Color(255, 255, 255));
        HEADER1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 2, true), "Thông Tin Đề Thi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Môn Học");

        monhoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Số Lượng Câu Hỏi");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Thời Gian");

        Thoigian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Thoigian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3\t", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36", "39", "42", "45", "48", "51", "54", "57", "60" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Phút");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Người Tạo");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Mã Phòng Thi");

        maphongthi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        NguoiTao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Soluongcauhoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Soluongcauhoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", " ", " ", " ", " ", " ", " ", " " }));

        javax.swing.GroupLayout HEADER1Layout = new javax.swing.GroupLayout(HEADER1);
        HEADER1.setLayout(HEADER1Layout);
        HEADER1Layout.setHorizontalGroup(
            HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HEADER1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monhoc)
                    .addComponent(Thoigian, 0, 138, Short.MAX_VALUE)
                    .addComponent(Soluongcauhoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HEADER1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NguoiTao, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(maphongthi))
                        .addContainerGap())
                    .addGroup(HEADER1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        HEADER1Layout.setVerticalGroup(
            HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HEADER1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(maphongthi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(NguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Soluongcauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(HEADER1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(Thoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(27, 27, 27))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Câu Hỏi:");

        CauHoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CauHoi.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thi/huhuhi.png"))); // NOI18N
        jLabel3.setText("Thời Gian:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Chọn Đáp Án");

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton1.setText("A");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jTextField_1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_1.setBorder(null);
        jTextField_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_1ActionPerformed(evt);
            }
        });

        demgioo.setBackground(new java.awt.Color(0, 255, 255));
        demgioo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        demgioo.setText("sdadad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(HEADER1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(HEADER2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Cauhoiso, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(demgioo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(240, 240, 240))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(CauHoi)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jSeparator2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HEADER1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HEADER2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Cauhoiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(demgioo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jRadioButton1)
                    .addComponent(jTextField_1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton2.setText("B");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton3.setText("C");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jRadioButton4.setText("D");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jTextField_3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_3.setBorder(null);

        jTextField_4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_4.setBorder(null);

        btnExit.setBackground(new java.awt.Color(204, 0, 51));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Kết Thúc");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        xemketqua.setBackground(new java.awt.Color(0, 153, 153));
        xemketqua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        xemketqua.setForeground(new java.awt.Color(255, 255, 255));
        xemketqua.setText("Xem Kết Quả");
        xemketqua.setBorder(null);
        xemketqua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemketquaActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(255, 204, 0));
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNext.setText("Câu Tiếp Theo");
        btnNext.setBorder(null);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jTextField_2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField_2.setBorder(null);
        jTextField_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_2ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\letra\\OneDrive\\Documents\\5231719.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(xemketqua, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_3, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_4, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 557, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4))
                .addGap(64, 64, 64)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xemketqua, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(167, 167, 167))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
     Taodethi taodethi = Taodethi.getInstance();

    // Kiểm tra xem bài thi đã hoàn thành hay chưa
    if (!taodethi.isCompleted()) {
        int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn kết thúc bài thi chưa hoàn thành?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            // Trở về trang Home
            Home home = Home.getInstance();
            home.setVisible(true);
            this.dispose();
        }
    } else {
        // Trở về trang Home
        Home home = Home.getInstance();
        home.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_btnExitActionPerformed

private String getSelectedOption(int index) {
    JRadioButton[] radioButtons = {jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4};

    if (index >= 0 && index < radioButtons.length && radioButtons[index].isSelected()) {
        // Lấy ra đáp án đã chọn
        return String.valueOf((char) ('A' + index));
    }

    return null;
}

private String convertToAnswerKey(String userAnswer) {
    if (userAnswer.equals("A")) {
        return jRadioButton1.getText();
    } else if (userAnswer.equals("B")) {
        return jRadioButton2.getText();
    } else if (userAnswer.equals("C")) {
        return jRadioButton3.getText();
    } else if (userAnswer.equals("D")) {
        return jRadioButton4.getText();
    } else {
        return ""; // Trường hợp không xác định, có thể xử lý thêm tùy ý
    }
}


private void updateAnswerTextFields(String optionA, String optionB, String optionC, String optionD) {
    jTextField_1.setText(optionA);
    jTextField_2.setText(optionB);
    jTextField_3.setText(optionC);
    jTextField_4.setText(optionD);
}
private int[] tinhKetQua() {
    int soCauDung = 0;
    int soCauSai = 0;

    // Debug: In ra giá trị của danh sách ketQuaDungCuaCauHoi và userAnswers
    System.out.println("Danh sách đáp án đúng của câu hỏi: " + ketQuaDungCuaCauHoi);
    System.out.println("Danh sách đáp án người dùng chọn: " + userAnswers);

    for (int i = 0; i < ketQuaDungCuaCauHoi.size(); i++) {
        String correctAnswer = ketQuaDungCuaCauHoi.get(i);
        String userAnswer = userAnswers.get(i);

        // Chuyển đổi đáp án người dùng chọn và đáp án đúng về cùng một định dạng
        String convertedUserAnswer = convertToAnswerKey(userAnswer);

        // Debug: In ra đáp án đúng và đáp án người dùng chọn cho từng câu hỏi
        System.out.println("Correct Answer: " + correctAnswer + ", User Answer: " + convertedUserAnswer);

        if (correctAnswer.equals(convertedUserAnswer)) {
            soCauDung++;
        } else {
            soCauSai++;
        }
    }

    return new int[] { soCauDung, soCauSai };
}

    private void xemketquaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemketquaActionPerformed
     // Gọi phương thức tính kết quả
    int[] ketQua = tinhKetQua();
    int soCauDung = ketQua[0];
    int soCauSai = ketQua[1];

    // Kiểm tra nếu danh sách câu hỏi không trống
    if (!questions.isEmpty()) {
        // Tính điểm dựa trên số câu đúng (tổng điểm là 10)
        int diemChoMoiCauDung = 10 / questions.size();
        int diem = diemChoMoiCauDung * soCauDung;

        // Tạo đối tượng ketquathi và hiển thị kết quả lên trang ketquathi
        ketquathi ketQuaThiInstance = new ketquathi();
        // Hiển thị thời gian làm bài trên trang ketquathi
        
        // Tính và gán hạng
        int rank = calculateRank(diem); // Tính toán hạng dựa trên điểm
        ketQuaThiInstance.setTimeTaken(countdownTimeInSeconds - secondsRemaining);
        ketQuaThiInstance.setRank(rank); // Đặt hạng

        ketQuaThiInstance.setInfo(username, soCauDung, soCauSai, diem, rank); // Thay 1 bằng rank
        ketQuaThiInstance.setVisible(true);
        
        // Lấy thời gian làm bài
        int thoiGianLamBai = countdownTimeInSeconds - secondsRemaining;

        // Lưu kết quả vào cơ sở dữ liệu
        saveResultToDatabase(username, soCauDung, soCauSai, thoiGianLamBai, diem, rank);
    } else {
        // Hiển thị thông báo nếu không có câu hỏi nào
        JOptionPane.showMessageDialog(this, "Không có câu hỏi nào được thêm vào!");
    }
    }//GEN-LAST:event_xemketquaActionPerformed
private int calculateRank(int diem) {
    // Truy vấn cơ sở dữ liệu để lấy danh sách điểm từ bảng kết quả
    List<Integer> danhSachDiem = getScoresFromDatabase();
    
    // Đếm số lượng điểm lớn hơn điểm của người dùng (không bằng)
    long count = danhSachDiem.stream().filter(score -> score > diem).count();
    
    // Xác định hạng của người chơi dựa trên số lượng điểm lớn hơn điểm của họ và cộng thêm 1
    int rank = (int) count + 1;
    
    return rank;
}
private List<Integer> getScoresFromDatabase() {
   List<Integer> danhSachDiem = new ArrayList<>();
    
    try {
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        String query = "SELECT diem FROM result WHERE diem > 0"; // Chỉ lấy điểm khác 0
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
            int diem = rs.getInt("diem");
            danhSachDiem.add(diem);
        }
        
        rs.close();
        pstmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return danhSachDiem;
}

    
    
public void saveResultToDatabase(String username, int soCauDung, int soCauSai, int thoiGianLamBai, float diem,int rank) {
    try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "")) {
       
        
        String sql = "INSERT INTO result (ten_nguoi_dung, so_cau_dung, so_cau_sai, thoi_gian_lam_bai, diem, xep_hang) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, soCauDung);
            pstmt.setInt(3, soCauSai);
            pstmt.setInt(4, thoiGianLamBai);
            pstmt.setFloat(5, diem);
            pstmt.setInt(6, rank);

            pstmt.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
 


    // Phương thức để xóa tất cả các đáp án đúng trong danh sách
    private void clearCorrectAnswers() {
        correctAnswers.clear();
    }
    private List<String> createdQuestions = new ArrayList<>();
public void initQuestions() {
   

    // Gọi phương thức loadQuestionFromTaodethi để lấy câu hỏi và đáp án đúng từ trang Taodethi
    loadQuestionFromTaodethi();

    // Kiểm tra xem có câu hỏi nào được thêm vào không
    if (questions.isEmpty()) {
        // Không có câu hỏi nào được thêm vào
        // Xử lý tùy ý, ví dụ:
        JOptionPane.showMessageDialog(this, "Không có câu hỏi nào được thêm vào!");
    } else {
        // Có câu hỏi được thêm vào
        // Đoạn mã kiểm tra nếu câu hỏi và câu trả lời đúng đã được ánh xạ thành công
        System.out.println("Số câu hỏi: " + questions.size());
        System.out.println("Số đáp án đúng: " + ketQuaDungCuaCauHoi.size());

        // Khởi tạo danh sách câu trả lời của người dùng để đảm bảo số lượng câu trả lời bằng số lượng câu hỏi
        for (int i = 0; i < questions.size(); i++) {
            userAnswers.add("");
        }

        // Gọi các phương thức khác để xử lý tiếp theo nếu cần
    }
}




public void addQuestion(String question, String correctAnswer, String[] options) {
    questions.add(question);
    ketQuaDungCuaCauHoi.add(correctAnswer);
    // Lưu trữ các tùy chọn trực tiếp vào danh sách questionOptions
    
}

    private String[][] options;
      public void enableTextFields(boolean enable) {
        jTextField_1.setEnabled(enable);
        jTextField_2.setEnabled(enable);
        jTextField_3.setEnabled(enable);
        jTextField_4.setEnabled(enable);
    }
    
      
    
    
    
     
     private String previousOption; // Biến lưu trữ lựa chọn trước đó

private void restorePreviousOption() {
    if (previousOption != null) {
        switch (previousOption) {
            case "A":
                jRadioButton1.setSelected(true);
                break;
            case "B":
                jRadioButton2.setSelected(true);
                break;
            case "C":
                jRadioButton3.setSelected(true);
                break;
            case "D":
                jRadioButton4.setSelected(true);
                break;
            default:
                break;
        }
    }
}
private void setSelectedOption(String selectedOption) {
    clearSelectedRadioButton(); // Đặt trạng thái ban đầu cho các nút radio
    clearTextFields(); // Xóa nội dung các trường JTextField
    switch (selectedOption) {
        case "A":
            jRadioButton1.setSelected(true);
            break;
        case "B":
            jRadioButton2.setSelected(true);
            break;
        case "C":
            jRadioButton3.setSelected(true);
            break;
        case "D":
            jRadioButton4.setSelected(true);
            break;
        default:
            break;
    }
}

private void clearTextFields() {
    jTextField_1.setText("");
    jTextField_2.setText("");
    jTextField_3.setText("");
    jTextField_4.setText("");
}


private void clearSelectedRadioButton() {
    // Đặt selection cho nhóm nút radio về null để xóa kết quả đã chọn
    buttonGroup.clearSelection();
}

private boolean isFinished = false; // Biến để lưu trạng thái hoàn thành bài trắc nghiệm

// ...
 private boolean isLastQuestion = false;
   // Phương thức stopCountdownTime dùng để dừng đồng hồ đếm ngược
    private void stopCountdownTime() {
        // Dừng Timer
        timer.stop();
    }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
    Taodethi taodethi = Taodethi.getInstance();

    // Kiểm tra xem người dùng đã nhấn nút "Next" ở câu cuối cùng hay chưa
    if (taodethi.isLastQuestion()) {
        // Thay đổi trạng thái nút "Next" thành "Hoàn thành" và hiển thị thông báo
        btnNext.setText("Hoàn thành");
        JOptionPane.showMessageDialog(this, "Bạn đã hoàn thành bài trắc nghiệm!. Chọn xem kết quả để biết điểm!");
        taodethi.markCompleted(); // Đánh dấu bài trắc nghiệm đã hoàn thành

        // Dừng đồng hồ đếm ngược khi hoàn thành
        stopCountdownTime();
    } else {
        // Nếu không phải câu hỏi cuối cùng, tiếp tục chuyển đến câu hỏi tiếp theo

        // Xóa lựa chọn button chỉ khi di chuyển đến câu hỏi tiếp theo
        clearSelectedRadioButton();

        // Lấy câu hỏi và các tùy chọn tiếp theo từ trang Taodethi
        String question = taodethi.getNextQuestion();
        String optionA = taodethi.getNextOptionA();
        String optionB = taodethi.getNextOptionB();
        String optionC = taodethi.getNextOptionC();
        String optionD = taodethi.getNextOptionD();

        // Cập nhật câu hỏi và các tùy chọn lên trang thi
        updateQuestionAndOptions(question, optionA, optionB, optionC, optionD);

        // Cập nhật giá trị của các textfield đáp án
        updateAnswerTextFields(optionA, optionB, optionC, optionD);

        // Nếu không phải câu hỏi cuối cùng, tiếp tục chuyển đến câu hỏi tiếp theo
        taodethi.moveToNextQuestion();

        // Cập nhật lại số câu hỏi hiện tại trên giao diện
        int currentQuestionNumber = taodethi.getIndex();
        Cauhoiso.setText(String.valueOf(currentQuestionNumber + 1)); // Tăng 1 để hiển thị số câu hỏi theo thứ tự từ 1, 2, 3,...

        // Reset trạng thái cho việc chọn đáp án mới
        isAnswerSelected = false;
        enableAnswerSelection();

        // Cập nhật lại đồng hồ đếm ngược sau khi chuyển đến câu hỏi tiếp theo
        updateClockLabel();
    }
    }//GEN-LAST:event_btnNextActionPerformed

    private void enableAnswerSelection() {
    jRadioButton1.setEnabled(true);
    jRadioButton2.setEnabled(true);
    jRadioButton3.setEnabled(true);
    jRadioButton4.setEnabled(true);
    
    // Đặt lại biến kiểm tra đã chọn đáp án về false
    isAnswerSelected = false;
}
    private void jTextField_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_2ActionPerformed
   
    }//GEN-LAST:event_jTextField_2ActionPerformed

    private void jTextField_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_1ActionPerformed
     
    }//GEN-LAST:event_jTextField_1ActionPerformed
// Phương thức để cập nhật đáp án người dùng
private void updateUserAnswer(int questionIndex, String selectedAnswer) {
    userAnswers.set(questionIndex, selectedAnswer);
}

// Phương thức để vô hiệu hóa tất cả các nút lựa chọn đáp án
private void disableAnswerSelection() {
    jRadioButton1.setEnabled(false);
    jRadioButton2.setEnabled(false);
    jRadioButton3.setEnabled(false);
    jRadioButton4.setEnabled(false);
}

// Phương thức để lấy đáp án người dùng đã chọn cho câu hỏi hiện tại
// Phương thức để lấy đáp án người dùng đã chọn cho câu hỏi hiện tại
private String getSelectedAnswer() {
    if (jRadioButton1.isSelected()) {
        return "A";
    } else if (jRadioButton2.isSelected()) {
        return "B";
    } else if (jRadioButton3.isSelected()) {
        return "C";
    } else if (jRadioButton4.isSelected()) {
        return "D";
    } else {
        return null; // Trường hợp không có đáp án nào được chọn
    }
}
    private boolean isAnswerSelected = false;
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
 if (jRadioButton1.isSelected()) {
      if (jRadioButton1.isSelected() && !isAnswerSelected) {
        String selectedOption = "A"; // Đáp án A được chọn
        String correctAnswer = Taodethi.getInstance().getCorrectAnswer();

        // Cập nhật màu sắc cho tất cả các textfield đáp án
        jTextField_1.setBackground(selectedOption.equals(correctAnswer) ? Color.GREEN : Color.RED);
        jTextField_2.setBackground("B".equals(correctAnswer) ? Color.GREEN : Color.RED);
        jTextField_3.setBackground("C".equals(correctAnswer) ? Color.GREEN : Color.RED);
        jTextField_4.setBackground("D".equals(correctAnswer) ? Color.GREEN : Color.RED);

        // Lưu đáp án người dùng chọn vào danh sách userAnswers
        int currentQuestionIndex = Taodethi.getInstance().getIndex();
        updateUserAnswer(currentQuestionIndex, selectedOption);

        // Vô hiệu hóa tất cả các nút lựa chọn sau khi đã chọn một đáp án
        disableAnswerSelection();

        // Đánh dấu là đã chọn đáp án
        isAnswerSelected = true;
      }
 }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       if (jRadioButton2.isSelected()) {
        String selectedOption = "B"; // Đáp án B được chọn
        String correctAnswer = Taodethi.getInstance().getCorrectAnswer();

        // Cập nhật màu sắc cho tất cả các textfield đáp án
        jTextField_1.setBackground("A".equals(correctAnswer) ? Color.GREEN : "A".equals(selectedOption) ? Color.RED :Color.RED);
        jTextField_2.setBackground(selectedOption.equals(correctAnswer) ? Color.GREEN : Color.RED);
        jTextField_3.setBackground("C".equals(correctAnswer) ? Color.GREEN : "C".equals(selectedOption) ? Color.RED : Color.RED);
        jTextField_4.setBackground("D".equals(correctAnswer) ? Color.GREEN : "D".equals(selectedOption) ? Color.RED : Color.RED);
         // Lưu đáp án người dùng chọn vào danh sách userAnswers
        int currentQuestionIndex = Taodethi.getInstance().getIndex();
        updateUserAnswer(currentQuestionIndex, selectedOption);

        // Vô hiệu hóa tất cả các nút lựa chọn sau khi đã chọn một đáp án
        disableAnswerSelection();

        // Đánh dấu là đã chọn đáp án
        isAnswerSelected = true;
    }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
    if (jRadioButton3.isSelected()) {
        String selectedOption = "C"; // Đáp án C được chọn
        String correctAnswer = Taodethi.getInstance().getCorrectAnswer();

        // Cập nhật màu sắc cho tất cả các textfield đáp án
        jTextField_1.setBackground("A".equals(correctAnswer) ? Color.GREEN : "A".equals(selectedOption) ? Color.RED : Color.RED);
        jTextField_2.setBackground("B".equals(correctAnswer) ? Color.GREEN : "B".equals(selectedOption) ? Color.RED : Color.RED);
        jTextField_3.setBackground(selectedOption.equals(correctAnswer) ? Color.GREEN : Color.RED);
        jTextField_4.setBackground("D".equals(correctAnswer) ? Color.GREEN : "D".equals(selectedOption) ? Color.RED : Color.RED);
       // Lưu đáp án người dùng chọn vào danh sách userAnswers
        int currentQuestionIndex = Taodethi.getInstance().getIndex();
        updateUserAnswer(currentQuestionIndex, selectedOption);

        // Vô hiệu hóa tất cả các nút lựa chọn sau khi đã chọn một đáp án
        disableAnswerSelection();

        // Đánh dấu là đã chọn đáp án
        isAnswerSelected = true;
    }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
    if (jRadioButton4.isSelected()) {
        String selectedOption = "D"; // Đáp án D được chọn
        String correctAnswer = Taodethi.getInstance().getCorrectAnswer();

        // Cập nhật màu sắc cho tất cả các textfield đáp án
        jTextField_1.setBackground("A".equals(correctAnswer) ? Color.GREEN : "A".equals(selectedOption) ? Color.RED : Color.RED);
        jTextField_2.setBackground("B".equals(correctAnswer) ? Color.GREEN : "B".equals(selectedOption) ? Color.RED : Color.RED);
        jTextField_3.setBackground("C".equals(correctAnswer) ? Color.GREEN : "C".equals(selectedOption) ? Color.RED : Color.RED);
        jTextField_4.setBackground(selectedOption.equals(correctAnswer) ? Color.GREEN : Color.RED);
       // Lưu đáp án người dùng chọn vào danh sách userAnswers
        int currentQuestionIndex = Taodethi.getInstance().getIndex();
        updateUserAnswer(currentQuestionIndex, selectedOption);

        // Vô hiệu hóa tất cả các nút lựa chọn sau khi đã chọn một đáp án
        disableAnswerSelection();

        // Đánh dấu là đã chọn đáp án
        isAnswerSelected = true;
    }
    }//GEN-LAST:event_jRadioButton4ActionPerformed




    private void CauhoisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CauhoisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CauhoisoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Thi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CauHoi;
    private javax.swing.JTextField Cauhoiso;
    private javax.swing.JPanel HEADER1;
    private javax.swing.JPanel HEADER2;
    private javax.swing.JTextField NguoiTao;
    private javax.swing.JComboBox<String> Soluongcauhoi;
    private javax.swing.JComboBox<String> Thoigian;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel demgioo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField_1;
    private javax.swing.JTextField jTextField_2;
    private javax.swing.JTextField jTextField_3;
    private javax.swing.JTextField jTextField_4;
    private javax.swing.JTextField maphongthi;
    private javax.swing.JTextField monhoc;
    private javax.swing.JRadioButton nam;
    private javax.swing.JTextField nguoidung;
    private javax.swing.JRadioButton nu;
    private javax.swing.JButton xemketqua;
    // End of variables declaration//GEN-END:variables


   
}
