package com.wuzhaoyan.user.controller;

import com.wuzhaoyan.user.pojo.BookUser;
import com.wuzhaoyan.user.repository.BookRepositoryUser;
import com.wuzhaoyan.user.service.BookServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user/books")
public class BookControllerUser {
    @Autowired
    private BookServiceUser bookServiceUser;

    @Autowired
    private BookRepositoryUser bookRepositoryUser;

    @GetMapping
    public List<BookUser> getAllBooks() {
        return bookServiceUser.getAllBooks();
    }


    @GetMapping("/{category}/id/book5")
    public Page<BookUser> getBooksByCategory(@PathVariable Integer category, @RequestParam(defaultValue = "0") int page) {
        return bookServiceUser.getBooksByCategory(category, page);
    }

    @GetMapping("/search/{bookName}")
    public List<BookUser> searchBooks(@PathVariable String bookName) {
        return bookServiceUser.searchBooksByName(bookName);
    }


    @GetMapping("/moneyCount")
    public Map<Integer, Float> getMoneyCountByCategory() {
        return bookServiceUser.getMoneyCountByCategory();
    }

    @GetMapping("/readCount")
    public Map<Integer,Integer> getNumberCountByCategory(){
        return bookServiceUser.getNumberCountByCategory();
    }

    // 获取number最高的四本书作为推荐书籍
    @GetMapping("/top4")
    public List<BookUser> getTopFourBooks() {
        return bookServiceUser.getTopFourBooks();
    }


//    // 搜索用户可访问的书籍
//    @GetMapping("/search")
//    public ResponseEntity<List<Book>> searchBooks() {
//        List<Book> books = bookService.getAccessibleBooks();
//        return ResponseEntity.ok(books);
//    }

    // 获取某本书的详情
    @GetMapping("/{id}")
    public BookUser getBookById(@PathVariable Integer id) {
        return bookServiceUser.getBookById(id);
    }



    //    @GetMapping("/{id}")
//    public ResponseEntity<?> getBook(@PathVariable Integer id) {
//        Book book = bookService.getBookById(id);
//        if (book == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
//        }
//
//        // 检查是否需要弹出广告
//        Ad ad = adService.getRandomAd();
//        if (ad != null) {
//            return ResponseEntity.ok(ad); // 返回广告信息
//        }
//
//        if (bookService.canAccessBook(book)) {
//            return ResponseEntity.ok(book); // 用户有权限访问书籍
//        } else {
//            PaymentCode paymentCode = paymentCodeService.getPaymentCodeForBook(book);
//            if (paymentCode != null) {
//                PaymentResponse response = new PaymentResponse("需要进行支付", paymentCode.getPath());
//                return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(response);
//            } else {
//                return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("支付路径未找到");
//            }
//        }
//    }

    // 根据 Book 的 ID 获取收款码
    @GetMapping("/{id}/payment-code")
    public ResponseEntity<String> getPaymentCode(@PathVariable Integer id) {
        // 从数据库中获取 Book 对象
        BookUser bookUser = bookRepositoryUser.findById(id).orElse(null);

        if (bookUser == null) {
            return ResponseEntity.notFound().build();
        }

        if (bookUser.getMoney() == null) {
            return ResponseEntity.badRequest().body("Book money is not set.");
        }

        String paymentCode = bookServiceUser.generatePaymentCode(bookUser.getMoney());
        return ResponseEntity.ok(paymentCode);
    }
}

