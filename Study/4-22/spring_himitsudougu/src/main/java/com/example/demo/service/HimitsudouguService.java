package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.HimitsudouguRequest;
import com.example.demo.dto.HimitsudouguUpdateRequest;
import com.example.demo.entity.HimitsudouguEntity;
import com.example.demo.repository.HimitsudouguRepository;

/**
 * ひみつ道具情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HimitsudouguService {

  /**
   * ひみつ道具情報 Repository
   */
  @Autowired
  private HimitsudouguRepository himitsudouguRepository;

  /**
   * ひみつ道具情報 全検索
   * @return 検索結果
   */
  public List<HimitsudouguEntity> searchAll() {
    return himitsudouguRepository.findAll();
  }

  /**
   * ひみつ道具情報 主キー検索
   * @param id ひみつ道具ID
   * @return 検索結果
   */
  public HimitsudouguEntity findById(Integer id) {
    return himitsudouguRepository.findById(id).orElse(null);
  }

  /**
   * ひみつ道具情報 新規登録
   * @param himitsudouguRequest ひみつ道具情報
   */
  public void create(HimitsudouguRequest himitsudouguRequest) {
      Date now = new Date();
      HimitsudouguEntity himitsudougu = new HimitsudouguEntity();
      himitsudougu.setName(himitsudouguRequest.getName());
      himitsudougu.setExplanation(himitsudouguRequest.getExplanation());
      himitsudougu.setFeature(himitsudouguRequest.getFeature());
      himitsudougu.setCreateDate(now);
      himitsudougu.setUpdateDate(now);
      himitsudouguRepository.save(himitsudougu);
  }

  /**
   * ひみつ道具情報 更新
   * @param himitsudouguUpdateRequest ひみつ道具情報更新リクエスト
   */
  public void update(HimitsudouguUpdateRequest himitsudouguUpdateRequest) {
    HimitsudouguEntity himitsudougu = findById(himitsudouguUpdateRequest.getId());
    if (himitsudougu != null) {
      himitsudougu.setExplanation(himitsudouguUpdateRequest.getExplanation());
      himitsudougu.setName(himitsudouguUpdateRequest.getName());
      himitsudougu.setFeature(himitsudouguUpdateRequest.getFeature());
      himitsudougu.setUpdateDate(new Date());
      himitsudouguRepository.save(himitsudougu);
    }
  }

  /**
   * ひみつ道具情報 物理削除
   * @param id ひみつ道具ID
   */
  public void delete(Integer id) {
    HimitsudouguEntity himitsudougu = findById(id);
    if (himitsudougu != null) {
      himitsudouguRepository.delete(himitsudougu);
    }
  }
}
