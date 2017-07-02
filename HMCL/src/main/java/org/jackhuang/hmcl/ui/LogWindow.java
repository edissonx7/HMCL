/*
 * Hello Minecraft!.
 * Copyright (C) 2013  huangyuhui <huanghongxun2008@126.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hmcl.ui;

import java.io.PrintStream;
import java.util.Deque;
import java.util.LinkedList;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.jackhuang.hmcl.util.C;
import org.jackhuang.hmcl.api.HMCLog;
import org.jackhuang.hmcl.util.log.Level;
import org.jackhuang.hmcl.api.func.NonFunction;
import org.jackhuang.hmcl.setting.Settings;
import org.jackhuang.hmcl.util.DoubleOutputStream;
import org.jackhuang.hmcl.util.Utils;
import org.jackhuang.hmcl.util.sys.ProcessMonitor;
import org.jackhuang.hmcl.util.ui.SwingUtils;

/**
 *
 * @author huangyuhui
 */
public class LogWindow extends javax.swing.JFrame {

    public static LogWindowOutputStream outputStream;

    NonFunction<Boolean> listener;

    /**
     * Creates new form LogWindow
     */
    public LogWindow() {
        initComponents();

        DoubleOutputStream out = new DoubleOutputStream(outputStream = new LogWindowOutputStream(this, Level.INFO), System.out);
        System.setOut(new PrintStream(out));
        DoubleOutputStream err = new DoubleOutputStream(new LogWindowOutputStream(this, Level.ERROR), System.err);
        System.setErr(new PrintStream(err));

        SwingUtilities.invokeLater(() -> {
            setLocationRelativeTo(null);
            //txtLog.setEditable(false);
            txtLog.setFont(Settings.getInstance().getConsoleFont());
            cboShowLines.setSelectedItem(String.valueOf(Settings.getInstance().getLogLines()));
        });
    }

