package com.xphsc.mybatis.service;



import com.xphsc.mybatis.model.response.UserDTO;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
public interface UserService {
    public List<UserDTO> listUser();
}
