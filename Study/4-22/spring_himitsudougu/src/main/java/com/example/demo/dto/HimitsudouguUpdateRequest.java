package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ひみつ道具情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class HimitsudouguUpdateRequest extends HimitsudouguRequest implements Serializable {

  /**
   * ユーザーID
   */
  @NotNull
  private Integer id;
}
