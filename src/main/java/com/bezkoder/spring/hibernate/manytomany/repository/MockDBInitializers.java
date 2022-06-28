/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.Tag;
import com.bezkoder.spring.hibernate.manytomany.model.Tutorial;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mac
 */
public class MockDBInitializers {
    
    @Autowired
    private TutorialRepository tutorialRepo;
    
    @Autowired
    private TagRepository tagRepo;
    
    public MockDBInitializers(TutorialRepository tutorialRepo, TagRepository tagRepo) {
        this.tutorialRepo = tutorialRepo;
        this.tagRepo = tagRepo;
    }
    
    private Set<Tag> generateTags() {
        Tag[] tgs = {
            new Tag("Java Fundamentals"),
            new Tag("Java OOP"),
            new Tag("Java EE"),
            new Tag("Java Spring"),
            new Tag("Java Databases"),
            new Tag("Java Testing"),
        };
        Set<Tag> tags = Arrays.stream(tgs).collect(Collectors.toSet());
        return(tags);
    }
    
    private Set<Tutorial> generateTutorialsWithTags() {
        Set<Tag> tags = generateTags();
        tagRepo.saveAll(tags);
        Tutorial[] tuts = new Tutorial[6];
        
        tuts[0] = new Tutorial("Java", "Java Fundamentals", true);
        tuts[0].addTag(tagRepo.getById(1L));
        
        tuts[1] = new Tutorial("Java", "Java OOP", true);
        tuts[1].addTag(tagRepo.getById(2L));
        
        tuts[2] = new Tutorial("Java", "Java EE", true);
        tuts[2].addTag(tagRepo.getById(3L));
        
        tuts[3] = new Tutorial("Java", "Java Spring", true);
        tuts[3].addTag(tagRepo.getById(4L));
        
        tuts[4] = new Tutorial("Java", "Java Hibernate", true);
        tuts[4].addTag(tagRepo.getById(5L));
        
        tuts[5] = new Tutorial("Java", "Java Testing", true);
        tuts[5].addTag(tagRepo.getById(6L));
        
        Set<Tutorial> tutorials = Arrays.stream(tuts).collect(Collectors.toSet());
        return(tutorials);
    }
        
    private void storeData(Set<Tutorial> tutorials) {
        tutorialRepo.saveAll(tutorials);
    }
    
    public void generateMockData() {
        storeData(generateTutorialsWithTags());
    }
    
    public void emptyDatabase() {
        tutorialRepo.deleteAll();
        tagRepo.deleteAll();
    }
}
