
package doanltm;
import CLIENT.MyConnection;
import org.apache.commons.codec.digest.DigestUtils;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SignUp extends javax.swing.JFrame {

   

 
    public SignUp() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jhovaten = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        gioitinh = new javax.swing.JLabel();
        radio_btn_nam = new javax.swing.JRadioButton();
        radio_btn_nu = new javax.swing.JRadioButton();
        ngaysinh = new javax.swing.JLabel();
        Register = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Ngaysinh = new com.toedter.calendar.JDateChooser();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();

        jScrollPane1.setViewportView(jEditorPane1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Ký");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doanltm/pngtree-quiz-time-png-image_6125411 (1).png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("CHIA SẺ ĐỀ VÀ THI TRẮC NGHIỆM");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Copyright © company name All rights reserved");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 590);

        jPanel3.setBackground(new java.awt.Color(25, 118, 211));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Họ và Tên");

        jhovaten.setBackground(new java.awt.Color(25, 118, 211));
        jhovaten.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jhovaten.setForeground(new java.awt.Color(204, 204, 204));
        jhovaten.setBorder(null);
        jhovaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhovatenActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Email");

        jemail.setBackground(new java.awt.Color(25, 118, 211));
        jemail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jemail.setForeground(new java.awt.Color(204, 204, 204));
        jemail.setBorder(null);
        jemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jemailActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Mật khẩu");

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Nhập lại mật khẩu");

        gioitinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gioitinh.setForeground(new java.awt.Color(204, 204, 204));
        gioitinh.setText("Giới tính");

        radio_btn_nam.setBackground(new java.awt.Color(25, 118, 211));
        radio_btn_nam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radio_btn_nam.setForeground(new java.awt.Color(204, 204, 204));
        radio_btn_nam.setText("Nam");

        radio_btn_nu.setBackground(new java.awt.Color(25, 118, 211));
        radio_btn_nu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radio_btn_nu.setForeground(new java.awt.Color(204, 204, 204));
        radio_btn_nu.setText("Nữ");

        ngaysinh.setBackground(new java.awt.Color(102, 102, 102));
        ngaysinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ngaysinh.setForeground(new java.awt.Color(204, 204, 204));
        ngaysinh.setText("Ngày sinh");

        Register.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Register.setForeground(new java.awt.Color(25, 118, 211));
        Register.setText("Đăng Ký");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Đăng Nhập");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Bạn có tài khoản rồi");

        Ngaysinh.setBackground(new java.awt.Color(25, 118, 211));

        jPasswordField1.setBackground(new java.awt.Color(25, 118, 211));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordField1.setBorder(null);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jPasswordField2.setBackground(new java.awt.Color(25, 118, 211));
        jPasswordField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordField2.setBorder(null);
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel5)
                    .addComponent(jhovaten, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jemail, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(gioitinh)
                        .addGap(18, 18, 18)
                        .addComponent(radio_btn_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio_btn_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ngaysinh)
                    .addComponent(Ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Register, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jhovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gioitinh)
                    .addComponent(radio_btn_nam)
                    .addComponent(radio_btn_nu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngaysinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 420, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LOGIN LOGINFrame = new LOGIN();
        LOGINFrame.setVisible(true);
        LOGINFrame.pack();
        LOGINFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private static final String AES_KEY = "thisIsASecretKey";  // Thay thế bằng khóa AES thật sự

    // Hàm mã hóa dữ liệu sử dụng AES
    private static String encrypt(String data, String key) {
        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    private boolean isValidName(String name) {
    // Kiểm tra họ và tên không chứa ký tự đặc biệt
    String pattern = "^[a-zA-Z\\s]+$";
    return name.matches(pattern);
}

private boolean isValidEmail(String email) {
    // Kiểm tra định dạng email là @gmail.com
    String pattern = "^[a-zA-Z0-9]+@gmail\\.com$";
    return email.matches(pattern);
}

private boolean isValidPassword(String password) {
    // Kiểm tra mật khẩu có ít nhất 6 ký tự
    return password.length() >= 6;
}
    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
      String name = jhovaten.getText();
    String email = jemail.getText();
    String pass = String.valueOf(jPasswordField1.getPassword());
    String re_pass = String.valueOf(jPasswordField2.getPassword());
    String birthdate = null;
    String gender;

    setEmail(email);
    if (radio_btn_nam.isSelected()) {
        gender = "Nam";
    } else {
        gender = "Nữ";
    }

    if (name.equals("") || email.equals("") || pass.equals("")) {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
    } else if (!isValidName(name)) {
        JOptionPane.showMessageDialog(null, "Họ và tên không được chứa ký tự đặc biệt!");
    } else if (!isValidEmail(email)) {
        JOptionPane.showMessageDialog(null, "Email không hợp lệ! Hãy sử dụng định dạng @gmail.com");
    } else if (!isValidPassword(pass)) {
        JOptionPane.showMessageDialog(null, "Mật khẩu phải có ít nhất 6 ký tự!");
    } else if (!pass.equals(re_pass)) {
        JOptionPane.showMessageDialog(null, "Bạn đã không nhập trùng mật khẩu. Vui lòng nhập lại!");
    } else if (checkEmail(email)) {
        JOptionPane.showMessageDialog(null, "Email này đã tồn tại. Vui lòng nhập lại!");
    } else {
        if (Ngaysinh.getDate() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            birthdate = dateFormat.format(Ngaysinh.getDate());

            PreparedStatement ps;
            String query = "INSERT INTO `users`(`full_name`, `email`, `password`, `confirm_password`, `gender`, `date_of_birth`) VALUES (?,?,?,?,?,?)";
            try {
                ps = MyConnection.getConnection().prepareStatement(query);

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, DigestUtils.sha256Hex(pass)); // Mã hóa và băm mật khẩu
                ps.setString(4, DigestUtils.sha256Hex(re_pass)); // Mã hóa và băm re_pass
                ps.setString(5, gender);

                if (birthdate != null) {
                    ps.setString(6, birthdate);
                }

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    // ...
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            String otp = CreateOTP();
            setOTP(otp);
            
            OTPSend(email, otp);
            //sendData();
            OTPCheck otpCheckFrame = new OTPCheck();
            otpCheckFrame.setVisible(true);
            otpCheckFrame.pack();
            otpCheckFrame.setLocationRelativeTo(null);
            long time = getTime();
            otpCheckFrame.reveiceData(name, email, pass, re_pass, gender, birthdate, otp, time);
            
            this.dispose();
        }
    }
    }//GEN-LAST:event_RegisterActionPerformed

    private void jemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jemailActionPerformed

    private void jhovatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhovatenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jhovatenActionPerformed

   //kiem Tra Email
    public boolean checkEmail(String email) {
        java.sql.PreparedStatement ps;
        java.sql.ResultSet rs;
        boolean kiemtrae = false;
        String query = "SELECT * FROM `users` WHERE `email`= ?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, email);

            rs = ps.executeQuery();
            if (rs.next()) {
                kiemtrae = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kiemtrae;
    }

    //Tao OTP
    public String CreateOTP() {
        Random random = new Random();
        int OTP = 10000000 + random.nextInt(90000000);
        String SendOTP = String.valueOf(OTP);
        return SendOTP;
    }

    //GUi OTP
    public void OTPSend(String Email, String OTP) {
        String host = "smtp.gmail.com";
        String username = "doanlaptringmang@gmail.com";
        String password = "xwipctnttixcsezg";
        int port = 587;
        boolean useTLS = true;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", useTLS);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

      try {
            // Tạo đối tượng Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));
            message.setSubject("Xác Thực tài khoản Email");
            message.setText("Mã OTP của bạn là :" + OTP + " Thời gian có hiệu lực của mã OTP là 3 phút tính từ thời điểm hiện tại : " + OTPStartTime);

            System.out.print(" Địa chỉ Email là : " + Email);
            System.out.println(" Mã OTP của bạn là: " + OTP + " Thời gian có hiệu lực của mã OTP là 3 phút.");

            // Gửi email
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Mã OTP đã được gửi tới địa chỉ email của bạn.");
            System.out.println("Email sent successfully.");
            long StartTime = System.currentTimeMillis();
            setTime(StartTime);
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Địa chỉ email không hợp lệ");
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
    public long OTPStartTime;
    private String OTP;
    private String Email;
    public void setTime(long time){
    this.OTPStartTime = time;
    }
    public long getTime(){
    return this.OTPStartTime;
    }

    public String getOTP() {
        return this.OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }
    public String getEmail(){
     return this.Email;
    }
    public void setEmail(String Email){
    this.Email = Email;
    }
    
    
  
    
    
    
    
    
    
    
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Ngaysinh;
    private javax.swing.JButton Register;
    private javax.swing.JLabel gioitinh;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jhovaten;
    private javax.swing.JLabel ngaysinh;
    private javax.swing.JRadioButton radio_btn_nam;
    private javax.swing.JRadioButton radio_btn_nu;
    // End of variables declaration//GEN-END:variables

    private static class Myconnection {

        private static Object getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public Myconnection() {
        }
    }
}
