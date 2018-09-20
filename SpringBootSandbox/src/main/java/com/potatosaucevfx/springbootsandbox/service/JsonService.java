package com.potatosaucevfx.springbootsandbox.service;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Richard Nader Jr. <heelyskidrj@gmail.com>
 */
@Repository
public class JsonService {

    @Autowired
    JSONParser parser;
}
