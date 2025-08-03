🎮 TwitchPlaywright
Automated Playwright Java tests targeting Twitch.tv. This project emulates mobile browsers (e.g. iPhone 12), performs game searches (e.g. StarCraft II), scrolls through results, clicks streams or videos, and validates navigation. Useful for end-to-end mobile UI testing of Twitch flows.



🚀 Features
Mobile device emulation using Playwright’s built‑in device descriptors

Search automation, scroll-based element detection, and click-with-viewport awareness

Reliable navigation handling via selector-based synchronization (e.g. stream title or player loaded)

Optional video recording, screenshots, and test reporting

Test runner integration with JUnit/TestNG (if used)

Ready for CI/CD (e.g. GitHub Actions)


📁 Project Structure
bash
Copy
Edit
TwitchPlaywright/
├── src/
│   └── main/java/…               # Java utility/helper classes
│   └── test/java/…               # Playwright test cases
├── videos/                       # Recorded test videos
├── screenshots/                  # Test-run screenshots
├── pom.xml or build.gradle       # Project build config
├── README.md                     # This file
└── .github/
    └── workflows/                # CI pipeline definitions


⚙️ Prerequisites
Java JDK 11+

Maven or Gradle (depending on project setup)

Playwright Java dependency

Playwright binaries installed via CLI (playwright install)

