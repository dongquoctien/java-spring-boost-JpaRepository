package com.example.demoAPI.api.mapper.omota.students;

import com.example.demoAPI.api.mapper.omota.students.vo.StudentsVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentsFluxMapper {

    private final StudentsMapper studentsMapper;

    public Mono<List<StudentsVo>> getListStudent(Map map) {
        return Mono.fromCallable(() -> studentsMapper.getListStudent(map));
    }
}
