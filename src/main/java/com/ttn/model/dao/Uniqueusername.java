package com.ttn.model.dao;

import org.springframework.stereotype.Service;

/**
 * Created by user on 7/3/2017.
 */
@Service
public interface Uniqueusername {
    public boolean checkavailability(String username);
}
