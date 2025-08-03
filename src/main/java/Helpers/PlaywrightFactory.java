package Helpers;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ViewportSize;
import com.microsoft.playwright.options.WaitUntilState;

import java.lang.foreign.StructLayout;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    private static Page page;
    static String OutputFolder = "./build"+System.currentTimeMillis()+"/";


    public Page init(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(300));
        Path videoDir = Paths.get(OutputFolder+"videos");
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(new ViewportSize(428, 926))
                .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 13_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.1 Mobile/15E148 Safari/604.1")
                .setDeviceScaleFactor(2.0)
                .setIsMobile(true)
                .setHasTouch(true)
                .setRecordVideoDir(videoDir));
        page = browserContext.newPage();
        page.setDefaultNavigationTimeout(60000);
        page.navigate("https://www.twitch.tv/", new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        page.waitForTimeout(1000);
        System.out.println(page.title());
        return page;
    }

    public static void tearDown() {
        Path videoPath = page.video().path();
        System.out.println("🎥 Video saved at: " + videoPath.toAbsolutePath());
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }

    public static void takeScreenshot(){
        String path = OutputFolder + "screenshot/" + System.currentTimeMillis()+".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
    }
}
