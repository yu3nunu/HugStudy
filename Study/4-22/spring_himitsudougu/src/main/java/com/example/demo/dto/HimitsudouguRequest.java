package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ひみつ道具情報 リクエストデータ
 */
@Data
public class HimitsudouguRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 100, message = "名前は100桁以内で入力してください")
  private String name;
  /**
   * 説明
   */
  @NotEmpty(message = "説明を入力してください")
  @Size(max = 255, message = "説明は255桁以内で入力してください")
  private String explanation;
  /**
   * 特徴
   */
  @NotEmpty(message = "特徴を入力してください")
  @Size(max = 255, message = "特徴は255桁以内で入力してください")
  private String feature;
}