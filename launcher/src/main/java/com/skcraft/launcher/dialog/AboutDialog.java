/*
 * SK's Minecraft Launcher
 * Copyright (C) 2010-2014 Albert Pham <http://www.sk89q.com> and contributors
 * Please see LICENSE.txt for license information.
 */

package com.skcraft.launcher.dialog;

import com.skcraft.launcher.swing.ActionListeners;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class AboutDialog extends JDialog {

    public AboutDialog(Window parent) {
        super(parent, "Sobre", ModalityType.DOCUMENT_MODAL);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
        setResizable(false);
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        JPanel container = new JPanel();
        container.setLayout(new MigLayout("insets dialog"));

        container.add(new JLabel("<html>Licenciado sob a GNU General Public License, vers\u00E3o 3."), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>Voc\u00EA est\u00E1 usando o SKCraft Launcher, uma plataforma de launcher<br>" +
                "open-source e customiz\u00E1vel que qualquer um pode usar."), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>SKCraft n\u00E3o necessariamente reflete a vers\u00E3o do<br>" +
                "launcher que voc\u00EA est\u00E1 usando.<br>"), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>Esse Launcher foi modificado por <strong>Focamacho</strong> para uso na <strong>Seal Island</strong>."), "wrap, gapbottom unrel");

        JButton okButton = new JButton("OK");
        JButton sourceCodeButton = new JButton("SKCraft");
        JButton sealSourceCodeButton = new JButton("Seal Launcher");

        container.add(sourceCodeButton, "span, split 3, sizegroup bttn");
        container.add(sealSourceCodeButton, "span, split 3, sizegroup bttn");
        container.add(okButton, "tag ok, sizegroup bttn");

        add(container, BorderLayout.CENTER);

        getRootPane().setDefaultButton(okButton);
        getRootPane().registerKeyboardAction(ActionListeners.dispose(this), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        okButton.addActionListener(ActionListeners.dispose(this));
        sourceCodeButton.addActionListener(ActionListeners.openURL(this, "https://github.com/SKCraft/Launcher"));
        sealSourceCodeButton.addActionListener(ActionListeners.openURL(this, "https://github.com/Seal-Island/Seal-Launcher"));
    }

    public static void showAboutDialog(Window parent) {
        AboutDialog dialog = new AboutDialog(parent);
        dialog.setVisible(true);
    }
}

