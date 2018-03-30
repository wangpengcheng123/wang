package com.dt59.dao;

import java.util.List;

import com.dt59.entity.QuestionInfo;

/**
 * 1)列出所有试题信息
		2)按科目查询
		3)按题干模糊查询
		4)添加试题
		5)删除试题
		6)退出系统
 * */
public interface BizDao {
	List<QuestionInfo> getAllQuestionInfo();//列出所有试题信息
	List<QuestionInfo> getQuestionInfoByKm(int subject);//按科目查询
	List<QuestionInfo> getQuestionInfoByTg(String title);//按题干模糊查询
	int saveQuestionInfo(QuestionInfo info);//添加试题
	int deleteQuestionInfoById(int id);//通过id删除
	void exitQuestion();
}
