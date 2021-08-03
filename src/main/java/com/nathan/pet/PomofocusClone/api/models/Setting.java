package com.nathan.pet.PomofocusClone.api.models;

import com.nathan.pet.PomofocusClone.api.helpers.ISODate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import static com.nathan.pet.PomofocusClone.api.constants.defaultSetting.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
public class Setting {
  private @Id @GeneratedValue Long id;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Date createdAt;

  @Column(nullable = false)
  @UpdateTimestamp
  private Date updatedAt;

   @Min(value = MIN_MINUTES)
  private int pomodoro = POMODORO;

   @Min(value = MIN_MINUTES)
  private int shortBreak = SHORT_BREAK;

   @Min(value = MIN_MINUTES)
  private int longBreak = LONG_BREAK;

  private boolean autoStartBreak = AUTO_START_BREAK;

  private boolean autoStartPomodoro = AUTO_START_POMODORO;

  @Min(MIN_INTERVAL) @Max(MAX_INTERVAL)
  private int longBreakInterval = LONG_BREAK_INTERVAL;

  private String alarmSound = ALARM_SOUND;

  private String tickingSpeed = TICKING_SPEED;

  @Min(MIN_VOLUME) @Max(MAX_VOLUME)
  private int alarmVolume = ALARM_VOLUME;

  @Min(MIN_REPEAT) @Max(MAX_REPEAT)
  private int alarmRepeat = ALARM_REPEAT;

  @Min(MIN_VOLUME) @Max(MAX_VOLUME)
  private int tickingVolume = TICKING_VOLUME;

  private boolean darkMode = DARK_MODE;

  private String notificationMode = NOTIFICATION_MODE;

  @Min(MIN_MINUTES)
  private int notificationMinutes = NOTIFICATION_MINUTES;

  @OneToOne(mappedBy = "setting")
  private User user;

  public Setting() {};

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public Setting(Date createdAt, Date updateAt, int pomodoro, int shortBreak, int longBreak, boolean autoStartBreak,
                 boolean autoStartPomodoro, int longBreakInterval, String alarmSound, String tickingSpeed, int alarmVolume,
                 int alarmRepeat, int tickingVolume, boolean darkMode, String notificationMode, int notificationMinutes) {
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
    this.alarmRepeat = alarmRepeat;
    this.tickingVolume = tickingVolume;
    this.darkMode = darkMode;
    this.notificationMode = notificationMode;
    this.notificationMinutes = notificationMinutes;
  }

  public Long getId() {
    return id;
  }

  public void setAlarmRepeat(int alarmRepeat) {
    this.alarmRepeat = alarmRepeat;
  }

  public void setTickingVolume(int tickingVolume) {
    this.tickingVolume = tickingVolume;
  }

  public int getAlarmRepeat() {
    return alarmRepeat;
  }

  public int getTickingVolume() {
    return tickingVolume;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
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

  public String getNotificationMode() {
    return notificationMode;
  }

  public int getNotificationMinutes() {
    return notificationMinutes;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setPomodoro(int pomodoro) {
    this.pomodoro = pomodoro;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
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

  public void setNotificationMode(String notificationMode) {
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
