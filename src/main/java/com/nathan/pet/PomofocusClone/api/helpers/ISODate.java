package com.nathan.pet.PomofocusClone.api.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ISODate{
  public ISODate() {}

  public static String getDate() {
    TimeZone tz = TimeZone.getTimeZone("UTC");
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    df.setTimeZone(tz);
    String nowAsISO = df.format(new Date());
    return nowAsISO;
  }
}

