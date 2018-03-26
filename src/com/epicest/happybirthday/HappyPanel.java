/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epicest.happybirthday;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JPanel;

/**
 *
 * @author Jayar
 */
public class HappyPanel extends JPanel {

 public static HappyBirthday parent;

 public String name = "Jared";

 public HappyPanel(String name) {
  super();
  this.name = name;
 }

 public HappyPanel() {
  super();
 }

 public String getDisplayName() {
  return name;
 }

 public void setDisplayName(String name) {
  this.name = name;
 }

 public Color bg = Conffetti.randomColor(64, 255);

 @Override
 public void paint(Graphics g) {
  Graphics2D g2d = (Graphics2D) g;
  g2d.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
  g2d.setRenderingHint(
          RenderingHints.KEY_TEXT_ANTIALIASING,
          RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
  g2d.setBackground(bg);
  g2d.clearRect(0, 0, getWidth(), getHeight());
  //Draw Conffetti
  for (Conffetti i : parent.conffetti) {
   g2d.setColor(i.color);
   g2d.fillOval(i.x, i.y, i.size, i.size);
  }

  //Draw Text
  Font happy;
  g2d.setColor(Color.BLACK);
  try {
   happy = Font.createFont(Font.TRUETYPE_FONT, HappyPanel.class.getResourceAsStream("FSEX300.ttf"));
   happy = happy.deriveFont(50.0f);
   g2d.setRenderingHint(
           RenderingHints.KEY_TEXT_ANTIALIASING,
           RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
  } catch (Exception e) {
   happy = new Font("Helvetica", Font.BOLD, 50);
  }
  g2d.setFont(happy);
  drawCenteredString(g2d, "Happy Birthday", new Rectangle(0, 0, getWidth(), getHeight()));
  happy = happy.deriveFont(40.0f);
  g2d.setFont(happy);
  drawCenteredString(g2d, name, new Rectangle(0, getHeight() / 2, getWidth(), getHeight() / 2));
 }

 public static Point drawCenteredString(Graphics g, String text, Rectangle rect) {
  FontMetrics metrics = g.getFontMetrics(g.getFont());
  int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
  int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
  g.drawString(text, x, y);
  return new Point(x, y);
 }

}
