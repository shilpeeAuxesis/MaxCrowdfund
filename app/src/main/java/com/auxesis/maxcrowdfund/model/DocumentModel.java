package com.auxesis.maxcrowdfund.model;

public class DocumentModel {
    String mDocumentTitle;
    String mDocumentUrl;

    public DocumentModel(String mDocumentTitle, String mDocumentUrl) {
        this.mDocumentTitle = mDocumentTitle;
        this.mDocumentUrl = mDocumentUrl;
    }

    public String getmDocumentTitle() {
        return mDocumentTitle;
    }

    public String getmDocumentUrl() {
        return mDocumentUrl;
    }
}
