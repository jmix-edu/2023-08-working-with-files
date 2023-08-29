package com.company.tm.screen.user;

import com.company.tm.entity.User;
import io.jmix.ui.component.Image;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("tm_User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {
    @Autowired
    private Image<byte[]> avatar;

    @Subscribe(id = "usersDc", target = Target.DATA_CONTAINER)
    public void onUsersDcItemChange(final InstanceContainer.ItemChangeEvent<User> event) {
        avatar.setVisible(event.getItem() != null);
    }
}