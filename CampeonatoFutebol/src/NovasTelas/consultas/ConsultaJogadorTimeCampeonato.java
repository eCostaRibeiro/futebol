/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NovasTelas.consultas;

import campeonatofutebol.JogadorTimeCampeonato;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repositorios.RepositorioJTC;

/**
 *
 * @author Stwuart
 */
public class ConsultaJogadorTimeCampeonato extends javax.swing.JInternalFrame {
    private final JDesktopPane telaAnterior;

    /**
     * Creates new form ConsultaJogadorTimeCampeonato
     * @param jDPPrincipal
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.Exception
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ConsultaJogadorTimeCampeonato(JDesktopPane jDPPrincipal) throws IllegalAccessException, ClassNotFoundException, SQLException, Exception{
        initComponents();
        this.telaAnterior = jDPPrincipal;
        carregarJTable();
    }
    
    private void carregarJTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
        try {
            ArrayList<JogadorTimeCampeonato> lista = RepositorioJTC.getInstance().obterListaJTC();
            
            
            
            DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
            modelo.addColumn("Campeonato");
            modelo.addColumn("Time");
            modelo.addColumn("Jogador");
            
            if (lista.isEmpty()) {
                modelo.addRow(new String[]{"Sem Dados",
                    null,
                    null});
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    JogadorTimeCampeonato jtc = lista.get(i);
                    

                    //Alimenta as linhas de dados
                    modelo.addRow(new String[]{
                        jtc.getCampeonato().getNomeCamp(),
                        jtc.getTime().getNomeTime(),
                        jtc.getJogador().getNomeJogador()
                                + ""});
                }
            }//fim IF  ELSE
            jTable1.setModel(modelo);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ConsultaEstadio.carregarJTable\n" + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton2.setText("atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.carregarJTable();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Botão Fechar
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
