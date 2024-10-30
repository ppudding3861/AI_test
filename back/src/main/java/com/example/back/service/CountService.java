package com.example.back.service;

import com.example.back.model.Count;
import com.example.back.model.CountDTO;
import com.example.back.repository.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountService {

    private final CountRepository countRepository;

    @Autowired
    public CountService(CountRepository countRepository) {
        this.countRepository = countRepository;
    }

    // Count 데이터를 가져오는 메서드
    public CountDTO getCount(Integer countId) {
        Count count = countRepository.findById(countId)
                .orElse(new Count(countId, 0)); // countId와 초기 countNum 값을 설정한 새 Count 객체 반환

        return new CountDTO(count.getCountId(), count.getCountNum());
    }

    // 카운트를 증가시키는 메서드
    public Count incread(CountDTO countDTO) {
        Count count = countRepository.findById(countDTO.getCountId())
                .orElse(new Count(countDTO.getCountId(), 0));

        count.setCountNum(count.getCountNum() + 1);

        return countRepository.save(count);
    }

    // 카운트를 감소시키는 메서드
    public Count decread(CountDTO countDTO) {
        Count count = countRepository.findById(countDTO.getCountId())
                .orElse(new Count(countDTO.getCountId(), 0));

        count.setCountNum(count.getCountNum() - 1);

        return countRepository.save(count);
    }
}
