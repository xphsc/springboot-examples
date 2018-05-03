package com.xphsc.dubbo.api.service;



import com.xphsc.dubbo.api.model.response.UserDTO;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
public interface UserService {
    public List<UserDTO> listUser();
}
