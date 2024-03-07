package org.example.test03.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticeDTO {


    private Integer noticeNo;


    private String noticeName;


    private String userName;


    private LocalDateTime createdTime;


    private String noticeContent;
}
