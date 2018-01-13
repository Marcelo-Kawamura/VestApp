package com.example.vestibular.vestibulapp.infraestruture.parser;

import org.json.JSONObject;

/**
 * Created by renan on 03/01/2018.
 */

 public interface BaseParser {
     public Object jsonToEntity(JSONObject response);
}
