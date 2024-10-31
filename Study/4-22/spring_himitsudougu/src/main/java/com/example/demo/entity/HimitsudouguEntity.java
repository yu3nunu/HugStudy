package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ひみつ道具情報 Entity
 */
@Data
@Entity
@Table(name = "himitsudougu", schema = "public")
public class HimitsudouguEntity  {

  /**
   * ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;


  /**
   * 名前
   */
  @Column(name = "name")
  private String name;


  /**
   * 説明
   */
  @Column(name = "explanation")
  private String explanation;


  /**
   * 特徴
   */
  @Column(name = "feature")
  private String feature;


  /**
   * 更新日時
   */
  @Column(name = "update_date")
  private Date updateDate;


  /**
   * 登録日時
   */
  @Column(name = "create_date")
  private Date createDate;
  
  /**
   * 削除日時
   */
  @Column(name = "deleted_at") // データベースのカラム名
  private LocalDateTime deletedAt; // 削除日時のフィールドを追加
}