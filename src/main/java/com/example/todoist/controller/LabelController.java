package com.example.todoist.controller;

import com.example.todoist.model.Label;
import com.example.todoist.requestBean.LabelRequest;
import com.example.todoist.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rest/v1")
public class LabelController {

    @Autowired
    LabelService labelService;

    boolean checkValidLabelName(String labelName) {
        if (labelName == null || labelName.trim().length() == 0) {
            return false;
        }
        return true;
    }

    @GetMapping("/labels")
    @ResponseBody
    private ResponseEntity getAllLabels() {
        return new ResponseEntity(labelService.getAllLabels(), HttpStatus.OK);
    }

    @PostMapping("/labels")
    @ResponseBody
    private ResponseEntity createNewLabel(@RequestBody LabelRequest labelRequest) {
        if (!checkValidLabelName(labelRequest.getName())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Label label = new Label(labelRequest.getName().trim());
        labelService.saveLabel(label);
        return new ResponseEntity(label, HttpStatus.OK);
    }

    @GetMapping("/labels/{id}")
    @ResponseBody
    private ResponseEntity getSingleLabel(@PathVariable("id") Integer id) {
        if (labelService.getLabelById(id).getId() != null)
            return new ResponseEntity(labelService.getLabelById(id), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/labels/{id}")
    private ResponseEntity updateLabel(@PathVariable("id") Integer id, @RequestBody LabelRequest labelRequest) {
        if (!checkValidLabelName(labelRequest.getName())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        if (labelService.getLabelById(id).getId() != null) {
            Label label = labelService.getOneLabelById(id);
            label.setName(labelRequest.getName());
            labelService.saveLabel(label);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/labels/{id}")
    private ResponseEntity deleteLabel(@PathVariable("id") Integer id) {
        if (labelService.getLabelById(id).getId() != null) {
            labelService.deleteLabelById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}