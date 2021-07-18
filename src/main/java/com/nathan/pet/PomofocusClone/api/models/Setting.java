package com.nathan.pet.PomofocusClone.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@Entity
public class Setting {
  private @Id @GeneratedValue Long id;
  private String createdAt;
  private String updatedAt;
  private int pomodoro;
  private int shortBreak;
  private int longBreak;
  private boolean autoStartBreak;
  private boolean autoStartPomodoro;
  private int longBreakInterval;
  private String alarmSound;
  private String tickingSpeed;
  private int alarmVolume;
  private boolean darkMode;
  private boolean notificationMode;
  private int notificationMinutes;

  public Setting(String createdAt, String updateAt, int pomodoro, int shortBreak, int longBreak, boolean autoStartBreak,
                 boolean autoStartPomodoro, int longBreakInterval, String alarmSound, String tickingSpeed, int alarmVolume,
                 boolean darkMode, boolean notificationMode, int notificationMinutes) {
    this.createdAt = createdAt;
    this.updatedAt = updateAt;
    this.pomodoro = pomodoro;
    this.shortBreak = shortBreak;
    this.longBreak = longBreak;
    this.autoStartBreak = autoStartBreak;
    this.autoStartPomodoro = autoStartPomodoro;
    this.longBreakInterval = longBreakInterval;
    this.alarmSound = alarmSound;
    this.tickingSpeed = tickingSpeed;
    this.alarmVolume = alarmVolume;
    this.darkMode = darkMode;
    this.notificationMode = notificationMode;
    this.notificationMinutes = notificationMinutes;
  }

  public Long getId() {
    return id;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public int getPomodoro() {
    return pomodoro;
  }

  public int getShortBreak() {
    return shortBreak;
  }

  public int getLongBreak() {
    return longBreak;
  }

  public boolean isAutoStartBreak() {
    return autoStartBreak;
  }

  public boolean isAutoStartPomodoro() {
    return autoStartPomodoro;
  }

  public int getLongBreakInterval() {
    return longBreakInterval;
  }

  public String getAlarmSound() {
    return alarmSound;
  }

  public String getTickingSpeed() {
    return tickingSpeed;
  }

  public int getAlarmVolume() {
    return alarmVolume;
  }

  public boolean isDarkMode() {
    return darkMode;
  }

  public boolean isNotificationMode() {
    return notificationMode;
  }

  public int getNotificationMinutes() {
    return notificationMinutes;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setPomodoro(int pomodoro) {
    this.pomodoro = pomodoro;
  }

  public void setShortBreak(int shortBreak) {
    this.shortBreak = shortBreak;
  }

  public void setLongBreak(int longBreak) {
    this.longBreak = longBreak;
  }

  public void setAutoStartBreak(boolean autoStartBreak) {
    this.autoStartBreak = autoStartBreak;
  }

  public void setAutoStartPomodoro(boolean autoStartPomodoro) {
    this.autoStartPomodoro = autoStartPomodoro;
  }

  public void setLongBreakInterval(int longBreakInterval) {
    this.longBreakInterval = longBreakInterval;
  }

  public void setAlarmSound(String alarmSound) {
    this.alarmSound = alarmSound;
  }

  public void setTickingSpeed(String tickingSpeed) {
    this.tickingSpeed = tickingSpeed;
  }

  public void setAlarmVolume(int alarmVolume) {
    this.alarmVolume = alarmVolume;
  }

  public void setDarkMode(boolean darkMode) {
    this.darkMode = darkMode;
  }

  public void setNotificationMode(boolean notificationMode) {
    this.notificationMode = notificationMode;
  }

  public void setNotificationMinutes(int notificationMinutes) {
    this.notificationMinutes = notificationMinutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Setting setting = (Setting) o;
    return pomodoro == setting.pomodoro && shortBreak == setting.shortBreak && longBreak == setting.longBreak &&
        autoStartBreak == setting.autoStartBreak && autoStartPomodoro == setting.autoStartPomodoro &&
        longBreakInterval == setting.longBreakInterval && alarmVolume == setting.alarmVolume &&
        darkMode == setting.darkMode && notificationMode == setting.notificationMode &&
        notificationMinutes == setting.notificationMinutes && id.equals(setting.id) && createdAt.equals(setting.createdAt) &&
        Objects.equals(updatedAt, setting.updatedAt) && Objects.equals(alarmSound, setting.alarmSound) &&
        Objects.equals(tickingSpeed, setting.tickingSpeed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, updatedAt, pomodoro, shortBreak, longBreak, autoStartBreak, autoStartPomodoro,
        longBreakInterval, alarmSound, tickingSpeed, alarmVolume, darkMode, notificationMode, notificationMinutes);
  }

  @Override
  public String toString() {
    return "Setting{" +
        "id=" + id +
        ", createdAt='" + createdAt + '\'' +
        ", updatedAt='" + updatedAt + '\'' +
        ", pomodoro=" + pomodoro +
        ", shortBreak=" + shortBreak +
        ", longBreak=" + longBreak +
        ", autoStartBreak=" + autoStartBreak +
        ", autoStartPomodoro=" + autoStartPomodoro +
        ", longBreakInterval=" + longBreakInterval +
        ", alarmSound='" + alarmSound + '\'' +
        ", tickingSpeed='" + tickingSpeed + '\'' +
        ", alarmVolume=" + alarmVolume +
        ", darkMode=" + darkMode +
        ", notificationMode=" + notificationMode +
        ", notificationMinutes=" + notificationMinutes +
        '}';
  }
}
