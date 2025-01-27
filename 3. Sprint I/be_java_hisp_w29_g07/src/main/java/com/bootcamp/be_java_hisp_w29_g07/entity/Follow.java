package com.bootcamp.be_java_hisp_w29_g07.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * This class represents a follow relationship between two users.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follow {
    /**
     * The unique identifier for the follow record.
     */
    private Integer id;
    /**
     * The user who follows another user.
     */
    private User follower;
    /**
     * The user who is being followed.
     */
    private User followed;
    /**
     * The date when the follow action occurred.
     */
    private LocalDate followDate;
}
