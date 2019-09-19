import com.pereverzew.collectionlinkedlist.CollectionLinkedList;
import com.pereverzew.collectionlinkedlist.CollectionLinkedListImpl;
import com.pereverzew.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollectionLinkedListImplTest {

    private CollectionLinkedList<User> users;

    public CollectionLinkedListImplTest() {
        users = new CollectionLinkedListImpl<>();
    }

    @Before
    public void init(){
        users.add(new User("Vitaly","111","Director"));
        users.add(new User("Olya","333","Secretary"));
        users.add(new User("Tanya","444","Accountant"));
        users.add(new User("Alex","222","Developer"));
        users.add(new User("Andry","555","Developer"));
    }


    @Test
    public void test_add_checkSize() {
        User user=new User("Viktor","000","architect");
        users.add(user);
        Assert.assertEquals(6, users.size());
    }

    @Test
    public void test_add() {
        User user=new User("Nona","101","nobody");
        users.add(user);
        Assert.assertEquals(user,users.getByIndex(users.size()-1).get());
    }

    @Test
    public void test_get_NullElemen() {
        Assert.assertFalse(users.get(null).isPresent());
    }

    @Test
    public void test_get() {
        User user=new User("Viktor","000","architect");
        users.add(user);
        Assert.assertEquals(user,users.get(user).get());
    }

    @Test
    public void test_getByIndex_IllegalIndex() {
        Assert.assertFalse(users.getByIndex(-1).isPresent());
    }

    @Test
    public void test_getByIndex() {
        User user=new User("Veronika","300","accountant");
        users.add(user);
        Assert.assertEquals(user, users.getByIndex(users.size()-1).get());
    }

    @Test
    public void test_remove() {
        User user= new User("Tanya","444","Accountant");
        users.remove(user);
        Assert.assertFalse(users.get(user).isPresent());
    }

    @Test
    public void test_removeByIndex() {
        User user= new User("Ira","404","");
        users.add(user);
        users.removeByIndex(users.size()-1);
        Assert.assertFalse(users.get(user).isPresent());
    }
}
