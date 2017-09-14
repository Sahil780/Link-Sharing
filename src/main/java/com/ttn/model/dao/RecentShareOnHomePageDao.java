package com.ttn.model.dao;

import com.ttn.beans.Resources;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 7/21/2017.
 */
@Component
public interface RecentShareOnHomePageDao {
    List<Resources> getRsources();
}
