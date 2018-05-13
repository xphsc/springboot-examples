package com.xphsc.jooq.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String uname;
    private String age;

}
