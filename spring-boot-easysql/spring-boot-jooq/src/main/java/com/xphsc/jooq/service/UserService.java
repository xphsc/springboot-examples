package com.xphsc.jooq.service;



import com.xphsc.jooq.model.response.UserDTO;

import java.util.List;
import java.util.Optional;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
public interface UserService {
    public List<UserDTO> listUser();
}
