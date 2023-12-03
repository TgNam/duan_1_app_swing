/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author thiet
 */
public class EditButtons {

    public void Edit(JButton button) {
//        button.setSize(new Dimension(100, 35));
        button.setBackground(new Color(0, 0, 0, 0));
        Font f = new Font("Times New Roman", Font.BOLD, 14);
        button.setFont(f);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
}
