package org.example.test03.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.repository.NoticeRepository;
import org.example.test03.model.dto.NoticeDTO;
import org.example.test03.model.entity.NoticeEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    NoticeRepository noticeRepository;

    // 공지사항 조회
    public List<NoticeDTO> getAllNoticeList() {

        List<NoticeEntity> noticeEntities = noticeRepository.findAll();

        List<NoticeDTO> noticeDTOList = new ArrayList<>();

        for (NoticeEntity noticeEntity : noticeEntities) {
            if (noticeEntity == null) {
                continue;
            }

            noticeDTOList.add(toNoticeDTO(noticeEntity));
        }

        return noticeDTOList;
    }

    // 공지사항 등록
    public String registerNotice(NoticeDTO noticeDTO) {
        noticeDTO.setCreatedTime(LocalDateTime.now());

        noticeRepository.save(toNoticeEntity(noticeDTO));
        return "성공";
    }

    // 공지사항 수정
    public String updateNotice(NoticeDTO noticeDTO) {

        noticeRepository.save(toNoticeEntity(noticeDTO));
        return "성공";
    }

    // 공지사항 삭제
    public String deleteNotice(NoticeDTO noticeDTO) {

        noticeRepository.delete(toNoticeEntity(noticeDTO));
        return "성공";
    }

    // 상세 공지 조회
    public NoticeDTO getNoticeById(Integer noticeId){
        return toNoticeDTO(noticeRepository.findById(noticeId).get());
    }












    public NoticeDTO toNoticeDTO(NoticeEntity noticeEntity){
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNoticeNo(noticeEntity.getNoticeNo());
        noticeDTO.setNoticeName(noticeEntity.getNoticeName());
        noticeDTO.setUserName(noticeEntity.getUserName());
        noticeDTO.setCreatedTime(noticeEntity.getCreatedTime());
        noticeDTO.setNoticeContent(noticeEntity.getNoticeContent());
        return noticeDTO;
    }

    public NoticeEntity toNoticeEntity(NoticeDTO noticeDTO){
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setNoticeNo(noticeDTO.getNoticeNo());
        noticeEntity.setNoticeName(noticeDTO.getNoticeName());
        noticeEntity.setNoticeContent(noticeDTO.getNoticeContent());
        noticeEntity.setCreatedTime(noticeDTO.getCreatedTime());
        noticeEntity.setUserName(noticeDTO.getUserName());

        return noticeEntity;
    }
}
