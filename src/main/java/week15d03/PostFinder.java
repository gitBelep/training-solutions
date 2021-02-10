package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PostFinder {
    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPostsFor(String user){
        List<Post> result = new ArrayList<>();
        for (Post actual : posts){
            if (actual.getOwner().equals(user) &&
                isTitleAndContentFilledOut(actual.getTitle(), actual.getContent()) &&
                isPublishedInThePast(actual.getPublishedAt())){
                result.add(actual);
            }
        }
        result.sort(Comparator.comparing(Post::getPublishedAt));
        return result;
    }

    private boolean isPublishedInThePast(LocalDate publishingDate){
        return publishingDate.isBefore(LocalDate.now());
    }

    private boolean isTitleAndContentFilledOut(String title, String content){
        return !content.isBlank() && !title.isBlank();
    }

}
