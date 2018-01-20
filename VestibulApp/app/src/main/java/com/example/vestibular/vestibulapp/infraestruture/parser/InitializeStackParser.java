package com.example.vestibular.vestibulapp.infraestruture.parser;

import com.example.vestibular.vestibulapp.domain.entity.Stack;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by marcelo on 15/01/18.
 */

public class InitializeStackParser implements BaseParser{
    @Override
    public Object jsonToEntity(JSONObject response) {
        int game_id;
        try{
            game_id = Integer.parseInt(response.getString("game_id"));
            return game_id;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
