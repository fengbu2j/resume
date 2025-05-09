package com.wuzhaoyan.admin.controller;

import com.wuzhaoyan.admin.pojo.Book;
import com.wuzhaoyan.admin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/admin/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book updateRequest) {
        // 首先根据ID查找书籍
        Book existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            throw new RuntimeException("书籍不存在，无法更新");
        }

        // 更新书籍的内容字段
        existingBook.setName(updateRequest.getName());
        existingBook.setCategory(updateRequest.getCategory());
        existingBook.setAuthor(updateRequest.getAuthor());
        existingBook.setFee(updateRequest.getFee());
        existingBook.setCover(updateRequest.getCover());
        existingBook.setPath(updateRequest.getPath());
        existingBook.setMoney(updateRequest.getMoney());
        existingBook.setNumber(updateRequest.getNumber());

        // 保存更新后的书籍
        return bookService.updateBook(existingBook);
    }
    //改
    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable Integer id) {
        try {
            return bookService.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/{category}/id/books")
    public List<Book> getBooksByCategory(@PathVariable Integer category) {
        return bookService.getBooksByCategory(category);
    }

    @GetMapping("/search/{bookName}")
    public List<Book> searchBooks(@PathVariable String bookName) {
        return bookService.searchBooksByName(bookName);
    }

    //改
    @PostMapping("/addbook")
    public Boolean uploadBook(@RequestParam("file") MultipartFile file,
                              @RequestParam("coverFile") MultipartFile coverFile,
                              @RequestParam("name") String name,
                              @RequestParam("category") Integer category,
                              @RequestParam("author") String author,
                              @RequestParam("fee") Integer fee,
                              @RequestParam("money") Float money,
                              @RequestParam("number") Integer number) {
        String uploadDir = System.getProperty("user.home") + "\\Desktop\\uploads\\";
        File uploadPath = new File(uploadDir);

        // 确保上传目录存在
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        // 保存文本文件（file），确保以UTF-8编码保存
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + fileName;

        try {
            // 读取文件内容并以UTF-8编码保存
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            Files.write(Paths.get(filePath), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            return false; // 如果保存文本文件失败，返回 false
        }

        // 保存封面图片（coverFile），直接保存即可
        String coverFileName = UUID.randomUUID().toString() + "_" + coverFile.getOriginalFilename();
        String coverFilePath = uploadDir + coverFileName;

        try {
            coverFile.transferTo(new File(coverFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            return false; // 如果保存封面图片失败，返回 false
        }

        // 创建Book对象并保存到数据库
        Book book = new Book();
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setFee(fee);
        book.setCover(coverFilePath); // 封面图片路径
        book.setPath(filePath);      // 文本文件路径
        book.setMoney(money);
        book.setNumber(number);

        try {
            bookService.saveBook(book); // 假设 saveBook 方法返回 void 或布尔值
            return true; // 如果保存到数据库成功，返回 true
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 如果保存到数据库失败，返回 false
        }
    }

    @GetMapping("/preview/{id}")
    public Book previewBook(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/charge/{id}")
    public Book updateBookCharge(@PathVariable Integer id, @RequestParam("fee") Integer fee, @RequestParam("money") Float money, @RequestParam("number") Integer number) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            book.setFee(fee);
            book.setMoney(money);
            book.setNumber(number);
            return bookService.saveBook(book);
        }
        return null;
    }

    // 获取number最高的四本书作为推荐书籍
    @GetMapping("/top4")
    public List<Book> getTopFourBooks() {
        return bookService.getTopFourBooks();
    }

    @GetMapping("/cover/{id}")
    public ResponseEntity<Resource> getBookCover(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        if (book == null || book.getCover() == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            Path coverPath = Paths.get(book.getCover());
            Resource resource = new UrlResource(coverPath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // 根据实际图片格式调整
                        .body(resource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
    //获取文件文本内容
    @GetMapping("/{id}/content")
    public ResponseEntity<String> getBookContent(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        if (book == null || book.getPath() == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            // 读取文件内容
            String content = Files.readString(Paths.get(book.getPath()), StandardCharsets.UTF_8);
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to read book content");
        }
    }

}
