package org.kaspars.pasakumaBE.interfaces;

import org.kaspars.pasakumaBE.model.UserDTO;
import org.kaspars.pasakumaBE.model.UserModel;

public interface UserServiceInterface {
    UserDTO findOrSaveUser(UserModel user);

}
