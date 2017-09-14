package com.ttn.model.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 7/16/2017.
 */
@Component
public interface FetchUserInfoOnDashboardDao {
    List<?> userInfo(int id);
}
