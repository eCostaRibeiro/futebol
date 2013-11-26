/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NovasTelas.Cadastros;

import campeonatofutebol.Estadio;
import campeonatofutebol.EstadioEquipe;
import campeonatofutebol.Time;
import classesDAO.EstadioDAO;
import classesDAO.EstadioEquipeDAO;
import classesDAO.TimeDAO;
import controles.ControleEstadioEquipe;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Stwuart
 */
public class CadastroEstadioTime extends javax.swing.JInternalFrame {
    private final JDesktopPane telaAnterior;
    private Time time;
    private Estadio estadio;

    /**
     * Creates new form CadastroEstadioTime
     * @param jDPPrincipal
     */
    public CadastroEstadioTime(JDesktopPane jDPPrincipal) {
        initComponents();
        this.telaAnterior = jDPPrincipal;
        this.time = null;
        this.estadio = null;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCodEstadio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCodTime = new javax.swing.JTextField();
        jBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jNomeEstadio = new javax.swing.JTextField();
        jNomeTime = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jGravar = new javax.swing.JButton();

        setTitle("Cadastro Estádio-Time");

        jLabel1.setText("Código Estádio:");

        jLabel2.setText("Código Time:");

        jBuscar.setText("buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome Estádio:");

        jLabel4.setText("Nome Time:");

        jNomeEstadio.setEnabled(false);

        jNomeTime.setEnabled(false);

        jButton2.setText("cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jGravar.setText("gravar");
        jGravar.setEnabled(false);
        jGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCodTime, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jCodEstadio))
                .addGap(29, 29, 29)
                .addComponent(jBuscar)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNomeEstadio)
                            .addComponent(jNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCodEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jNomeEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCodTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jGravar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        Integer codEstadio = Integer.parseInt(jCodEstadio.getText());
        Integer codTime = Integer.parseInt(jCodTime.getText());
        
        try{
            TimeDAO timeDAO = new TimeDAO();
            this.time = timeDAO.selectCodigo(codTime);
            
            EstadioDAO estadioDAO = new EstadioDAO();
            this.estadio = estadioDAO.selectCodigo(codEstadio);
            
            jNomeEstadio.setText(this.estadio.getNomeEstadio());
            jNomeTime.setText(this.time.getNomeTime());
            jGravar.setEnabled(true);
            
        } catch (IllegalAccessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        
        
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGravarActionPerformed

        
        try {
            EstadioEquipe estTime = new EstadioEquipe();
            ControleEstadioEquipe controle = new ControleEstadioEquipe();
            
            
            if (controle.cadastrarEstadioEquipe(estTime)){
                estTime.setEstadioCodigo(this.estadio);
                estTime.setEquipeCodigo(this.time);
                
                
                
                EstadioEquipeDAO estadioEquipeDAO = new EstadioEquipeDAO(estTime);
                estadioEquipeDAO.insert();
                JOptionPane.showMessageDialog (this, "Cadastrado com sucesso!");
                
            }
        } catch (IllegalAccessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally{
            this.dispose();
        }
    }//GEN-LAST:event_jGravarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBuscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jCodEstadio;
    private javax.swing.JTextField jCodTime;
    private javax.swing.JButton jGravar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jNomeEstadio;
    private javax.swing.JTextField jNomeTime;
    // End of variables declaration//GEN-END:variables
}
