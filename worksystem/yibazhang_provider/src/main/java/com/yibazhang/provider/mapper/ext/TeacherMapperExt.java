package com.yibazhang.provider.mapper.ext;

import com.yibazhang.provider.entity.ext.TeacherExt;
import java.util.List;
import java.util.Map;

/**
 * @Author 一巴掌
 * @Date 2019/2/22 16:39
 * @Description TODO
 * @Version 1.0
 **/
public interface TeacherMapperExt {

    List<Map<String, Object>> selectTeachers(TeacherExt teacherExt);
}
