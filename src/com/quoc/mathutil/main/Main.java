/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quoc.mathutil.main;

import com.quoc.mathutil.core.MathUtil;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        
        //thử nghiệm hàm tính giai thừa coi chạy đúng thiết kế hay k
        //ta phải đưa ra các tình huống sử dụng hàm trong thực tế
        //ví dụ: đưa vô: -5, 0, 21,...
        
        long expected = 120; //tao kì vọng hàm trả về 120 nếu ta tính 5!
        int n = 5;           //Input
        long actual = MathUtil.getFactorial(n);
        System.out.println("5! = " + expected +" expected");
        System.out.println("5! = " + actual +" actual");
        
    }
}
