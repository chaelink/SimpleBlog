package sss.simpleblog.post.memoryrepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sss.simpleblog.post.MemoryPostRepository;
import sss.simpleblog.post.Post;

public class MemoryPostRepositoryTest {

    @Test
    void savePostUIDTest() {
        MemoryPostRepository memoryPostRepository = new MemoryPostRepository();

        Post firstData = new Post();
        Post secondData = new Post();
        Post thirdData = new Post();

        firstData.setTitle("First");
        secondData.setTitle("second");
        thirdData.setTitle("third");

        memoryPostRepository.save(firstData);
        memoryPostRepository.save(secondData);
        memoryPostRepository.save(thirdData);

        Assertions.assertThat(firstData.getUid()).isEqualTo(0);
        Assertions.assertThat(secondData.getUid()).isEqualTo(1);
        Assertions.assertThat(thirdData.getUid()).isEqualTo(2);
    }

    @Test
    void findByIncludeContentsTest() {
        MemoryPostRepository memoryPostRepository = new MemoryPostRepository();

        Post firstData = new Post();
        Post secondData = new Post();
        Post thirdData = new Post();

        firstData.setTitle("First");
        firstData.setContents("abcdefg");
        secondData.setTitle("second");
        secondData.setContents("abcqwer");
        thirdData.setTitle("third");
        thirdData.setContents("qwert");

        memoryPostRepository.save(firstData);
        memoryPostRepository.save(secondData);
        memoryPostRepository.save(thirdData);

        Assertions.assertThat(memoryPostRepository.findByIncludeContents("abc")).contains(firstData, secondData);
        Assertions.assertThat(memoryPostRepository.findByIncludeContents("ert")).contains(thirdData);
    }

    @Test
    void findByDateOrderedPageTest() {
        MemoryPostRepository memoryPostRepository = new MemoryPostRepository();

        Post firstData = new Post();
        Post secondData = new Post();
        Post thirdData = new Post();

        firstData.setTitle("First");
        secondData.setTitle("second");
        thirdData.setTitle("third");

        memoryPostRepository.save(firstData);
        memoryPostRepository.save(secondData);
        memoryPostRepository.save(thirdData);

        Assertions.assertThat(memoryPostRepository.findByDateOrderedPage(2L, 0L, false)).containsExactlyInAnyOrder(firstData, secondData);
    }
}
