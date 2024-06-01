package milestone1;

public class node {
    String pageName;
    String pageId;
    String date;
    String siteUrl;
    boolean bookmark;
    node next;

    public node(String pageName, String pageId, String date, String siteUrl, boolean bookmark) {
        this.pageName = pageName;
        this.pageId = pageId;
        this.date = date;
        this.siteUrl = siteUrl;
        this.bookmark = bookmark;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Page_Name: " + pageName + ", Page_Id: " + pageId + ", Date: " + date + ", Site_URL: " + siteUrl + ", Bookmark: " + (bookmark ? "Yes" : "No");
    }
}
