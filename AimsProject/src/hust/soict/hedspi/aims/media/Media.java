package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    protected static int idCount = 0;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public Media(String title) {
        this.title = title;
        id = ++idCount;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        id = ++idCount;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        id = ++idCount;
    }

    public boolean equals(Object obj) throws ClassCastException, NullPointerException {
        if (obj == null) {
            throw new NullPointerException("ERROR: Null object!");
        }
        if (!(obj instanceof Media media)) {
            throw new ClassCastException("ERROR: Not a media!");
        }
        return (Objects.equals(this.title, media.title) && (this.cost == media.cost));
    }

    public boolean isMatch(String keyword) {
        String keywordLowerCase = keyword.toLowerCase();
        String titleLowerCase = title.toLowerCase();
        String[] words = keywordLowerCase.split(" ");
        for (String word : words) {
            if (!titleLowerCase.contains(word)) {
                return true;
            }
        }
        return false;
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

}
