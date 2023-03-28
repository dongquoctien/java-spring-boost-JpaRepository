package com.example.demoAPI.api.handler.students;

import com.example.demoAPI.service.students.StudentsService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StudentsHandler {
    private final StudentsService studentsService;

    public Mono<ServerResponse> getStudents(ServerRequest request) {
        return ServerResponse.ok().body(request.bodyToMono(JsonNode.class).flatMap(studentsService::getStudents), JsonNode.class);
    }
}
