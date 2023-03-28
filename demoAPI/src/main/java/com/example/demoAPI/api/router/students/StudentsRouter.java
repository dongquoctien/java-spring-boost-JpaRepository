package com.example.demoAPI.api.router.students;

import com.example.demoAPI.api.handler.students.StudentsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;

@Component
public class StudentsRouter {
    @Bean
    public RouterFunction<ServerResponse> commonRoutes(StudentsHandler studentsHandler) {
        String url = "/students";
        return RouterFunctions
                .route(POST(url+"/list"), studentsHandler::getStudents)
                //.andRoute(POST(url+"/email"), commonHandler::commonEmail)
                ;
    }

}
