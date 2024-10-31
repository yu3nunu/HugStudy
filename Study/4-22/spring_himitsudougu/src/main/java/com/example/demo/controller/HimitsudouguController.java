package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.HimitsudouguRequest;
import com.example.demo.dto.HimitsudouguUpdateRequest;
import com.example.demo.entity.HimitsudouguEntity;
import com.example.demo.service.HimitsudouguService;


/**
 * 秘密道具情報 Controller
 */
@Controller
public class HimitsudouguController {

  /**
   * 秘密道具情報 Service
   */
  @Autowired
  HimitsudouguService himitsudouguService;

  /**
   * 秘密道具情報一覧画面を表示
   * @param model Model
   * @return 秘密道具情報一覧画面のHTML
   */
  @RequestMapping("/himitsudougu/list")
  public String himitsudouguList(Model model) {
    List<HimitsudouguEntity> himitsudougulist = himitsudouguService.searchAll();
    model.addAttribute("himitsudougulist", himitsudougulist);
    return "himitsudougu/list";
  }

  /**
   * 秘密道具新規登録画面を表示
   * @param model Model
   * @return 秘密道具情報登録画面
   */
  @RequestMapping("/himitsudougu/add")
  public String himitsudouguRegister(Model model) {
    model.addAttribute("himitsudouguRequest", new HimitsudouguRequest());
    return "himitsudougu/add";
  }

  /**
   * 秘密道具新規登録
   * @param himitsudouguRequest リクエストデータ
   * @param model Model
   * @return 秘密道具情報一覧画面
   */
  @RequestMapping("/himitsudougu/create")
  public String himitsudouguCreate(@Validated @ModelAttribute HimitsudouguRequest himitsudouguRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      //エラー判定後の画面遷移
      model.addAttribute("validationError", errorList);
      return "himitsudougu/add";
    }
    // 秘密道具情報の登録
    himitsudouguService.create(himitsudouguRequest);
    return "redirect:/himitsudougu/list";
  }

  /**
   * 秘密道具情報詳細画面を表示
   * @param id 表示する秘密道具ID
   * @param model Model
   * @return 秘密道具情報詳細画面
   */
  @GetMapping("/himitsudougu/{id}")
  public String himitsudouguDetail(@PathVariable Integer id, Model model) {
    HimitsudouguEntity himitsudougu = himitsudouguService.findById(id);
    model.addAttribute("himitsudouguData", himitsudougu);
    return "himitsudougu/view";
  }
  
  /**
   * 秘密道具編集画面を表示
   * @param id 表示する秘密道具ID
   * @param model Model
   * @return 秘密道具編集画面
   */
  @GetMapping("/himitsudougu/{id}/edit")
  public String himitsudouguEdit(@PathVariable Integer id, Model model) {
    // 編集対象の秘密道具情報を取得
    HimitsudouguEntity himitsudougu = himitsudouguService.findById(id);
    // 編集画面用のDTOに格納
    HimitsudouguUpdateRequest himitsudouguUpdateRequest = new HimitsudouguUpdateRequest();
    himitsudouguUpdateRequest.setId(himitsudougu.getId());
    himitsudouguUpdateRequest.setName(himitsudougu.getName());
    himitsudouguUpdateRequest.setFeature(himitsudougu.getFeature());
    himitsudouguUpdateRequest.setExplanation(himitsudougu.getExplanation());
    model.addAttribute("himitsudouguUpdateRequest", himitsudouguUpdateRequest);
    return "himitsudougu/edit";
  }

  /**
   * 秘密道具情報更新
   * @param himitsudouguUpdateRequest リクエストデータ
   * @param model Model
   * @return 秘密道具情報詳細画面
   */
  @RequestMapping("/himitsudougu/update")
  public String userUpdate(@Validated @ModelAttribute HimitsudouguUpdateRequest himitsudouguUpdateRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "himitsudougu/edit";
    }
    // 秘密道具情報の更新
    himitsudouguService.update(himitsudouguUpdateRequest);
    return String.format("redirect:/himitsudougu/%d", himitsudouguUpdateRequest.getId());
  }

  /**
   * 秘密道具情報削除
   * @param id 表示する秘密道具ID
   * @param model Model
   * @return 秘密道具情報一覧画面
   */
  @GetMapping("/himitsudougu/{id}/delete")
  public String himitsudouguDelete(@PathVariable Integer id, Model model) {
    // 秘密道具情報の削除
    himitsudouguService.delete(id);
    return "redirect:/himitsudougu/list";
  }
}
