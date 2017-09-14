package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.ReadingItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/21/2017.
 */
@Service
public interface ShowPostOnUserProfilePageService {
   String getResources(String username, int firstresultindex);

}
