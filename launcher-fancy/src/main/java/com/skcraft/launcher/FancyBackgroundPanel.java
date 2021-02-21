/*
 * SKCraft Launcher
 * Copyright (C) 2010-2014 Albert Pham <http://www.sk89q.com> and contributors
 * Please see LICENSE.txt for license information.
 */

package com.skcraft.launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FancyBackgroundPanel extends JPanel {

    private Image background;
    private Image borders;
    private Image logo;

    public FancyBackgroundPanel() {
        try {
            background = ImageIO.read(FancyBackgroundPanel.class.getResourceAsStream("launcher_bg.png"));
        } catch (IOException e) {
            background = null;
        }

        try {
            borders = ImageIO.read(FancyBackgroundPanel.class.getResourceAsStream("borders.png"));
        } catch (IOException e) {
            borders = null;
        }

        try {
            logo = ImageIO.read(FancyBackgroundPanel.class.getResourceAsStream("logo.png"));
        } catch (IOException e) {
            logo = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, null);
        }

        if(borders != null){
            g.drawImage(borders, 0, 0, null);
        }

        if(logo != null) {
            g.drawImage(logo, 460, 100, 450, 365, null);
        }
    }

}
