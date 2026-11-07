<div align="center">
  <h1>🙏 Pray for One Another</h1>

  <h3>A Simple Way to Share Prayers and Strengthen Faith Together</h3>

  <p>
    <em>Carry each other's burdens, and in this way you will fulfill the law of Christ.</em>
    <br />
    <strong>— Galatians 6:2</strong>
  </p>

  <p>
    <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
    <img src="https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven" />
    <img src="https://img.shields.io/badge/License-MIT-brightgreen?style=for-the-badge" alt="MIT License" />
  </p>
</div>

<hr />

<div align="justify">
  <h2>📖 About the Project</h2>

  <p>
    <strong>Pray for One Another</strong> was inspired by a small prayer group I shared with my friends, called <em>"Oração pela Juventude"</em> ("Prayer for the Youth").
  </p>

  <p>
    Every Monday night, we would gather to read the Bible and pray together. At the end of each meeting, each person would pray specifically for another member of the group.
  </p>

  <p>
    Wanting to bring a touch of technology into this meaningful routine, I came up with the idea of developing a simple application to randomly assign prayer pairs.
  </p>

  <p>
    The goal was to make this tradition easier to organize while preserving its original purpose: encouraging fellowship, strengthening faith, and reminding us of the importance of praying for one another.
  </p>

  <blockquote>
    <em>Sometimes, a simple idea can help bring people closer together.</em>
  </blockquote>
</div>

<hr />

<div align="justify">
  <h2>✨ Features</h2>

  <ul>
    <li><strong>Random Prayer Assignment:</strong> Randomly assigns prayer partners among group members.</li>
    <li><strong>Participant Management:</strong> Allows participants' names to be managed before the draw.</li>
    <li><strong>Simple Interface:</strong> Provides a straightforward graphical interface for organizing prayer groups.</li>
  </ul>
</div>

<hr />

<div align="justify">
  <h2>📸 Screenshots</h2>

  <p>
    Take a look at Pray for One Another in action!
  </p>

  <div align="center">
    <h3>Edit Participants</h3>

<p>
  <img src="https://imgur.com/HhvsYgO.png" alt="Pray for One Another - Edit participants" width="90%" />
</p>

<h3>Random Prayer Assignment</h3>

<p>
  <img src="https://imgur.com/MUpn5Mw.png" alt="Pray for One Another - Random prayer assignment result" width="90%" />
</p>
    </div>
</div>

<hr />

<div align="justify">
  <h2>🛠️ Technologies Used</h2>

  <table>
    <thead>
      <tr>
        <th align="left">Technology</th>
        <th align="left">Purpose</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><a href="https://www.java.com/">Java</a></td>
        <td>Application development and implementation.</td>
      </tr>
      <tr>
        <td><a href="https://maven.apache.org/">Apache Maven</a></td>
        <td>Project build and dependency management.</td>
      </tr>
      <tr>
        <td><a href="https://github.com/google/guice">Google Guice</a></td>
        <td>Dependency injection and application component management.</td>
      </tr>
      <tr>
        <td><a href="https://junit.org/junit5/">JUnit 5</a></td>
        <td>Automated unit testing.</td>
      </tr>
      <tr>
        <td><a href="https://git-scm.com/">Git</a></td>
        <td>Source code versioning.</td>
      </tr>
    </tbody>
  </table>
</div>

<hr />

<div align="justify">
  <h2>📂 Project Structure</h2>

  <p>
    The project follows a modular Java application structure, organizing its components into dedicated packages for models, services, mappers, validators, utilities, and views.
  </p>

<pre>
pray-for-one-another/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev/guedes/prayforoneanother/
│   │   │       ├── exceptions/
│   │   │       ├── mappers/
│   │   │       │   └── impl/
│   │   │       ├── models/
│   │   │       ├── services/
│   │   │       │   └── impl/
│   │   │       ├── utils/
│   │   │       │   └── swing/
│   │   │       ├── validators/
│   │   │       ├── views/
│   │   │       │   ├── components/
│   │   │       │   │   ├── cards/
│   │   │       │   │   ├── frames/
│   │   │       │   │   └── panels/
│   │   │       │   └── factories/
│   │   │       │   └── styles/
│   │   │       ├── Application.java
│   │   │       ├── ApplicationInjector.java
│   │   │       ├── ApplicationModule.java
│   │   │       └── PrayForOneAnotherApplication.java
│   │   └── resources/
│   │       └── assets/
│   └── test/
│       └── java/
│           ├── dev/guedes/prayforoneanother/
│           │   ├── mappers/
│           │   ├── services/
│           │   ├── utils/
│           │   │   └── swing/
│           │   ├── validators/
│           │   └── PrayForOneAnotherApplicationTests.java
│           └── extensions/
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── LICENSE
</pre>

  <p>
    The <code>main</code> source set contains the application implementation, while the <code>test</code> source set contains automated tests for its main components.
  </p>

  <p>
    Maven Wrapper scripts allow the project to be built without requiring a separate Maven installation.
  </p>
</div>

<hr />

<div align="justify">
  <h2>🚀 Getting Started</h2>

  <p>
    You can download a ready-to-run version of Pray for One Another from GitHub Releases or explore and build the source code locally.
  </p>

  <h3>Running a Released Version</h3>

  <ol>
    <li>Visit the project's <a href="https://github.com/JoaoGuedesLuna/pray-for-one-another/releases">Releases</a> page on GitHub.</li>
    <li>Choose the version you want to download.</li>
    <li>Download the executable JAR file from the release assets.</li>
    <li>Make sure Java is installed on your machine.</li>
    <li>Open a terminal in the directory containing the downloaded file and execute:</li>
  </ol>

<pre>
java -jar pray-for-one-another-1.0.0.jar
</pre>

  <p>
    <em>Note: Executable JAR files are automatically generated by the CI pipeline whenever a new release is published and made available through GitHub Releases.</em>
  </p>

  <h3>Running from Source Code</h3>

  <h4>Prerequisites</h4>

  <ul>
    <li>Java Development Kit (JDK) compatible with the project configuration.</li>
    <li>Git (to clone the repository).</li>
  </ul>

  <h4>Steps</h4>

  <ol>
    <li>Clone the repository:</li>
  </ol>

<pre>
git clone https://github.com/JoaoGuedesLuna/pray-for-one-another.git
</pre>

  <ol start="2">
    <li>Navigate to the project directory:</li>
  </ol>

<pre>
cd pray-for-one-another
</pre>

  <ol start="3">
    <li>Run the application using Maven Wrapper.</li>
  </ol>

  <p><strong>Linux / macOS:</strong></p>

<pre>
./mvnw compile exec:java
</pre>

  <p><strong>Windows:</strong></p>

<pre>
mvnw.cmd compile exec:java
</pre>

  <p>
    Alternatively, you can open the project in a Java-compatible IDE, such as IntelliJ IDEA or Eclipse, and run the <code>PrayForOneAnotherApplication</code> class.
  </p>
</div>

<hr />

<div align="justify">
  <h2>📄 License</h2>

  <p>
    This project is licensed under the <strong>MIT License</strong>.
  </p>

  <p>
    You are free to use, copy, modify, distribute, and share this project in accordance with the terms of the license.
  </p>

  <p>
    See the <a href="LICENSE">LICENSE</a> file for details.
  </p>
</div>
