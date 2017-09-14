package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.ReadingItem;
import com.ttn.beans.Resources;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 7/13/2017.
 */
@Service
public interface ShowInboxOnDashboardPageService {
    String getResources(String username, int firstresultindex);

}
