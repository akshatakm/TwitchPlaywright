🎮 TwitchPlaywright
Playwright automation tests for Twitch.tv UI using Java, targeting real-world workflows like game search, scrolling, clicking visible elements, and stream validation — all in a mobile (iPhone 12) emulated environment.

📌 Features
✅ Mobile browser emulation (iPhone 12)

🔍 Search automation for games like "StarCraft II"

🖱️ Scroll + click on first visible stream element

🧪 Validate page load via reliable selectors

🎥 Video recording & screenshot capture

🧰 Extensible Java framework (Playwright + Maven or Gradle)

🚀 Getting Started
1. Clone the repo
bash
Copy
Edit
git clone https://github.com/akshatakm/TwitchPlaywright.git
cd TwitchPlaywright
2. Install Dependencies
Install Playwright for Java:

bash
Copy
Edit
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
3. Run a Test
bash
Copy
Edit
mvn test
🧪 Example Use Case
Automated test that:

Opens twitch.tv in mobile mode

Searches for StarCraft II

Scrolls the page

Clicks the first visible stream

Waits for stream title to appear

Validates the navigation

🎞 Video Recording
To record test runs, browser contexts are configured to save .webm files:

java
Copy
Edit
BrowserContext context = browser.newContext(new Browser.NewContextOptions()
  .setRecordVideoDir(Paths.get("videos"))
  .setRecordVideoSize(1280, 720));
After the test:

java
Copy
Edit
Path videoPath = page.video().path();
System.out.println("Video saved at: " + videoPath.toAbsolutePath());
📁 Project Structure
bash
Copy
Edit
TwitchPlaywright/
├── src/test/java/           # Playwright UI tests
├── videos/                  # Recorded videos from test runs
├── screenshots/             # Captured screenshots
├── pom.xml                  # Maven build file
├── README.md                # This file
⚙️ Tech Stack
Playwright Java

Java 11+

Maven

(Optionally) GitHub Actions for CI

💡 Future Enhancements
CI pipeline with video artifact upload

Parameterized test support for multiple search terms

More validations (e.g., viewer count, stream metadata)

Playwright Test Report integration


Test run Gif:
