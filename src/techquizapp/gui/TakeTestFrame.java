/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import techquizapp.dao.PerformanceDAO;
import techquizapp.dao.QuestionDao;
import techquizapp.pojo.Answer;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;
import javax.swing.ImageIcon;
/**
 *
 * @author hp
 */
public class TakeTestFrame extends javax.swing.JFrame {

    private Exam exam;
    private QuestionStore qstore;
    private AnswerStore astore;  
    private int qno,pos=0;

    
    public TakeTestFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUsername.setText("Hello "+UserProfile.getUsername());
        qstore=new QuestionStore();
        astore=new AnswerStore();
        qno=1;
        lblQno.setText(lblQno.getText()+qno);
    }
    public TakeTestFrame(Exam exam) {
        this();
        this.exam=exam;
        lblTitle.setText(exam.getLanguage().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();
        SplashThread1 sp = new SplashThread1();
        sp.start();
    }
    class SplashThread1 extends Thread
{
   public void run()
   {      
       try     
          {
             int count=1;
             int sec;
             String str;
            while(count>=0)
            {
                    sec=59;
                         while(sec>=0)
                         {
                             if(sec / 10==0)
                                 str="0"+count+":"+"0"+sec+" left";
                             else
                                 str="0"+count+":"+sec+" left";
                              lblTime.setText(str);
                              System.out.println();
                              Thread.sleep(1000); 
                              sec--;
                          }
                         sec=59;
                  count--;
             }
            
             
             
          } catch (InterruptedException ex) {
              
              JOptionPane.showMessageDialog(null,"Exception in Thread: "+ex, "Error !",JOptionPane.ERROR_MESSAGE);
           }
          
             Toolkit.getDefaultToolkit().beep();
             lblTime.setText("Times up");
             
             jrOption1.setEnabled(false);
             jrOption2.setEnabled(false);
             jrOption3.setEnabled(false);
             jrOption4.setEnabled(false);
             
             txtQuestion.setEditable(false);
             btnNext.setEnabled(false);
             btnCancel.setEnabled(false);
             btnPrevious.setEnabled(false);
             JOptionPane.showMessageDialog(null,"Times up,Press done to submit the test","Time up",JOptionPane.INFORMATION_MESSAGE);

   }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblQno = new javax.swing.JLabel();
        jrOption3 = new javax.swing.JRadioButton();
        jrOption1 = new javax.swing.JRadioButton();
        jrOption4 = new javax.swing.JRadioButton();
        jrOption2 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        lblUsername = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("src/src/image/quiz.png").getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblLogout.setBackground(new java.awt.Color(0, 0, 0));
        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 153, 51));
        lblLogout.setText("Logout");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/image/good luck2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        lblQno.setBackground(new java.awt.Color(0, 0, 0));
        lblQno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQno.setForeground(new java.awt.Color(255, 153, 0));
        lblQno.setText("Question no:");

        jrOption3.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption3);
        jrOption3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrOption3.setForeground(new java.awt.Color(255, 153, 0));
        jrOption3.setText("jRadioButton3");

        jrOption1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption1);
        jrOption1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrOption1.setForeground(new java.awt.Color(255, 153, 0));
        jrOption1.setText("jRadioButton1");

        jrOption4.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption4);
        jrOption4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrOption4.setForeground(new java.awt.Color(255, 153, 0));
        jrOption4.setText("jRadioButton4");
        jrOption4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrOption4ActionPerformed(evt);
            }
        });

        jrOption2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jrOption2);
        jrOption2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jrOption2.setForeground(new java.awt.Color(255, 153, 0));
        jrOption2.setText("jRadioButton2");

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 153, 0));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 153, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 153, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 153, 0));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 153, 0));
        lblTitle.setText("SUBJECT PAPER");

        txtQuestion.setColumns(20);
        txtQuestion.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txtQuestion.setRows(5);
        jScrollPane2.setViewportView(txtQuestion);

        lblUsername.setText("jLabel3");

        lblTime.setBackground(new java.awt.Color(0, 0, 0));
        lblTime.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        lblTime.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264)
                        .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(396, 396, 396)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jrOption3)
                                    .addComponent(jrOption1))
                                .addGap(133, 133, 133)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jrOption2)
                                    .addComponent(jrOption4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(210, 210, 210)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(86, 86, 86)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(86, 86, 86)
                                    .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(101, 101, 101)
                                    .addComponent(lblQno)
                                    .addGap(109, 109, 109)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblQno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrOption1)
                            .addComponent(jrOption2))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrOption3)
                            .addComponent(jrOption4))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblTime)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited

        // TODO add your handling code here:
        lblLogout.setForeground(new Color(255,153,0));
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        // TODO add your handling code here:
        lblLogout.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void jrOption4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrOption4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrOption4ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       
        String chosenAnswer=getUserAnswer();
        if(chosenAnswer!=null)
        {
            Question question=qstore.getQuestionByQno(qno);
            
           // System.out.println("1");
            String correctAnswer=question.getCorrectAnswer();
           // System.out.println("2");
            Answer ans=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
            
            System.out.println(ans);
            
            Answer attempted=astore.getAnswerByQno(qno);
            
            if(attempted==null)
                astore.addAnswer(ans);
            else
            {
                String prevAnswer = attempted.getChosenAnswer();
                if(prevAnswer.equals(chosenAnswer)==false)
                {
                     int apos=astore.removeAnswer(attempted);
                     astore.setAnswerAt(apos, ans);
                }
            }
        }
        pos++;
        if(pos>=qstore.getCount())
        {
            pos=0;
        }
        qno++;         
        if(qno>qstore.getCount())
                qno=1;
        lblQno.setText("Question no:"+qno);
        showQuestion();
    }   
    private String getUserAnswer(){
        
        Object ob = new Object();
        
        if(jrOption1.isSelected())
            return "Answer1";
        else if(jrOption2.isSelected())
            return "Answer2";
        else if(jrOption3.isSelected())
            return "Answer3";
        else if(jrOption4.isSelected())
            return "Answer4";
        else
            return null;

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        
        String chosenAnswer=getUserAnswer();
            if(chosenAnswer!=null)
            {
                 Question question=qstore.getQuestionByQno(qno);
                 String correctAnswer=question.getCorrectAnswer();
                 Answer newanswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,chosenAnswer,correctAnswer);
                // System.out.println(newanswer);
                 Answer answer=astore.getAnswerByQno(qno);
              if(answer==null)
                    astore.addAnswer(newanswer);
           else
           {
            if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false)
            {
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newanswer);
            }
        }
     }
        pos--;
        if(pos<0)
        {
            pos=qstore.getCount()-1;
        }
        qno--;
        if(qno<=0)
            qno=qstore.getCount();
        lblQno.setText("Question no:"+qno);
        showQuestion();

    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        // TODO add your handling code here:
        String userAnswer=getUserAnswer();
        if(userAnswer!=null){
        Question question=qstore.getQuestionByQno(qno);
        String correctAnswer=question.getCorrectAnswer();
                
        Answer newanswer=new Answer(exam.getExamId(),exam.getLanguage(),qno,userAnswer,correctAnswer);
       // System.out.println(newanswer);
        Answer answer=astore.getAnswerByQno(qno);
        
        if(answer==null)
            astore.addAnswer(newanswer);
        else{
            if(newanswer.getChosenAnswer().equals(answer.getChosenAnswer())==false){
                int apos=astore.removeAnswer(answer);
                astore.setAnswerAt(apos, newanswer);
            }
        }
        }
        int right=0,wrong=0;
        for(Question question:qstore.getAllQuestions()){
            int qno=question.getQno();
            Answer answer=astore.getAnswerByQno(qno);
            if(answer==null)
                continue;
            else
            {
                String chosenAnswer1=answer.getChosenAnswer();
                String correctAnswer=answer.getCorrectAnswer();
                if(chosenAnswer1.equals(correctAnswer))
                    ++right;
                else
                    ++wrong;
                    
            }
            
        }
        String reportCard="Total Questions:"+qstore.getCount();
        reportCard+="\nRight Answers:"+right;
        reportCard+="\nWrong Answers:"+wrong;
        reportCard+="\nUnAttempted  :"+(qstore.getCount()-(right+wrong));
        JOptionPane.showMessageDialog(null, reportCard,"Your Result!",JOptionPane.INFORMATION_MESSAGE);
       try
       {
            Performance performance=new Performance(exam.getExamId(),exam.getLanguage(),UserProfile.getUsername(),right,wrong,(qstore.getCount()-(right+wrong)),(double)right/qstore.getCount()*100);

            PerformanceDAO.addPerformance(performance);
            JOptionPane.showMessageDialog(null, "Your performance has been successfully added to the database"," Performance Added!",JOptionPane.INFORMATION_MESSAGE);
            ChoosePaperFrame paperFrame=new ChoosePaperFrame();
            paperFrame.setVisible(true);
            this.dispose();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        ChoosePaperFrame paperFrame=new ChoosePaperFrame();
        paperFrame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
        
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton jrOption1;
    private javax.swing.JRadioButton jrOption2;
    private javax.swing.JRadioButton jrOption3;
    private javax.swing.JRadioButton jrOption4;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblQno;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables

    private void loadQuestions() {
            try
            {
                ArrayList<Question> questionList=QuestionDao.getQuestionsByExamId(exam.getExamId());
                for(Question obj:questionList)
                {
                    qstore.addQuestion(obj);
                }
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }

    }

    private void showQuestion() {
        Question question=qstore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQuestion.setText(question.getQuestion());
        jrOption1.setText(question.getAnswer1());
        jrOption2.setText(question.getAnswer2());
        jrOption3.setText(question.getAnswer3());
        jrOption4.setText(question.getAnswer4());
        Answer answer=astore.getAnswerByQno(qno);
        if(answer==null)
            return;
        String chosenAnswer=answer.getChosenAnswer();
        switch(chosenAnswer){
            case "Answer1":
                jrOption1.setSelected(true);
                break;
            case "Answer2":
                jrOption2.setSelected(true);
                break;
            case "Answer3":
                jrOption3.setSelected(true);
                break;
            case "Answer4":
                jrOption4.setSelected(true);
                break;
        }

    }
}
