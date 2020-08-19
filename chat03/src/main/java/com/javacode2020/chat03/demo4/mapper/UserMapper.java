package com.javacode2020.chat03.demo4.mapper;

import com.javacode2020.chat03.demo4.dto.UserFindDto;
import com.javacode2020.chat03.demo4.model.UserModel;
import org.apache.ibatis.session.ResultHandler;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author 水面行走
 * @date 2020/8/18 9:31 
 */

public interface UserMapper {
    // 当只有一个参数时 #{xxx} xxx参数名随意
    UserModel getByName(String name);

    // map传参
    List<UserModel> getByMap(Map<String, Object> maps);

    List<UserModel> getListByUserFindDto(UserFindDto userFindDto);

    UserModel getByIdOrName(Long id, String name);
    UserModel getByIdOrName1(Long id, String name);

    List<UserModel> getListByIdCollection(Collection<Long> idCollection);

    // org.apache.ibatis.session.defaults.DefaultSqlSession#wrapCollection
    //    private Object wrapCollection(final Object object) {
    //    if (object instanceof Collection) {
    //      StrictMap<Object> map = new StrictMap<>();
    //      map.put("collection", object);
    //      if (object instanceof List) {
    //        map.put("list", object);
    //      }
    //      return map;
    //    } else if (object != null && object.getClass().isArray()) {
    //      StrictMap<Object> map = new StrictMap<>();
    //      map.put("array", object);
    //      return map;
    //    }
    //    return object;
    //  }
    // list = Collection + list
    List<UserModel> getListByIdList(List<Long> idList);

    // 当查询量大时 通过ResultHandler 通过next
    void getList(ResultHandler<UserModel> resultHandler);
}
