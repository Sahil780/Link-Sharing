package com.ttn.model.dao;

import com.ttn.beans.ReadingItem;
import com.ttn.beans.Resources;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/13/2017.
 */
@Component
public interface ShowInboxOnDashboardPageDao {
    List<ReadingItem> getResources(String username, int firstresultindex);
}