    public static final LogWindow INSTANCE = new LogWindow();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnCopy = new javax.swing.JButton();
        lblCrash = new javax.swing.JLabel();
        btnContact = new javax.swing.JButton();
        btnTerminateGame = new javax.swing.JButton();
        pnlLog = new javax.swing.JScrollPane();
        txtLog = new JLineWrapTextPane();
        lblShowLines = new javax.swing.JLabel();
        cboShowLines = new javax.swing.JComboBox<>();
        btnDebug = new javax.swing.JToggleButton();
        btnInfo = new javax.swing.JToggleButton();
        btnWarn = new javax.swing.JToggleButton();
        btnError = new javax.swing.JButton();
        btnFatal = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(C.i18n("logwindow.title")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnClear.setText(C.i18n("ui.button.clear")); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setText(C.i18n("ui.button.close")); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnCopy.setText(C.i18n("ui.button.copy")); // NOI18N
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        lblCrash.setText(C.i18n("ui.label.crashing")); // NOI18N

        btnContact.setText(C.i18n("logwindow.contact")); // NOI18N
        btnContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactActionPerformed(evt);
            }
        });

        btnTerminateGame.setText(C.i18n("logwindow.terminate_game")); // NOI18N
        btnTerminateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminateGameActionPerformed(evt);
            }
        });

        txtLog.setEditable(false);
        pnlLog.setViewportView(txtLog);

        lblShowLines.setText(C.i18n("logwindow.show_lines")); // NOI18N
        lblShowLines.setToolTipText("");

        cboShowLines.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100", "1000", "5000" }));
        cboShowLines.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboShowLinesItemStateChanged(evt);
            }
        });

        btnDebug.setText("0 debug");

        btnInfo.setText("0 info");

        btnWarn.setText("0 warn");

        btnError.setText("0 error");

        btnFatal.setText("0 fatal");

        txtSearch.setToolTipText("");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lblSearch.setText(C.i18n("logwindow.search")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnContact)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addComponent(btnTerminateGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose))
                    .addComponent(lblCrash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblShowLines)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboShowLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWarn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDebug))
                    .addComponent(pnlLog))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShowLines)
                    .addComponent(cboShowLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebug)
                    .addComponent(btnInfo)
                    .addComponent(btnWarn)
                    .addComponent(btnError)
                    .addComponent(btnFatal)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCrash)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLog, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnClose)
                    .addComponent(btnCopy)
                    .addComponent(btnContact)
                    .addComponent(btnTerminateGame))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (listener != null && listener.apply())
            terminateGames();
        SwingUtils.exitIfNoWindow(this, true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clean();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        Utils.setClipborad(this.txtLog.getText());
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactActionPerformed
        SwingUtils.openLink(C.URL_CONTACT);
    }//GEN-LAST:event_btnContactActionPerformed

    private void btnTerminateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminateGameActionPerformed
        terminateGames();
    }//GEN-LAST:event_btnTerminateGameActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (listener != null && listener.apply())
            terminateGames();
        SwingUtils.exitIfNoWindow(this);
    }//GEN-LAST:event_formWindowClosing

    private void cboShowLinesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboShowLinesItemStateChanged
        Settings.getInstance().setLogLines(Integer.parseInt(cboShowLines.getSelectedItem().toString()));
    }//GEN-LAST:event_cboShowLinesItemStateChanged

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        if (evt.getSource() != txtSearch || txtSearch.getText().isEmpty())
            return;
        try {
            if (!s.equals(txtSearch.getText()))
                pos = 0;
            StyledDocument d = txtLog.getStyledDocument();
            s = txtSearch.getText();
            String content = d.getText(0, d.getLength());
            int x = content.indexOf(s, pos);
            if (x == -1) {
                pos = 0;
                x = content.indexOf(s, pos);
            }
            if (x == -1)
                return;
            int len = s.length();
            pos = x + len;
            SimpleAttributeSet set = new SimpleAttributeSet(d.getLogicalStyle(x).copyAttributes());
            StyleConstants.setBackground(set, txtLog.getSelectionColor());
            StyleConstants.setForeground(set, txtLog.getSelectedTextColor());
            d.setCharacterAttributes(x, len, set, true);
            set = new SimpleAttributeSet(d.getLogicalStyle(lastX).copyAttributes());
            StyleConstants.setBackground(set, txtLog.getBackground());
            StyleConstants.setForeground(set, txtLog.getForeground());
            d.setCharacterAttributes(lastX, lastLen, set, true);
            txtLog.select(x, pos);
            lastX = x;
            lastLen = len;
        } catch (BadLocationException e) {
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    String s = "";
    int pos = 0, lastX = 0, lastLen = 0;

    void terminateGames() {
        ProcessMonitor.stopAll();
    }

    int removedLength = 0;
    Deque<Integer> offsets = new LinkedList<>();
    int fatals = 0, errors = 0, warns = 0, infos = 0, debugs = 0;

    public void log(final String status, final Level c) {
        if (!isVisible())
            return;
        SwingUtilities.invokeLater(() -> {
            Document d = txtLog.getStyledDocument();
            try { // prevent too much memory used.
                if (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() > 1l * 1024 * 1024 * 256) {
                    d.remove(0, d.getLength());
                    offsets.clear();
                    removedLength = 0;
                }
            } catch (Exception ex) {
                HMCLog.err("Failed to clear the text component", ex);
            }
            String newStatus = status.replace("\t", "    ");
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setForeground(sas, c.COLOR);
            try {
                offsets.add(d.getLength() + removedLength);
                d.insertString(d.getLength(), newStatus, sas);
            } catch (Exception ex) {
                HMCLog.err("Failed to insert \"" + newStatus + "\" to " + d.getLength(), ex);
            }

            switch (c) {
                case FATAL:
                    btnFatal.setText(++fatals + " fatals");
                    break;
                case ERROR:
                    btnError.setText(++errors + " errors");
                    break;
                case WARN:
                    btnWarn.setText(++warns + " warns");
                    break;
                case INFO:
                    btnInfo.setText(++infos + " infos");
                    break;
                case DEBUG:
                    btnDebug.setText(++debugs + " debugs");
                    break;
            }

            int maxLines = Integer.parseInt(cboShowLines.getSelectedItem().toString());
            while (offsets.size() > maxLines) {
                int start = offsets.pollFirst();
                int end = offsets.peekFirst();
                try {
                    d.remove(start - removedLength, end - start); // start - removedLength must become 0
                    removedLength = end;
                } catch (Exception ignore) {
                }
            }
        });
    }

    public void setExit(NonFunction<Boolean> exit) {
        this.listener = exit;
    }

    public void clean() {
        txtLog.setText("");
    }

    @Override
    public void setVisible(boolean b) {
        txtLog.setFont(Settings.getInstance().getConsoleFont());
        lblCrash.setVisible(false);
        btnContact.setVisible(false);
        super.setVisible(b);
    }

    public void showAsCrashWindow(boolean out_date) {
        txtLog.setFont(Settings.getInstance().getConsoleFont());
        if (out_date) {
            lblCrash.setVisible(false);
            btnContact.setVisible(false);
            lblCrash.setText(C.i18n("ui.label.crashing_out_dated"));
        } else {
            lblCrash.setVisible(true);
            btnContact.setVisible(true);
            lblCrash.setText(C.i18n("ui.label.crashing"));
        }

        super.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnContact;
    private javax.swing.JButton btnCopy;
    private javax.swing.JToggleButton btnDebug;
    private javax.swing.JButton btnError;
    private javax.swing.JButton btnFatal;
    private javax.swing.JToggleButton btnInfo;
    private javax.swing.JButton btnTerminateGame;
    private javax.swing.JToggleButton btnWarn;
    private javax.swing.JComboBox<String> cboShowLines;
    private javax.swing.JLabel lblCrash;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblShowLines;
    private javax.swing.JScrollPane pnlLog;
    private javax.swing.JTextPane txtLog;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
