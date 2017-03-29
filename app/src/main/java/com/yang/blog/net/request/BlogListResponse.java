package com.yang.blog.net.request;

import com.yang.blog.base.BaseResponse;

import java.util.List;

/**
 * Created by YangShuang
 * on 2017/3/29.
 */

public class BlogListResponse extends BaseResponse{
    public static class BlogListElement{
        private String articleId;
        private String articleTime;
        private String articleTitle;
        private String articleContent;

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public String getArticleTime() {
            return articleTime;
        }

        public void setArticleTime(String articleTime) {
            this.articleTime = articleTime;
        }

        public String getArticleTitle() {
            return articleTitle;
        }

        public void setArticleTitle(String articleTitle) {
            this.articleTitle = articleTitle;
        }

        public String getArticleContent() {
            return articleContent;
        }

        public void setArticleContent(String articleContent) {
            this.articleContent = articleContent;
        }
    }

    private List<BlogListElement> list;

    public List<BlogListElement> getList() {
        return list;
    }

    public void setList(List<BlogListElement> list) {
        this.list = list;
    }
}
