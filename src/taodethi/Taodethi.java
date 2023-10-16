

package taodethi;


import Thi.Thi;
import com.sun.jdi.connect.spi.Connection;
import doanltm.Home;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.util.Arrays;
import java.util.List;



    public class Taodethi extends javax.swing.JFrame {
        private ExamInfo examInfo;
    private String[] questions;
    private String[][] options;
    private int index = 0;
    private int correct = 0;
    private ButtonGroup buttonGroup1 = new ButtonGroup();
    private JTextField selectedTextField;
    private JRadioButton selectedRadioButton;
    private String[] selectedOptions;

    private String[] savedQuestions;
    private String[][] savedOptions;
    private String[] savedSelectedOptions;
    
    
     private boolean completed = false; // Thêm trường completed để kiểm tra hoàn thành bài trắc nghiệm


public int getSoLuongCauHoi() {
    return totalQuestions;
}
    public boolean isLastQuestion() {
        // Kiểm tra xem câu hỏi hiện tại có phải là câu hỏi cuối cùng hay không
        return index == questions.length - 1;
    }

    public boolean isCurrentQuestionAnswered() {
        // Kiểm tra xem đã có đáp án được chọn cho câu hỏi hiện tại hay chưa
        return selectedTextField != null;
    }
    

    public void saveAnswer() {
        // Lưu đáp án của câu hỏi hiện tại vào mảng selectedOptions
        String selectedOption = getSelectedOption(selectedTextField);
        selectedOptions[index] = selectedOption;
    }
     // Thêm phương thức để lưu câu trả lời của người dùng cho câu hỏi hiện tại
    public void saveUserAnswer(String selectedOption) {
        selectedOptions[index] = selectedOption;
    }

    // Thêm phương thức để đánh dấu hoàn thành bài trắc nghiệm
    public void markCompleted() {
        completed = true;
    }

    // Thêm phương thức để kiểm tra xem bài trắc nghiệm đã hoàn thành hay chưa
    public boolean isCompleted() {
        return completed;
    }
    
     private int totalQuestions; // Biến lưu trữ tổng số câu hỏi

   private int maxQuestionQuantity; // Số lượng câu hỏi tối đa mà người dùng đã chọn từ trang Home

    // ... (Các phương thức khác)

    public Taodethi(int maxQuestionQuantity) {
        initComponents();
        this.maxQuestionQuantity = maxQuestionQuantity;
        // ... (khởi tạo các thành phần khác của giao diện)
    }
        public static void setExamData(String[] createdQuestions, String[][] createdOptions) {
        instance.questions = createdQuestions;
        instance.options = createdOptions;
        instance.index = 0; // Đặt lại chỉ mục để hiển thị câu hỏi đầu tiên
        instance.displayQuestionAndOptions(); // Hiển thị câu hỏi và các tùy chọn
    }

private List<String> correctAnswers = new ArrayList<>();

     
 public String getQuestion(int index) {
        if (index >= 0 && index < questions.length) {
            return questions[index];
        } else {
            return null;
        }
    }

    
public void moveToNextQuestion() {
    if (!completed && index < questions.length - 1) {
        index++; // Tăng chỉ mục để chuyển đến câu hỏi tiếp theo
        displayQuestionAndOptions(); // Hiển thị câu hỏi và các tùy chọn mới
    }
}




  // Phương thức để lấy câu hỏi của câu hỏi tiếp theo
    public String getNextQuestion() {
        if (index < questions.length - 1) {
            return questions[index + 1];
        }
        return null;
    }

    // Phương thức để lấy tùy chọn A của câu hỏi tiếp theo
    public String getNextOptionA() {
        if (index < options.length - 1) {
            return options[index + 1][0];
        }
        return null;
    }

    // Phương thức để lấy tùy chọn B của câu hỏi tiếp theo
    public String getNextOptionB() {
        if (index < options.length - 1) {
            return options[index + 1][1];
        }
        return null;
    }

    // Phương thức để lấy tùy chọn C của câu hỏi tiếp theo
    public String getNextOptionC() {
        if (index < options.length - 1) {
            return options[index + 1][2];
        }
        return null;
    }

    // Phương thức để lấy tùy chọn D của câu hỏi tiếp theo
    public String getNextOptionD() {
        if (index < options.length - 1) {
            return options[index + 1][3];
        }
        return null;
    }
   
      public String getCorrectAnswer() {
        // Lấy đáp án đúng cho câu hỏi hiện tại
        return selectedOptions[index];
    }
    


    public String[] getCreatedQuestions() {
        return questions;
    }

    public String[][] getCreatedOptions() {
        return options;
    }
    
    public String getCurrentQuestion() {
    return questions[index];
}

    public String getCurrentOptionA() {
    return options[index][0];
   }

    public String getCurrentOptionB() {
    return options[index][1];
   }

    public String getCurrentOptionC() {
    return options[index][2];
   }

    public String getCurrentOptionD() {
    return options[index][3];
   }
    
    // ...
    
   



    
    private static Taodethi instance;

    private String currentQuestion;
    private String currentCorrectAnswer;
    private String currentUserAnswer; // Thêm thuộc tính lưu câu trả lời của người dùng

    

    public void setCurrentQuestion(String currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public String getCurrentCorrectAnswer() {
        return currentCorrectAnswer;
    }

    public void setCurrentCorrectAnswer(String currentCorrectAnswer) {
        this.currentCorrectAnswer = currentCorrectAnswer;
    }

    public String getCurrentUserAnswer() {
        return currentUserAnswer;
    }

   public void setCurrentUserAnswer(String questionIndex, String selectedOption) {
    int index = Integer.parseInt(questionIndex);
    if (index >= 0 && index < selectedOptions.length) {
        selectedOptions[index] = selectedOption;
    }
    
}
   
      
    public Taodethi() {
      initComponents();
    int width = 1080;  // Độ rộng mong muốn của JFrame
    int height = 800; // Độ cao mong muốn của JFrame
    setSize(width, height);

    totalQuestions = 4; // Giá trị mặc định, có thể thay đổi dựa vào giá trị người dùng chọn

    questions = new String[totalQuestions];
    options = new String[totalQuestions][4];

    // Đặt giá trị mặc định cho completed là false khi tạo trang Taodethi mới
    completed = false;

    // Reset các thông tin đã lưu trữ của đề thi trước đó
    resetSavedData();

    initializeExam();
    NextActionPerformed(null);
    }
    
       private void resetSavedData() {
    savedQuestions = null;
    savedOptions = null;
    savedSelectedOptions = null;
}

    private String currentOptionA;
    private String currentOptionB;
    private String currentOptionC;
    private String currentOptionD;
  

    // Các phương thức getter và setter cho các thuộc tính



   

   
    public void setCurrentOptionA(String currentOptionA) {
        this.currentOptionA = currentOptionA;
    }

   

    public void setCurrentOptionB(String currentOptionB) {
        this.currentOptionB = currentOptionB;
    }

   
    public void setCurrentOptionC(String currentOptionC) {
        this.currentOptionC = currentOptionC;
    }

 

    public void setCurrentOptionD(String currentOptionD) {
        this.currentOptionD = currentOptionD;
    }

  
    

      // Danh sách lưu trữ câu hỏi đã tạo
    private List<String> createdQuestions = new ArrayList<>();

    // Danh sách lưu trữ các đáp án đúng tương ứng với từng câu hỏi

      private List<String> userAnswers = new ArrayList<>();
private void saveQuestionAndCorrectAnswer(String question, String correctAnswer, String userAnswer) {
    createdQuestions.add(question);
    correctAnswers.add(correctAnswer);
    userAnswers.add(userAnswer); // Lưu câu trả lời của người dùng
}


   
    
     // Phương thức để thiết lập số lượng câu hỏi mà người dùng chọn từ combobox
    public void setTotalQuestions(int total) {
        totalQuestions = total;
        questions = new String[totalQuestions];
        options = new String[totalQuestions][4];
        index = 0; // Reset chỉ mục câu hỏi về 0 khi thay đổi số lượng câu hỏi
        initializeExam(); // Khởi tạo lại đề thi với số lượng câu hỏi mới
    }

    // ...

    public static void setExamData(String[] createdQuestions, String[][] createdOptions, int total) {
        instance.questions = createdQuestions;
        instance.options = createdOptions;
        instance.totalQuestions = total;
    }
      public static Taodethi getInstance() {
        if (instance == null) {
            instance = new Taodethi();
        }
        return instance;
    }
      

    public void initializeExam() {


         // Kiểm tra xem có thông tin câu hỏi và tùy chọn đã lưu trữ hay không
            if (savedQuestions != null && savedOptions != null && savedSelectedOptions != null) {
                questions = savedQuestions;
                options = savedOptions;
                selectedOptions = savedSelectedOptions;
            } else {
                // Lấy thông tin câu hỏi và tùy chọn từ cơ sở dữ liệu
                loadExamInfoFromDatabase();

                selectedOptions = new String[1000];
                Arrays.fill(selectedOptions, "");

                index = 0; // Đặt giá trị ban đầu của index là 0
                correct = 0;
                enableTextFields(true);
                selectedTextField = null;

                // Hiển thị câu hỏi và các tùy chọn của câu hỏi đầu tiên
                displayQuestionAndOptions();

                // Đặt giá trị ban đầu cho số câu hỏi
                Cauhoiso.setText(String.valueOf(index + 1));
            }
    }



    private void loadExamInfoFromDatabase() {
        
        try {
            // Kết nối đến cơ sở dữ liệu và truy vấn thông tin đề thi mới nhất
                 java.sql. Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
          Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM exam WHERE id = (SELECT MAX(id) FROM exam)";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String monhoc = rs.getString("monhoc");
                String maphongthi = rs.getString("maphongthi");
                String thoigianthi = rs.getString("thoigianthi");
                String soluongcauhoi = rs.getString("soluongcauhoi");
                String nguoitao = rs.getString("nguoitao");

                // Truy vấn các câu hỏi đã lưu trữ cho đề thi mới nhất
                String sqlQuestions = "SELECT cau_hoi FROM question WHERE id = " + rs.getInt("id");
                Statement stmtQuestions = conn.createStatement();
                ResultSet rsQuestions = stmtQuestions.executeQuery(sqlQuestions);
                int i = 0;
                while (rsQuestions.next()) {
                    questions[i] = rsQuestions.getString("cau_hoi");
                    i++;
                }

                // Truy vấn các tùy chọn đã lưu trữ cho đề thi mới nhất
                String sqlOptions = "SELECT dap_an_a, dap_an_b, dap_an_c, dap_an_d FROM `question` WHERE id = " + rs.getInt("id");
                Statement stmtOptions = conn.createStatement();
                ResultSet rsOptions = stmtOptions.executeQuery(sqlOptions);
                int j = 0;
                while (rsOptions.next()) {
                    options[j][0] = rsOptions.getString("dap_an_a");
                    options[j][1] = rsOptions.getString("dap_an_b");
                    options[j][2] = rsOptions.getString("dap_an_c");
                    options[j][3] = rsOptions.getString("dap_an_d");
                    j++;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
   public void displayQuestionAndOptions() {
        // Hiển thị câu hỏi và các tùy chọn tương ứng với chỉ mục hiện tại
        CauHoi.setText(questions[index]);
        jTextField_1.setText(options[index][0]);
        jTextField_2.setText(options[index][1]);
        jTextField_3.setText(options[index][2]);
        jTextField_4.setText(options[index][3]);

        // Hiển thị số câu hỏi
        Cauhoiso.setText(String.valueOf(index + 1));

        // Kiểm tra và chọn tùy chọn đã lưu trữ
        if (selectedOptions[index].equals("A")) {
            selectedRadioButton = jRadioButton1_1;
        } else if (selectedOptions[index].equals("B")) {
            selectedRadioButton = jRadioButton2_2;
        } else if (selectedOptions[index].equals("C")) {
            selectedRadioButton = jRadioButton3_3;
        } else if (selectedOptions[index].equals("D")) {
            selectedRadioButton = jRadioButton4_4;
        }

        if (selectedRadioButton != null) {
            selectedRadioButton.setSelected(true);
        }

        selectedTextField = null;
        enableTextFields(true);
    }
      public void displayCreatedQuestions(String[] questions, String[][] options) {
        this.questions = questions;
        this.options = options;
        index = 0;
        displayQuestionAndOptions();
    }

      public void saveExamToDatabase() {
        // Lưu thông tin đề thi vào cơ sở dữ liệu
        try {
            java.sql. Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
            Statement stmt = conn.createStatement();

            // Thêm thông tin đề thi vào bảng "exam"
            String sqlExam = "INSERT INTO exam (monhoc, maphongthi, thoigianthi, soluongcauhoi, nguoitao) VALUES ('" + examInfo.getMonHoc() + "', '" + examInfo.getMaPhongThi() + "', '" + examInfo.getThoiGian() + "', '" + examInfo.getSoLuongCauHoi() + "', '" + examInfo.getNguoiTaoDe() + "')";
            stmt.executeUpdate(sqlExam, Statement.RETURN_GENERATED_KEYS);

            // Lấy id của đề thi vừa được thêm
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            int examId = -1;
            if (generatedKeys.next()) {
                examId = generatedKeys.getInt(1);
            }

            // Thêm câu hỏi và tùy chọn vào bảng "question" và "options"
            for (int i = 0; i < index; i++) {
                String sqlQuestion = "INSERT INTO question (cau_hoi_so, cau_hoi, dap_an_a, dap_an_b, dap_an_c, dap_an_d, dap_an_dung, exam_id) VALUES ('" + (i + 1) + "', '" + questions[i] + "', '" + options[i][0] + "', '" + options[i][1] + "', '" + options[i][2] + "', '" + options[i][3] + "', '" + selectedOptions[i] + "', '" + examId + "')";
                stmt.executeUpdate(sqlQuestion);
               
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




private String getSelectedOption(JTextField selectedTextField) {
    if (selectedTextField == jTextField_1) {
            return "A";
        } else if (selectedTextField == jTextField_2) {
            return "B";
        } else if (selectedTextField == jTextField_3) {
            return "C";
        } else if (selectedTextField == jTextField_4) {
            return "D";
        } else {
            return null;
        }
}

    public void enableTextFields(boolean enable) {
        jTextField_1.setEnabled(enable);
        jTextField_2.setEnabled(enable);
        jTextField_3.setEnabled(enable);
        jTextField_4.setEnabled(enable);
    }

    public void setExamInfo(ExamInfo examInfo) {
     this.examInfo = examInfo;
    monhoc.setText(examInfo.getMonHoc());
    maphongthi.setText(examInfo.getMaPhongThi());
    Thoigian.setSelectedItem(examInfo.getThoiGian());
    Soluongcauhoi.setSelectedItem(examInfo.getSoLuongCauHoi());
    NguoiTao.setText(examInfo.getNguoiTaoDe());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        monhoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Soluongcauhoi = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        maphongthi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        NguoiTao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Thoigian = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Cauhoiso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CauHoi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField_1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField_3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField_4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton1_1 = new javax.swing.JRadioButton();
        jRadioButton2_2 = new javax.swing.JRadioButton();
        jRadioButton3_3 = new javax.swing.JRadioButton();
        jRadioButton4_4 = new javax.swing.JRadioButton();
        Luudapan = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Done = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TẠO BỘ CÂU HỎI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(393, 393, 393))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Môn Học");

        monhoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Số Lượng Câu Hỏi");

        Soluongcauhoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Soluongcauhoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", " ", " ", " ", " ", " ", " ", " " }));
        Soluongcauhoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoluongcauhoiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã Phòng Thi");

        maphongthi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Người Tạo ");

        NguoiTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Thời Gian");

        Thoigian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Thoigian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3\t", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36", "39", "42", "45", "48", "51", "54", "57", "60" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Phút");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Soluongcauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(248, 248, 248)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maphongthi, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(NguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Thoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(146, 146, 146))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maphongthi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Soluongcauhoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Câu Hỏi Số :");

        Cauhoiso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Cauhoiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CauhoisoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Câu Hỏi:");

        CauHoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CauHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CauHoiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Đáp Án:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("A");

        jTextField_1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("B");

        jTextField_2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("C");

        jTextField_3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("D");

        jTextField_4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_4ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Đáp Án Đúng:");

        jRadioButton1_1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1_1.setText("A");
        jRadioButton1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_1ActionPerformed(evt);
            }
        });

        jRadioButton2_2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2_2.setText("B");
        jRadioButton2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_2ActionPerformed(evt);
            }
        });

        jRadioButton3_3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton3_3.setText("C");
        jRadioButton3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3_3ActionPerformed(evt);
            }
        });

        jRadioButton4_4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton4_4.setText("D");
        jRadioButton4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4_4ActionPerformed(evt);
            }
        });

        Luudapan.setBackground(new java.awt.Color(255, 51, 0));
        Luudapan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Luudapan.setForeground(new java.awt.Color(255, 255, 255));
        Luudapan.setText("Lưu Đáp Án");
        Luudapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuudapanActionPerformed(evt);
            }
        });

        Next.setBackground(new java.awt.Color(102, 51, 0));
        Next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Next.setForeground(new java.awt.Color(255, 255, 255));
        Next.setText("Câu Hỏi Tiếp Theo");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        Back.setBackground(new java.awt.Color(0, 102, 255));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Câu Hỏi Trước ĐÓ");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Done.setBackground(new java.awt.Color(0, 153, 0));
        Done.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Done.setForeground(new java.awt.Color(255, 255, 255));
        Done.setText("Hoàn Tất");
        Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Luudapan)
                                .addGap(30, 30, 30)
                                .addComponent(Next)
                                .addGap(29, 29, 29)
                                .addComponent(Back))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField_1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cauhoiso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CauHoi, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                            .addComponent(jTextField_2)
                            .addComponent(jTextField_3)
                            .addComponent(jTextField_4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Done)
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Cauhoiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Done, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CauHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jRadioButton1_1))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2_2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioButton3_3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4_4))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Luudapan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(282, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    private String previousOption; // Biến lưu trữ lựa chọn trước đó
    
    private void restorePreviousOption() {
    if (previousOption != null) {
        switch (previousOption) {
            case "A":
                jRadioButton1_1.setSelected(true);
                break;
            case "B":
                jRadioButton2_2.setSelected(true);
                break;
            case "C":
                jRadioButton3_3.setSelected(true);
                break;
            case "D":
                jRadioButton4_4.setSelected(true);
                break;
            default:
                break;
        }
    }
}
    
    private void setSelectedOption(String selectedOption) {
    switch (selectedOption) {
        case "A":
            jRadioButton1_1.setSelected(true);
            break;
        case "B":
            jRadioButton2_2.setSelected(true);
            break;
        case "C":
            jRadioButton3_3.setSelected(true);
            break;
        case "D":
            jRadioButton4_4.setSelected(true);
            break;
        default:
            break;
    }
}
    
    


// Biến lưu trữ danh sách các tùy chọn đã tạo
private List<String[]> createdOptions = new ArrayList<>();

// Phương thức để lưu câu hỏi và tùy chọn đã tạo
private void saveCreatedQuestionAndOptions() {
    createdQuestions.add(CauHoi.getText());
    createdOptions.add(new String[]{
            jTextField_1.getText(),
            jTextField_2.getText(),
            jTextField_3.getText(),
            jTextField_4.getText()
    });
}

// Phương thức để khôi phục câu hỏi và tùy chọn từ danh sách đã tạo
private void restoreCreatedQuestionAndOptions(int index) {
    if (index < createdQuestions.size()) {
        CauHoi.setText(createdQuestions.get(index));
        jTextField_1.setText(createdOptions.get(index)[0]);
        jTextField_2.setText(createdOptions.get(index)[1]);
        jTextField_3.setText(createdOptions.get(index)[2]);
        jTextField_4.setText(createdOptions.get(index)[3]);
    }
}
    // Phương thức để xóa trường nhập liệu của câu hỏi hiện tại
private void clearQuestionFields() {
    CauHoi.setText("");
    jTextField_1.setText("");
    jTextField_2.setText("");
    jTextField_3.setText("");
    jTextField_4.setText("");
}

private void updateQuestionFields() {
    if (index >= 0 && index < questions.length) {
        CauHoi.setText(questions[index]);
        jTextField_1.setText(options[index][0]);
        jTextField_2.setText(options[index][1]);
        jTextField_3.setText(options[index][2]);
        jTextField_4.setText(options[index][3]);
    }
}
    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
     if (selectedTextField != null) {
        // Lưu đáp án trước khi chuyển sang câu hỏi tiếp theo
        saveAnswer();
    }

    if (index < questions.length - 1) {
        index++; // Chuyển đến câu hỏi tiếp theo
        clearQuestionFields(); // Xóa trường nhập liệu của câu hỏi hiện tại
        enableTextFields(true);

        // Lưu câu hỏi và tùy chọn đã tạo trước đó
        saveCreatedQuestionAndOptions();

        // Khôi phục câu hỏi và tùy chọn của câu hỏi tiếp theo
        restoreCreatedQuestionAndOptions(index);

        selectedTextField = null;
        Cauhoiso.setText(String.valueOf(index + 1)); // Cập nhật số câu hỏi hiện tại

        // Khôi phục lựa chọn trước đó
        restorePreviousOption();

        // Xóa kết quả câu hỏi trước đó
        clearSelectedRadioButton();

        // Kiểm tra và thiết lập lựa chọn đáp án đã được chọn
        String selectedOption = selectedOptions[index];
        if (selectedOption != null) {
            setSelectedOption(selectedOption);
        }

        // Kiểm tra và điều chỉnh trạng thái các nút điều hướng
        if (index == questions.length - 1) {
            Next.setEnabled(false); // Vô hiệu hóa nút "Next" nếu đó là câu hỏi cuối cùng
        }
        Back.setEnabled(true); // Kích hoạt nút "Prev" sau khi chuyển đến câu hỏi tiếp theo
    }

    updateQuestionFields(); // Cập nhật lại trạng thái của các trường nhập liệu
    }//GEN-LAST:event_NextActionPerformed
 
      private void clearSelectedRadioButton() {
         jRadioButton1_1.setSelected(false);
    jRadioButton2_2.setSelected(false);
    jRadioButton3_3.setSelected(false);
    jRadioButton4_4.setSelected(false);
      }
    
    private void jTextField_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_1ActionPerformed
          selectedTextField = jTextField_1;
    }//GEN-LAST:event_jTextField_1ActionPerformed

    private void jTextField_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_2ActionPerformed
        selectedTextField = jTextField_2;
    }//GEN-LAST:event_jTextField_2ActionPerformed

    private void jTextField_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_3ActionPerformed
         selectedTextField = jTextField_3;
    }//GEN-LAST:event_jTextField_3ActionPerformed

    private void jTextField_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_4ActionPerformed
        selectedTextField = jTextField_4;
    }//GEN-LAST:event_jTextField_4ActionPerformed

    private void jRadioButton1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_1ActionPerformed
        clearSelectedRadioButton();
    jRadioButton1_1.setSelected(true);
    }//GEN-LAST:event_jRadioButton1_1ActionPerformed

    private void jRadioButton2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_2ActionPerformed
    clearSelectedRadioButton();
    jRadioButton2_2.setSelected(true);
    }//GEN-LAST:event_jRadioButton2_2ActionPerformed

    private void jRadioButton3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3_3ActionPerformed
    clearSelectedRadioButton();
    jRadioButton3_3.setSelected(true);
    }//GEN-LAST:event_jRadioButton3_3ActionPerformed

    private void jRadioButton4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4_4ActionPerformed
     clearSelectedRadioButton();
    jRadioButton4_4.setSelected(true);
    }//GEN-LAST:event_jRadioButton4_4ActionPerformed

    private void CauHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CauHoiActionPerformed
          String question = CauHoi.getText();
        questions[index] = question;
        index++;
        CauHoi.setText(""); // Xóa nội dung câu hỏi sau khi đã lưu vào mảng

        // Thực hiện các xử lý khác hoặc chuyển đến câu hỏi tiếp theo
        // ...
    
    }//GEN-LAST:event_CauHoiActionPerformed

    private void SoluongcauhoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoluongcauhoiActionPerformed
       
    }//GEN-LAST:event_SoluongcauhoiActionPerformed
    
    private int count = 0;
    private void CauhoisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CauhoisoActionPerformed
          count++; // Tăng số câu hỏi lên 1
          Cauhoiso.setText(String.valueOf(count)); // Hiển thị số câu hỏi trong trường Cauhoiso
    }//GEN-LAST:event_CauhoisoActionPerformed

    
    
    private void saveQuestionToDatabase(String question, String optionA, String optionB, String optionC, String optionD, String correctOption) {
    // Kết nối đến cơ sở dữ liệu và lưu câu hỏi vào bảng tương ứng

    try {
        
        java.sql. Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        String sql = "INSERT INTO question  (cau_hoi, dap_an_a, dap_an_b, dap_an_c, dap_an_d, dap_an_dung) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, question);
        stmt.setString(2, optionA);
        stmt.setString(3, optionB);
        stmt.setString(4, optionC);
        stmt.setString(5, optionD);
        stmt.setString(6, correctOption);
        stmt.executeUpdate();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

      
    private void LuudapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuudapanActionPerformed
  String question = CauHoi.getText();
    String optionA = jTextField_1.getText();
    String optionB = jTextField_2.getText();
    String optionC = jTextField_3.getText();
    String optionD = jTextField_4.getText();
    String selectedOption = "";

    if (question.isEmpty() || optionA.isEmpty() || optionB.isEmpty() || optionC.isEmpty() || optionD.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ thông tin câu hỏi và đáp án!");
        return; // Không tiến hành lưu nếu thông tin chưa được điền đầy đủ
    }

    // Kiểm tra xem đáp án nào được chọn
    if (jRadioButton1_1.isSelected()) {
        selectedOption = "A";
    } else if (jRadioButton2_2.isSelected()) {
        selectedOption = "B";
    } else if (jRadioButton3_3.isSelected()) {
        selectedOption = "C";
    } else if (jRadioButton4_4.isSelected()) {
        selectedOption = "D";
    }

    // Kiểm tra xem người dùng đã chọn đáp án hay chưa
    if (!selectedOption.isEmpty()) {
        // Kiểm tra đáp án được chọn có đúng hay không
        if (selectedOption.equals(options[index][3])) {
            correct++;
        }

        // Lưu câu hỏi vào cơ sở dữ liệu
        saveQuestionToDatabase(question, optionA, optionB, optionC, optionD, selectedOption);
        
        // Lưu thông tin câu hỏi và các lựa chọn đáp án vào mảng
        questions[index] = question;
        options[index][0] = optionA;
        options[index][1] = optionB;
        options[index][2] = optionC;
        options[index][3] = optionD;

        selectedOptions[index] = selectedOption;
        JOptionPane.showMessageDialog(this, "Câu hỏi đã được lưu!");

        // Hiển thị lại câu hỏi và các lựa chọn đáp án trong textfield
        CauHoi.setText(question);
        jTextField_1.setText(optionA);
        jTextField_2.setText(optionB);
        jTextField_3.setText(optionC);
        jTextField_4.setText(optionD);
    } else {
        JOptionPane.showMessageDialog(this, "Hãy chọn một đáp án!");
    }
    }//GEN-LAST:event_LuudapanActionPerformed
    
    private void restoreQuestionFields() {
    if (index >= 0 && index < questions.length) {
        CauHoi.setText(questions[index]);
        jTextField_1.setText(options[index][0]);
        jTextField_2.setText(options[index][1]);
        jTextField_3.setText(options[index][2]);
        jTextField_4.setText(options[index][3]);
    }
}
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
     if (selectedTextField != null) {
        // Lưu đáp án trước khi chuyển sang câu hỏi trước
        saveAnswer();
    }

    if (index > 0) {
        index--; // Chuyển đến câu hỏi trước đó
        clearQuestionFields(); // Xóa trường nhập liệu của câu hỏi hiện tại
        enableTextFields(true);

        // Khôi phục câu hỏi và tùy chọn của câu hỏi trước đó
        restoreCreatedQuestionAndOptions(index);

        selectedTextField = null;
        Cauhoiso.setText(String.valueOf(index + 1)); // Cập nhật số câu hỏi hiện tại

        // Khôi phục lựa chọn trước đó
        restorePreviousOption();

        // Xóa kết quả câu hỏi trước đó
        clearSelectedRadioButton();

        // Kiểm tra và thiết lập lựa chọn đáp án đã được chọn
        String selectedOption = selectedOptions[index];
        if (selectedOption != null) {
            setSelectedOption(selectedOption);
        }

        // Kiểm tra và điều chỉnh trạng thái các nút điều hướng
        if (index == 0) {
            Back.setEnabled(false); // Vô hiệu hóa nút "Prev" nếu đó là câu hỏi đầu tiên
        }
        Next.setEnabled(true); // Kích hoạt nút "Next" sau khi chuyển đến câu hỏi trước đó
    }

    updateQuestionFields(); // Cập nhật lại trạng thái của các trường nhập liệu
    }//GEN-LAST:event_BackActionPerformed

    
    private boolean isQuestionInfoComplete() {
    if (CauHoi.getText().isEmpty() || jTextField_1.getText().isEmpty() || jTextField_2.getText().isEmpty() ||
            jTextField_3.getText().isEmpty() || jTextField_4.getText().isEmpty()) {
        return false; // Trả về false nếu có ít nhất một trường thông tin câu hỏi chưa được nhập
    }
    return true; // Trả về true nếu tất cả các trường thông tin câu hỏi đã được nhập đầy đủ
}
    private Home homePage;
    private void DoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneActionPerformed
    // Lấy danh sách câu hỏi và tùy chọn đã tạo từ trang Taodethi
    String[] createdQuestions = getCreatedQuestions();
    String[][] createdOptions = getCreatedOptions();

    // Trở về trang Home
    Home home = Home.getInstance();
    home.displayCreatedQuestions(createdQuestions, createdOptions);
    home.setVisible(true);

    // Tải câu hỏi lên bảng jTable2 sau khi hiển thị câu hỏi trên bảng jTable1
    home.loadQuestionsToTable();

    this.dispose();
    }//GEN-LAST:event_DoneActionPerformed

    
    private void saveExamInfoToDatabase(ExamInfo examInfo) {
    try {
        // Kết nối đến cơ sở dữ liệu và lưu thông tin câu hỏi vào bảng tương ứng
        
        java.sql. Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "");
        String sql = "INSERT INTO exam (monhoc, maphongthi, thoigianthi, soluongcauhoi, nguoitao) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, examInfo.getMonHoc());
        stmt.setString(2, examInfo.getMaPhongThi());
        stmt.setString(3, examInfo.getThoiGian());
        stmt.setString(4, examInfo.getSoLuongCauHoi());
        stmt.setString(5, examInfo.getNguoiTaoDe());
        stmt.executeUpdate();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Taodethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Taodethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Taodethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Taodethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Taodethi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField CauHoi;
    private javax.swing.JTextField Cauhoiso;
    private javax.swing.JButton Done;
    private javax.swing.JButton Luudapan;
    private javax.swing.JButton Next;
    private javax.swing.JTextField NguoiTao;
    private javax.swing.JComboBox<String> Soluongcauhoi;
    private javax.swing.JComboBox<String> Thoigian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1_1;
    private javax.swing.JRadioButton jRadioButton2_2;
    private javax.swing.JRadioButton jRadioButton3_3;
    private javax.swing.JRadioButton jRadioButton4_4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_1;
    private javax.swing.JTextField jTextField_2;
    private javax.swing.JTextField jTextField_3;
    private javax.swing.JTextField jTextField_4;
    private javax.swing.JTextField maphongthi;
    private javax.swing.JTextField monhoc;
    // End of variables declaration//GEN-END:variables

   public void displayCreatedQuestions() {
    if (questions != null && options != null) {
        // Hiển thị câu hỏi và tùy chọn tại vị trí hiện tại trong mảng
        String question = questions[index];
        String[] optionList = options[index];
        
        // TODO: Hiển thị câu hỏi và tùy chọn trên giao diện
        
      
    }
}


    public boolean isDisplayed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDisplayed(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String[] getSelectedOptions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    

    public String[] getOptions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  public int getIndex() {
    return index;
}
private int[] correctAnswerPositions;
    public int[] getCorrectAnswerPositions() {
        return correctAnswerPositions;
    }

 // Phương thức để lưu thông tin vị trí đáp án đúng
    public void setCorrectAnswerPositions(int[] positions) {
        correctAnswerPositions = positions;
    }
   
    
}
