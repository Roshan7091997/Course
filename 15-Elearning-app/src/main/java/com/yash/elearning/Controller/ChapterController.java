package com.yash.elearning.Controller;

import com.yash.elearning.Repository.ChapterRepo;
import com.yash.elearning.model.Chapter;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/elearningapp")
public class ChapterController {

    @Autowired
    private ChapterRepo chapterRepo;

    // Create a new chapter
    @PostMapping("/createchapter")
    public Chapter createChapter(@RequestBody Chapter chapter) {
        return chapterRepo.save(chapter);
    }

    // Update an existing chapter
    @PutMapping("/updatechapter/{chapterId}")
    public Chapter updateChapter(@PathVariable int chapterId, @RequestBody Chapter updatedChapter) {
        return chapterRepo.findById(chapterId)
                .map(existingChapter -> {
                    existingChapter.setChapterName(updatedChapter.getChapterName());
                    // Update other fields as needed
                    return chapterRepo.save(existingChapter);
                })
                .orElseThrow(() -> new RuntimeException("Chapter not found with id: " + chapterId));
    }

    // Delete a chapter by ID
    @DeleteMapping("/deletechapter/{chapterId}")
    public String deleteChapter(@PathVariable int chapterId) {
        chapterRepo.deleteById(chapterId);
        return "Chapter with id " + chapterId + " deleted successfully.";
    }

    // View all chapters
    @GetMapping("/viewAllchapter")
    public List<Chapter> viewAllChapters() {
        return chapterRepo.findAll();
    }
}
