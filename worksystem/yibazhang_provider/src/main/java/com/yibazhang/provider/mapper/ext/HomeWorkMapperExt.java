package com.yibazhang.provider.mapper.ext;

import com.yibazhang.provider.entity.ext.HomeWorkExt;

import java.util.List;
import java.util.Map;

public interface HomeWorkMapperExt {

    int insertHomeworkToStudentBatch(Map<String,Object> map);

    List<Map<String,Object>> selectHomeworkOfTeacher(HomeWorkExt homeWorkExt);
}