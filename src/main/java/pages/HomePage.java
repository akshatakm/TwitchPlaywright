package pages;

import Helpers.PlaywrightFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class HomePage {

    Page page;

    public HomePage(Page page){
        this.page = page;
    }
    String videoLinks = "img[class = tw-image]";
    String searchBox = "#tw-3458b0586328585c33bee652208ab17d";

    public boolean searchItem(String searchText){
        Locator search = page.getByText("Browse");
        search.click();
        Locator searchBox = page.getByPlaceholder("Search");
        searchBox.click();
        searchBox.fill(searchText);
        page.keyboard().press("Enter");
        page.waitForTimeout(2000);
        if(searchBox.textContent().equals(searchText)){
            return true;
        }
        return false;
    }

    public boolean scrollAndClick(){
        boolean videoPageLand = false;
        Locator videoLinkArray = page.locator(videoLinks);
        page.mouse().wheel(0,500);
        page.mouse().wheel(0,500);
        for(int i = 0; i<videoLinkArray.count();i++){
            if(videoLinkArray.nth(i).isVisible()){
                videoLinkArray.nth(i).click();
                page.waitForTimeout(5000);
                if(page.getByText("Share this video").isVisible() || page.getByText("Follow").isVisible()){
                    videoPageLand = true;
                }
                break;
            }
        }
        PlaywrightFactory.takeScreenshot();
        return videoPageLand;
    }
}
