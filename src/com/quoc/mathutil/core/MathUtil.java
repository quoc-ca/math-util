/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quoc.mathutil.core;

/**
 *
 * @author ASUS
 */
public class MathUtil {

    //Trong class này cung cấp cho ai đó nhiều hàm xử lý toán học
    //clone class Math của JDK
    //hàm thư viện xài chung cho ai đó, ko cần lưu lại trạng thái/giá trị
    //=> chọn thiết kế hàm static
    //hàm tính gia thừa !!!
    //n! = 1.2.3.4...n
    //ko có giai thừa cho số âm
    //0! = 1! = 1 quy ước
    //giai thừa hàm đồ thị dốc đứng, tăng nhanh về giá trị
    //20 giai thừa 18 con số 0, vừa kịp đủ cho kiểu long của Java
    //21 giai thừa tràn kiểu long
    //bài này quy ước tính n! trong khoảng từ 0...20
//    public static long getFactorial(int n) {
//        
//        if (n < 0 || n > 20)
//            throw new IllegalArgumentException("Invalid argument. N must be between 0..20");
//        
//        if (n == 0 || n == 1)
//            return 1; //kết thúc cuộc chơi sớm
//        
//        long product = 1; //tích nhân dồn, thuật toán heo đất
//        
//        for (int i = 2; i <= n; i++) {
//            product *= i;
//        }
//        
//        return product;
//    }
    //Đệ quy là hiện tượng gọi lại chính mình với 1 quy mô khác
    //Ví dụ: Tính 6!
    //n! = 1x2x3x4x...xn
    //6! = 6 x 5!
    //5! = 5 x 4!
    //...
    //1! = 1
    //Chốt hạ: n! = n x (n - 1)!
    public static long getFactorial(int n) {
        
        if (n < 0 || n > 20)
            throw new IllegalArgumentException("Invalid argument. N must be between 0..20");
        
        if (n == 0 || n == 1) {
            return 1; //kết thúc cuộc chơi sớm
        }
        
        return n * getFactorial(n - 1);
    }
}
