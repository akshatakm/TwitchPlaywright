import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class VideoClickTest extends BaseTest{

    HomePage homePage;
    @Test
    public void videoClick(){
        homePage = new HomePage(page);
        homePage.searchItem("StarCraft II");
        Assert.assertTrue(homePage.scrollAndClick());
    }
}
