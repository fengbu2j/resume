package com.wuzhaoyan.admin.controller;

import com.wuzhaoyan.admin.pojo.ReadingHistory;
import com.wuzhaoyan.admin.service.ReadingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/reading")
public class ReadingHistoryController {
    @Autowired
    private ReadingHistoryService readingHistoryService;

    // 记录阅读行为
    @PostMapping("/record")
    public Boolean recordReading(@RequestParam("userId") Integer userId,
                                @RequestParam("bookId") Integer bookId) {
        return readingHistoryService.recordReading(userId, bookId);
    }
    // 根据用户id查阅读记录
    @GetMapping("/history/{userId}")
    public List<ReadingHistory> getPersonalReadingHistory(@PathVariable("userId") Integer userId) {
        return readingHistoryService.getPersonalReadingHistory(userId);
    }
}