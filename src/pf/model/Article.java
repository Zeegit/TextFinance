package pf.model;

import pf.exception.ModelException;

public class Article extends Common {
    private String title;

    public Article() {
    }

    public Article(String title) throws ModelException {
        if (title.length() == 0) {
            throw new ModelException(ModelException.TITLE_EMPTY);
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" + "title='" + title + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return title != null ? title.equals(article.title) : article.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String getValueForComboBox() {
         return this.title;
    }
}
