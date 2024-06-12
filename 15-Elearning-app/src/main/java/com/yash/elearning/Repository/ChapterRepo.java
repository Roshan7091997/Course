package com.yash.elearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.elearning.model.Chapter;

public interface ChapterRepo extends JpaRepository<Chapter, Integer>{

}
