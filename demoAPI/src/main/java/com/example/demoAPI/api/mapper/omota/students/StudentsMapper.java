package com.example.demoAPI.api.mapper.omota.students;

import com.example.demoAPI.api.mapper.omota.students.vo.StudentsVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentsMapper {

    List<StudentsVo> getListStudent(Map map);
}
