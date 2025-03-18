package com.wuzhaoyan.user.controller;

import com.wuzhaoyan.user.pojo.ReadingHistoryUser;
import com.wuzhaoyan.user.service.ReadingHistoryServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user/reading")
public class ReadingHistoryControllerUser {
    @Autowired
    private ReadingHistoryServiceUser readingHistoryServiceUser;

    // 记录阅读行为
    @PostMapping("/record")
    public Boolean recordReading(@RequestParam("userId") Integer userId,
                                 @RequestParam("bookId") Integer bookId) {
        return readingHistoryServiceUser.recordReading(userId, bookId);
    }
    // 根据用户id查阅读记录
    @GetMapping("/history/{userId}")
    public List<ReadingHistoryUser> getPersonalReadingHistory(@PathVariable("userId") Integer userId) {
        return readingHistoryServiceUser.getPersonalReadingHistory(userId);
    }
}