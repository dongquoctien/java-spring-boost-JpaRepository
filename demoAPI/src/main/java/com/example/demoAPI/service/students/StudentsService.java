package com.example.demoAPI.service.students;

import com.example.demoAPI.api.mapper.omota.students.StudentsFluxMapper;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.example.demoAPI.utils.CommonUtils;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentsService {
    private final StudentsFluxMapper studentsFluxMapper;

    public Mono<JsonNode> getStudents (JsonNode request) {

        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put("name", request.at("/name").asText(request.at("/name").textValue()));

        return  studentsFluxMapper.getListStudent(conditionMap)
                .map(x ->  CommonUtils.getBaseTypeNode(CommonUtils.convertVoToJsonNode(x), "list"));
    }

}
