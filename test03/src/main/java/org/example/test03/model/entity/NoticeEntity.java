package org.example.test03.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tbl_table")
public class NoticeEntity {

    @Id
    @Column(name = "NOTICE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeNo;

    @Column(name = "NOTICE_NAME")
    private String noticeName;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @Column(name = "NOTICE_CONTENT")
    private String noticeContent;

}
