package com.chuangwei.internalAnswer.service;

import com.chuangwei.internalAnswer.dao.QuestionDAO;
import com.chuangwei.internalAnswer.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;


@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    /*@Autowired
    SensitiveService sensitiveService;*/


    /*public Question getById(int id) {
        return questionDAO.getById(id);
    }*/

    public int addQuestion(Question question) {
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));//过滤，转义html，渲染时自动转回，令其变得安全
        // 敏感词过滤
//        question.setTitle(sensitiveService.filter(question.getTitle()));
//        question.setContent(sensitiveService.filter(question.getContent()));

        return questionDAO.addQuestion(question) > 0 ? question.getId() : 0;
    }

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }

    /*public int updateCommentCount(int id, int count) {
        return questionDAO.updateCommentCount(id, count);
    }*/
}
