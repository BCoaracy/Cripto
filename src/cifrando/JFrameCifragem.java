/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrando;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Aguia
 */
public class JFrameCifragem extends javax.swing.JFrame {

    /**
     * Creates new form JFrameCifragem
     */
    public String caminho = "D:\\Facul\\Projetos\\CrifraArquivo\\teste.txt";
    public String caminhoCript = "D:\\Facul\\Projetos\\CrifraArquivo\\arqCripto.txt";
    
    public JFrameCifragem() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonCript = new javax.swing.JButton();
        TextComum = new javax.swing.JTextField();
        ButtonSalvar = new javax.swing.JButton();
        TextPuro = new javax.swing.JTextField();
        TextSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ButtonDecript = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonCript.setText("Criptografa");
        ButtonCript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCriptActionPerformed(evt);
            }
        });

        ButtonSalvar.setText("SalvarArquivo");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        jLabel1.setText("Senha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextPuro)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButtonCript, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TextComum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextComum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCript, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TextPuro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ButtonDecript.setText("Descriptografa");
        ButtonDecript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDecriptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonDecript)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonDecript, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonDecriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDecriptActionPerformed
        try{
            
        BufferedReader buffRead = new BufferedReader(new FileReader(caminhoCript));
        String linha = "";
        String textoOriginal = "";
        String senha = TextSenha.getText();
        while (true) {
            if (linha != null) {
                System.out.println(linha);
                new Criptografia(linha,senha);
        
                textoOriginal = Criptografia.Decriptografar();
            } else{
                break;
            }  
                
            linha = buffRead.readLine();
        }
        BufferedWriter buffWriteDecripto = new BufferedWriter(new FileWriter("D:\\Facul\\Projetos\\CrifraArquivo\\arqDecripto.txt"));
                
        System.out.println("texto decriptografado: "+textoOriginal);
        buffWriteDecripto.append(textoOriginal);
        
        TextPuro.setText(textoOriginal);

        buffWriteDecripto.close();
        
        buffRead.close();
        
        JOptionPane.showMessageDialog(null, "Mensagem decriptografada com sucesso!");
            
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_ButtonDecriptActionPerformed

    private void ButtonCriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCriptActionPerformed
        try{
            
        BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
        String linha = "";
        String textoCifrado = "";
        String senha = TextSenha.getText();
        while (true) {
            if (linha != null) {
                System.out.println(linha);
                new Criptografia(linha,senha);
                textoCifrado = Criptografia.Criptografar();
            } else{
                break;
            }  
                
            linha = buffRead.readLine();
        }
        BufferedWriter buffWriteCrip = new BufferedWriter(new FileWriter("D:\\Facul\\Projetos\\CrifraArquivo\\arqCripto.txt"));        
        System.out.println("texto criptografado: "+textoCifrado);
        buffWriteCrip.append(textoCifrado);
        //System.out.println(linha);
        
        buffWriteCrip.close();
        
        buffRead.close();
        
        JOptionPane.showMessageDialog(null, "Mensagem criptografada com sucesso!");
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }//GEN-LAST:event_ButtonCriptActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
        
        try{
            
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(caminho));
        String linha = "";

        linha = TextComum.getText();
        
        buffWrite.append(linha + "\n");
        buffWrite.close();
        
        JOptionPane.showMessageDialog(null, "Mensagem gravada com sucesso!");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_ButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameCifragem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCifragem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCifragem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCifragem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCifragem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCript;
    private javax.swing.JButton ButtonDecript;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JTextField TextComum;
    private javax.swing.JTextField TextPuro;
    private javax.swing.JTextField TextSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
