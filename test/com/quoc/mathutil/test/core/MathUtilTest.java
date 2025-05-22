/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.quoc.mathutil.test.core;

import com.quoc.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ASUS
 */
public class MathUtilTest {

    //Đây là class sẽ dùng các hàm của thư viện/frame work Junit
    //để kiểm thử/kiểm tra code chính - hàm tínhGiaiThừa()
    //bên class core.MathUtil
    //viết code để test code
    //Có nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích cảu các case kiểm thử
    //xài hàm theo kiểu thành công và thất bại
    //hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6! CHỨ KO đưa -5!, 30!
    //@Test Junit sẽ phối hợp với JVM để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    //Có nhiều @Test úng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    //Không viết các hàm lẻ rồi chạy trong 1 main() vì như thế nếu 1 cái lỗi thì 
    //nó sẽ lỗi toàn bộ
    @Test
    public void testGetFactorialGivenRightArgumentReturnWell() {
        int n = 0; //test thử tình huống tử tế đầu vào, phải chạy đúng
        long expected = 1;
        long actual = MathUtil.getFactorial(n);

        //so sánh expected vs actual dùng xanh xanh đỏ đỏ, framework
        org.junit.Assert.assertEquals(expected, actual);
        //hàm này giúp so sánh 2 giá trị expected vs actual có giống nhau hay k
        //nếu giống nhau ==> ra màu xanh

        //nếu ko giống nhau ==> ra màu đỏ
        //gộp thêm vài case thành công nữa
        org.junit.Assert.assertEquals(1, MathUtil.getFactorial(1)); //muốn 1! == 1
        org.junit.Assert.assertEquals(2, MathUtil.getFactorial(2)); //muốn 2! == 2
        org.junit.Assert.assertEquals(6, MathUtil.getFactorial(3)); //muốn 3! == 6
        org.junit.Assert.assertEquals(240, MathUtil.getFactorial(4)); //muốn 4! == 24

    }

    //hàm getFactorial() ta thiết kế 2 tình huống xử lý
    //1. Đưa data tử tế [0..20] -> Tính đúng n! => DONE
    //2. Đưa data cà chớn, âm , >20; Thiết kế của hàm là ném ra NGOẠI LỆ
    //tao kì vọng ngoại lệ xuất hiện khi N < 20 || N > 20
    //rất mong muốn ngoại lệ xuất hiện với "n" cà chớn này
    //nếu hàm nhận vào n < 20 hoặc n > 20 và hàm ném ra ngoại lệ
    //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> MÀU XANH PHẢI XUẤT HIỆN
    //nếu hàm nhận vào n < 20 hoặc n > 20 và hàm KO ném ra ngoại lệ
    //HÀM CHẠY ĐÚNG SAI THIẾT KẾ, SAI KÌ VỌNG
    //Test case: 
    //input: -5
    //expected: IlligalArgumentException
    //Tình huống ngoại lệ bất thường không thể đo lường so sánh kiểu value
    //mà chỉ có thể đo lường = cách chúng xuất hiện hay ko
    //assertEquals() không thể dùng để so sánh 2 ngoại lệ
    //      equal là bằng nhau trên value
    //MÀU ĐỎ ĐÓ, DO HÀM ĐÚNG LÀ CÓ NÉM NGOẠI LỆ THỰC SỰ
    //          NHƯNG KO PHẢI NGOẠI LỆ NHƯ KÌ VỌNG
    //          KÌ VỌNG SAI CHỨ KO PHẢI NGOẠI LỆ SAI
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException() {
//        MathUtil.getFactorial(-5);  //Hàm @Test chạy, hay hàm getFactorial()
//                                    //chạy sẽ ném về ngoại lệ...
//    }
    @Test(expected = IllegalArgumentException.class) //Nếu ko biết expected = ... thì nó tự động hiểu là hàm trả về != expected
    public void testGetFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-5);  //Hàm @Test chạy, hay hàm getFactorial()
        //chạy sẽ ném về ngoại lệ...
    }

    //cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn
    // Liên quan đến Lambda expression
    //Test case: hàm sẽ ném về ngoại lệ nếu nhập vô 21
    //Tui cần thấy màu xanh khi nhập 21!
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_LambdaVersion() {

//        org.junit.Assert.assertThrows(tham số 1: loại ngoại lệ muốn so sánh, 
//                                      tham số 2: đoạn code chạy văng ra ngoại lệ);
        org.junit.Assert.assertThrows(IllegalArgumentException.class,
                () -> {
                    MathUtil.getFactorial(-5);
                }
        );

//        MathUtil.getFactorial(-5);
    }

    @Test
    public void testGetFactorialGivenWrongArgumentThrowsException_TryCatch() {

        //Chủ động kiểm soát ngoại lệ
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bắt try-catch là JUnit ra màu xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay k
            //có đoạn code kiểm soát đúng ngoại lệ hay k
            
            Assert.assertEquals("Invalid argument. N must be between 0..20",
                    e.getMessage());
        }

        

    }

}
