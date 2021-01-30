package com.tera.project.springboot.service.consult;

import com.tera.project.springboot.domain.consult.Consult;
import com.tera.project.springboot.domain.consult.ConsultRepository;
import com.tera.project.springboot.domain.consult.ConsultSaveHistoryRepository;
import com.tera.project.springboot.domain.posts.Posts;
import com.tera.project.springboot.domain.posts.PostsRepository;
import com.tera.project.springboot.web.dto.ConsultSaveHistoryDto;
import com.tera.project.springboot.web.dto.ConsultSaveRequestDto;
import com.tera.project.springboot.web.dto.PostsSaveRequestDto;
import com.tera.project.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ConsultService {
    private final ConsultRepository consultRepository;
    private final ConsultSaveHistoryRepository consultSaveHistoryRepository;

    @Transactional
    public Long save(ConsultSaveRequestDto requestDto) {
        Consult result = consultRepository.save(requestDto.toEntity());
        ConsultSaveHistoryDto historyDto = new ConsultSaveHistoryDto(requestDto.getUser(),requestDto.getConsultStatus(), result);
        consultSaveHistoryRepository.save(historyDto.toEntity());
        return result.getId();
    }

    @Transactional
    public Long update(Long id, ConsultSaveRequestDto requestDto) {
        Consult consult = consultRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        consult.update(requestDto.getReception(),requestDto.getProceeding(),requestDto.getConsultStatus(),requestDto.getConsultType());
        return id;
    }
}
