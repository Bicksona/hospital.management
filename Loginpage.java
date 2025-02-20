//package Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Loginpage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField edtId;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Loginpage frame = new Loginpage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Loginpage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 905, 774);

        // Create a layered pane for layering components
        //JLayeredPane layeredPane = new JLayeredPane();
        //setContentPane(layeredPane);
        //layeredPane.setLayout(null);

        // Load the background image
        //ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/whts.jpg")); // Ensure the correct path
        //JLabel backgroundLabel = new JLabel(new ImageIcon(
                //backgroundImage.getImage().getScaledInstance(897, 773, Image.SCALE_SMOOTH)
        //));
        backgroundLabel.setBounds(0, 0, 897, 773);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        contentPane = new JPanel();
        contentPane.setBorder(null);
        contentPane.setOpaque(false);
        contentPane.setBounds(0, 0, 897, 726);
        layeredPane.add(contentPane, JLayeredPane.PALETTE_LAYER);
        contentPane.setLayout(null);
                                        
                                        JPanel panel = new JPanel();
                                        panel.setBackground(new Color(255, 255, 255));
                                        
                                        panel.setBorder(new LineBorder(new Color(51, 153, 255)));
                                        
                                        panel.setBounds(244, 199, 371, 280);
                                        contentPane.add(panel);
                                        panel.setLayout(null);
                                        
                                        JLabel lblNewLabel = new JLabel("Login");
                                        lblNewLabel.setForeground(new Color(0, 102, 255));
                                        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                                        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
                                        lblNewLabel.setBounds(89, 10, 171, 58);
                                        panel.add(lblNewLabel);
                                        
                                                JLabel lblNewLabel_1 = new JLabel("PATIENT ID:");
                                                lblNewLabel_1.setForeground(new Color(0, 102, 255));
                                                lblNewLabel_1.setBounds(10, 89, 128, 56);
                                                panel.add(lblNewLabel_1);
                                                lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 17));
                                                
                                                        edtId = new JTextField();
                                                        edtId.setBounds(137, 99, 206, 41);
                                                        panel.add(edtId);
                                                        edtId.setFont(new Font("Tahoma", Font.BOLD, 12));
                                                        edtId.setColumns(10);
                                                        
                                                                JButton sub = new JButton("SUBMIT");
                                                                sub.setForeground(new Color(255, 255, 255));
                                                                sub.setBounds(27, 183, 136, 41);
                                                                panel.add(sub);
                                                                sub.setBackground(new Color(0, 102, 255));
                                                                sub.addActionListener(new ActionListener() {
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        try {
                                                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital?useSSL=false", "Aswin", "root");
                                                                            String Id = edtId.getText();
                                                                            Statement stm = con.createStatement();
                                                                            String sql = "SELECT * FROM hospital WHERE Id ='" + Id + "'";
                                                                            ResultSet rs = stm.executeQuery(sql);

                                                                            Interface2 details = new Interface2();
                                                                            if (Id.isEmpty()) {
                                                                            	JOptionPane.showMessageDialog(Loginpage.this, "Please Enter a Patient ID");
                                                                      
                                                                            }else if (rs.next()) {
                                                                            	details.frame.setVisible(true);
                                                                                String name = rs.getString(2);
                                                                                details.labelname.setText(name);

                                                                                String agee = rs.getString(3);
                                                                                details.age.setText(agee);

                                                                                String sex = rs.getString(4);
                                                                                details.variblesex.setText(sex);

                                                                                String address = rs.getString(5);
                                                                                details.add.setText(address);

                                                                                String lastVisit = rs.getString(6);
                                                                                details.last.setText(lastVisit);

                                                                                String reason = rs.getString(7);
                                                                                details.rea.setText(reason);

                                                                                String doctorName = rs.getString(8);
                                                                                details.dname.setText(doctorName);

                                                                                String medicine = rs.getString(9);
                                                                                details.mg.setText(medicine);

                                                                                String amountPaid = rs.getString(10);
                                                                                details.amt.setText(amountPaid);

                                                                                dispose();
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(Loginpage.this, "Invalid ID, please try again.");
                                                                            }
                                                                        } catch (Exception a) {
                                                                            System.out.println(a.getMessage());
                                                                        }
                                                                    }

                                                                            
                                                                });
                                                                sub.setFont(new Font("Verdana", Font.BOLD, 14));
                                                                
                                                                        JButton cl = new JButton("CLEAR");
                                                                        cl.setForeground(new Color(255, 255, 255));
                                                                        cl.setBounds(207, 183, 136, 41);
                                                                        panel.add(cl);
                                                                        cl.setBackground(new Color(0, 102, 255));
                                                                        cl.setFont(new Font("Verdana", Font.BOLD, 14));
                                        cl.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                edtId.setText("");
                                               //resultLabel.setText("");
                                            }
                                        });
    }
}
