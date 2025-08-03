🎮 TwitchPlaywright
Automated Playwright Java tests targeting Twitch.tv. This project emulates mobile browsers (e.g. iPhone 12), performs game searches (e.g. StarCraft II), scrolls through results, clicks streams or videos, and validates navigation. Useful for end-to-end mobile UI testing of Twitch flows.

🚀 Features
- Mobile device emulation using Playwright's built‑in device descriptors
- Search automation, scroll-based element detection, and click-with-viewport awareness
- Reliable navigation handling via selector-based synchronization (e.g. stream title or player loaded)
- Optional video recording, screenshots, and test reporting
- TestNG integration with ExtentReports for comprehensive test reporting
- Ready for CI/CD (e.g. GitHub Actions)

📁 Project Structure
```
TwitchPlaywright/
├── src/
│   ├── main/java/
│   │   ├── Helpers/              # PlaywrightFactory and utility classes
│   │   └── pages/                # Page Object Model classes (HomePage)
│   ├── test/java/
│   │   ├── BaseTest.java         # Base test configuration
│   │   └── VideoClickTest.java   # Test implementation
│   └── testngxml/
│       └── searchTest.xml        # TestNG configuration
├── build*/                       # Test run output directories
│   ├── screenshot/               # Test screenshots
│   └── videos/                   # Recorded test videos
├── videos/                       # Additional test videos
├── target/                       # Maven build output
├── pom.xml                       # Maven project configuration
├── .gitignore                    # Git ignore rules
└── README.md                     # This file
```

⚙️ Prerequisites
- Java JDK 23+
- Maven 3.6+
- Playwright Java dependency (included in pom.xml)
- Playwright binaries installed via CLI: `playwright install`

🔧 Setup Instructions
1. Clone the repository
2. Install Playwright browsers:
   ```bash
   mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
   ```
3. Run tests:
   ```bash
   mvn test
   ```
   Or run specific TestNG suite:
   ```bash
   mvn test -DsuiteXmlFile=src/testngxml/searchTest.xml
   ```

📊 Test Reports
- Test videos and screenshots are saved in `build*/` directories
- Each test run creates a timestamped build directory

🧪 Test Configuration
- Tests use TestNG framework with XML configuration
- Mobile device emulation is configured in `PlaywrightFactory`
- Page Object Model pattern is implemented for maintainable tests
- Video recording and screenshots are enabled by default

🔍 Key Components
- `BaseTest.java`: Base test class with common setup and teardown
- `VideoClickTest.java`: Main test implementation for Twitch video interaction
- `PlaywrightFactory.java`: Playwright browser and context management
- `HomePage.java`: Page Object for Twitch home page interactions

GIF file for local run: 
![alt text](https://github.com/akshatakm/TwitchPlaywright/blob/main/videos/7a9846b783328f137b1f506ae1dddec7.gif#:~:text=videos-,7a9846b783328f137b1f506ae1dddec7,-.gif)

