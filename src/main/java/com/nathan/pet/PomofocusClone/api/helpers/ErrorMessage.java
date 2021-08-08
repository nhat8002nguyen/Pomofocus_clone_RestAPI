package com.nathan.pet.PomofocusClone.api.helpers;

import net.minidev.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {
  public static JSONObject create(String key, String value) {
    Map<String, String> message = new HashMap<>();
    message.put(key, value);
    return new JSONObject(message);
  }
}
