/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epicest.happybirthday;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Jayar
 */
public class Conffetti {

 public static Random rand = new Random();

 public int size = 3;
 public Color color = Color.BLUE;
 public int x = 0, y = 0;

 public Conffetti() {
  color = randomColor(0, 255);
  size = rand.nextInt((5 - 2) + 1) + 2;
  y = rand.nextInt((-5 + 10) + 1) - 10;

  x = rand.nextInt(HappyPanel.parent.getWidth());
 }

 public void update() {
  y += rand.nextInt(3);
  if (y > HappyPanel.parent.getHeight()) {
   y = rand.nextInt((-5 + 10) + 1) - 10;
  }
  x += rand.nextInt((2 + 2) + 1) - 2;
  if (x < -size) {
   x = 0;
  }
  if (x > HappyPanel.parent.getWidth()) {
   x = HappyPanel.parent.getWidth() - size;
  }
 }

 public static Color randomColor(int min, int max) {
  int redValue = rand.nextInt((max - min) + 1) + min;
  int greenValue = rand.nextInt((max - min) + 1) + min;
  int blueValue = rand.nextInt((max - min) + 1) + min;

  //System.out.println("Red: " + redValue + ", Green: " + greenValue + ", Blue: " + blueValue);
  return new Color(redValue, greenValue, blueValue);
 }

}
