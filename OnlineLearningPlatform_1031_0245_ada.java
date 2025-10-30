// 代码生成时间: 2025-10-31 02:45:38
package com.onlinelearning;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Managed Bean for Online Learning Platform
 */
@ManagedBean(name = "learningBean")
@ViewScoped
public class OnlineLearningPlatform implements Serializable {
    private List<Course> courses;
    private Course selectedCourse;

    /**
     * Default constructor
     */
    public OnlineLearningPlatform() {
        courses = new ArrayList<>();
        // Initialize with some sample courses
        Course course1 = new Course("Mathematics", "Learn basic to advanced mathematics concepts", 10);
        Course course2 = new Course("Physics", "Explore the principles of physics", 8);
        courses.add(course1);
        courses.add(course2);
    }

    /**
     * Handles course selection event
     *
     * @param actionEvent the action event triggered
     */
    public void onCourseSelect(ActionEvent actionEvent) {
        try {
            selectedCourse = (Course) actionEvent.getComponent().getAttributes().get("selectedCourse");
            if (selectedCourse == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Please select a course."));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error selecting course: " + e.getMessage()));
        }
    }

    /**
     * Returns the list of courses
     *
     * @return the list of courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses
     *
     * @param courses the list of courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Returns the selected course
     *
     * @return the selected course
     */
    public Course getSelectedCourse() {
        return selectedCourse;
    }

    /**
     * Sets the selected course
     *
     * @param selectedCourse the selected course to set
     */
    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    /**
     * Represents a course in the online learning platform
     */
    public static class Course {
        private String name;
        private String description;
        private int credits;

        public Course(String name, String description, int credits) {
            this.name = name;
            this.description = description;
            this.credits = credits;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCredits() {
            return credits;
        }

        public void setCredits(int credits) {
            this.credits = credits;
        }
    }
}