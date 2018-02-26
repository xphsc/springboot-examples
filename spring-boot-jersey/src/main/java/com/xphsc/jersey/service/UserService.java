package com.xphsc.jersey.service;





import com.xphsc.jersey.model.response.UserDTO;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
public interface UserService {
    public List<UserDTO> listUser();
    public UserDTO  findUserByid(Integer id);
    public UserDTO addUser(UserDTO userDTO);
}
