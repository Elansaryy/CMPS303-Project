package HashTables;

import java.io.Serializable;

public class Website implements Serializable {

     private String url;
    private String date;
    private String time;
    private String title;

    public Website(String url, String date, String title, String time) {
        this.url = url;
        this.date = date;
        this.time = time;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

	@Override
	public String toString() {
		return "Website title: "+title+ ", url: " + url + ", Visited in date: " + date + ", at: " + time;
	}
}
